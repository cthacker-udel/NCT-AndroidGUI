package com.example.nctai_trading.bidesk.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.nctai_trading.bidesk.constant.BrokerConstants;

import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelOrderResponse {

    private String exchangeId;

    private String symbol;

    private Long orderId;

    private String clientOrderId;

    private OrderStatus status;

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BrokerConstants.TO_STRING_BUILDER_STYLE)
                .append("exchangeId", exchangeId)
                .append("symbol", symbol)
                .append("status", status)
                .append("orderId", orderId)
                .append("clientOrderId", clientOrderId)
                .toString();
    }
}
