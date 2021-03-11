package com.example.nctai_trading.bidesk;


import com.example.nctai_trading.bidesk.impl.BrokerApiRestClientImpl;
import com.example.nctai_trading.bidesk.impl.BrokerApiServiceGenerator;
import com.example.nctai_trading.bidesk.impl.BrokerApiWebSocketClientImpl;
import com.example.nctai_trading.bidesk.impl.BrokerContractApiRestClientImpl;

/**
 * A factory for creating BrokerApi client objects.
 */
public final class BrokerApiClientFactory extends BrokerApiServiceGenerator {

    /**
     * API Key
     */
    private String apiKey;

    /**
     * Api Secret.
     */
    private String secret;

    /**
     * Api base url.
     */
    private String baseUrl;

    /**
     * Instantiates a new Broker api client factory.
     *
     * @param baseUrl Api base url
     * @param apiKey the API key
     * @param secret the Secret
     */
    private BrokerApiClientFactory(String baseUrl, String apiKey, String secret) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * New instance.
     *
     * @param baseUrl Api base url
     * @param apiKey the API key
     * @param secret the Secret
     * @return the Broker api client factory
     */
    public static BrokerApiClientFactory newInstance(String baseUrl, String apiKey, String secret) {
        return new BrokerApiClientFactory(baseUrl, apiKey, secret);
    }

    /**
     * New instance without authentication.
     *
     * @param baseUrl Api base url
     * @return the Broker api client factory
     */
    public static BrokerApiClientFactory newInstance(String baseUrl) {
        return new BrokerApiClientFactory(baseUrl,null, null);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BrokerApiRestClient newRestClient() {
        return new BrokerApiRestClientImpl(baseUrl, apiKey, secret);
    }

    /**
     * Creates a new synchronous/blocking Contract REST client.
     */
    public BrokerContractApiRestClient newContractRestClient() {
        return new BrokerContractApiRestClientImpl(baseUrl, apiKey, secret);
    }

    /**
     * Creates a new synchronous/blocking websocket REST client.
     *
     * @param wsBaseQuoteUrl Websocket base quote url
     * @param wsBaseUserUrl Websocket base user url
     * @return a broker websocket client
     */
    public BrokerApiWebSocketClient newWebSocketClient(String wsBaseQuoteUrl, String wsBaseUserUrl) {
        return new BrokerApiWebSocketClientImpl(getSharedClient(), wsBaseQuoteUrl, wsBaseUserUrl);
    }
}
