package com.example.nctai_trading.bidesk;


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

import java.util.List;

public interface BrokerApiRestClient {

    void ping();

    Long getServerTime();

    BrokerInfo getBrokerInfo();

    /**
     * * Get order book of a symbol.
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     * @param limit  depth of the order book (max 100)
     * @return
     */
    OrderBook getOrderBook(String symbol, Integer limit);

    /**
     * Get recent trades (up to last 500). Weight: 1
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     * @param limit  of last trades (Default 500; max 1000.)
     */
    List<TradeHistoryItem> getTrades(String symbol, Integer limit);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     */
    List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Long startTime, Long endTime, Integer limit);

    /**
     * Get 24 hour price change statistics.
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     */
    TickerStatistics get24HrPriceStatistics(String symbol);


    /**
     * Get latest price for <code>symbol</code>.
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     */
    TickerPrice getPrice(String symbol);

    BookTicker getBookTicker(String symbol);

    /**
     * Get option index for <code>symbol</code>
     * @param symbol ticker symbol (e.g. ETHBTC)
     */
    Index getIndex(String symbol);


    /**
     * Send in a new order.
     *
     * @param order the new order to submit.
     * @return a response containing details about the newly placed order.
     */
    NewOrderResponse newOrder(NewOrder order);

    /**
     * Check an order's status.
     *
     * @param orderStatusRequest order status request options/filters
     * @return an order
     */
    Order getOrderStatus(OrderStatusRequest orderStatusRequest);

    /**
     * Cancel an active order.
     *
     * @param cancelOrderRequest order status request parameters
     */
    CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest);

    /**
     * Get all open orders on a symbol.
     *
     * @param orderRequest order request parameters
     * @return a list of all account open orders on a symbol.
     */
    List<Order> getOpenOrders(OpenOrderRequest orderRequest);

    /**
     * Get all account orders; active, canceled, or filled.
     *
     * @param orderRequest order request parameters
     * @return a list of all account orders
     */
    List<Order> getHistoryOrders(HistoryOrderRequest orderRequest);

    /**
     * Get current account information.
     */
    Account getAccount(Long recvWindow, Long timestamp);

    /**
     * Get trades for a specific account and symbol.
     *
     * @param request
     * @return
     */
    List<Trade> getMyTrades(MyTradeRequest request);

    /**
     * Get deposit order
     *
     * @param request
     * @return
     */
    List<DepositOrder> getDepositOrders(DepositOrderRequest request);

    /**
     * Start a new user data stream.
     *
     * @return a listen key that can be used with data streams
     */
    String startUserDataStream(Long recvWindow, Long timestamp);

    /**
     * PING a user data stream to prevent a time out.
     *
     * @param listenKey listen key that identifies a data stream
     */
    void keepAliveUserDataStream(String listenKey, Long recvWindow, Long timestamp);

    /**
     * Close out a new user data stream.
     *
     * @param listenKey listen key that identifies a data stream
     */
    void closeUserDataStream(String listenKey, Long recvWindow, Long timestamp);

}
