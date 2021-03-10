package com.example.nctai_trading.bibox;

public class BiBoxWebSocketConfig
{
    private String host = UrlConstants.DEFAULT_WEBSOCKET_HOST;

    public static Builder custom()
    {
        return new Builder();
    }

    public static Builder from(BiBoxWebSocketConfig config)
    {
        return new Builder(config);
    }

    public static BiBoxWebSocketConfig ofDefaults()
    {
        return new Builder().build();
    }

    public String getHost()
    {
        return host;
    }

    public static class Builder
    {
        private BiBoxWebSocketConfig config = new BiBoxWebSocketConfig();

        public Builder()
        {

        }

        public Builder(BiBoxWebSocketConfig config)
        {
            this.config = config;
        }

        public Builder host(String host)
        {
            config.host = host;
            return this;
        }

        public BiBoxWebSocketConfig build()
        {
            return config;
        }
    }
}
