package com.example.nctai_trading.bidesk.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.Socket;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SocketUserResponse {

    public Long pingTime;

    public List<SocketOrder> orderList;

    public List<SocketAccount> accountList;

    public SocketUserResponse() {

    }

    public SocketUserResponse(Long pingTime, List<SocketOrder> orderList, List<SocketAccount> accountList){
        this.pingTime = pingTime;
        this.orderList = orderList;
        this.accountList = accountList;
    }
}
