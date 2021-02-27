package com.example.nctai_trading.robinhood.http.client;

import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Map;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HTTPQuery {
    public String getUrl() {
        return url;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    private final String url;
    private final Map<String, String> parameters;
    private final Map<String, String> headers;

    public HTTPQuery(String login, Map<String,String> params, Map<String,String> theHeaders){
        this.url = login;
        this.parameters = params;
        this.headers = theHeaders;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(url).append(parameters).append(headers).toHashCode();
    }

    @Override
    public boolean equals(final Object otherObject) {
        if (!(otherObject instanceof HTTPQuery)) {
            return false;
        }
        final HTTPQuery otherQuery = (HTTPQuery)  otherObject;
        return (Objects.equals(url, otherQuery.getUrl()) &&
                Objects.equals(parameters, otherQuery.getParameters()) &&
                Objects.equals(headers, otherQuery.getHeaders()));
    }
}
