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

    }


}
