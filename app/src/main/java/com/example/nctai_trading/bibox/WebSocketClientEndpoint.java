package com.example.nctai_trading.bibox;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.websocket.*;
import java.net.URI;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@ClientEndpoint
public class WebSocketClientEndpoint
{
    private static long IDLE_TIME_OUT = 1000 * 30;

    private Session session;
    private URI endpointURI;
    private WebSocketContainer container;
    private MessageHandler messageHandler;

    private Map<String, String> channelSet = new HashMap<>();
    private AtomicBoolean isOpen = new AtomicBoolean(false);

    private ExecutorService connExecutor = Executors.newFixedThreadPool(2);
    private ExecutorService dataProcessExector = Executors.newFixedThreadPool(5);

    public interface MessageHandler
    {

        /**
         * 收到的 ping pong
         *
         * @param message
         */
        void pingPong(String message);

        /**
         * 解压处理后的消息
         *
         * @param dataType
         * @param channel
         * @param data
         */
        void channelMessage(int dataType, String channel, String data);

        /**
         * 错误消息处理
         *
         * @param message
         */
        void error(String message);
    }

    public WebSocketClientEndpoint(URI endpointURI)
    {
        this.endpointURI = endpointURI;
        this.container = ContainerProvider.getWebSocketContainer();
        container.setDefaultMaxSessionIdleTimeout(IDLE_TIME_OUT);
        connect();
        //发送心跳
        HeartbeatTask heartbeatTask = HeartbeatTask.getHeartbeatTask(1000 * 10, 0);
        heartbeatTask.registerTrigger(time ->
        {
            Map<String, Object> ping = new HashMap<>();
            ping.put("ping", time);
            sendMessage(JSON.toJSONString(ping));
        });
    }

    @OnOpen
    public void onOpen(Session session)
    {
        System.out.println(String.format("onOpen"));
        isOpen.compareAndSet(false, true);
        this.session = session;
        //重连之后，重新发送订阅
        channelSet.forEach((key, value) -> sendMessage(value));
    }

    @OnClose
    public void onClose(Session session, CloseReason reason)
    {
        System.out.println(String.format("WebSocket onError 断开链接-----》onError :%s", reason.getReasonPhrase()));
        this.session = null;
        isOpen.compareAndSet(true, false);
        connect();
    }

    @OnError
    public void onError(Session session, Throwable error)
    {
        System.out.println("onError");
    }

    @OnMessage
    public void onMessage(String message)
    {
        dataProcessExector.execute(() -> processZip(message));
    }

    public void processZip(String message)
    {
        try {
            if (Objects.isNull(messageHandler)) {
                System.out.println("没有添加消息监听器！！！！！");
                return;
            }
            Optional.ofNullable(message).filter(PredicateWebsocketHelper.isPingPong(message)).ifPresent(messageHandler::pingPong);

            Optional.ofNullable(message).filter(PredicateWebsocketHelper.isPing(message)).ifPresent(this::reply);

            Optional.ofNullable(message).filter(PredicateWebsocketHelper.isError(message)).ifPresent(messageHandler::error);

            Optional.ofNullable(message).filter(this::isArray).ifPresent(msg ->
            {
                List<JSONObject> rets = JSON.parseArray(msg, JSONObject.class);
                Optional.ofNullable(rets.get(0)).ifPresent(opData ->
                {
                    String data = opData.getString("data");
                    String channel = opData.getString("channel");
                    int dataType = opData.getInteger("data_type");
                    if ("1".equals(opData.getString("binary"))) {
                        data = GZIPUtils.uncompress(Base64.getDecoder().decode(data));
                    }
                    messageHandler.channelMessage(dataType, channel, data);
                });
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reply(String message)
    {
        Map<String, Integer> ping = JSON.parseObject(message, Map.class);
        Integer time = ping.get("ping");
        Map<String, Integer> pong = new HashMap<>();
        pong.put("pong", time);
        sendMessage(JSON.toJSONString(pong));
    }

    private boolean isPing(String message)
    {
        return message.contains("ping");
    }

    private boolean isPong(String message)
    {
        return message.contains("pong");
    }

    private boolean isPingPong(String message)
    {
        return isPing(message) || isPong(message);
    }

    private boolean isArray(String ret)
    {
        return ret.indexOf("[") == 0;
    }

    private void connect()
    {
        try {
            container.connectToServer(WebSocketClientEndpoint.this, endpointURI);
            System.out.println("connectToServer success");
        } catch (Exception e) {
            reconnect();
        }
    }

    private void reconnect()
    {
        connExecutor.execute(() ->
        {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isOpen.get()) {
                System.out.println("session is open 不需要重新链接");
                return;
            }
            System.out.println("重新尝试链接.....");
            connect();
        });
    }

    private void sendMessage(String message)
    {
        try {
            System.out.println(String.format("sendMessage %s", message));
            Optional.ofNullable(session).ifPresent(session -> session.getAsyncRemote().sendText(message));
        } catch (Exception e) {
            System.out.println("sendMessage error");
        }
    }

    public void registerMessageHandler(MessageHandler messageHandler)
    {
        this.messageHandler = messageHandler;
    }

    public void subChannel(String channel, String message)
    {
        if (channelSet.containsKey(channel)) {
            return;
        }
        channelSet.put(channel, message);
        sendMessage(message);
    }

    public void removeChannel(String channel, String message)
    {
        channelSet.remove(channel);
        sendMessage(message);
    }
}
