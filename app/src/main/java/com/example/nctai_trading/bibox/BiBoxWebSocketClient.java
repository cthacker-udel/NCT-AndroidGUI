package com.example.nctai_trading.bibox;


import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * ps：each client channel max 20
 */
public class BiBoxWebSocketClient
{
    private WebSocketClientEndpoint endpoint;
    private BiBoxWebSocketConfig config;

    public BiBoxWebSocketClient(BiBoxWebSocketConfig config) throws URISyntaxException
    {
        this.config = config;
        endpoint = new WebSocketClientEndpoint(new URI(config.getHost()));
    }

    public void login(String apiKey, String secret) throws NoSuchAlgorithmException, InvalidKeyException {
        endpoint.subChannel(ChannelUtils.getLoginChannel(), ChannelUtils.loginSubChannel(apiKey, secret));
    }

    public void subChannel(String channel)
    {
        endpoint.subChannel(channel, ChannelUtils.subChannelMessage(channel));
    }

    public void removeChannel(String channel)
    {
        endpoint.removeChannel(channel, ChannelUtils.removeChannelMessage(channel));
    }

    public void registerMessageHandler(WebSocketClientEndpoint.MessageHandler handler)
    {
        endpoint.registerMessageHandler(handler);
    }

    public static void main(String[] args) throws URISyntaxException, InvalidKeyException, NoSuchAlgorithmException {
        String apiKey = "Yours apiKey";
        String secret = "Yours secret";
        String host = "wss://push.bibox365.com/";
        //BiBoxWebSocketClient webSocketClient=BiBoxClient.ofDefaultsWebSocket();
        BiBoxWebSocketConfig config = BiBoxWebSocketConfig.custom().host(host).build();
        BiBoxWebSocketClient webSocketClient = BiBoxClient.ofWebSocket(config);
        webSocketClient.login(apiKey, secret);
        webSocketClient.subChannel(ChannelUtils.getTickerChannel("BTC_USDT"));
        webSocketClient.subChannel(ChannelUtils.getIndexMarket());
        webSocketClient.subChannel(ChannelUtils.getContractPriceLimit());
        webSocketClient.registerMessageHandler(new WebSocketClientEndpoint.MessageHandler()
        {
            @Override
            public void pingPong(String message)
            {
                System.out.println(message);
            }

            @Override
            public void channelMessage(int dataType, String channel, String data)
            {
                System.out.println(String.format("dataType:%d channel:%s %s", dataType, channel, data));
            }

            @Override
            public void error(String message)
            {
                System.out.println(message);
            }
        });
        while (true) {

        }
    }
}
