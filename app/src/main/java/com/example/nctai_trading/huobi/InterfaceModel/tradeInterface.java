package com.example.nctai_trading.huobi.InterfaceModel;

import com.example.nctai_trading.huobi.Controller.TradeAPI.BatchOrder.BatchOrder;
import com.example.nctai_trading.huobi.Controller.TradeAPI.CancelOrder.CancelOrder;
import com.example.nctai_trading.huobi.Controller.TradeAPI.HistoryOrder.HistoryOrder;
import com.example.nctai_trading.huobi.Controller.TradeAPI.OrderDetailsAcquisition.OrderDetailsAcquisition;
import com.example.nctai_trading.huobi.Controller.TradeAPI.OrderDetailsAcquisition.UnfilledOrder.UnfilledOrder;
import com.example.nctai_trading.huobi.Controller.TradeAPI.OrderInfo.OrderInfo;
import com.example.nctai_trading.huobi.Controller.TradeAPI.PlaceOrder.PlaceOrder;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.TreeMap;

public interface tradeInterface {

    @POST("https://api.hbdm.com/swap-api/v1/swap_order")
    Call<PlaceOrder> placeOrder(@QueryMap TreeMap<String,Object> queries);

    @POST("https://api.hbdm.com/swap-api/v1/swap_batchorder")
    Call<BatchOrder> placeBatchOrder(@Body TreeMap<String,Object> queries);

    @POST("https://api.hbdm.com/swap-api/v1/swap_cancel")
    Call<CancelOrder> cancelOrder(@Body TreeMap<String,Object> queries);

    @POST("https://api.hbdm.com/swap-api/v1/swap_cancelall")
    Call<CancelOrder> cancelAllOrders(@Body TreeMap<String,Object> queries);

    @POST("https://api.hbdm.com/swap-api/v1/swap_order_info")
    Call<OrderInfo> getOrderInfo(@Body TreeMap<String,Object> queries);

    @POST("https://api.hbdm.com/swap-api/v1/swap_order_detail")
    Call<OrderDetailsAcquisition> getOrderDetailsAcquisition(@Body TreeMap<String,Object> queries);

    @POST("https://api.hbdm.com/swap-api/v1/swap_openorders")
    Call<UnfilledOrder> getUnfilledOrderAcquisition(@Body TreeMap<String,Object> queries);

    @POST("https://api.hbdm.com/swap-api/v1/swap_hisorders")
    Call<HistoryOrder> getHistoricalOrders(@Body TreeMap<String,Object> queries);

}
