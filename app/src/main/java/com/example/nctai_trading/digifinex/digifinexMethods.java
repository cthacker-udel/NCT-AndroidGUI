package com.example.nctai_trading.digifinex;

import com.example.nctai_trading.digifinex.myPositions.myPosition;
import com.example.nctai_trading.digifinex.order.orderResponse;
import com.example.nctai_trading.digifinex.openOrders.openOrder;
import com.example.nctai_trading.digifinex.orderHistory.orderHistory;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class digifinexMethods {

    String apiKey = "124a2d171fde72";
    String secretKey = "59a94280f6eb2c2c0d4ed48ed9d91bb5921f534b90";


    public digifinexMethods(String apiKey, String secretKey){
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    private static String md5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHex(byte[] bytes) {
        final char[] hexDigits = "0123456789abcdef".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(hexDigits[(bytes[i] >> 4) & 0x0f]);
            ret.append(hexDigits[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    // construct a treemap of params, intialize empty string beforehand
    // in example it is String str = "";
    /*

    Run this on treemap

       Iterator titer = treemap.entrySet().iterator();
			while(titer.hasNext()){
				Map.Entry ent = (Map.Entry)titer.next();
		   		String key = ent.getKey().toString();
		   		String value = ent.getValue().toString();
				str += value;
			}

     */

    public class orderRequests{

        public orderResponse placeOrder(String symbol, String type, Double price, Double amount) throws IOException {

            String url = "https://openapi.digifinex.vip/v2/trade/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            orderInterface orderInterface = retrofit.create(com.example.nctai_trading.digifinex.orderInterface.class);



            Map<String,Object> treemap = new TreeMap<>();
            treemap.put("symbol",symbol);
            treemap.put("type",type);
            Long timestamp = new Date().getTime()/1000;
            treemap.put("timestamp",timestamp);
            treemap.put("apiKey",apiKey);
            treemap.put("apiSecret",secretKey);
            treemap.put("price",price); // not in example
            treemap.put("amount",amount); // not in example

            String str = "";
            Iterator titer = treemap.entrySet().iterator();
            while(titer.hasNext()){
                Map.Entry ent = (Map.Entry)titer.next();
                String key = ent.getKey().toString();
                String value = ent.getValue().toString();
                str += value;
            }

            treemap.put("sign",md5(str));

            Call<orderResponse> call = orderInterface.placeLimitOrder(treemap);

            Response<orderResponse> response = call.execute();

            return response.body();

        }

        public openOrder getOpenOrders() throws IOException {

            String url = "https://openapi.digifinex.vip/v2/open_orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            orderInterface orderInterface = retrofit.create(com.example.nctai_trading.digifinex.orderInterface.class);

            Map<String,Object> treeMap = new TreeMap<>();
            Long timestamp = new Date().getTime()/1000;
            treeMap.put("timestamp",timestamp);
            treeMap.put("apiKey",apiKey);
            treeMap.put("apiSecret",secretKey);

            String str = "";
            Iterator titer = treeMap.entrySet().iterator();
            while(titer.hasNext()){
                Map.Entry ent = (Map.Entry)titer.next();
                String key = ent.getKey().toString();
                String value = ent.getValue().toString();
                str += value;
            }

            treeMap.put("sign",md5(str));

            Call<openOrder> call = orderInterface.getOpenOrders(treeMap);

            Response<openOrder> response = call.execute();

            return response.body();

        }

        public orderHistory getOrderHistory() throws IOException {

            String url = "https://openapi.digifinex.vip/v2/order_history/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            orderInterface orderInterface = retrofit.create(com.example.nctai_trading.digifinex.orderInterface.class);

            Map<String,Object> treeMap = new TreeMap<>();
            Long timestamp = new Date().getTime()/1000;
            treeMap.put("timestamp",timestamp);
            treeMap.put("apiKey",apiKey);
            treeMap.put("apiSecret",secretKey);

            String str = "";
            Iterator titer = treeMap.entrySet().iterator();
            while(titer.hasNext()){
                Map.Entry ent = (Map.Entry)titer.next();
                String key = ent.getKey().toString();
                String value = ent.getValue().toString();
                str += value;
            }

            treeMap.put("sign",md5(str));

            Call<orderHistory> call = orderInterface.getOrderHistory(treeMap);

            Response<orderHistory> response = call.execute();

            return response.body();



        }

        public myPosition getMyPositions() throws IOException {

            String url = "https://openapi.digifinex.vip/v2/myposition/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            orderInterface orderInterface = retrofit.create(com.example.nctai_trading.digifinex.orderInterface.class);

            Map<String,Object> treeMap = new TreeMap<>();
            Long timestamp = new Date().getTime() / 1000;
            treeMap.put("timestamp",timestamp);
            treeMap.put("apiKey",apiKey);
            treeMap.put("apiSecret",secretKey);

            String str = "";
            Iterator titer = treeMap.entrySet().iterator();
            while(titer.hasNext()){
                Map.Entry ent = (Map.Entry)titer.next();
                String key = ent.getKey().toString();
                String value = ent.getValue().toString();
                str += value;
            }
            treeMap.put("sign",md5(str));

            Call<myPosition> call = orderInterface.getMyPosition(treeMap);

            Response<myPosition> response = call.execute();

            return response.body();

        }

    }

}
