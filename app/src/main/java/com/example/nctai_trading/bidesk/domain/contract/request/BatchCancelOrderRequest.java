package com.example.nctai_trading.bidesk.domain.contract.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BatchCancelOrderRequest {

    public List<String> getSymbolList() {
        return symbolList;
    }

    /**
     * The symbol ids of the cancel orders
     */
    private List<String> symbolList;
}
