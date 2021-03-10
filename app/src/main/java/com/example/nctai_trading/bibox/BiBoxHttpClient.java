package com.example.nctai_trading.bibox;


import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BiBoxHttpClient
{
    BiBoxHttpClientConfig config;
    private HttpClientHelper helper;

    private V1MDataProxy mDataProxy;
    private V1CreditProxy mCreditProxy;
    private V1CTradeProxy mCTradeProxy;
    private V1TransferProxy v1MTransferProxy;
    private V2AssetsTransferSpotProxy spotProxy;
    private V1CTradeQueryProxy mCTradeQueryProxy;
    private V1OrderPendingProxy mOrderPendingProxy;

    public BiBoxHttpClient(BiBoxHttpClientConfig config)
    {
        this.config = config;
        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder().connectTimeout(config.getConnectTimeout(), TimeUnit.SECONDS).readTimeout(config.getReadTimeout(), TimeUnit.SECONDS).writeTimeout(config.getWriteTimeout(), TimeUnit.SECONDS);
        this.helper = HttpClientHelper.getOkHttpBuilder(okBuilder);
        mCTradeQueryProxy = new V1CTradeQueryProxy(config, helper);
        mDataProxy = new V1MDataProxy(config, this.helper);
        mCTradeProxy = new V1CTradeProxy(config, this.helper);
        mCreditProxy = new V1CreditProxy(config, this.helper);
        spotProxy = new V2AssetsTransferSpotProxy(config, helper);
        v1MTransferProxy = new V1TransferProxy(config, this.helper);
        mOrderPendingProxy = new V1OrderPendingProxy(config, this.helper);
    }

    /**
     * 网络测试
     *
     * @return
     * @throws IOException
     */
    public String ping() throws IOException
    {
        return mDataProxy.ping();
    }

    /**
     * 查询交易对
     *
     * @return
     * @throws IOException
     */
    public String pairList() throws IOException
    {
        return mDataProxy.pairList();
    }

    /**
     * 查询k线
     *
     * @param pair   交易对 BIX_BTC, ETH_BTC, ...
     * @param period K线周期 是一个枚举 '1min', '3min', '5min', '15min', '30min', '1hour' ...
     * @param size   数量 1-1000
     * @return
     * @throws IOException
     */
    public String kline(String pair, KLinePeriodEnum period, Integer size) throws IOException
    {
        return mDataProxy.kline(pair, period, size);
    }

    /**
     * 查询全币种市场行情
     *
     * @return
     * @throws IOException
     */
    public String marketAll() throws IOException
    {
        return mDataProxy.marketAll();
    }

    /**
     * 查询单币种市场行情
     *
     * @param pair 交易对 BIX_BTC, ETH_BTC, ...
     * @return
     * @throws IOException
     */
    public String market(String pair) throws IOException
    {
        return mDataProxy.market(pair);
    }

    /**
     * 查询市场深度
     *
     * @param pair 交易对 BIX_BTC, ETH_BTC, ...
     * @param size 数量 1-200
     * @return
     * @throws IOException
     */
    public String depth(String pair, Integer size) throws IOException
    {
        return mDataProxy.depth(pair, size);
    }

    /**
     * 查询成交记录
     *
     * @param pair 交易对 BIX_BTC, ETH_BTC, ...
     * @param size 数量 1-200
     * @return
     * @throws IOException
     */
    public String deals(String pair, Integer size) throws IOException
    {
        return mDataProxy.deals(pair, size);
    }

    /**
     * 查询市场ticker
     *
     * @param pair 交易对	 BIX_BTC, ETH_BTC, ...
     * @return
     * @throws IOException
     */
    public String ticker(String pair) throws IOException
    {
        return mDataProxy.ticker(pair);
    }

    /**
     * 下单限制信息
     *
     * @return
     * @throws IOException
     */
    public String tradeLimit() throws IOException
    {
        return mOrderPendingProxy.tradeLimit();
    }

    /**
     * 币币账户资产
     *
     * @param select 是否查询资产明细 不传-各币种总资产合计，1-请求所有币种资产明细
     * @return
     * @throws IOException
     */
    public String transferAssets(Integer select) throws IOException
    {
        return v1MTransferProxy.transferAssets(select);
    }

    /**
     * 钱包账户
     *
     * @param select 不传-各币种总资产合计，1-请求所有币种资产明细
     * @return
     * @throws IOException
     */
    public String transferMainAssets(Integer select) throws IOException
    {
        return v1MTransferProxy.transferMainAssets(select);
    }

    /**
     * 信用账户资产
     *
     * @param select 不传-各币种总资产合计，1-请求所有币种资产明细
     * @return
     * @throws IOException
     */
    public String transferCreditAssets(Integer select) throws IOException
    {
        return v1MTransferProxy.transferCreditAssets(select);
    }

    /**
     * 充值
     *
     * @param symbol 充值币种	 BTC,ETH...
     * @return
     * @throws IOException
     */
    public String transferTransferIn(String symbol) throws IOException
    {
        return v1MTransferProxy.transferTransferIn(symbol);
    }

    /**
     * 提现
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String transferTransferOut(TransferOutParams params) throws IOException
    {
        return v1MTransferProxy.transferTransferOut(params);
    }

    /**
     * 查询充值记录
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String transferTransferInList(TransferInListParams params) throws IOException
    {
        return v1MTransferProxy.transferTransferInList(params);
    }

    /**
     * 查询提现记录
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String transferTransferOutList(TransferOutListParams params) throws IOException
    {
        return v1MTransferProxy.transferTransferOutList(params);
    }

    /**
     * 获取币种配置
     *
     * @param symbol 币种
     * @return
     * @throws IOException
     */
    public String transferCoinConfig(String symbol) throws IOException
    {
        return v1MTransferProxy.transferCoinConfig(symbol);
    }

    /**
     * 查询某一条提现记录
     *
     * @param id 提现id
     * @return
     * @throws IOException
     */
    public String transferWithdrawInfo(Long id) throws IOException
    {
        return v1MTransferProxy.transferWithdrawInfo(id);
    }

    /**
     * 下单
     *
     * @param index     用户自定义随机数
     * @param pair      交易对
     * @param orderSide 交易方向
     * @param price     委托价格
     * @param amount    委托数量
     * @return
     * @throws IOException
     */
    public String orderPendingTrade(String index, String pair, OrderSideEnum orderSide, Double price, Double amount) throws IOException
    {
        return mOrderPendingProxy.orderPendingTrade(index, pair, orderSide, price, amount);
    }

    /**
     * 撤单
     *
     * @param index 用户自定义随机数
     * @param id    委托单id
     * @return
     * @throws IOException
     */
    public String orderPendingCancelTrade(String index, String id) throws IOException
    {
        return mOrderPendingProxy.orderPendingCancelTrade(index, id);
    }

    /**
     * 当前委托
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String orderPendingOrderPendingList(OrderPendingListParams params) throws IOException
    {
        return mOrderPendingProxy.orderPendingOrderPendingList(params);
    }

    /**
     * 历史委托
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String orderPendingPendingHistoryList(OrderPendingHistoryListParams params) throws IOException
    {
        return mOrderPendingProxy.orderPendingPendingHistoryList(params);
    }

    /**
     * 成交记录
     *
     * @param id          委托单id
     * @param accountType 账户类型 0-币币账户
     * @return
     * @throws IOException
     */
    public String orderPendingOrderDetail(String id, AccountTypeEnum accountType) throws IOException
    {
        return mOrderPendingProxy.orderPendingOrderDetail(id, accountType);
    }

    /**
     * 委托单详情
     *
     * @param id          委托单id
     * @param accountType 账户类型
     * @return
     * @throws IOException
     */
    public String orderPendingOrder(String id, AccountTypeEnum accountType) throws IOException
    {
        return mOrderPendingProxy.orderPendingOrder(id, accountType);
    }

    /**
     * 成交明细
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String orderPendingOrderHistoryList(OrderPendingListParams params) throws IOException
    {
        return mOrderPendingProxy.orderPendingOrderHistoryList(params);
    }

    /**
     * 发布预定放贷信息
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String lendOrderBookPublish(LendPublishParams params) throws IOException
    {
        return mCreditProxy.lendOrderBookPublish(params);
    }

    /**
     * 撤销预定放贷信息
     *
     * @param id 订单id
     * @return
     * @throws IOException
     */
    public String lendOrderBookCancel(String id) throws IOException
    {
        return mCreditProxy.lendOrderBookCancel(id);
    }

    /**
     * 获取自己的预定放贷信息
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String lendOrderBookGet(LendOrderBookGetParams params) throws IOException
    {
        return mCreditProxy.lendOrderBookGet(params);
    }

    /**
     * 获取自己的放贷信息
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String lendOrderGet(LendOrderGetParams params) throws IOException
    {
        return mCreditProxy.lendOrderGet(params);
    }

    /**
     * 获取自己的放贷资产信息
     *
     * @param symbol 交易币种
     * @return
     * @throws IOException
     */
    public String transferAssetsLendAssets(String symbol) throws IOException
    {
        return mCreditProxy.transferAssetsLendAssets(symbol);
    }

    /**
     * 发起借贷
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String borrowOrderBook(BorrowOrderBookParams params) throws IOException
    {
        return mCreditProxy.borrowOrderBook(params);
    }

    /**
     * 订单id
     *
     * @param id
     * @return
     * @throws IOException
     */
    public String borrowOrderCancel(Long id) throws IOException
    {
        return mCreditProxy.borrowOrderCancel(id);
    }

    /**
     * 还款
     *
     * @param id     借款单id
     * @param amount 还款数量
     * @return
     * @throws IOException
     */
    public String borrowOrderRefund(Long id, String amount) throws IOException
    {
        return mCreditProxy.borrowOrderRefund(id, amount);
    }

    /**
     * 获取自己的借贷信息
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String borrowOrderGet(BorrowOrderGetParams params) throws IOException
    {
        return mCreditProxy.borrowOrderGet(params);
    }

    /**
     * 获取信用交易深度
     *
     * @param symbol 交易币种
     * @param pair   交易对
     * @return
     * @throws IOException
     */
    public String borrowDepthGet(String symbol, String pair) throws IOException
    {
        return mCreditProxy.borrowDepthGet(symbol, pair);
    }

    /**
     * 获取信用账户资产
     *
     * @param symbol   交易币种
     * @param currency 定价币种
     * @return
     * @throws IOException
     */
    public String transferAssetsBorrowAssets(String symbol, String currency) throws IOException
    {
        return mCreditProxy.transferAssetsBorrowAssets(symbol, currency);
    }

    /**
     * 信用下单
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String creditTrade(TradeParams params) throws IOException
    {
        return mCreditProxy.creditTrade(params);
    }

    /**
     * 信用撤单
     *
     * @param index 用户自定义随机数
     * @param id    委托单id
     * @return
     * @throws IOException
     */
    public String creditTradeCancel(String index, String id) throws IOException
    {
        return mCreditProxy.creditTradeCancel(index, id);
    }

    /**
     * 钱包账户划转到信用账户
     *
     * @param symbol 币种
     * @param amount 转账金额
     * @param pair   交易对
     * @return
     * @throws IOException
     */
    public String transferAssetsBase2credit(String symbol, String amount, String pair) throws IOException
    {
        return mCreditProxy.transferAssetsBase2credit(symbol, amount, pair);
    }

    /**
     * 信用户划转到钱包账户
     *
     * @param symbol 币种
     * @param amount 转账金额
     * @param pair   交易对
     * @return
     * @throws IOException
     */
    public String transferAssetsCredit2Base(String symbol, String amount, String pair) throws IOException
    {
        return mCreditProxy.transferAssetsCredit2Base(symbol, amount, pair);
    }

    /**
     * 钱包账户划转到币币账户
     *
     * @param symbol 币种
     * @param amount 转账金额
     * @param type   转账类型 0钱包转币币; 1币币转钱包
     * @return
     * @throws IOException
     */
    public String transferSpot(String symbol, String amount, TransferSpotTypeEnum type) throws IOException
    {
        return spotProxy.transferSpot(symbol, amount, type);
    }

    /**
     * 查询合约市场成交记录
     *
     * @param index
     * @param pair
     * @param size
     * @return
     * @throws IOException
     */
    public String cQueryDeals(String index, String pair, Integer size) throws IOException
    {
        return mCTradeQueryProxy.cQueryDeals(index, pair, size);
    }

    /**
     * 查询合约资产
     *
     * @return
     * @throws IOException
     */
    public String cQueryAssets() throws IOException
    {
        return mCTradeQueryProxy.cQueryAssets();
    }

    /**
     * 查询单个合约持仓信息
     *
     * @param pair 合约符号 4BTC_USDT,4ETH_USDT, ...
     * @return
     * @throws IOException
     */
    public String cQueryOrder(String pair) throws IOException
    {
        return mCTradeQueryProxy.cQueryOrder(pair);
    }

    /**
     * 查询所有合约持仓信息
     *
     * @param pair 合约符号 4BTC_USDT,4ETH_USDT, ...
     * @return
     * @throws IOException
     */
    public String cQueryOrderAll(String pair) throws IOException
    {
        return mCTradeQueryProxy.cQueryOrderAll(pair);
    }

    /**
     * 查询合约未成交订单
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String cQueryOrderPending(CQueryOrderPendingParams params) throws IOException
    {
        return mCTradeQueryProxy.cQueryOrderPending(params);
    }

    /**
     * 通过订单号查询合约未成交订单
     *
     * @param ids 订单号 最大长度限制50单
     * @return
     * @throws IOException
     */
    public String cQueryOrderPendingByIds(List<Long> ids) throws IOException
    {
        return mCTradeQueryProxy.cQueryOrderPendingByIds(ids);
    }


    /**
     * 查询个人成交记录
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String cQueryOrderList(CQueryOrderListParams params) throws IOException
    {
        return mCTradeQueryProxy.cQueryOrderList(params);
    }

    /**
     * 合约下单
     *
     * @param params
     * @return
     * @throws IOException
     */
    public String cOrderOpen(CTradeOrderOpenParams params) throws IOException
    {
        return mCTradeProxy.orderOpen(params);
    }

    /**
     * 合约撤单
     *
     * @param id 订单号
     * @return
     * @throws IOException
     */
    public String cOrderClose(String id) throws IOException
    {
        return mCTradeProxy.orderClose(id);
    }

    /**
     * 合约撤多单
     *
     * @param orderIds
     * @return
     * @throws IOException
     */
    public String cOrderCloseBatch(List<String> orderIds) throws IOException
    {
        return mCTradeProxy.orderCloseBatch(orderIds);
    }


    /**
     * 合约撤1000单
     *
     * @param pair 合约符号
     * @return
     * @throws IOException
     */
    public String cOrderCloseAll(String pair) throws IOException
    {
        return mCTradeProxy.orderCloseAll(pair);
    }

    /**
     * 合约调整杠杆倍数
     *
     * @param pair     合约符号
     * @param leverage 杠杆倍数	全仓:0,逐仓:1,2,...
     * @param cross    是否全仓 0逐仓，1全仓
     * @return
     * @throws IOException
     */
    public String cOrderChangeLeverage(String pair, Integer leverage, Integer cross) throws IOException
    {
        return mCTradeProxy.orderChangeLeverage(pair, leverage, cross);
    }

    /**
     * 合约调整保证金
     *
     * @param pair   合约符号
     * @param margin 增减保证金 增加margin>=0.5;减少margin<=-0.5
     * @return
     * @throws IOException
     */
    public String cOrderChangeMargin(String pair, Double margin) throws IOException
    {
        return mCTradeProxy.orderChangeMargin(pair, margin);
    }

    /**
     * 主账户资金转入合约账户
     *
     * @param amount 金额
     * @return
     * @throws IOException
     */
    public String cTransferIn(String amount) throws IOException
    {
        return mCTradeProxy.transferIn(amount);
    }

    public static void main(String[] args) throws IOException
    {
        String apiKey = "Yours ApiKey";
        String secret = "Yours ApiSecret";
        // 不需要apikey
        //BiBoxHttpClient defaults = BiBoxClient.ofDefaults();

        BiBoxHttpClientConfig config = BiBoxHttpClientConfig
                .custom().host("https://api.bibox365.com")
                .apiKey(apiKey)
                .secret(secret)
                .build();
        BiBoxHttpClient client = BiBoxClient.of(config);

        client.ping();
        client.pairList();

        client.kline("BIX_BTC", KLinePeriodEnum.MIN_15, 10);
        client.marketAll();
        client.market("BIX_BTC");
        client.depth("BIX_BTC", 200);
        client.deals("BIX_BTC", 200);
        client.ticker("BIX_BTC");
        client.tradeLimit();
        client.transferAssets(1);
        client.transferTransferIn("BIX");

        TransferOutParams params = new TransferOutParams();
        params.setCoinSymbol("BIX");
        params.setAmount(2);
        params.setTotpCode("123");
        params.setTradePwd("123456");
        params.setAddr("asdas");
        params.setAddrRemark("asdasda");
        params.setMemo("memo");
        client.transferTransferOut(params);

        TransferInListParams params1 = new TransferInListParams();
        params1.setFilterType(DepositListFilterTypeEnum.FINISH);
        params1.setSymbol("ETH");
        client.transferTransferInList(params1);

        TransferOutListParams params2 = new TransferOutListParams();
        client.transferTransferOutList(params2);
        client.transferCoinConfig("BTC");

        client.transferWithdrawInfo(1l);
        client.orderPendingTrade("111", "BIX_BTC", OrderSideEnum.BID, 0.00002474, 5d);

        client.orderPendingCancelTrade("1111", "11110000009");

        OrderPendingListParams params3 = new OrderPendingListParams();
        client.orderPendingOrderPendingList(params3);

        OrderPendingHistoryListParams params4 = new OrderPendingHistoryListParams();
        params4.setHideCancel(0);
        params4.setCoinSymbol("BIX");
        params4.setSize(2);
        client.orderPendingPendingHistoryList(params4);

        client.orderPendingOrderDetail("12323132432424324324", AccountTypeEnum.MAIN);

        client.orderPendingOrder("11111111111111111", AccountTypeEnum.MAIN);

        OrderPendingListParams params5 = new OrderPendingListParams();
        params5.setCoinSymbol("BIX");
        params5.setCurrencySymbol("BTC");
        params5.setOrderSide(OrderSideEnum.BID);
        client.orderPendingOrderHistoryList(params5);

        LendPublishParams params6 = new LendPublishParams();
        params6.setCoinSymbol("EOS");
        params6.setAmount(10);
        params6.setInterestRate(0.001);
        params6.setInsurance(1);
        params6.setForce(1);
        client.lendOrderBookPublish(params6);

        client.lendOrderBookCancel("1111111l");
        LendOrderBookGetParams params7 = new LendOrderBookGetParams();
        params7.addStatus(LendOrderBookStatusEnum.DEAL_ALL);
        params7.addStatus(LendOrderBookStatusEnum.DEAL_PART);
        params7.addStatus(LendOrderBookStatusEnum.WAIT_DEAL);
        client.lendOrderBookGet(params7);

        LendOrderGetParams params8 = new LendOrderGetParams();
        params8.addStatus(LendOrderStatusEnum.WAIT_GET);
        params8.addStatus(LendOrderStatusEnum.DEAL_ALL_GET);
        client.lendOrderGet(params8);
        client.transferAssetsLendAssets("BTC");

        BorrowOrderBookParams params9 = new BorrowOrderBookParams();
        params9.setCoinSymbol("EOS");
        params9.setPair("EOS_USDT");
        params9.setAmount("2");
        params9.setInterestRate(1);
        client.borrowOrderBook(params9);

        client.borrowOrderCancel(11111111l);
        client.borrowOrderRefund(1l, "2");

        BorrowOrderGetParams params10 = new BorrowOrderGetParams();
        params10.setCoinSymbol("EOS");
        params10.setPair("EOS_USDT");
        params10.addStatus(BorrowOrderStatusEnum.REFOUND_PART);
        params10.addStatus(BorrowOrderStatusEnum.BORROW_SUCCESS);
        params10.addStatus(BorrowOrderStatusEnum.REFOUND_SUC_3);
        client.borrowOrderGet(params10);

        client.borrowDepthGet("EOS", "EOS_USDT");
        client.transferAssetsBorrowAssets("EOS", "USDT");

        TradeParams params11 = new TradeParams();
        params11.setPair("EOS_USDT");
        params11.setOrderType(OrderTypeEnum.LIMIT);
        params11.setOrderSide(OrderSideEnum.BID);
        params11.setPrice(4.18);
        params.setAmount(0.5);
        client.creditTrade(params11);

        client.creditTradeCancel("11111", "1234566");
        client.transferMainAssets(1);
        client.transferCreditAssets(null);
        client.transferSpot("USDT", "2", TransferSpotTypeEnum.COIN);
        client.transferAssetsBase2credit("USDT", "1", "BTC_USDT");
        client.transferAssetsCredit2Base("USDT", "1", "BTC_USDT");
        client.cQueryAssets();
        client.cQueryOrder("4BTC_USDT");
        client.cQueryOrderAll("4BTC_USDT");

        CQueryOrderPendingParams params12 = new CQueryOrderPendingParams();
        params12.setPair("4BTC_USDT");
        client.cQueryOrderPending(params12);

        CTradeOrderOpenParams params13 = new CTradeOrderOpenParams();
        params13.setOrderType(OrderTypeEnum.LIMIT);
        params13.setOrderSide(COrderSideEnum.UP);
        params13.setPair("4BTC_USDT");
        params13.setPrice("11887.62");
        params13.setContract("1");
        params13.setLeverage(50);
        client.cOrderOpen(params13);

        client.cOrderClose("564139660");
        client.cTransferIn("10");
        client.cQueryDeals("11111", "4BTC_USDT", 2);
        CQueryOrderListParams params14 = new CQueryOrderListParams();
        params14.setType(CTypeEnum.CLOSE);
        client.cQueryOrderList(params14);
    }
}
