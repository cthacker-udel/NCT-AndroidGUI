package com.example.nctai_trading.bidesk.domain.contract.request;


import com.example.nctai_trading.bidesk.domain.account.OrderSide;
import com.example.nctai_trading.bidesk.domain.account.TimeInForce;
import com.example.nctai_trading.bidesk.domain.contract.OrderType;
import com.example.nctai_trading.bidesk.domain.contract.PriceType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContractOrderRequest {

    public String getSymbol() {
        return symbol;
    }

    public OrderSide getSide() {
        return side;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getLeverage() {
        return leverage;
    }

    public String getPrice() {
        return price;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public String getTriggerPrice() {
        return triggerPrice;
    }

    public TimeInForce getTimeInForce() {
        return timeInForce;
    }

    /**
     * Name of the contract.
     */
    private String symbol;

    /**
     * Direction of the order.
     */
    private OrderSide side;

    /**
     * The order type,
     */
    private OrderType orderType;

    /**
     * The number of contracts to buy.
     */
    private String quantity;

    /**
     * Leverage of the order.
     */
    private String leverage;

    /**
     * Price of the order
     */
    private String price;

    /**
     * The price type,
     */
    private PriceType priceType;

    /**
     * The price at which the trigger order will be executed.
     * Required for STOP orders.
     */
    private String triggerPrice;

    /**
     * Time in force for LIMIT orders.
     */
    private TimeInForce timeInForce;

    /**
     * A unique ID of the order. Automatically generated if not sent.
     */
    private String clientOrderId;

    public String getClientOrderId() {
        return this.clientOrderId;
    }


}
