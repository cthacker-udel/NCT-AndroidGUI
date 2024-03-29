package com.example.nctai_trading.bidesk.domain.contract.request;

import com.example.nctai_trading.bidesk.domain.contract.OrderType;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CancelContractOrderRequest {

    public Long getOrderId() {
        return orderId;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    /**
     * The order ID of the order to be canceled.
     */
    private Long orderId;

    /**
     * Unique client customized ID of the order.
     */
    private String clientOrderId;

    /**
     * The order type, possible types: LIMIT and STOP.
     */
    private OrderType orderType;
}