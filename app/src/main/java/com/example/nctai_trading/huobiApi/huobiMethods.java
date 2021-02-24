package com.example.nctai_trading.huobiApi;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class huobiMethods {

    String baseUrl = "https://api.hbdm.com";
    String testUrl = "https://api.testnet.huobi.pro";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static class apiSignature{


        static final String op = "op";
        static final String opValue = "auth";
        private static final String ACCESS_KEY_NAME = "accessKey";
        private static final String SIGNATURE_METHOD_NAME = "signatureMethod";
        private static final String SIGNATURE_METHOD_VALUE = "HmacSHA256";
        private static final String SIGNATURE_VERSION_NAME = "signatureVersion";
        public static final String SIGNATURE_VERSION_VALUE = "2.1";
        private static final String TIMESTAMP_NAME = "timestamp";
        private static final String SIGNATURE_NAME = "signature";

        private static final DateTimeFormatter DT_FORMAT = DateTimeFormatter
                .ofPattern("uuuu-MM-dd'T'HH:mm:ss");
        private static final ZoneId ZONE_GMT = ZoneId.of("Z");


        @RequiresApi(api = Build.VERSION_CODES.O)
        public void createSignature(String accessKey, String secretKey, String method, String host,
                                    String uri, UrlParamsBuilder builder) {
            StringBuilder sb = new StringBuilder(1024);

            if (accessKey == null || "".equals(accessKey) || secretKey == null || "".equals(secretKey)) {
                throw new SDKException(SDKException.KEY_MISSING,
                        "API key and secret key are required");
            }

            sb.append(method.toUpperCase()).append('\n')
                    .append(host.toLowerCase()).append('\n')
                    .append(uri).append('\n');

            builder.putToUrl(ACCESS_KEY_NAME, accessKey)
                    .putToUrl(SIGNATURE_VERSION_NAME, SIGNATURE_VERSION_VALUE)
                    .putToUrl(SIGNATURE_METHOD_NAME, SIGNATURE_METHOD_VALUE)
                    .putToUrl(TIMESTAMP_NAME, gmtNow());

            sb.append(builder.buildSignature());
            Mac hmacSha256;
            try {
                hmacSha256 = Mac.getInstance(SIGNATURE_METHOD_VALUE);
                SecretKeySpec secKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), SIGNATURE_METHOD_VALUE);
                hmacSha256.init(secKey);
            } catch (NoSuchAlgorithmException e) {
                throw new SDKException(SDKException.RUNTIME_ERROR, "[Signature] No such algorithm: " + e.getMessage());
            } catch (InvalidKeyException e) {
                throw new SDKException(SDKException.RUNTIME_ERROR, "[Signature] Invalid key: " + e.getMessage());
            }
            String payload = sb.toString();
            byte[] hash = hmacSha256.doFinal(payload.getBytes(StandardCharsets.UTF_8));

            String actualSign = Base64.getEncoder().encodeToString(hash);

            builder.putToUrl(SIGNATURE_NAME, actualSign);

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        private static long epochNow() {
            return Instant.now().getEpochSecond();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        static String gmtNow() {
            return Instant.ofEpochSecond(epochNow()).atZone(ZONE_GMT).format(DT_FORMAT);
        }

    }

    public static class UrlParamsBuilder{


        class ParamsMap {

            final Map<String, String> map = new HashMap<>();
            final Map<String, List> stringListMap = new HashMap<>();

            void put(String name, String value) {

                if (name == null || "".equals(name)) {
                    throw new SDKException(SDKException.RUNTIME_ERROR,
                            "[URL] Key can not be null");
                }
                if (value == null || "".equals(value)) {
                    return;
                }

                map.put(name, value);
            }

            void put(String name, Integer value) {
                put(name, value != null ? Integer.toString(value) : null);
            }

            void put(String name, Date value, String format) {
                SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
                put(name, value != null ? dateFormatter.format(value) : null);
            }

            void put(String name, Long value) {
                put(name, value != null ? Long.toString(value) : null);
            }

            void put(String name, BigDecimal value) {
                put(name, value != null ? value.toPlainString() : null);
            }

        }

        private static final MediaType JSON_TYPE = MediaType.parse("application/json");
        private final UrlParamsBuilder.ParamsMap paramsMap = new UrlParamsBuilder.ParamsMap();
        private final UrlParamsBuilder.ParamsMap postBodyMap = new UrlParamsBuilder.ParamsMap();
        private boolean postMode = false;

        public static UrlParamsBuilder build() {
            return new UrlParamsBuilder();
        }

        private UrlParamsBuilder() {
        }

        public UrlParamsBuilder setPostMode(boolean mode) {
            postMode = mode;
            return this;
        }

        public <T extends Enum> UrlParamsBuilder putToUrl(String name, T value) {
            if (value != null) {
                paramsMap.put(name, value.toString());
            }
            return this;
        }

        public UrlParamsBuilder putToUrl(String name, String value) {
            paramsMap.put(name, value);
            return this;
        }

        public UrlParamsBuilder putToUrl(String name, Date value, String format) {
            paramsMap.put(name, value, format);
            return this;
        }

        public UrlParamsBuilder putToUrl(String name, Integer value) {
            paramsMap.put(name, value);
            return this;
        }

        public UrlParamsBuilder putToUrl(String name, Long value) {
            paramsMap.put(name, value);
            return this;
        }

        public UrlParamsBuilder putToUrl(String name, BigDecimal value) {
            paramsMap.put(name, value);
            return this;
        }

        public UrlParamsBuilder putToPost(String name, String value) {
            postBodyMap.put(name, value);
            return this;
        }

        public <T extends Enum> UrlParamsBuilder putToPost(String name, T value) {
            if (value != null) {
                postBodyMap.put(name, value.toString());
            }
            return this;
        }

        public UrlParamsBuilder putToPost(String name, Date value, String format) {
            postBodyMap.put(name, value, format);
            return this;
        }

        public UrlParamsBuilder putToPost(String name, Integer value) {
            postBodyMap.put(name, value);
            return this;
        }

        public <T> UrlParamsBuilder putToPost(String name, List list) {
            postBodyMap.stringListMap.put(name, list);
            return this;
        }

        public UrlParamsBuilder putToPost(String name, Long value) {
            postBodyMap.put(name, value);
            return this;
        }

        public UrlParamsBuilder putToPost(String name, BigDecimal value) {
            postBodyMap.put(name, value);
            return this;
        }

        public String buildUrl() {
            Map<String, String> map = new HashMap<>(paramsMap.map);
            StringBuilder head = new StringBuilder("?");
            return AppendUrl(map, head);

        }

        public String buildSignature() {
            Map<String, String> map = new TreeMap<>(paramsMap.map);
            StringBuilder head = new StringBuilder();
            return AppendUrl(map, head);

        }

        private String AppendUrl(Map<String, String> map, StringBuilder stringBuilder) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!("").equals(stringBuilder.toString())) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append(urlEncode(entry.getValue()));
            }
            return stringBuilder.toString();
        }

        public RequestBody buildPostBody() {
            if (postBodyMap.stringListMap.isEmpty()) {
                if (postBodyMap.map.isEmpty()) {
                    return RequestBody.create(JSON_TYPE, "");
                } else {
                    return RequestBody.create(JSON_TYPE, JSON.toJSONString(postBodyMap.map));
                }
            } else {
                return RequestBody.create(JSON_TYPE, JSON.toJSONString(postBodyMap.stringListMap));


            }
        }

        public boolean hasPostParam() {
            return !postBodyMap.map.isEmpty() || postMode;
        }


        public String buildUrlToJsonString() {
            return JSON.toJSONString(paramsMap.map);
        }

        /**
         * 使用标准URL Encode编码。注意和JDK默认的不同，空格被编码为%20而不是+。
         *
         * @param s String字符串
         * @return URL编码后的字符串
         */
        private static String urlEncode(String s) {
            try {
                return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
            } catch (UnsupportedEncodingException e) {
                throw new SDKException(SDKException.RUNTIME_ERROR,
                        "[URL] UTF-8 encoding not supported!");
            }
        }

    }


    public class marketDataRequests{

        public swapMarketInfo getMarketData() throws IOException {

            String url = baseUrl + "/swap-api/v1/swap_contract_info/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            huobiMarketInterface huobiMarketInterface = retrofit.create(com.example.nctai_trading.huobiApi.huobiMarketInterface.class);

            Call<swapMarketInfo> call = huobiMarketInterface.getSwapMarketInfo();

            Response<swapMarketInfo> response = call.execute();

            return response.body();


        }

        public huobiSwapMarketIndex getSwapIndexPriceInfo() throws IOException {

            String url = baseUrl + "/swap-api/v1/swap_index/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            huobiMarketInterface huobiMarketInterface = retrofit.create(com.example.nctai_trading.huobiApi.huobiMarketInterface.class);

            Call<huobiSwapMarketIndex> call = huobiMarketInterface.getSwapMarketIndex();

            Response<huobiSwapMarketIndex> response = call.execute();

            return response.body();

        }

        public huobiSwapMarketLimitation getSwapPriceLimitation(String contractCode) throws IOException {
            String url = baseUrl + "/swap-api/v1/swap_price_limit/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            huobiMarketInterface huobiMarketInterface = retrofit.create(com.example.nctai_trading.huobiApi.huobiMarketInterface.class);

            Call<huobiSwapMarketLimitation> getSwapMarketLimitation = huobiMarketInterface.getSwapMarketLimitation(contractCode);

            Response<huobiSwapMarketLimitation> response = getSwapMarketLimitation.execute();

            return response.body();

        }

        public huobiSwapMarketOpenInterest getSwapOpenInterest() throws IOException {

            String url = baseUrl + "/swap-api/v1/swap_open_interest/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            huobiMarketInterface huobiMarketInterface = retrofit.create(com.example.nctai_trading.huobiApi.huobiMarketInterface.class);

            Call<huobiSwapMarketOpenInterest> call = huobiMarketInterface.getSwapMarketOpenInterest();

            Response<huobiSwapMarketOpenInterest> response = call.execute();

            return response.body();

        }

        public huobiSwapMarketDepth getMarketDepth(String contractCode, String type) throws IOException {

            String url = baseUrl + "/swap-ex/market/depth/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            huobiMarketInterface huobiMarketInterface = retrofit.create(com.example.nctai_trading.huobiApi.huobiMarketInterface.class);

            Call<huobiSwapMarketDepth> call = huobiMarketInterface.getSwapMarketDepth(contractCode, type);

            Response<huobiSwapMarketDepth> response = call.execute();

            return response.body();
        }

        public huobiSwapMarketKlineData getKLineData(String contractCode, String period) throws IOException {

            String url = baseUrl + "/swap-ex/market/history/kline/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            huobiMarketInterface huobiMarketInterface = retrofit.create(com.example.nctai_trading.huobiApi.huobiMarketInterface.class);

            Call<huobiSwapMarketKlineData> call = huobiMarketInterface.getSwapMarketKline(contractCode,period);

            Response<huobiSwapMarketKlineData> response = call.execute();

            return response.body();

        }

        public huobiSwapMarketKlineDataSize getKlineData(String contractCode, String period, Integer size) throws IOException {

            String url = baseUrl + "/index/market/history/swap_mark_price_kline/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            huobiMarketInterface huobiMarketInterface = retrofit.create(com.example.nctai_trading.huobiApi.huobiMarketInterface.class);


            Call<huobiSwapMarketKlineDataSize> call = huobiMarketInterface.getSwapMarketKlineSize(contractCode,period,size);

            Response<huobiSwapMarketKlineDataSize> response = call.execute();

            return response.body();


        }

        public huobiMarketDetail getMarketDataOverview(String contractCode) throws IOException {

            String url = baseUrl + "/swap-ex/market/detail/merged/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            huobiMarketInterface huobiMarketInterface = retrofit.create(com.example.nctai_trading.huobiApi.huobiMarketInterface.class);

            Call<huobiMarketDetail> call = huobiMarketInterface.getMarketDetail(contractCode);

            Response<huobiMarketDetail> response = call.execute();

            return response.body();

        }

        public huobiMarketDetailBatch getMarketDetailOverviewBatch(String contractCode) throws IOException {

            String url = baseUrl + "/swap-ex/market/detail/batch_merged";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            huobiMarketInterface huobiMarketInterface = retrofit.create(com.example.nctai_trading.huobiApi.huobiMarketInterface.class);

            Call<huobiMarketDetailBatch> call = huobiMarketInterface.getMarketDetailBatch(contractCode);

            Response<huobiMarketDetailBatch> response = call.execute();

            return response.body();

        }

    }

    public class accountRequests{

        public void getAccountInformation(){




        }


    }


}
