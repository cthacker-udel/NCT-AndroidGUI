package com.example.nctai_trading.bidesk.domain.contract.request;


import com.example.nctai_trading.bidesk.domain.account.OrderSide;
import com.example.nctai_trading.bidesk.domain.contract.OrderType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContractOpenOrderRequest {

    public String getSymbol() {
        return symbol;
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderSide getSide() {
        return side;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public Integer getLimit() {
        return limit;
    }

    /**
     * Symbol to return open orders for.
     * If not sent, orders of all contracts will be returned.
     */
    private String symbol;

    /**
     * Order ID
     */
    private Long orderId;

    /**
     * Direction of the order.
     * <strong>This parameter is no longer supported</strong>
     */
    @Deprecated
    private OrderSide side;

    /**
     * The order type.
     */
    private OrderType orderType;

    /**
     * Number of entries to return.
     */
    private Integer limit;
}
