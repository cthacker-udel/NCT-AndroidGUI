package com.example.nctai_trading.robinhood.robinhood.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Execution {
    private String quantity;
    private String timestamp;
}
