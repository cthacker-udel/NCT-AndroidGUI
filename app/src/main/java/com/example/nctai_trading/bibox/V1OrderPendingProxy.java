package com.example.nctai_trading.bibox;



import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderPendingTrade(String index, String pair, OrderSideEnum orderSide, Double price, Double amount) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderPendingCancelTrade(String index, String id) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCancelTradeCmd(index, id));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderPendingOrderPendingList(OrderPendingListParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createOrderPendingListCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderPendingPendingHistoryList(OrderPendingHistoryListParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createOrderPendingHistoryListCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderPendingOrderDetail(String id, AccountTypeEnum accountType) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createOrderPendingOderDetailCmd(id, accountType));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderPendingOrder(String id, AccountTypeEnum accountType) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createOrderPendingOrderCmd(id, accountType));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String orderPendingOrderHistoryList(OrderPendingListParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createOrderPendingOrderHistoryListCmd(params));
    }
}
