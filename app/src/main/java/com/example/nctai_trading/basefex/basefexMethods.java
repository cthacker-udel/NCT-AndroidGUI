package com.example.nctai_trading.basefex;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;
import com.google.gson.Gson;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class basefexMethods {

    String apiKey = "5ce82c1b-c9e7-4e9e-0006-139ff42b18d2";
    String secretKey = "njB3bdJ0xtrY5J8eg9G4LCsb+DV1wyiBvOKmHFd7/e8=";
    String baseUrl = "https://api.basefex.com";
    HMAC256 signatureGenerator = new HMAC256();

    public basefexMethods(String apiKey, String secretKey){
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    public String generateSignature(String secretKey, String method, String path, String expires, String data) throws InvalidKeyException, NoSuchAlgorithmException {

        String signature = signatureGenerator.hmacDigest(method + path + expires + data,secretKey,"HmacSHA256");

        return signature;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getTimeStamp(){
        return Instant.now().getEpochSecond()+5+"";
    }

    public String jsonStringifyMap(Map<String,Object> map){
        return new Gson().toJson(map);
    }

    // header must have expires, api key id, and signature
    // api-expires
    // api-key
    // api-signature

    public class accountRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<basefexGetAccountCashAndPositionDetail> getCashAndPositionDetail() throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/accounts/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexAccountInterface basefexAccountInterface = retrofit.create(com.example.nctai_trading.basefex.basefexAccountInterface.class);

            String expires = getTimeStamp();
            Call<List<basefexGetAccountCashAndPositionDetail>> call = basefexAccountInterface.getAccountCashAndDetail(expires,apiKey,generateSignature(secretKey,"GET","/accounts",expires,""));

            Response<List<basefexGetAccountCashAndPositionDetail>> response = call.execute();

            List<basefexGetAccountCashAndPositionDetail> result = response.body();

            return result;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<basefexAccountDepositWithdrawHistory> getDepositAndWithdrawHistory() throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/accounts/transactions/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexAccountInterface basefexAccountInterface = retrofit.create(com.example.nctai_trading.basefex.basefexAccountInterface.class);

            String expires = getTimeStamp();

            Call<List<basefexAccountDepositWithdrawHistory>> call = basefexAccountInterface.getAccountDepositWithdrawHistory(expires,apiKey,generateSignature(secretKey,"GET","/accounts/transactions",expires,""));

            Response<List<basefexAccountDepositWithdrawHistory>> response = call.execute();

            List<basefexAccountDepositWithdrawHistory> result = response.body();

            return result;


        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public basefexCountTransactions countTransactions() throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/accounts/transactions/count/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexAccountInterface basefexAccountInterface = retrofit.create(com.example.nctai_trading.basefex.basefexAccountInterface.class);

            String timeStamp = getTimeStamp();
            Call<basefexCountTransactions> call = basefexAccountInterface.getAccountTransactions(timeStamp,apiKey,generateSignature(secretKey,"GET","/accounts/transactions/count",timeStamp,""));

            Response<basefexCountTransactions> response = call.execute();

            basefexCountTransactions result = response.body();

            return result;

        }
    }

    public class ordersRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public basefexGetOrderId getOrderDetail(String orderId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + String.format("/orders/%s/",orderId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexOrdersInterface basefexOrdersInterface = retrofit.create(com.example.nctai_trading.basefex.basefexOrdersInterface.class);

            String timeStamp = getTimeStamp();
            Call<basefexGetOrderId> call = basefexOrdersInterface.getOrderId(orderId,timeStamp,apiKey,generateSignature(secretKey,"GET",String.format("/orders/%s",orderId),timeStamp,""));

            Response<basefexGetOrderId> response = call.execute();

            return response.body();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public basefexPlaceOrderResponse placeOrder(Integer size, String symbol, String type, String side) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,Object> jsonMap = new LinkedHashMap<>();
            jsonMap.put("size",size);
            jsonMap.put("symbol",symbol);
            jsonMap.put("type",type);
            jsonMap.put("side",side);

            basefexOrdersInterface basefexOrdersInterface = retrofit.create(com.example.nctai_trading.basefex.basefexOrdersInterface.class);

            String timestamp = getTimeStamp();
            Call<basefexPlaceOrderResponse> call = basefexOrdersInterface.placeOrder(timestamp,apiKey,generateSignature(secretKey,"POST","/orders",timestamp,jsonStringifyMap(jsonMap)),jsonMap);

            Response<basefexPlaceOrderResponse> response = call.execute();

            basefexPlaceOrderResponse result = response.body();

            return result;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public boolean cancelOrder(String orderId) throws NoSuchAlgorithmException, InvalidKeyException {

            String url = baseUrl + String.format("/orders/%s/",orderId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexOrdersInterface basefexOrdersInterface = retrofit.create(com.example.nctai_trading.basefex.basefexOrdersInterface.class);

            String timestamp = getTimeStamp();

            Response cancelOrder = basefexOrdersInterface.cancelOrder(orderId,timestamp,apiKey,generateSignature(secretKey,"DELETE",String.format("/orders/%s",orderId),timestamp,""));

            return cancelOrder.isSuccessful();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<basefexOrderListOrder> getOrderList(String status) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexOrdersInterface basefexOrdersInterface = retrofit.create(com.example.nctai_trading.basefex.basefexOrdersInterface.class);

            String timestamp = getTimeStamp();
            Call<List<basefexOrderListOrder>> call = basefexOrdersInterface.getOrderList(timestamp,apiKey,generateSignature(secretKey,"GET","/orders",timestamp,""),status);
            Response<List<basefexOrderListOrder>> response = call.execute();

            return response.body();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<basefexOrderListOrder> placeOrderInBatches(String symbol, List<Map<String,Object>> orders) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

            String url = baseUrl + "/orders/batch/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexOrdersInterface basefexOrdersInterface = retrofit.create(com.example.nctai_trading.basefex.basefexOrdersInterface.class);

            Map<String,Object> body = new LinkedHashMap<>();

            body.put("symbol",symbol);
            body.put("orders",orders);

            String timestamp = getTimeStamp();
            Call<List<basefexOrderListOrder>> call = basefexOrdersInterface.placeOrderBatch(timestamp,apiKey,generateSignature(secretKey,"POST","/orders/batch",timestamp,jsonStringifyMap(body)),body);

            Response<List<basefexOrderListOrder>> response = call.execute();

            return response.body();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public boolean cancelOrderBatch(String symbol, List<String> ids) throws NoSuchAlgorithmException, InvalidKeyException {

            String url = baseUrl + "/orders/batch/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexOrdersInterface basefexOrdersInterface = retrofit.create(com.example.nctai_trading.basefex.basefexOrdersInterface.class);

            Map<String,Object> body = new LinkedHashMap<>();

            body.put("symbol",symbol);
            body.put("ids",ids);

            String timestamp = getTimeStamp();
            Response cancelOrderBatch = basefexOrdersInterface.cancelOrderBatch(timestamp,apiKey,generateSignature(secretKey,"DELETE","/orders/batch",timestamp,jsonStringifyMap(body)),body);

            return cancelOrderBatch.isSuccessful();




        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<basefexActiveOrderListOrder> getActiveOrderList(String symbol, String limit) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/orders/opening/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexOrdersInterface basefexOrdersInterface = retrofit.create(com.example.nctai_trading.basefex.basefexOrdersInterface.class);

            Map<String,String> queryMap = new LinkedHashMap<>();

            queryMap.put("symbol",symbol);
            queryMap.put("limit",limit);

            String timestamp = getTimeStamp();
            Call<List<basefexActiveOrderListOrder>> call = basefexOrdersInterface.getActiveOrderList(timestamp,apiKey,generateSignature(secretKey,"GET","/orders/opening",timestamp,""),queryMap);

            Response<List<basefexActiveOrderListOrder>> response = call.execute();

            return response.body();



        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public basefexCountOrdersCount countOrders(String symbol, String type, String side) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

            String url = baseUrl + "/orders/count/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexOrdersInterface basefexOrdersInterface = retrofit.create(com.example.nctai_trading.basefex.basefexOrdersInterface.class);

            Map<String,String> queryMap = new LinkedHashMap<>();
            queryMap.put("symbol",symbol);
            queryMap.put("type",type);
            queryMap.put("side",side);

            String timestamp = getTimeStamp();
            Call<basefexCountOrdersCount> call = basefexOrdersInterface.getOrderCount(timestamp,apiKey,generateSignature(secretKey,"GET","/orders/count",timestamp,""),queryMap);

            Response<basefexCountOrdersCount> response = call.execute();

            return response.body();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public basefexCountOrdersCount countActiveOrders(String symbol) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/opening/count/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexOrdersInterface basefexOrdersInterface = retrofit.create(com.example.nctai_trading.basefex.basefexOrdersInterface.class);

            Map<String,String> queryMap = new LinkedHashMap<>();

            queryMap.put("symbol",symbol);

            String timestamp = getTimeStamp();
            Call<basefexCountOrdersCount> call =  basefexOrdersInterface.getActiveOrderCount(timestamp,apiKey,generateSignature(secretKey,"GET","/opening/count",timestamp,""),queryMap);

            Response<basefexCountOrdersCount> response = call.execute();

            return response.body();
        }

    }

    public class tradeRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public List<basefexTradeListTrade> getTradeList(String symbol, String side) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/trades/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexTradesInterface basefexTradesInterface = retrofit.create(com.example.nctai_trading.basefex.basefexTradesInterface.class);

            Map<String,String> queryMap = new LinkedHashMap<>();
            queryMap.put("symbol",symbol);
            queryMap.put("side",side);

            String timestamp = getTimeStamp();
            Call<List<basefexTradeListTrade>> call = basefexTradesInterface.getTradeList(timestamp,apiKey,generateSignature(secretKey,"GET","/trades",timestamp,""),queryMap);

            Response<List<basefexTradeListTrade>> response = call.execute();

            return response.body();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public basefexCountOrdersCount getTradeCount(String symbol, String side) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/trades/count/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexTradesInterface basefexTradesInterface = retrofit.create(com.example.nctai_trading.basefex.basefexTradesInterface.class);

            Map<String,String> queryMap = new LinkedHashMap<>();
            queryMap.put("symbol",symbol);
            queryMap.put("side",side);

            String timestamp = getTimeStamp();
            Call<basefexCountOrdersCount> call = basefexTradesInterface.getTradeCount(timestamp,apiKey,generateSignature(secretKey,"GET","/trades/count",timestamp,""),queryMap);

            Response<basefexCountOrdersCount> response = call.execute();

            return response.body();
        }


    }

    public class positionRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public basefexAdjustLeverage adjustLeverage(String symbol) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + String.format("/positions/%s/margin/",symbol);


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexPositionInterface basefexPositionInterface = retrofit.create(com.example.nctai_trading.basefex.basefexPositionInterface.class);

            String timestamp = getTimeStamp();
            Call<basefexAdjustLeverage> call = basefexPositionInterface.adjustLeverage(symbol,timestamp,apiKey,generateSignature(secretKey,"PUT",String.format("/positions/%s/margin",symbol),timestamp,""));

            Response<basefexAdjustLeverage> response = call.execute();

            return response.body();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public basefexSetRiskLimit setRiskLimit(String symbol, Integer notional) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

            String url = baseUrl + String.format("/positions/%s/risk-limit",symbol);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            basefexPositionInterface basefexPositionInterface = retrofit.create(com.example.nctai_trading.basefex.basefexPositionInterface.class);

            Map<String,Object> body = new LinkedHashMap<>();
            body.put("notional",notional);

            String timestamp = getTimeStamp();
            Call<basefexSetRiskLimit> call = basefexPositionInterface.setRiskLimit(symbol,timestamp,apiKey,generateSignature(secretKey,"PUT",String.format("/positions/%s/risk-limit",symbol),timestamp,jsonStringifyMap(body)),body);

            Response<basefexSetRiskLimit> response = call.execute();

            return response.body();
        }




    }


}
