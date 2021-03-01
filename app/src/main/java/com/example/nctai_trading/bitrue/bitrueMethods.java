package com.example.nctai_trading.bitrue;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.time.Instant;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bitrueMethods {

    String baseUrl = "https://www.bitrue.com";

    String apiKey = "4d52b03ce5feb11781490b77696aeab7bc7a76a0f8c4bf0d2c575d983f4ba4e7";
    String secretKey = "592d0d53611f643790607b4e9f36006fcb71bf273d22fcf78a5ab11ac92c726f";

    // require X-MBX-APIKEY header
    // signed require : signature (query string) HMAC 256 secretkey as key and totalParams as value for HMAC encryption
    // totalParams: query string concat with body, also requires recvWindow

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Long getTimestamp(){
        return Instant.now().getEpochSecond();
    }


    public class serverRequests{

        public boolean serverPing() throws IOException {

            String url = baseUrl + "/api/v1/ping/";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitrueServerInterface bitrueServerInterface = retrofit.create(com.example.nctai_trading.bitrue.bitrueServerInterface.class);

            Call<Object> call = bitrueServerInterface.serverPing();

            Response<Object> response = call.execute();

            return response.isSuccessful();

        }

        public boolean getServerTime() throws IOException {

            String url = baseUrl + "/api/v1/time/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitrueServerInterface bitrueServerInterface = retrofit.create(com.example.nctai_trading.bitrue.bitrueServerInterface.class);

            Call<com.example.nctai_trading.bitrue.serverObject.serverTimeResponse> getServerTime = bitrueServerInterface.getServerTime();

            Response<com.example.nctai_trading.bitrue.serverObject.serverTimeResponse> response = getServerTime.execute();

            return response.isSuccessful();


        }

        public com.example.nctai_trading.bitrue.exchangeInfo.exchangeInfoResponse getExchangeInfo() throws IOException {
            String url = baseUrl + "/api/v1/depth/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bitrueServerInterface bitrueServerInterface = retrofit.create(com.example.nctai_trading.bitrue.bitrueServerInterface.class);

            Call<com.example.nctai_trading.bitrue.exchangeInfo.exchangeInfoResponse> call = bitrueServerInterface.getExchangeInfo();

            Response<com.example.nctai_trading.bitrue.exchangeInfo.exchangeInfoResponse> response = call.execute();

            return response.body();
        }


    }

    public class exchangeInfoRequests{

    }


}
