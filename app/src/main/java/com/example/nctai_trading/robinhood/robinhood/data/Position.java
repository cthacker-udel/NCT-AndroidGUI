package com.example.nctai_trading.robinhood.robinhood.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private double quantity;
    private double average_buy_price;
    private String instrument;

    public double getQuantity() {
        return quantity;
    }
}
