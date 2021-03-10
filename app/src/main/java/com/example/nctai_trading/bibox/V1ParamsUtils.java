package com.example.nctai_trading.bibox;

import android.os.Build;

import androidx.annotation.RequiresApi;



import java.util.*;

public class V1ParamsUtils
{

    public static Map<String, Object> createPingCmd()
    {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", CmdConstants.PING_CMD);
        params.put("body", Collections.EMPTY_MAP);
        return params;
    }

    public static Map<String, Object> createAPIPairListCmd()
    {
        Map<String, Object> params = new HashMap<>();
        params.put("cmd", CmdConstants.API_PAIR_LIST_CMD);
        params.put("body", Collections.EMPTY_MAP);
        return params;
    }

    public static Map<String, Object> createKLineCmd(String pair, KLinePeriodEnum period, Integer size)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", pair);
        body.put("period", period.getPeriod());
        body.put("size", Optional.ofNullable(size).orElse(1000));
        params.put("cmd", CmdConstants.API_K_LINE_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createMarketAllCmd()
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        params.put("cmd", CmdConstants.API_MARKET_ALL_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createMarketCmd(String pair)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", pair);
        params.put("cmd", CmdConstants.API_MARKET_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createDepthCmd(String pair, Integer size)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", pair);
        body.put("size", Optional.ofNullable(size).orElse(200));
        params.put("cmd", CmdConstants.API_DEPTH_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createDealsCmd(String pair, Integer size)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", pair);
        body.put("size", Optional.ofNullable(size).orElse(200));
        params.put("cmd", CmdConstants.API_DEALS_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createTickerCmd(String pair)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", pair);
        params.put("cmd", CmdConstants.API_TICKER_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createTradeLimitCmd()
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        params.put("cmd", CmdConstants.API_TRADE_LIMIT_CMD);
        params.put("body", body);
        return params;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 以下需要api_key
    ///////////////////////////////////////////////////////////////////////////

    public static Map<String, Object> createTransferAssetsCmd(Integer select)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("select", Optional.ofNullable(select).orElse(0));
        params.put("cmd", CmdConstants.TRANSFER_ASSETS_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createTransferTransferInCmd(String symbol)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_symbol", symbol);
        params.put("cmd", CmdConstants.TRANSFER_TRANSFER_IN_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createTransferTransferOutCmd(TransferOutParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_symbol", params.getCoinSymbol());
        body.put("amount", params.getAmount());
        body.put("totp_code", params.getTotpCode());
        body.put("trade_pwd", params.getTradePwd());
        body.put("addr", params.getAddr());
        body.put("addr_remark", params.getAddrRemark());
        body.put("memo", params.getMemo());
        cmd.put("cmd", CmdConstants.TRANSFER_TRANSFER_OUT_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createTransferTransferInListCmd(TransferInListParams paramsIn)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("filter_type", paramsIn.getFilterType().getFlag());
        body.put("coin_symbol", paramsIn.getSymbol());
        body.put("page", Optional.ofNullable(paramsIn.getPage()).orElse(1));
        body.put("size", Optional.ofNullable(paramsIn.getPage()).orElse(50));
        params.put("cmd", CmdConstants.TRANSFER_TRANSFER_IN_LIST_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createTransferTransferOutListCmd(TransferOutListParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("filter_type", params.getFilterType().getFlag());
        body.put("coin_symbol", params.getSymbol());
        body.put("page", Optional.ofNullable(params.getPage()).orElse(1));
        body.put("size", Optional.ofNullable(params.getPage()).orElse(50));
        cmd.put("cmd", CmdConstants.TRANSFER_TRANSFER_OUT_LIST_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createTransferTransferCoinConfigCmd(String symbol)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        if (!"".equals(symbol)) {
            body.put("coin_symbol", symbol);
        }
        cmd.put("cmd", CmdConstants.TRANSFER_COIN_CONFIG_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createTransferTransferWithdrawInfoCmd(Long id)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("id", id);
        cmd.put("cmd", CmdConstants.TRANSFER_WITHDRAW_INFO_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createOrderPendingTradeCmd(TradeParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", params.getPair());
        body.put("account_type", params.getAccountType().getFlag());
        body.put("order_type", params.getOrderType().getFlag());
        body.put("order_side", params.getOrderSide().getFlag());
        body.put("price", params.getPrice());
        body.put("amount", params.getAmount());
        cmd.put("cmd", CmdConstants.ORDERPENDING_TRADE_CMD);
        cmd.put("body", body);
        if (!"".equals(params.getIndex())) {
            cmd.put("index", params.getIndex());
        }
        return cmd;
    }

    public static Map<String, Object> createCancelTradeCmd(String index, String orderId)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("orders_id", orderId);
        cmd.put("cmd", CmdConstants.ORDERPENDING_CANCEL_TRADE_CMD);
        cmd.put("body", body);
        cmd.put("index", index);
        return cmd;
    }

    public static Map<String, Object> createOrderPendingListCmd(OrderPendingListParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", Optional.ofNullable(params.getPair()).orElse(""));
        body.put("account_type", Optional.ofNullable(params.getAccountType()).orElse(AccountTypeEnum.MAIN).getFlag());
        if (params.getOrderSide() != null) {
            body.put("order_side", params.getOrderSide().getFlag());
        }
        body.put("coin_symbol", Optional.ofNullable(params.getCoinSymbol()).orElse(""));
        body.put("currency_symbol", Optional.ofNullable(params.getCurrencySymbol()).orElse(""));
        body.put("page", Optional.ofNullable(params.getPage()).orElse(1));
        body.put("size", Optional.ofNullable(params.getSize()).orElse(50));
        cmd.put("cmd", CmdConstants.ORDERPENDING_ORDERPENDING_LIST_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createOrderPendingHistoryListCmd(OrderPendingHistoryListParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", params.getPair());
        body.put("account_type", Optional.ofNullable(params.getAccountType()).orElse(AccountTypeEnum.MAIN).getFlag());
        if (params.getOrderSide() != null) {
            body.put("order_side", params.getOrderSide().getFlag());
        }
        body.put("coin_symbol", Optional.ofNullable(params.getCoinSymbol()).orElse(""));
        body.put("currency_symbol", Optional.ofNullable(params.getCurrencySymbol()).orElse(""));
        body.put("hide_cancel", Optional.ofNullable(params.getHideCancel()).orElse(0));
        body.put("page", Optional.ofNullable(params.getPage()).orElse(1));
        body.put("size", Optional.ofNullable(params.getSize()).orElse(50));
        cmd.put("cmd", CmdConstants.ORDERPENDING_PENDING_HISTORY_LIST_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createOrderPendingOderDetailCmd(String id, AccountTypeEnum accountType)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("id", id);
        body.put("account_type", accountType.getFlag());
        cmd.put("cmd", CmdConstants.ORDERPENDING_ORDER_DETAIL);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createOrderPendingOrderCmd(String id, AccountTypeEnum accountType)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("id", id);
        body.put("account_type", accountType.getFlag());
        cmd.put("cmd", CmdConstants.ORDERPENDING_ORDER);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createOrderPendingOrderHistoryListCmd(OrderPendingListParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", params.getPair());
        body.put("account_type", Optional.ofNullable(params.getAccountType()).orElse(AccountTypeEnum.MAIN).getFlag());
        if (params.getOrderSide() != null) {
            body.put("order_side", params.getOrderSide().getFlag());
        }
        body.put("coin_symbol", params.getCoinSymbol());
        body.put("currency_symbol", params.getCurrencySymbol());
        body.put("page", Optional.ofNullable(params.getPage()).orElse(1));
        body.put("size", Optional.ofNullable(params.getSize()).orElse(50));
        cmd.put("cmd", CmdConstants.ORDERPENDING_ORDER_HISTORY_LIST_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createLendOrderBookPublishCmd(LendPublishParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_symbol", Optional.ofNullable(params.getCoinSymbol()).orElse(""));
        body.put("amount", params.getAmount());
        body.put("interest_rate", params.getInterestRate());
        body.put("is_insurance", params.getInsurance());
        body.put("force", params.getForce());
        cmd.put("cmd", CmdConstants.LEND_ORDER_BOOK_PUBLISH_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createLendOrderBookCancelCmd(String orderbookId)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("orderbook_id", orderbookId);
        cmd.put("cmd", CmdConstants.LEND_ORDER_BOOK_CANCEL_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createLendOrderBookGetCmd(LendOrderBookGetParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_symbol", params.getCoinSymbol());
        body.put("status", params.flags());
        body.put("page", Optional.ofNullable(params.getPage()).orElse(1));
        body.put("size", Optional.ofNullable(params.getPage()).orElse(50));
        cmd.put("cmd", CmdConstants.LEND_ORDER_BOOK_GET_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createLendOrderGetCmd(LendOrderGetParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_id", params.getCoinId());
        body.put("status", params.flags());
        body.put("page", Optional.ofNullable(params.getPage()).orElse(1));
        body.put("size", Optional.ofNullable(params.getPage()).orElse(50));
        cmd.put("cmd", CmdConstants.LEND_ORDER_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createTransferAssetsLendAssetsCmd(String coinSymbol)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_symbol", coinSymbol);
        cmd.put("cmd", CmdConstants.TRANSFER_ASSETS_LEND_ASSETS_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createBorrowOrderBookCmd(BorrowOrderBookParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_symbol", params.getCoinSymbol());
        body.put("pair", params.getPair());
        body.put("amount", params.getAmount());
        body.put("interest_rate", params.getInterestRate());
        cmd.put("cmd", CmdConstants.BORROW_ORDER_BOOK_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createBorrowOrderCancelCmd(Long orderId)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("order_id", orderId);
        cmd.put("cmd", CmdConstants.BORROW_ORDER_CANCEL_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createBorrowOrderRefundCmd(Long orderId, String amount)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("order_id", orderId);
        body.put("amount", amount);
        cmd.put("cmd", CmdConstants.BORROW_ORDER_REFUND_CMD);
        cmd.put("body", body);
        return cmd;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Map<String, Object> createBorrowOrderGetCmd(BorrowOrderGetParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_symbol", params.getCoinSymbol());
        body.put("pair", params.getPair());
        body.put("status", params.flags());
        body.put("page", Optional.ofNullable(params.getPage()).orElse(1));
        body.put("size", Optional.ofNullable(params.getSize()).orElse(50));
        cmd.put("cmd", CmdConstants.BORROW_ORDER_GET_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createBorrowDepthGetCmd(String coinSymbol, String pair)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_symbol", coinSymbol);
        body.put("pair", pair);
        cmd.put("cmd", CmdConstants.BORROW_DEPTH_GET_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createTransferAssetsBorrowAssetsCmd(String coinSymbol, String currencySymbol)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_symbol", coinSymbol);
        body.put("currency_symbol", currencySymbol);
        cmd.put("cmd", CmdConstants.TRANSFER_ASSETS_BORROW_ASSETS_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createCreditTradeTradeCmd(TradeParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", params.getPair());
        body.put("account_type", AccountTypeEnum.CREDIT.getFlag());
        body.put("order_type", params.getOrderType().getFlag());
        body.put("order_side", params.getOrderSide().getFlag());
        body.put("price", params.getPrice() + "");
        body.put("amount", params.getAmount() + "");
        cmd.put("cmd", CmdConstants.CREDIT_TRADE_TRADE_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createCreditTradeCancelCmd(String index, String orderId)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        if (!"".equals(index)) {
            body.put("index", index);
        }
        body.put("orders_id", orderId);
        cmd.put("cmd", CmdConstants.CREDIT_TRADE_CANCEL_CMD);
        cmd.put("body", body);
        return cmd;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Map<String, Object> createTransferMainAssetsCmd(Integer select)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        if (Objects.nonNull(select)) {
            body.put("select", select);
        }
        cmd.put("cmd", CmdConstants.TRANSFER_MAIN_ASSETS_CMD);
        cmd.put("body", body);
        return cmd;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Map<String, Object> createTransferCreditAssetsCmd(Integer select)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        if (Objects.nonNull(select)) {
            body.put("select", select);
        }
        cmd.put("cmd", CmdConstants.TRANSFER_CREDIT_ASSETS_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createTransferAssetsBase2CreditCmd(String symbol, String amount, String pair)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_symbol", symbol);
        body.put("amount", amount);
        body.put("pair", pair);
        params.put("cmd", CmdConstants.TRANSFER_ASSETS_BASE2CREDIT_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createTransferAssetsCredit2BaseCmd(String symbol, String amount, String pair)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("coin_symbol", symbol);
        body.put("amount", amount);
        body.put("pair", pair);
        params.put("cmd", CmdConstants.TRANSFER_ASSETS_CREDIT2BASE_CMD);
        params.put("body", body);
        return params;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 合约
    ///////////////////////////////////////////////////////////////////////////

    public static Map<String, Object> createCQueryAssetsCmd()
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        params.put("cmd", CmdConstants.C_QUERY_ASSETS_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createCQueryOrderCmd(String pair)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", pair);
        params.put("cmd", CmdConstants.C_QUERY_ORDER_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createCQueryOrderAllCmd(String pair)
    {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", pair);
        params.put("cmd", CmdConstants.C_QUERY_ORDER_ALL_CMD);
        params.put("body", body);
        return params;
    }

    public static Map<String, Object> createCQueryOrderPendingCmd(CQueryOrderPendingParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("page", params.getPage());
        body.put("size", params.getSize());
        body.put("pair", params.getPair());
        cmd.put("cmd", CmdConstants.C_QUERY_ORDER_PENDING_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createCTradeOrderOpenCmd(CTradeOrderOpenParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("order_type", params.getOrderType().getFlag());
        body.put("leverage", params.getLeverage());
        body.put("order_side", params.getOrderSide().getFlag());
        body.put("price", params.getPrice());
        body.put("contract", params.getContract());
        body.put("pair", params.getPair());
        body.put("order_from", OrderFromEnum.API_KEY.getFlag());
        cmd.put("cmd", CmdConstants.C_ORDER_OPEN_CMD);
        cmd.put("body", body);
        return cmd;
    }

    //fixme 批量下单api文档有问题
    public static Map<String, Object> createCTradeOrderOpenBatchCmd(CTradeOrderOpenParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        cmd.put("cmd", CmdConstants.C_ORDER_OPEN_OPEN_BATCH_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createCTradeOrderCloseCmd(String orderId)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("order_id", orderId);
        cmd.put("cmd", CmdConstants.C_ORDER_CLOSE_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createCTradeOrderCloseBatchCmd(List<String> orderIds)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("order_id", orderIds);
        cmd.put("cmd", CmdConstants.C_ORDER_CLOSE_BATCH_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createCTradeOrderCloseAllCmd(String pair)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", pair);
        cmd.put("cmd", CmdConstants.C_ORDER_CLOSE_ALL_CMD);
        cmd.put("body", body);
        return cmd;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Map<String, Object> createCTradeOrderChangeLeveragelCmd(String pair, Integer leverage, Integer cross)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", pair);
        body.put("leverage", Optional.ofNullable(leverage).orElse(0));
        body.put("cross", cross);
        cmd.put("cmd", CmdConstants.C_ORDER_CHANGE_LEVERAGE_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createCTradeOrderChangeMarginCmd(String pair, Double margin)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", pair);
        body.put("margin", margin);
        cmd.put("cmd", CmdConstants.C_ORDER_CHANGE_MARGIN_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createCTradeTransferInCmd(String amount)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("amount", amount);
        cmd.put("cmd", CmdConstants.C_TRANSFER_IN_CMD);
        cmd.put("body", body);
        return cmd;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Map<String, Object> createCQueryDealsGetCmd(String index, String pair, Integer size)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("index", index);
        body.put("pair", pair);
        body.put("size", Optional.ofNullable(size).orElse(1));
        cmd.put("cmd", CmdConstants.C_QUERY_DEALS_GET_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createCQueryOrderPendingCmd(List<Long> ids)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("ids", ids);
        cmd.put("cmd", CmdConstants.C_QUERY_ORDER_PENDING_BY_IDS_CMD);
        cmd.put("body", body);
        return cmd;
    }

    public static Map<String, Object> createCQueryOrderListCmd(CQueryOrderListParams params)
    {
        Map<String, Object> cmd = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("pair", params.getPair());
        body.put("page", params.getPage());
        body.put("size", params.getSize());
        body.put("begin_time", params.getBeginTime());
        body.put("end_time", params.getEndTime());
        body.put("type", params.getType().getFlag());
        cmd.put("cmd", CmdConstants.C_QUERY_ORDER_LIST_CMD);
        cmd.put("body", body);
        return cmd;
    }
}
