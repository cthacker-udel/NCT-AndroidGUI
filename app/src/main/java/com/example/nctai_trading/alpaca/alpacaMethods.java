package com.example.nctai_trading.alpaca;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class alpacaMethods {

    String apiKey = "PKDORC9AVWCD76ORX9G0";
    String secretKey = "uPmNGZWXp4P6lCgZC0TAMhXWmLuV8J/IPWddKPzD";

    String webBaseUrl = "https://api.alpaca.markets";
    String paperBaseUrl = "https://paper-api.alpaca.markets";

    public alpacaMethods(String apiKey, String secretKey){
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }


    public class accountReqeusts{

        public alpacaGetAccountResponse getAccount() throws IOException {

            String url = "https://paper-api.alpaca.markets/v2/account/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            alpacaAccountInterface alpacaAccountInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaAccountInterface.class);

            Call<alpacaGetAccountResponse> call = alpacaAccountInterface.getAccount(apiKey,secretKey);

            Response<alpacaGetAccountResponse> response = call.execute();

            alpacaGetAccountResponse accountDetails = response.body();

            return accountDetails;


        }

    }

    public class orderRequests{

        public List<alpacaOrderListOrder> getListOfOrders() throws IOException {

            String url = paperBaseUrl + "/v2/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            // clientOrderId aac4fd90-872d-4aff-b84c-e89f9c13ad48
            // id db2c0948-7815-4085-8958-5e00f56e2faa

            alpacaOrderInterface alpacaOrderInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaOrderInterface.class);

            Call<List<alpacaOrderListOrder>> getOrderList = alpacaOrderInterface.getListOfOrders(apiKey,secretKey);

            Response<List<alpacaOrderListOrder>> response = getOrderList.execute();

            return response.body();

        }

        public alpacaOrderListOrder placeOrder(String symbol, Integer quantity, String side, String type, String timeInForce) throws IOException {

            String url = paperBaseUrl + "/v2/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<Object,Object> body = new LinkedHashMap<>();
            body.put("symbol",symbol);
            body.put("qty",quantity);
            body.put("side",side);
            body.put("type",type);
            body.put("time_in_force",timeInForce);

            alpacaOrderInterface alpacaOrderInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaOrderInterface.class);

            //Call<alpacaOrderListOrder> call = alpacaOrderInterface.placeOrder(apiKey,secretKey,symbol,quantity,side,type,timeInForce);

            Call<alpacaOrderListOrder> call = alpacaOrderInterface.placeOrder(apiKey,secretKey,body);

            Response<alpacaOrderListOrder> response = call.execute();

            alpacaOrderListOrder result = response.body();

            return result;

        }

        public alpacaOrderListOrder getOrderOrderId(String orderId) throws IOException {

            String url = paperBaseUrl + String.format("/v2/orders/%s/",orderId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            alpacaOrderInterface alpacaOrderInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaOrderInterface.class);

            Call<alpacaOrderListOrder> call = alpacaOrderInterface.getOrderOrderId(orderId,apiKey,secretKey);

            Response<alpacaOrderListOrder> response = call.execute();

            alpacaOrderListOrder result = response.body();

            return result;

        }

        public alpacaOrderListOrder getOrderClientOrderId(String clientOrderId) throws IOException {

            String url = paperBaseUrl + String.format("/v2/orders:%s",clientOrderId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            alpacaOrderInterface alpacaOrderInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaOrderInterface.class);

            Call<alpacaOrderListOrder> call = alpacaOrderInterface.getOrderClientOrderId(clientOrderId,apiKey,secretKey);

            Response<alpacaOrderListOrder> response = call.execute();

            return response.body();
        }

        public alpacaOrderListOrder replaceOrder(String orderId, Integer quantity, String timeInForce) throws IOException {

            String url = paperBaseUrl + String.format("/v2/orders/%s/",orderId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<Object,Object> body = new LinkedHashMap<>();

            body.put("qty",quantity);
            body.put("time_in_force",timeInForce);

            alpacaOrderInterface alpacaOrderInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaOrderInterface.class);

            Call<alpacaOrderListOrder> call = alpacaOrderInterface.replaceOrder(orderId,apiKey,secretKey,body);

            Response<alpacaOrderListOrder> response = call.execute();

            return response.body();


        }

        public void cancelAllOrders(){

            String url = paperBaseUrl + "/v2/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            alpacaOrderInterface alpacaOrderInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaOrderInterface.class);

            Response deleteAllOrders = alpacaOrderInterface.deleteAllOrders(apiKey,secretKey);

            return;

        }

        public void canelOrder(String orderId){

            String url = paperBaseUrl + String.format("/v2/orders/%s/",orderId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            alpacaOrderInterface alpacaOrderInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaOrderInterface.class);

            Response deleteOrder = alpacaOrderInterface.deleteOrder(orderId,apiKey,secretKey);

            return;
        }



    }

    public class positionRequests{

        public List<alpacaPosition> getOpenPositions() throws IOException {

            String url = paperBaseUrl + "/v2/positions/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            alpacaPositionInterface alpacaPositionInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaPositionInterface.class);

            Call<List<alpacaPosition>> call = alpacaPositionInterface.getOpenPositions(apiKey,secretKey);

            Response<List<alpacaPosition>> response = call.execute();

            return response.body();
        }

        public alpacaPosition getOpenPosition(String symbol) throws IOException {

            String url = paperBaseUrl + String.format("/v2/positions/%s/",symbol);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            alpacaPositionInterface alpacaPositionInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaPositionInterface.class);

            Call<alpacaPosition> call = alpacaPositionInterface.getOpenPositionSymbol(symbol,apiKey,secretKey);

            Response<alpacaPosition> response = call.execute();

            return response.body();
        }

        public boolean closeAllPositions(){

            String url = paperBaseUrl + "/v2/positions/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            alpacaPositionInterface alpacaPositionInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaPositionInterface.class);

            Response response = alpacaPositionInterface.closeAllPositions(apiKey,secretKey);

            return response.errorBody().contentLength() < 1;

        }

        public boolean closeAPosition(String symbol){

            String url = paperBaseUrl + String.format("/v2/positions/%s/",symbol);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            alpacaPositionInterface alpacaPositionInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaPositionInterface.class);

            Response response = alpacaPositionInterface.closePosition(symbol,apiKey,secretKey);

            return response.errorBody().contentLength() < 1;
        }
    }

    public class assetRequests{

        public List<alpacaAsset> getAssets() throws IOException {

            String url = paperBaseUrl + "/v2/assets/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            alpacaAssetInterface alpacaAssetInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaAssetInterface.class);

            Call<List<alpacaAsset>> getAssets = alpacaAssetInterface.getAssets(apiKey,secretKey);

            Response<List<alpacaAsset>> response = getAssets.execute();

            List<alpacaAsset> assets = response.body();

            return assets;

        }

        public alpacaAsset getAsset(String symbol) throws IOException {

            String url = paperBaseUrl + String.format("/v2/assets/%s/",symbol);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            alpacaAssetInterface alpacaAssetInterface = retrofit.create(com.example.nctai_trading.alpaca.alpacaAssetInterface.class);

            Call<alpacaAsset> call = alpacaAssetInterface.getAsset(symbol,apiKey,secretKey);

            Response<alpacaAsset> response = call.execute();

            return response.body();
        }

    }


}
