package com.example.nctai_trading.huobi.InterfaceModel;


import com.example.nctai_trading.huobi.Controller.MarketDataAPI.ContractTradeRecordBatch.ContractTradeRecordBatch;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.KlineData.KlineData;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.KlineData.MarkPrice.MarkPrice;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.LastContractTrade.LastContractTrade;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketBBO.MarketBBO;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketDepth.MarketDepth;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketOverview.Batch.MarketDataOverviewBatch;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.MarketOverview.MarketOverview;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.SwapContractInfo.SwapContractInfo;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.SwapIndexPrice.SwapIndexPrice;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.SwapInterestInfo.SwapInterestInfo;
import com.example.nctai_trading.huobi.Controller.MarketDataAPI.SwapPriceLimit.SwapPriceLimit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.TreeMap;

public interface marketInterface {

    @GET("https://api.hbdm.com/swap-api/v1/swap_contract_info")
    Call<SwapContractInfo> querySwapInfo(@QueryMap TreeMap<String,Object> queries);

    @GET("https://api.hbdm.com/swap-api/v1/swap_index")
    Call<SwapIndexPrice> querySwapIndexPrice(@QueryMap TreeMap<String,Object> queries);

    @GET("https://api.hbdm.com/swap-api/v1/swap_price_limit")
    Call<SwapPriceLimit> querySwapPriceLimit(@QueryMap TreeMap<String,Object> queries);

    @GET("https://api.hbdm.com/swap-api/v1/swap_open_interest")
    Call<SwapInterestInfo> querySwapInterestInfo(@QueryMap TreeMap<String,Object> queries);

    @GET("https://api.hbdm.com/swap-ex/market/depth")
    Call<MarketDepth> queryMarketDepth(@QueryMap TreeMap<String,Object> queries);

    @GET("https://api.hbdm.com/swap-ex/market/bbo")
    Call<MarketBBO> queryMarketBBO(@QueryMap TreeMap<String,Object> queries);

    @GET("https://api.hbdm.com/swap-ex/market/history/kline")
    Call<KlineData> queryKlineData(@QueryMap TreeMap<String,Object> queries);

    @GET("https://api.hbdm.com/index/market/history/swap_mark_price_kline")
    Call<MarkPrice> queryKlineMarkPrice(@QueryMap TreeMap<String,Object> queries);

    @GET("https://api.hbdm.com/swap-ex/market/detail/merged")
    Call<MarketOverview> queryMarketOverview(@QueryMap TreeMap<String,Object> queries);

    @GET("https://api.hbdm.com/swap-ex/market/detail/batch_merged")
    Call<MarketDataOverviewBatch> queryMarketOverviewBatch(@QueryMap TreeMap<String,Object> queries);

    @GET("https://api.hbdm.com/swap-ex/market/trade")
    Call<LastContractTrade> queryLastContractTrade(@QueryMap TreeMap<String,Object> queries);

    @GET("https://api.hbdm.com/swap-ex/market/history/trade")
    Call<ContractTradeRecordBatch> queryContractTradeRecordBatch(@QueryMap TreeMap<String,Object> queries);

}
