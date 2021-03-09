package com.example.nctai_trading.wbf;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class wbfMethods {

    String baseUrl = "https://openapi.wbf.live";
    String api_key = "43f3210b1d268ce0a2308cd3761b2e3d";
    String secret_key = "315c8ec2df6b2095c4a904a642e24cb9";

    TreeMap<String,String> generateSignature(TreeMap<String,String> params){
        params.put("api_key", api_key);
        params.put("time", new Date().getTime() + "");
        StringBuilder result = new StringBuilder();
        Set<Map.Entry<String, String>> entrys = params.entrySet();
        for (Map.Entry<String, String> param : entrys) {
            if (param.getKey().equals("sign")) {
                continue;
            }
            if (param.getValue() != null) {
                result.append(param.getKey());
                result.append(param.getValue().toString());
            }
        }
        result.append(secret_key);
        String sign = getMD5(result.toString());
        params.put("sign", sign);
        return params;
    }

    private static String bytesToHex(byte[] md5Array) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < md5Array.length; i++) {
            int temp = 0xff & md5Array[i];
            String hexString = Integer.toHexString(temp);
            if (hexString.length() == 1) {//If it is hexadecimal 0f, only f is displayed by default, and then 0 is added
                strBuilder.append("0").append(hexString);
            } else {
                strBuilder.append(hexString);
            }
        }
        return strBuilder.toString();
    }


    public static String getMD5(String info) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(info.getBytes("UTF-8"));

            byte[] md5Array = md5.digest();
            return bytesToHex(md5Array);
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }







    public class transactionRequests{

        public wbfTransactionRecords getTransactionRecords(String symbol) throws IOException {

            TreeMap<String,String> params = new TreeMap<>();
            params.put("symbol",symbol);

            String url = baseUrl + "/open/api/all_trade/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            wbfTransactionInterface wbfTransactionInterface = retrofit.create(com.example.nctai_trading.wbf.wbfTransactionInterface.class);

            Call<wbfTransactionRecords> call = wbfTransactionInterface.getTransactionRecords("application/x-www-form-urlencoded;charset=utf-8",symbol);

            Response<wbfTransactionRecords> response = call.execute();

            return response.body();
        }


    }




}
