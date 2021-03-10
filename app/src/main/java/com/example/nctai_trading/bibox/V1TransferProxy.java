package com.example.nctai_trading.bibox;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class V1TransferProxy extends BaseProxy
{

    public V1TransferProxy(BiBoxHttpClientConfig config, HttpClientHelper helper)
    {
        super.config = config;
        super.helper = helper;
    }

    @Override
    public String getUrl()
    {
        return config.getHost().concat(UrlConstants.V1_TRANSFER);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferAssets(Integer select) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferAssetsCmd(select));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferMainAssets(Integer select) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferMainAssetsCmd(select));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferCreditAssets(Integer select) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferCreditAssetsCmd(select));
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferTransferIn(String symbol) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferTransferInCmd(symbol));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferTransferOut(TransferOutParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferTransferOutCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferTransferInList(TransferInListParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferTransferInListCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferTransferOutList(TransferOutListParams params) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferTransferOutListCmd(params));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferCoinConfig(String symbol) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferTransferCoinConfigCmd(symbol));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String transferWithdrawInfo(Long id) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        return postSign(V1ParamsUtils.createTransferTransferWithdrawInfoCmd(id));
    }

}
