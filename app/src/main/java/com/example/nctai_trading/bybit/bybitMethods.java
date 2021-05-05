package com.example.nctai_trading.bybit;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bybitMethods {

    String baseUrl = "https:/api.bybit.com";

    String apiKey = "a";
    String secretKey = "a";

    // headers required for auth, 1) api_key 2) timestamp 3) sign

    public bybitMethods(String apiKey, String secretKey){
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    private static String getSignature(TreeMap<String, String> params, String secret) throws NoSuchAlgorithmException, InvalidKeyException {
        Set<String> keySet = params.keySet();
        Iterator<String> iter = keySet.iterator();
        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()) {
            String key = iter.next();
            sb.append(key + "=" + params.get(key));
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
//        System.out.println(sb.toString());
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return bytesToHex(sha256_HMAC.doFinal(sb.toString().getBytes()));
    }



    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public String synchronize() throws IOException {
        long serverTime = getServerTime();
        long systemTime = System.currentTimeMillis() * 1000;
        long offset = systemTime - serverTime + 500;
        return (systemTime - offset) + "";
    }

    public long getServerTime() throws IOException {

        String url = baseUrl + "/v2/public/time/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bybitServerTimeInterface bybitServerTimeInterface = retrofit.create(com.example.nctai_trading.bybit.bybitServerTimeInterface.class);

        Call<bybitServerTimeResponse> call = bybitServerTimeInterface.getServerTime();

        Response<bybitServerTimeResponse> response = call.execute();

        return Math.round(Double.parseDouble(response.body().getTimeNow()));


    }



    public class orderRequests{

        public bybitOrderResponse placeOrder(String side, String symbol, String orderType, String qty, String timeInForce, String reduceOnly, String closeOnTrigger) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

            String url = "https://api-testnet.bybit.com/private/linear/order/create/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bybitOrderInterface bybitOrderInterface = retrofit.create(com.example.nctai_trading.bybit.bybitOrderInterface.class);

            TreeMap map = new TreeMap<String, String>(
                    new Comparator<String>() {
                        public int compare(String obj1, String obj2) {
                            //sort in alphabet order
                            return obj1.compareTo(obj2);
                        }
                    });

            map.put("side",side);
            map.put("symbol",symbol);
            map.put("order_type",orderType);
            map.put("qty",qty);
            map.put("time_in_force",timeInForce);
            map.put("reduce_only",reduceOnly);
            map.put("close_on_trigger",closeOnTrigger);
            map.put("api_key",apiKey);
            map.put("timestamp",synchronize());

            String signature = getSignature(map,secretKey);

            Call<bybitOrderResponse> call = bybitOrderInterface.placeOrder(apiKey,map.get("timestamp"),signature,map);

            Response<bybitOrderResponse> response = call.execute();

            return response.body();



        }


    }

}
