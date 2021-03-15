package com.example.nctai_trading.bibox;

public class BiBoxHttpClientConfig
{
    private String host = UrlConstants.DEFAULT_HOST;
    private String apiKey;
    private String secret;
    private int connectTimeout = 20;
    private int writeTimeout = 20;
    private int readTimeout = 20;

    public BiBoxHttpClientConfig()
    {

    }

    public static Builder custom()
    {
        return new Builder();
    }

    public static Builder from(BiBoxHttpClientConfig baseConfig)
    {
        return new Builder(baseConfig);
    }

    public static BiBoxHttpClientConfig ofDefaults()
    {
        return new Builder().build();
    }

    public String getHost()
    {
        return host;
    }

    public String getApiKey()
    {
        return apiKey;
    }

    public String getSecret()
    {
        return secret;
    }

    public int getConnectTimeout()
    {
        return connectTimeout;
    }

    public int getWriteTimeout()
    {
        return writeTimeout;
    }

    public int getReadTimeout()
    {
        return readTimeout;
    }

    public static class Builder
    {
        private BiBoxHttpClientConfig config = new BiBoxHttpClientConfig();

        public Builder()
        {

        }

        public Builder(BiBoxHttpClientConfig config)
        {
            this.config = config;
        }

        public Builder host(String host)
        {
            config.host = host;
            return this;
        }

        public Builder apiKey(String apiKey)
        {
            config.apiKey = apiKey;
            return this;
        }

        public Builder secret(String secret)
        {
            config.secret = secret;
            return this;
        }

        public Builder connectTimeout(int connectTimeout)
        {
            config.connectTimeout = connectTimeout;
            return this;
        }

        public Builder writeTimeout(int writeTimeout)
        {
            config.writeTimeout = writeTimeout;
            return this;
        }

        public Builder readTimeout(int readTimeout)
        {
            config.readTimeout = readTimeout;
            return this;
        }

        public BiBoxHttpClientConfig build()
        {
            return config;
        }
    }
}
