package com.example.nctai_trading.bibox;


import java.io.IOException;

public class V1CreditProxy extends BaseProxy
{
    public V1CreditProxy(BiBoxHttpClientConfig config, HttpClientHelper helper)
    {
        super.config = config;
        super.helper = helper;
    }

    @Override
    public String getUrl()
    {
        return config.getHost().concat(UrlConstants.V1_CREDIT);
    }

    public String lendOrderBookPublish(LendPublishParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createLendOrderBookPublishCmd(params));
    }

    public String lendOrderBookCancel(String id) throws IOException
    {
        return postSign(V1ParamsUtils.createLendOrderBookCancelCmd(id));
    }

    public String lendOrderBookGet(LendOrderBookGetParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createLendOrderBookGetCmd(params));
    }

    public String lendOrderGet(LendOrderGetParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createLendOrderGetCmd(params));
    }

    public String transferAssetsLendAssets(String symbol) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferAssetsLendAssetsCmd(symbol));
    }

    public String borrowOrderBook(BorrowOrderBookParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createBorrowOrderBookCmd(params));
    }

    public String borrowOrderCancel(Long id) throws IOException
    {
        return postSign(V1ParamsUtils.createBorrowOrderCancelCmd(id));
    }

    public String borrowOrderRefund(Long id, String amount) throws IOException
    {
        return postSign(V1ParamsUtils.createBorrowOrderRefundCmd(id, amount));
    }

    public String borrowOrderGet(BorrowOrderGetParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createBorrowOrderGetCmd(params));
    }

    public String borrowDepthGet(String symbol, String pair) throws IOException
    {
        return postSign(V1ParamsUtils.createBorrowDepthGetCmd(symbol, pair));
    }

    public String transferAssetsBorrowAssets(String symbol, String currency) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferAssetsBorrowAssetsCmd(symbol, currency));
    }

    public String transferAssetsBase2credit(String symbol, String amount, String pair) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferAssetsBase2CreditCmd(symbol, amount, pair));
    }

    public String transferAssetsCredit2Base(String symbol, String amount, String pair) throws IOException
    {
        return postSign(V1ParamsUtils.createTransferAssetsCredit2BaseCmd(symbol, amount, pair));
    }


    public String creditTrade(TradeParams params) throws IOException
    {
        return postSign(V1ParamsUtils.createCreditTradeTradeCmd(params));
    }

    public String creditTradeCancel(String index, String id) throws IOException
    {
        return postSign(V1ParamsUtils.createCreditTradeCancelCmd(index, id));
    }

}

