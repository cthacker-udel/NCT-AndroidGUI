package com.example.nctai_trading.kiteConnect;

import com.google.gson.annotations.SerializedName;

public class TokenSet {

    @SerializedName("user_id")
    public String userId;
    @SerializedName("access_token")
    public String accessToken;
    @SerializedName("refresh_token")
    public String refreshToken;

}