package com.example.nctai_trading.exante;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.exante.accountDetail.AccountSummary;
import com.example.nctai_trading.exante.activeOrders.activeOrder;
import com.example.nctai_trading.exante.historicalOrders.historicalOrder;

import java.io.IOException;
import java.security.KeyStore;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class exanteMethods {

    String applicationID = "2e97ef4d-ad68-46dd-ba17-3851a857c0c6";
    String access_key = "6ZxHHjl8qnRWscZubtSU";
    String baseUrl = "https://api-demo.exante.eu/";

    public exanteMethods(String apiKey, String secretKey){

    }

    public class orderRequests{

        public exanteOrderResponse placeOrder(String accountId, String instrument, String side, String quantity, String orderType, String duration) throws IOException {

            String url = baseUrl + "trade/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,Object> params = new LinkedHashMap<>();
            params.put("orderType",orderType);
            params.put("side",side);
            params.put("quantity",quantity);
            params.put("duration",duration);

            exanteOrderInterface exanteOrderInterface = retrofit.create(com.example.nctai_trading.exante.exanteOrderInterface.class);

            Call<exanteOrderResponse> call = exanteOrderInterface.placeOrder(applicationID,access_key,params);

            Response<exanteOrderResponse> response = call.execute();

            return response.body();



        }


        @RequiresApi(api = Build.VERSION_CODES.O)
        public String createDate(int year, int month, int day, int hour, int minute, int second){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm:ssZ");
            LocalDate date = LocalDate.of(year,month,day);
            LocalTime time = LocalTime.of(hour,minute,second);
            date.atTime(time);
            return date.format(formatter);
        }

        public AccountSummary getAccountDetails(String accountId, String currency) throws IOException {

            String url = baseUrl + String.format("/md/%s/summary/%s/%s/","3.0",accountId,currency);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            exanteOrderInterface exanteOrderInterface = retrofit.create(com.example.nctai_trading.exante.exanteOrderInterface.class);

            Call<AccountSummary> call = exanteOrderInterface.getAccountDetails(applicationID,access_key,accountId,currency);

            Response<AccountSummary> response = call.execute();

            return response.body();

        }

        public List<historicalOrder> getHistoricalOrders(String limit, String from, String to, String accountId) throws IOException {

            String url = baseUrl + "/trade/3.0/orders/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            exanteOrderInterface exanteOrderInterface = retrofit.create(com.example.nctai_trading.exante.exanteOrderInterface.class);

            Map<String,String> queries = new LinkedHashMap<>();
            queries.put("limit",limit);
            queries.put("from",from);
            queries.put("to",to);
            queries.put("accountId",accountId);

            Call<List<historicalOrder>> call = exanteOrderInterface.getHistoricalOrders(applicationID,access_key,queries);

            Response<List<historicalOrder>> response = call.execute();

            return response.body();


        }

        public List<activeOrder> getActiveOrders(String limit, String accountId, String symbolId) throws IOException {

            String url = baseUrl + "/trade/3.0/orders/active/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            exanteOrderInterface exanteOrderInterface = retrofit.create(com.example.nctai_trading.exante.exanteOrderInterface.class);

            Map<String,String> map = new LinkedHashMap<>();
            map.put("limit",limit);
            map.put("accountId",accountId);
            map.put("symbolId",symbolId);

            Call<List<activeOrder>> call = exanteOrderInterface.getActiveOrders(applicationID,access_key,map);

            Response<List<activeOrder>> response = call.execute();

            return response.body();

        }



    }
}
