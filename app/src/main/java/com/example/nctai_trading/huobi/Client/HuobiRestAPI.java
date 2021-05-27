package com.example.nctai_trading.huobi.Client;



import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.huobi.Controller.AccountAPI.AccountAssetInformation.*;
import com.example.nctai_trading.huobi.Controller.AccountAPI.AccountInformation.*;
import com.example.nctai_trading.huobi.Controller.AccountAPI.AssetValuation.*;
import com.example.nctai_trading.huobi.Controller.AccountAPI.PositionInformation.*;

import com.example.nctai_trading.huobi.Controller.MarketDataAPI.ContractTradeRecordBatch.*;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.KlineData.*;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.KlineData.MarkPrice.MarkPrice;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.LastContractTrade.*;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketBBO.*;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketDepth.*;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketOverview.*;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketOverview.Batch.MarketDataOverviewBatch;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.SwapContractInfo.*;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.SwapIndexPrice.*;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.SwapInterestInfo.*;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.SwapPriceLimit.*;


import com.example.nctai_trading.huobi.Controller.ServerAPI.ServerStatus.*;


import com.example.nctai_trading.huobi.Controller.TradeAPI.BatchOrder.*;
import com.example.nctai_trading.huobi.Controller.TradeAPI.CancelOrder.*;
import com.example.nctai_trading.huobi.Controller.TradeAPI.OrderDetailsAcquisition.*;
import com.example.nctai_trading.huobi.Controller.TradeAPI.OrderDetailsAcquisition.UnfilledOrder.UnfilledOrder;
import com.example.nctai_trading.huobi.Controller.TradeAPI.OrderInfo.*;
import com.example.nctai_trading.huobi.Controller.TradeAPI.PlaceOrder.*;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.nctai_trading.huobi.InterfaceModel.*;

import java.io.IOException;
import java.util.TreeMap;

public class HuobiRestAPI {

    public static String baseUrl = "https://api.hbdm.com";


    /*

    Server Requests

     */


    public ServerStatus getSystemStatus() throws IOException {

        String url = "https://status-swap.huobigroup.com/api/v2/summary.json/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serverInterface serverInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.serverInterface.class);

        Call<ServerStatus> call = serverInterface.getServerStatus();

        Response<ServerStatus> response = call.execute();

        return response.body();
    }

    public ServerHeartbeat getServerHeartbeat() throws IOException {

        String url = "https://api.hdbm.com/heartbeat/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serverInterface serverInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.serverInterface.class);

        Call<ServerHeartbeat> call = serverInterface.getServerHeartbeat();

        Response<ServerHeartbeat> response = call.execute();

        return response.body();

    }

    public ServerTimestamp getServerTimestamp() throws IOException {

        String url = "https://api.hbdm.com/api/v1/timestamp/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serverInterface serverInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.serverInterface.class);

        Call<ServerTimestamp> call = serverInterface.getServerTimestamp();

        Response<ServerTimestamp> response = call.execute();

        return response.body();

    }

    /*

    Swap Market API

     */

    public SwapContractInfo querySwapInfo(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_contract_info/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<SwapContractInfo> call = marketInterface.querySwapInfo(client.getMarket().generateQueryParams());

        Response<SwapContractInfo> response = call.execute();

        return response.body();

    }

    public SwapIndexPrice querySwapIndexPrice(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_index/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<SwapIndexPrice> call = marketInterface.querySwapIndexPrice(client.getMarket().generateQueryParams());

        Response<SwapIndexPrice> response = call.execute();

        return response.body();

    }

    public SwapPriceLimit querySwapPriceLimit(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_price_limit/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<SwapPriceLimit> call = marketInterface.querySwapPriceLimit(client.getMarket().generateQueryParams());

        Response<SwapPriceLimit> response = call.execute();

        return response.body();
    }

    public SwapInterestInfo querySwapInterestInfo(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_open_interest/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<SwapInterestInfo> call = marketInterface.querySwapInterestInfo(client.getMarket().generateQueryParams());

        Response<SwapInterestInfo> response = call.execute();

        return response.body();

    }


    public MarketDepth getMarketDepth(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-ex/market/depth/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<MarketDepth> call = marketInterface.queryMarketDepth(client.getMarket().generateQueryParams());

        Response<MarketDepth> response = call.execute();

        return response.body();

    }

    public MarketBBO getMarketBBOData(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-ex/market/bbo/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<MarketBBO> call = marketInterface.queryMarketBBO(client.getMarket().generateQueryParams());

        Response<MarketBBO> response = call.execute();

        return response.body();

    }

    public KlineData queryMarketKlineData(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-ex/market/history/kline/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<KlineData> call = marketInterface.queryKlineData(client.getMarket().generateQueryParams());

        Response<KlineData> response = call.execute();

        return response.body();

    }

    public MarkPrice queryMarketKlineMarkPrice(HuobiClient client) throws IOException {

        String url = baseUrl + "/index/market/history/swap_mark_price_kline/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<MarkPrice> call = marketInterface.queryKlineMarkPrice(client.getMarket().generateQueryParams());

        Response<MarkPrice> response = call.execute();

        return response.body();

    }

    public MarketOverview queryMarketDataOverview(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-ex/market/detail/merged/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<MarketOverview> call = marketInterface.queryMarketOverview(client.getMarket().generateQueryParams());

        Response<MarketOverview> response = call.execute();

        return response.body();

    }

    public MarketDataOverviewBatch queryMarketDataOverviewBatch(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-ex/market/detail/batch_merged/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<MarketDataOverviewBatch> call = marketInterface.queryMarketOverviewBatch(client.getMarket().generateQueryParams());

        Response<MarketDataOverviewBatch> response = call.execute();

        return response.body();

    }

    public LastContractTrade queryLastContractTrade(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-ex/market/trade/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<LastContractTrade> call = marketInterface.queryLastContractTrade(client.getMarket().generateQueryParams());

        Response<LastContractTrade> response = call.execute();

        return response.body();

    }


    public ContractTradeRecordBatch queryContractTradeRecordHistory(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-ex/market/history/trade/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketInterface marketInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.marketInterface.class);

        Call<ContractTradeRecordBatch> call = marketInterface.queryContractTradeRecordBatch(client.getMarket().generateQueryParams());

        Response<ContractTradeRecordBatch> response = call.execute();

        return response.body();
    }

    /*

    Account API

     */
    
    @RequiresApi(api = Build.VERSION_CODES.O)
    public AssetValuation queryAssetValuation(HuobiClient client) throws IOException {
        
        String url = baseUrl + "/swap-api/v1/swap_balance_valuation/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.accountInterface.class);

        TreeMap<String,Object> queries = client.getAccount().generate_queries();

        queries.put("signature",client.getAuth().createSignature("POST","https://api.hbdm.com/swap-api/v1/swap_balance_valuation",queries));

        Call<AssetValuation> call = accountInterface.queryAssetValuation(queries);


        Response<AssetValuation> response = call.execute();

        return response.body();

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public AccountInformation queryAccountInformation(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_account_info/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.accountInterface.class);

        TreeMap<String,Object> queries = client.getAccount().generate_queries();

        queries.put("signature",client.getAuth().createSignature("POST","https://api.hbdm.com/swap-api/v1/swap_account_info",queries));

        Call<AccountInformation> call = accountInterface.queryAccountInformation(queries);

        Response<AccountInformation> response = call.execute();

        return response.body();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public AccountPositionInformation queryUserPositionInformation(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_position_info/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.accountInterface.class);

        TreeMap<String,Object> queries = client.getAccount().generate_queries();

        queries.put("signature",client.getAuth().createSignature("POST","https://api.hbdm.com/swap-api/v1/swap_position_info",queries));

        Call<AccountPositionInformation> call = accountInterface.queryAccountPositionInformation(queries);

        Response<AccountPositionInformation> response = call.execute();

        return response.body();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public AccountAssetInformation queryUserAssets(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_account_position_info/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        accountInterface accountInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.accountInterface.class);

        TreeMap<String,Object> queries = client.getAccount().generate_queries();

        queries.put("signature",client.getAuth().createSignature("POST","https://api.hbdm.com/swap-api/v1/swap_account_position_info",queries));

        Call<AccountAssetInformation> call = accountInterface.queryAccountAssetInformation(queries);

        Response<AccountAssetInformation> response = call.execute();

        return response.body();

    }

    /*

    Trade interface

     */


    @RequiresApi(api = Build.VERSION_CODES.O)
    public PlaceOrder placeAnOrder(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_order/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tradeInterface tradeInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.tradeInterface.class);

        TreeMap<String,Object> queries = client.getTrade().generateQueries();

        queries.put("signature",client.getAuth().createSignature("POST","https://api.hbdm.com/swap-api/v1/swap_order",queries));

        Call<PlaceOrder> call = tradeInterface.placeOrder(queries);

        Response<PlaceOrder> response = call.execute();

        return response.body();

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public BatchOrder placeBatchOrder(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_batchorder/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tradeInterface tradeInterface = retrofit.create(tradeInterface.class);

        TreeMap<String,Object> queries = client.getTrade().generateQueries();

        queries.put("signature",client.getAuth().createSignature("POST","https://api.hbdm.com/swap-api/v1/swap_batchorder",queries));

        Call<BatchOrder> call = tradeInterface.placeBatchOrder(queries);

        Response<BatchOrder> response = call.execute();

        return response.body();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public CancelOrder cancelOrder(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_cancel/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tradeInterface tradeInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.tradeInterface.class);

        TreeMap<String,Object> queries = client.getTrade().generateQueries();

        queries.put("signature",client.getAuth().createSignature("POST","https://api.hbdm.com/swap-api/v1/swap_cancel",queries));

        Call<CancelOrder> call = tradeInterface.cancelOrder(queries);

        Response<CancelOrder> response = call.execute();

        return response.body();



    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public CancelOrder cancelAllOrders(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_cancelall/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tradeInterface tradeInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.tradeInterface.class);

        TreeMap<String,Object> queries = client.getTrade().generateQueries();

        queries.put("signature",client.getAuth().createSignature("POST","https://api.hbdm.com/swap-api/v1/swap_cancelall",queries));

        Call<CancelOrder> call = tradeInterface.cancelAllOrders(queries);

        Response<CancelOrder> response = call.execute();

        return response.body();


    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public OrderInfo getOrderInformation(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_order_info/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tradeInterface tradeInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.tradeInterface.class);

        TreeMap<String,Object> queries = client.getTrade().generateQueries();

        queries.put("signature",client.getAuth().createSignature("POST","https://api.hbdm.com/swap-api/v1/swap_order_info",queries));

        Call<OrderInfo> call = tradeInterface.getOrderInfo(queries);

        Response<OrderInfo> response = call.execute();

        return response.body();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public OrderDetailsAcquisition getOrderDetails(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_order_detail/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tradeInterface tradeInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.tradeInterface.class);

        TreeMap<String,Object> queries = client.getTrade().generateQueries();

        queries.put("signature",client.getAuth().createSignature("POST","https://api.hbdm.com/swap-api/v1/swap_order_detail",queries));

        Call<OrderDetailsAcquisition> call = tradeInterface.getOrderDetailsAcquisition(queries);

        Response<OrderDetailsAcquisition> response = call.execute();

        return response.body();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public UnfilledOrder getCurrentUnfilledOrderAcquisitions(HuobiClient client) throws IOException {

        String url = baseUrl + "/swap-api/v1/swap_openorders/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tradeInterface tradeInterface = retrofit.create(com.example.nctai_trading.huobi.InterfaceModel.tradeInterface.class);

        TreeMap<String,Object> queries = client.getTrade().generateQueries();

        queries.put("signature",client.getAuth().createSignature("POST","https://api.hbdm.com/swap-api/v1/swap_openorders",queries));

        Call<UnfilledOrder> call = tradeInterface.getUnfilledOrderAcquisition(queries);

        Response<UnfilledOrder> response = call.execute();

        return response.body();

    }














}
