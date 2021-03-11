package com.example.nctai_trading.bidesk.domain.contract.request;


import com.example.nctai_trading.bidesk.domain.account.OrderSide;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContractMyTradeRequest {

    /**
     * Symbol to return open orders for.
     * If not sent, orders of all contracts will be returned.
     */
    private String symbol;

    /**
     * TradeId to fetch from.
     */
    private Long fromId;

    public String getSymbol() {
        return symbol;
    }

    public Long getFromId() {
        return fromId;
    }

    public Long getToId() {
        return toId;
    }

    public OrderSide getSide() {
        return side;
    }

    public Integer getLimit() {
        return limit;
    }

    /**
     * TradeId to fetch to.
     */
    private Long toId;

    /**
     * Direction of the order.
     * <strong>This parameter is no longer supported</strong>
     */
    @Deprecated
    private OrderSide side;

    /**
     * Number of entries to return.
     */
    private Integer limit;
}
