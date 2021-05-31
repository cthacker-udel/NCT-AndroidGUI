package com.example.nctai_trading.idcm;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.HMAC256;
import com.example.nctai_trading.idcm.OrderInfo.OrderInfo;
import com.example.nctai_trading.idcm.UserInfo.UserInfo;
import com.google.gson.Gson;

import org.apache.commons.codec.digest.DigestUtils;
import org.spongycastle.crypto.Digest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class idcmMethods {

    String baseUrl = "https://api.IDCM.cc:8323/api/v1";
    String apiKey = "lpREviCmtECyfHcc0f_D3A";
    String secretKey = "907DBLUl7Q8jhfCFItdjbzfs1IP565tqF2GxyfPJOQYwdNmge5agUKizLECTWOe2nHEez57sEtvkBJedmyQ0UcwVJ6LTCWMZBW9v97H9YIBqfXY2ppwoXe8abIusjdPIGvIEAJ4eRH2cB6GM7Jtdpo1nNYkqDePKSSJJejsGkiwgbVz42IlAJBjitlQBoEBDRhkImWxNhNT6SKcSpfoUTf0gyrfTtQhGHTpUBQI5bxjWIdpI8Yc9gHJCg39VGDkq";
    // three headers required, X-IDCM-APIKEY, X-IDCM-SIGNATURE, X-IDCM-INPUT
    static final String HMAC_SHA384 = "HmacSHA384";

    public idcmMethods(String apiKey, String secretKey){
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getSignature(String params) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {

        // needs revisions, hmacDigest does a hmac.hexdigest() instead of hmac.digest()

        com.example.nctai_trading.HMAC256 hmac256 = new HMAC256();
        byte[] digest = hmac256.hmacDigest(params,secretKey,HMAC_SHA384).getBytes();
        String digest2 = hmacDigest2(params,secretKey,HMAC_SHA384);
        return new String(Base64.getEncoder().encode(hmac256.hmacDigest(params,secretKey,HMAC_SHA384).getBytes()),StandardCharsets.UTF_8);

        /*

        aYB7HkMJAHvnY4

        final Mac mac = Mac.getInstance(HMAC_SHA384);
        final Charset utf8 = StandardCharsets.UTF_8;
        SecretKeySpec secretKeySpec = new SecretKeySpec(utf8.encode(secretKey).array(),"HmacSHA348");
        mac.init(secretKeySpec);
        byte[] result = mac.doFinal(utf8.encode(params).array());
        StringBuffer hash = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            String hex = Integer.toHexString(0xFF & result[i]);
            if (hex.length() == 1) {
                hash.append('0');
            }
            hash.append(hex);
        }
        String digest = hash.toString();
        String signature = new String(Base64.getEncoder().encode(digest.getBytes()),StandardCharsets.UTF_8);
        return signature;
         */
    }

    public String hmacDigest2(String msg, String keyString, String algo){
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes(), algo);
            Mac mac = Mac.getInstance(algo);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes());

            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        }
          catch (InvalidKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        }
        return digest;
    }


    public String jsonStringifyMap(Map<String,Object> map){
        return new Gson().toJson(map);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String encodedBase64(String jsonObj){
        return Base64.getEncoder().encodeToString(jsonObj.getBytes());
    }

    public String encodedUTF8(String jsonObj) throws UnsupportedEncodingException {
        return new String(jsonObj.getBytes(), StandardCharsets.UTF_8);
    }


    public class orderRequests{

        @RequiresApi(api = Build.VERSION_CODES.O)
        public idcmOrderResponse placeOrder(String symbol, int size, int price, int side, int orderType, int amount) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

            String url = baseUrl + "/trade/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Map<String,Object> params = new LinkedHashMap<>();

            params.put("Symbol",symbol);
            params.put("Size",size);
            params.put("Price",price);
            params.put("Side",side);
            params.put("Type",orderType);
            params.put("Amount",amount);

            idcmOrderInterface idcmOrderInterface = retrofit.create(com.example.nctai_trading.idcm.idcmOrderInterface.class);

            String signature = getSignature(jsonStringifyMap(params));

            Call<idcmOrderResponse> call = idcmOrderInterface.placeOrder(apiKey,signature,encodedUTF8(jsonStringifyMap(params)),params);

            Response<idcmOrderResponse> response = call.execute();

            return response.body();

        }


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public UserInfo getUserInformation() throws NoSuchAlgorithmException, InvalidKeyException, IOException {

        String url = baseUrl + "/getuserinfo/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Map<String,Object> params = new LinkedHashMap<>();

        params.put("1","1");

        idcmOrderInterface idcmOrderInterface = retrofit.create(com.example.nctai_trading.idcm.idcmOrderInterface.class);

        String signature = getSignature(jsonStringifyMap(params));

        Call<UserInfo> call = idcmOrderInterface.getAccountInfo(apiKey,signature,encodedUTF8(jsonStringifyMap(params)),params);

        Response<UserInfo> response = call.execute();

        return response.body();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public OrderInfo getHistoricalOrderInformation(String symbol, Integer pageIndex, Integer pageSize, Integer orderStatus) throws NoSuchAlgorithmException, InvalidKeyException, IOException {

        String url = baseUrl + "/gethistoryorder/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Map<String,Object> params = new LinkedHashMap<>();

        params.put("Symbol",symbol);
        params.put("PageIndex",pageIndex);
        params.put("PageSize",pageSize);
        params.put("Status",orderStatus);

        idcmOrderInterface idcmOrderInterface = retrofit.create(com.example.nctai_trading.idcm.idcmOrderInterface.class);

        String signature = getSignature(jsonStringifyMap(params));

        Call<OrderInfo> call = idcmOrderInterface.getHistoricalOrderInfo(apiKey,signature,encodedUTF8(jsonStringifyMap(params)),params);

        Response<OrderInfo> response = call.execute();

        return response.body();


    }


}
