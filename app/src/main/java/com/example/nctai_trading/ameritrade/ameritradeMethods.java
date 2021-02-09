package com.example.nctai_trading.ameritrade;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ameritradeMethods {

    public String clientId;

    public String baseUrl = "https://api.tdameritrade.com/v1";

    public String accessToken = "A84UCPOEY9BKT4VM3MYASTSUZJATUSSM";

    public ameritradeMethods(){
        this.clientId = "A84UCPOEY9BKT4VM3MYASTSUZJATUSSM";
    }

    public Map<String,String> getTokenAuthorization(String code, String clinetId, String redirectUri){

        Map<String,String> authHeaders = new HashMap<>();
        authHeaders.put("grant_type","authorization_code");
        authHeaders.put("access_type","offline");
        authHeaders.put("code",code);
        authHeaders.put("client_id",clinetId);
        authHeaders.put("redirect_uri",redirectUri);

        return authHeaders;
    }

    public Map<String,String> getTokenRefresh(String refreshToken, String clientId){

        Map<String,String> authHeaders = new HashMap<>();
        authHeaders.put("grant_type","refresh_token");
        authHeaders.put("refresh_token",refreshToken);
        authHeaders.put("access_type","online");
        authHeaders.put("client_id",clientId);

        return authHeaders;

    }

    public Map<String,String> getAuthorizationHeader(String accessToken){
        Map<String,String> authHeader = new HashMap<>();
        authHeader.put("Authorization",accessToken);
        return authHeader;
    }

    public ameritradeAuthorizationTokenResponse getAccessTokenAUTH() throws IOException {

        Map<String,String> authHeaders = getTokenAuthorization("","","");

        String url = baseUrl + "/oauth/token";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ameritradeTokenInterface ameritradeTokenInterface = retrofit.create(com.example.nctai_trading.ameritrade.ameritradeTokenInterface.class);

        Call<ameritradeAuthorizationTokenResponse> call = ameritradeTokenInterface.getAuthorizationToken(authHeaders);

        Response<ameritradeAuthorizationTokenResponse> response = call.execute();

        return response.body();

    }

    public ameritradeAuthorizationTokenResponse getAccessTokenREFRESH() throws IOException {

        Map<String,String> authHeaders = getTokenRefresh("","");

        String url = baseUrl + "/oauth/token";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ameritradeTokenInterface ameritradeTokenInterface = retrofit.create(com.example.nctai_trading.ameritrade.ameritradeTokenInterface.class);

        Call<ameritradeAuthorizationTokenResponse> call  = ameritradeTokenInterface.getRefreshToken(getTokenRefresh("",""));

        Response<ameritradeAuthorizationTokenResponse> response = call.execute();

        return response.body();

    }

    public class accountsAndTradingRequests{

        public boolean cancelOrder(String accessToken, String accountId, String orderId){

            String url = baseUrl + String.format("/accounts/%s/orders/%s",accountId,orderId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ameritradeAccountTradingInterface ameritradeAccountTradingInterface = retrofit.create(com.example.nctai_trading.ameritrade.ameritradeAccountTradingInterface.class);

            Response cancelOrder = ameritradeAccountTradingInterface.cancelOrder(accountId,orderId,getAuthorizationHeader(accessToken));

            return cancelOrder.errorBody().contentLength() < 1;


        }

        public ameritradeGetOrderResponse getSpecificOrder(String theAccount, String orderId, String accessToken) throws IOException {

            String url = baseUrl + String.format("/accounts/%s/orders/%s",theAccount,orderId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ameritradeAccountTradingInterface ameritradeAccountTradingInterface = retrofit.create(com.example.nctai_trading.ameritrade.ameritradeAccountTradingInterface.class);

            Call<ameritradeGetOrderResponse> call = ameritradeAccountTradingInterface.getSpecificAccountOrder(theAccount,orderId,getAuthorizationHeader(accessToken));

            Response<ameritradeGetOrderResponse> response = call.execute();

            return response.body();
        }

        public boolean placeOrderMarket(String accessToken, String account, String session, String duration, String orderStrategyType, long quantity, String stockSymbol, String assetType){

            String url = baseUrl + String.format("/accounts/%s/orders/",account);

            Map<String,Object> body = new HashMap<>();

            body.put("orderType","MARKET");
            body.put("session",session);
            body.put("duration",duration);
            body.put("orderStrategyType",orderStrategyType);

            Map<String,String> instrument = new HashMap<>();

            instrument.put("symbol",stockSymbol);
            instrument.put("assetType",assetType);

            ameritradePlaceOrderOrderLegCollection getOrderLegCollection = new ameritradePlaceOrderOrderLegCollection("Buy",15,instrument);

            Map<String,Object> orderLegCollection = getOrderLegCollection.getOrderLegCollection();

            body.put("orderLegCollection",orderLegCollection);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ameritradeAccountTradingInterface ameritradeAccountTradingInterface = retrofit.create(com.example.nctai_trading.ameritrade.ameritradeAccountTradingInterface.class);

            Response placeOrder = ameritradeAccountTradingInterface.placeOrder(account,body,getAuthorizationHeader(accessToken));

            return placeOrder.errorBody().contentLength() < 1;

        }

        public boolean replaceOrderMarket(String accessToken,String orderId, String account, String session, String duration, String orderStrategyType, long quantity, String stockSymbol, String assetType) {

            String url = baseUrl + String.format("/accounts/%s/orders/%s/", account,orderId);

            Map<String, Object> body = new HashMap<>();

            body.put("orderType", "MARKET");
            body.put("session", session);
            body.put("duration", duration);
            body.put("orderStrategyType", orderStrategyType);

            Map<String, String> instrument = new HashMap<>();

            instrument.put("symbol", stockSymbol);
            instrument.put("assetType", assetType);

            ameritradePlaceOrderOrderLegCollection getOrderLegCollection = new ameritradePlaceOrderOrderLegCollection("Buy", 15, instrument);

            Map<String, Object> orderLegCollection = getOrderLegCollection.getOrderLegCollection();

            body.put("orderLegCollection", orderLegCollection);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ameritradeAccountTradingInterface ameritradeAccountTradingInterface = retrofit.create(com.example.nctai_trading.ameritrade.ameritradeAccountTradingInterface.class);

            Response replaceOrder = ameritradeAccountTradingInterface.replaceOrderId(account,orderId,body,getAuthorizationHeader(accessToken));

            return replaceOrder.errorBody().contentLength() < 1;
        }

        public boolean createSavedOrder(String accessToken, String account, String session, String duration, String orderStrategyType, long quantity, String stockSymbol, String assetType){

            String url = baseUrl + String.format("/accounts/%s/orders/",account);

            Map<String,Object> body = new HashMap<>();

            body.put("orderType","MARKET");
            body.put("session",session);
            body.put("duration",duration);
            body.put("orderStrategyType",orderStrategyType);

            Map<String,String> instrument = new HashMap<>();

            instrument.put("symbol",stockSymbol);
            instrument.put("assetType",assetType);

            ameritradePlaceOrderOrderLegCollection getOrderLegCollection = new ameritradePlaceOrderOrderLegCollection("Buy",15,instrument);

            Map<String,Object> orderLegCollection = getOrderLegCollection.getOrderLegCollection();

            body.put("orderLegCollection",orderLegCollection);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ameritradeAccountTradingInterface ameritradeAccountTradingInterface = retrofit.create(com.example.nctai_trading.ameritrade.ameritradeAccountTradingInterface.class);

            Response placeOrder = ameritradeAccountTradingInterface.createSavedOrder(account,body,getAuthorizationHeader(accessToken));

            return placeOrder.errorBody().contentLength() < 1;
        }

        public boolean deleteSavedOrder(String accessToken,String orderId, String account, String session, String duration, String orderStrategyType, long quantity, String stockSymbol, String assetType){

            String url = baseUrl + String.format("/accounts/%s/orders/",account);

            Map<String,Object> body = new HashMap<>();

            body.put("orderType","MARKET");
            body.put("session",session);
            body.put("duration",duration);
            body.put("orderStrategyType",orderStrategyType);

            Map<String,String> instrument = new HashMap<>();

            instrument.put("symbol",stockSymbol);
            instrument.put("assetType",assetType);

            ameritradePlaceOrderOrderLegCollection getOrderLegCollection = new ameritradePlaceOrderOrderLegCollection("Buy",15,instrument);

            Map<String,Object> orderLegCollection = getOrderLegCollection.getOrderLegCollection();

            body.put("orderLegCollection",orderLegCollection);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ameritradeAccountTradingInterface ameritradeAccountTradingInterface = retrofit.create(com.example.nctai_trading.ameritrade.ameritradeAccountTradingInterface.class);

            Response placeOrder = ameritradeAccountTradingInterface.deleteSavedOrder(account,orderId,body,getAuthorizationHeader(accessToken));

            return placeOrder.errorBody().contentLength() < 1;
        }

        public ameritradeGetAccountMarginAccount getAccount(String accountId) throws IOException {

            String url = baseUrl + String.format("/accounts/%s",accountId);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ameritradeAccountTradingInterface ameritradeAccountTradingInterface = retrofit.create(com.example.nctai_trading.ameritrade.ameritradeAccountTradingInterface.class);

            Call<ameritradeGetAccountMarginAccount> call = ameritradeAccountTradingInterface.getAccount(accountId,getAuthorizationHeader(accessToken));

            Response<ameritradeGetAccountMarginAccount> response = call.execute();

            ameritradeGetAccountMarginAccount result = response.body();

            return result;
        }

    }

    public class intstrumentRequests{



    }


}
