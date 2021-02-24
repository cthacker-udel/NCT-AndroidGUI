package com.example.nctai_trading.huobiApi2.api;

import com.example.nctai_trading.huobiApi2.request.Order;

import org.apache.http.HttpException;

import java.io.IOException;
import java.util.List;

public interface IHbdmswapRestApi {


    public String futureContractInfo(String contractCode)
            throws HttpException, IOException;


    public String futureContractIndex(String contractCode) throws HttpException, IOException;


    public String futurePriceLimit(String contractCode)
            throws HttpException, IOException;


    public String futureOpenInterest(String contractCode)
            throws HttpException, IOException;


    public String futureMarketDepth(String contractcode, String type) throws HttpException, IOException;


    public String futureMarketHistoryKline(String contractCode, String period,String size) throws HttpException, IOException;


    public String futureMarketDetailMerged(String contractCode) throws HttpException, IOException;


    public String futureMarketDetailTrade(String contractCode, String size) throws HttpException, IOException;


    public String futureMarketHistoryTrade(String contractCode, String size) throws HttpException, IOException;


    public String futureContractAccountInfo(String contractCode) throws HttpException, IOException;


    public String futureContractPositionInfo(String contractCode) throws HttpException, IOException;


    public String futureContractOrder( String contractCode, String clientOrderId,
                                       String price, String volume, String direction, String offset, String leverRate, String orderPriceType)
            throws HttpException, IOException;


    public String futureContractBatchorder(List<Order> orders) throws HttpException, IOException;


    public String futureContractCancel(String orderId, String clientOrderId,String symbol) throws HttpException, IOException;


    public String futureContractCancelall(String contractCode) throws HttpException, IOException;


    public String futureContractOrderInfo(String orderId, String clientOrderId,String symbol,String orderType) throws HttpException, IOException;


    public String futureContractOrderDetail(String symbol, String orderId, String pageIndex, String pageSize,String createdAt,String orderType)
            throws HttpException, IOException;


    public String futureContractOpenorders(String symbol, String pageIndex, String pageSize)
            throws HttpException, IOException;


    public String futureContractHisorders(String symbol, String tradeType, String type, String status,
                                          String createDate, String pageIndex, String pageSize) throws HttpException, IOException;

}