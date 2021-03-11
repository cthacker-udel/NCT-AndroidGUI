package com.example.nctai_trading.bidesk.impl;


import com.example.nctai_trading.bidesk.BrokerContractApiRestClient;
import com.example.nctai_trading.bidesk.domain.contract.BatchCancelOrderResult;
import com.example.nctai_trading.bidesk.domain.contract.ContractAccountResult;
import com.example.nctai_trading.bidesk.domain.contract.ContractMatchResult;
import com.example.nctai_trading.bidesk.domain.contract.ContractOrderResult;
import com.example.nctai_trading.bidesk.domain.contract.ContractPositionResult;
import com.example.nctai_trading.bidesk.domain.contract.ModifyMarginResult;
import com.example.nctai_trading.bidesk.domain.contract.OrderType;
import com.example.nctai_trading.bidesk.domain.contract.request.BatchCancelOrderRequest;
import com.example.nctai_trading.bidesk.domain.contract.request.CancelContractOrderRequest;
import com.example.nctai_trading.bidesk.domain.contract.request.ContractHistoryOrderRequest;
import com.example.nctai_trading.bidesk.domain.contract.request.ContractMyTradeRequest;
import com.example.nctai_trading.bidesk.domain.contract.request.ContractOpenOrderRequest;
import com.example.nctai_trading.bidesk.domain.contract.request.ContractOrderRequest;
import com.example.nctai_trading.bidesk.domain.contract.request.ContractPositionRequest;
import com.example.nctai_trading.bidesk.domain.contract.request.ModifyMarginRequest;
import com.example.nctai_trading.bidesk.domain.general.BrokerInfo;
import com.example.nctai_trading.bidesk.domain.general.TradeType;
import com.example.nctai_trading.bidesk.domain.market.Candlestick;
import com.example.nctai_trading.bidesk.domain.market.CandlestickInterval;
import com.example.nctai_trading.bidesk.domain.market.OrderBook;
import com.example.nctai_trading.bidesk.domain.market.TradeHistoryItem;
import com.example.nctai_trading.bidesk.service.BrokerContractApiService;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

import static com.example.nctai_trading.bidesk.impl.BrokerApiServiceGenerator.createService;

import static com.example.nctai_trading.bidesk.impl.BrokerApiServiceGenerator.executeSync;
import static com.example.nctai_trading.bidesk.impl.BrokerApiServiceGenerator.executeSync2;
import static com.example.nctai_trading.bidesk.impl.BrokerApiServiceGenerator.executeSync3;
import static com.example.nctai_trading.bidesk.impl.BrokerApiServiceGenerator.executeSync4;



/**
 * Implementation of Broker's Contract REST API using Retrofit with synchronous/blocking method calls.
 */
public class BrokerContractApiRestClientImpl implements BrokerContractApiRestClient {

    private final BrokerContractApiService brokerContractApiService;

    private static final String PARAMETER_LIST_SEPARATOR = ",";

    public BrokerContractApiRestClientImpl(String baseUrl, String apiKey, String secret) {
        brokerContractApiService = createService(baseUrl, BrokerContractApiService.class, apiKey, secret);
    }

    @Override
    public BrokerInfo getBrokerInfo(TradeType type) {
        return (BrokerInfo) executeSync2(brokerContractApiService.getBrokerInfo(type == null ? "" : type.getValue()));
    }

    @Override
    public ContractOrderResult newContractOrder(ContractOrderRequest request) {
        String clientOrderId = request.getClientOrderId();
        if (StringUtils.isEmpty(clientOrderId)) {
            clientOrderId = String.valueOf(System.currentTimeMillis());
        }

        return (ContractOrderResult) executeSync3(brokerContractApiService.newContractOrder(
                request.getSymbol(),
                request.getSide() == null ? "" : request.getSide().name(),
                request.getOrderType() == null ? "" : request.getOrderType().name(),
                request.getQuantity(),
                request.getLeverage(),
                request.getPrice(),
                request.getPrice()  == null ? "" : request.getPriceType().name(),
                request.getTriggerPrice(),
                request.getTimeInForce() == null ? "" : request.getTimeInForce().name(),
                clientOrderId
        ));
    }

    @Override
    public ContractOrderResult cancelContractOrder(CancelContractOrderRequest cancelOrderRequest) {
        return executeSync(brokerContractApiService.cancelContractOrder(
           cancelOrderRequest.getOrderId(),
           cancelOrderRequest.getClientOrderId(),
           cancelOrderRequest.getOrderType() == null ? "" : cancelOrderRequest.getOrderType().name()
        ));
    }

    @Override
    public BatchCancelOrderResult batchCancelContractOrder(BatchCancelOrderRequest request) {
        return (BatchCancelOrderResult) executeSync4(brokerContractApiService.batchCancelContractOrder(
                StringUtils.join(request.getSymbolList(), PARAMETER_LIST_SEPARATOR)
        ));
    }

    @Override
    public ContractOrderResult getContractOrder(OrderType orderType, String clientOrderId, Long orderId) {
        return executeSync(brokerContractApiService.getContractOrder(
                orderType == null ? "" : orderType.name(),
                orderId == null ? "" : orderId.toString(),
                clientOrderId));
    }

    @Override
    public List<ContractOrderResult> getContractOpenOrders(ContractOpenOrderRequest orderRequest) {
        return executeSync(brokerContractApiService.getContractOpenOrders(
                orderRequest.getSymbol(),
                orderRequest.getOrderId(),
                orderRequest.getSide() == null ? "" : orderRequest.getSide().name(),
                orderRequest.getOrderType() == null ? "" : orderRequest.getOrderType().name(),
                orderRequest.getLimit()
        ));
    }

    @Override
    public List<ContractOrderResult> getContractHistoryOrders(ContractHistoryOrderRequest orderRequest) {
        return executeSync(brokerContractApiService.getContractHistoryOrders(
                orderRequest.getSymbol(),
                orderRequest.getOrderId(),
                orderRequest.getSide() == null ? "" : orderRequest.getSide().name(),
                orderRequest.getOrderType() == null ? "" : orderRequest.getOrderType().name(),
                orderRequest.getLimit()
        ));
    }

    @Override
    public List<ContractMatchResult> getContractMyTrades(ContractMyTradeRequest request) {
        return executeSync(brokerContractApiService.getContractMyTrades(
                request.getSymbol(),
                request.getLimit(),
                request.getSide() == null ? "" : request.getSide().name(),
                request.getFromId(),
                request.getToId()
        ));
    }

    @Override
    public List<ContractPositionResult> getContractPositions(ContractPositionRequest request) {
        return executeSync(brokerContractApiService.getContractPositions(
                request.getSymbol(),
                request.getSide() == null ? "" : request.getSide().name()
        ));
    }

    @Override
    public ModifyMarginResult modifyMargin(ModifyMarginRequest request) {
        return executeSync(brokerContractApiService.modifyMargin(
                request.getSymbol(),
                request.getSide() == null ? "" : request.getSide().name(),
                request.getAmount()
        ));
    }

    @Override
    public Map<String, ContractAccountResult> getContractAccount() {
        return executeSync(brokerContractApiService.getContractAccount());
    }

    @Override
    public OrderBook getContractOrderBook(String symbol, Integer limit) {
        return executeSync(brokerContractApiService.getOrderBook(symbol, limit));
    }

    @Override
    public List<TradeHistoryItem> getContractTrades(String symbol, Integer limit) {
        return executeSync(brokerContractApiService.getTrades(symbol, limit));
    }

    @Override
    public List<Candlestick> getContractCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long to) {
        return executeSync(brokerContractApiService.getCandlestickBars(
                symbol, interval == null ? "" : interval.getIntervalId(), limit, to));
    }
}
