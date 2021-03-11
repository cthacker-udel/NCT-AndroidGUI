package com.example.nctai_trading.bidesk.domain.contract.request;


import com.example.nctai_trading.bidesk.domain.contract.PositionSide;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModifyMarginRequest {

    /**
     * The symbol's margin to be modified.
     */
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public PositionSide getSide() {
        return side;
    }

    public String getAmount() {
        return amount;
    }

    /**
     * Direction of the position.
     */
    private PositionSide side;

    /**
     * Amount of margin to be added (Positive Value) or removed (Negative Value).
     * Please note that this amount refers to the underlying quote asset of the asset.
     */
    private String amount;
}
