package com.example.nctai_trading.bidesk.impl;


import com.example.nctai_trading.bidesk.BrokerApiRestClient;
import com.example.nctai_trading.bidesk.domain.account.Account;
import com.example.nctai_trading.bidesk.domain.account.CancelOrderResponse;
import com.example.nctai_trading.bidesk.domain.account.DepositOrder;
import com.example.nctai_trading.bidesk.domain.account.NewOrder;
import com.example.nctai_trading.bidesk.domain.account.NewOrderResponse;
import com.example.nctai_trading.bidesk.domain.account.Order;
import com.example.nctai_trading.bidesk.domain.account.Trade;
import com.example.nctai_trading.bidesk.domain.account.request.CancelOrderRequest;
import com.example.nctai_trading.bidesk.domain.account.request.DepositOrderRequest;
import com.example.nctai_trading.bidesk.domain.account.request.HistoryOrderRequest;
import com.example.nctai_trading.bidesk.domain.account.request.MyTradeRequest;
import com.example.nctai_trading.bidesk.domain.account.request.OpenOrderRequest;
import com.example.nctai_trading.bidesk.domain.account.request.OrderStatusRequest;
import com.example.nctai_trading.bidesk.domain.general.BrokerInfo;
import com.example.nctai_trading.bidesk.domain.market.BookTicker;
import com.example.nctai_trading.bidesk.domain.market.Candlestick;
import com.example.nctai_trading.bidesk.domain.market.CandlestickInterval;
import com.example.nctai_trading.bidesk.domain.market.Index;
import com.example.nctai_trading.bidesk.domain.market.OrderBook;
import com.example.nctai_trading.bidesk.domain.market.TickerPrice;
import com.example.nctai_trading.bidesk.domain.market.TickerStatistics;
import com.example.nctai_trading.bidesk.domain.market.TradeHistoryItem;
import com.example.nctai_trading.bidesk.service.BrokerApiService;

import java.util.List;


/**
 * Implementation of Broker's REST API using Retrofit with synchronous/blocking method calls.
 */
public class BrokerApiRestClientImpl implements BrokerApiRestClient {

    private final BrokerApiService brokerApiService;

    public BrokerApiRestClientImpl(String baseUrl, String apiKey, String secret) {
        brokerApiService = BrokerApiServiceGenerator.createService(baseUrl, BrokerApiService.class, apiKey, secret);
    }

    // General endpoints

    @Override
    public void ping() {
        BrokerApiServiceGenerator.executeSync(brokerApiService.ping());
    }

    @Override
    public Long getServerTime() {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getServerTime()).getServerTime();
    }

    @Override
    public BrokerInfo getBrokerInfo() {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getBrokerInfo());
    }

    @Override
    public OrderBook getOrderBook(String symbol, Integer limit) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getOrderBook(symbol, limit));
    }

    @Override
    public List<TradeHistoryItem> getTrades(String symbol, Integer limit) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getTrades(symbol, limit));
    }

    @Override
    public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Long startTime, Long endTime, Integer limit) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getCandlestickBars(symbol, interval.getIntervalId(), startTime, endTime, limit));
    }

    @Override
    public TickerStatistics get24HrPriceStatistics(String symbol) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.get24HrPriceStatistics(symbol));
    }

    @Override
    public TickerPrice getPrice(String symbol) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getLatestPrice(symbol));
    }

    @Override
    public BookTicker getBookTicker(String symbol) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getBookTicker(symbol));
    }

    @Override
    public Index getIndex(String symbol) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getIndex(symbol));
    }

    @Override
    public NewOrderResponse newOrder(NewOrder order) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.newOrder(order.getSymbol(), order.getSide(), order.getType(),
                order.getTimeInForce(), order.getQuantity(), order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(),
                order.getIcebergQty(), order.getRecvWindow(), order.getTimestamp()));
    }

    @Override
    public Order getOrderStatus(OrderStatusRequest orderStatusRequest) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getOrderStatus(orderStatusRequest.getOrderId(), orderStatusRequest.getOrigClientOrderId(),
                orderStatusRequest.getRecvWindow(), orderStatusRequest.getTimestamp()));
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.cancelOrder(cancelOrderRequest.getOrderId(), cancelOrderRequest.getClientOrderId(),
                cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp()));
    }

    @Override
    public List<Order> getOpenOrders(OpenOrderRequest orderRequest) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getOpenOrders(orderRequest.getSymbol(), orderRequest.getLimit(),
                orderRequest.getRecvWindow(), orderRequest.getTimestamp()));
    }

    @Override
    public List<Order> getHistoryOrders(HistoryOrderRequest orderRequest) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getHistroyOrders(orderRequest.getOrderId(), orderRequest.getStartTime(), orderRequest.getEndTime(),
                orderRequest.getLimit(), orderRequest.getRecvWindow(), orderRequest.getTimestamp()));
    }

    @Override
    public Account getAccount(Long recvWindow, Long timestamp) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getAccount(recvWindow, timestamp));
    }

    @Override
    public List<Trade> getMyTrades(MyTradeRequest request) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getMyTrades(request.getFromId(), request.getToId(), request.getStartTime(), request.getEndTime(),
                request.getLimit(), request.getRecvWindow(), request.getTimestamp()));
    }

    @Override
    public List<DepositOrder> getDepositOrders(DepositOrderRequest request) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.getDepositOrders(request.getToken(), request.getStartTime(), request.getEndTime(), request.getFromId(),
                request.getLimit(), request.getRecvWindow(), request.getTimestamp()));
    }

    @Override
    public String startUserDataStream(Long recvWindow, Long timestamp) {
        return BrokerApiServiceGenerator.executeSync(brokerApiService.startUserDataStream(recvWindow, timestamp)).toString();
    }

    @Override
    public void keepAliveUserDataStream(String listenKey, Long recvWindow, Long timestamp) {
        BrokerApiServiceGenerator.executeSync(brokerApiService.keepAliveUserDataStream(listenKey, recvWindow, timestamp));
    }

    @Override
    public void closeUserDataStream(String listenKey, Long recvWindow, Long timestamp) {
        BrokerApiServiceGenerator.executeSync(brokerApiService.closeAliveUserDataStream(listenKey, recvWindow, timestamp));
    }

}
