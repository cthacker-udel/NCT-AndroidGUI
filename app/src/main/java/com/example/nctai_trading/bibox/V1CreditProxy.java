package com.example.nctai_trading.bibox;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String lendOrderBookPublish(LendPublishParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createLendOrderBookPublishCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String lendOrderBookCancel(String id) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createLendOrderBookCancelCmd(id));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String lendOrderBookGet(LendOrderBookGetParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createLendOrderBookGetCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String lendOrderGet(LendOrderGetParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createLendOrderGetCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferAssetsLendAssets(String symbol) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferAssetsLendAssetsCmd(symbol));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String borrowOrderBook(BorrowOrderBookParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createBorrowOrderBookCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String borrowOrderCancel(Long id) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createBorrowOrderCancelCmd(id));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String borrowOrderRefund(Long id, String amount) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createBorrowOrderRefundCmd(id, amount));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String borrowOrderGet(BorrowOrderGetParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createBorrowOrderGetCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String borrowDepthGet(String symbol, String pair) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createBorrowDepthGetCmd(symbol, pair));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferAssetsBorrowAssets(String symbol, String currency) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferAssetsBorrowAssetsCmd(symbol, currency));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferAssetsBase2credit(String symbol, String amount, String pair) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferAssetsBase2CreditCmd(symbol, amount, pair));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferAssetsCredit2Base(String symbol, String amount, String pair) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferAssetsCredit2BaseCmd(symbol, amount, pair));
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public String creditTrade(TradeParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCreditTradeTradeCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String creditTradeCancel(String index, String id) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createCreditTradeCancelCmd(index, id));
    }

}

