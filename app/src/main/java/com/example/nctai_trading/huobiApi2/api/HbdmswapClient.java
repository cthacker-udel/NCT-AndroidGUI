package com.example.nctai_trading.huobiApi2.api;

import com.example.nctai_trading.huobiApi2.request.Order;

import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HbdmswapClient {

    private static Logger logger = LoggerFactory.getLogger(HbdmswapClient.class);

    public static void main(String[] args) throws HttpException, IOException {


        String api_key = "";
        String secret_key = "";
        String url_prex = "";
        IHbdmswapRestApi futureGetV1 = new HbdmswapRestApiV1(url_prex);
        IHbdmswapRestApi futurePostV1 = new HbdmswapRestApiV1(url_prex, api_key, secret_key);


        String contractInfo = futureGetV1.futureContractInfo("BTC-USD");
        logger.info("Contract Info" + contractInfo);

        String contractindex = futureGetV1.futureContractIndex("BTC-USD");
        logger.info("Contract Index" + contractindex);

        String pricelimit = futureGetV1.futurePriceLimit("BTC-USD");
        logger.info("Price Limit" + pricelimit);

        String openInterest = futureGetV1.futureOpenInterest("BTC-USD");
        logger.info("Open Interest" + openInterest);


        String marketDepth = futureGetV1.futureMarketDepth("BTC-USD", "step0");
        logger.info("Market Depth" + marketDepth);


        String historyKline = futureGetV1.futureMarketHistoryKline("BTC-USD", "15min","100");
        logger.info("History Kline" + historyKline);


        String merged = futureGetV1.futureMarketDetailMerged("BTC-USD");
        logger.info("Merged" + merged);


        String trade = futurePostV1.futureMarketDetailTrade("BTC-USD", "10");
        logger.info("Trade" + trade);


        String historTrade = futurePostV1.futureMarketHistoryTrade("BTC-USD", "10");
        logger.info("History Trade" + historTrade);

        String accountInfo = futurePostV1.futureContractAccountInfo("BTC-USD");
        logger.info("Account Info" + accountInfo);


        String positionInfo = futurePostV1.futureContractPositionInfo("BTC-USD");
        logger.info("Contract Position" + positionInfo);


        String contractOrder = futurePostV1.futureContractOrder( "BTC-USD", "", "6188", "12",
                "buy", "open", "10", "limit");

        logger.info("Contract order" + contractOrder);

        List<Order> orders = new ArrayList<>();
        Order order1 = new Order("BTC-USD", "10", "6400", "1","buy", "open", "10", "limit");
        Order order2 = new Order("BTC-USD", "12", "6398", "2","buy", "open", "10", "limit");
        orders.add(order1);
        orders.add(order2);
        String futureContractBatchOorder = futurePostV1.futureContractBatchorder(orders);
        logger.info("Contract Batch Order" + futureContractBatchOorder);


        String contractcancel = futurePostV1.futureContractCancel("123556", "","BTC-USD");
        logger.info("Contract Cancel" + contractcancel);


        String contractCancelall = futurePostV1.futureContractCancelall("BTC-USD");
        logger.info("Contract Cancel All" + contractCancelall);


        String contractOrderInfo = futurePostV1.futureContractOrderInfo("4", "","BTC-USD","1");
        logger.info("Contract Order Info" + contractOrderInfo);


        String detail = futurePostV1.futureContractOrderDetail("BTC-USD", "123556", "1", "100","1539345271124","1");
        logger.info("Contract Order Detail" + detail);


        String openorders = futurePostV1.futureContractOpenorders("BTC-USD", "1", "100");
        logger.info("Contract Open Orders" + openorders);


        String orderDetail = futurePostV1.futureContractHisorders("BTC-USD", "0", "1", "0", "90", "1", "20");
        logger.info("Order Detail" + orderDetail);
    }

}
