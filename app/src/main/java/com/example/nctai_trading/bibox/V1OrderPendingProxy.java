package com.example.nctai_trading.bibox;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class V1OrderPendingProxy extends BaseProxy
{

    public V1OrderPendingProxy(BiBoxHttpClientConfig config, HttpClientHelper helper)
    {
        super.config = config;
        super.helper = helper;
    }

    @Override
    public String getUrl()
    {
        return config.getHost().concat(UrlConstants.V1_ORDERPENDING);
    }

    public String tradeLimit() throws IOException
    {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", "tradeLimit");
        return get(params);
    }

    public String orderPendingTrade(String index, String pair, OrderSideEnum orderSide, Double price, Double amount) throws IOException
    {
        TradeParams params = new TradeParams();
        params.setPair(pair);
        params.setAccountType(AccountTypeEnum.MAIN);
        params.setOrderType(OrderTypeEnum.LIMIT);
        params.setOrderSide(orderSide);
        params.setPrice(price);
        params.setAmount(amount);
        params.setIndex(index);
        return postSign(V1ParamsUtils.createOrderPendingTradeCmd(params));
    }

    public String orderPendingCancelTrade(String index, String id) throws IOException
    {
        return postSign(V1ParamsUtils.createCancelTradeCmd(index, id));
    }

    public String orderPendingOrderPendingList(OrderPendingListParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createOrderPendingListCmd(params));
    }

    public String orderPendingPendingHistoryList(OrderPendingHistoryListParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createOrderPendingHistoryListCmd(params));
    }

    public String orderPendingOrderDetail(String id, AccountTypeEnum accountType) throws IOException
    {
        return postSign(V1ParamsUtils.createOrderPendingOderDetailCmd(id, accountType));
    }

    public String orderPendingOrder(String id, AccountTypeEnum accountType) throws IOException
    {
        return postSign(V1ParamsUtils.createOrderPendingOrderCmd(id, accountType));
    }

    public String orderPendingOrderHistoryList(OrderPendingListParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createOrderPendingOrderHistoryListCmd(params));
    }
}
