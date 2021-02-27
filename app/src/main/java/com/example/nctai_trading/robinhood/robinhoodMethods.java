package com.example.nctai_trading.robinhood;

import java.util.HashMap;
import java.util.List;

import jersey.repackaged.com.google.common.collect.ImmutableList;

public class robinhoodMethods {

    private final HashMap<String, String> headers = new HashMap<String, String>() {{
        put("Accept", "*/*");
        put("Accept-Encoding", "gzip, deflate");
        put("Accept-Language", "en;q=1, fr;q=0.9, de;q=0.8, ja;q=0.7, nl;q=0.6, it;q=0.5");
        put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        put("X-Robinhood-API-Version", "1.70.0");
        put("Connection", "keep-alive");
        put("User-Agent", "Robinhood/823 (iPhone; iOS 7.1.2; Scale/2.00)");
    }};

    private final HashMap<String, String> endpoints = new HashMap<String, String>() {{
        put("login", "https://api.robinhood.com/api-token-auth/");
        put("investment_profile", "https://api.robinhood.com/user/investment_profile/");
        put("accounts", "https://api.robinhood.com/accounts/");
        put("ach_iav_auth", "https://api.robinhood.com/ach/iav/auth/");
        put("ach_relationships", "https://api.robinhood.com/ach/relationships/");
        put("ach_transfers", "https://api.robinhood.com/ach/transfers/");
        put("applications", "https://api.robinhood.com/applications/");
        put("dividends", "https://api.robinhood.com/dividends/");
        put("edocuments", "https://api.robinhood.com/documents/");
        put("instruments", "https://api.robinhood.com/instruments/");
        put("margin_upgrades", "https://api.robinhood.com/margin/upgrades/");
        put("markets", "https://api.robinhood.com/markets/");
        put("notifications", "https://api.robinhood.com/notifications/");
        put("orders", "https://api.robinhood.com/orders/");
        put("password_reset", "https://api.robinhood.com/password_reset/request/");
        put("quotes", "https://api.robinhood.com/quotes/");
        put("document_requests", "https://api.robinhood.com/upload/document_requests/");
        put("user", "https://api.robinhood.com/user/");
        put("user/additional_info", "https://api.robinhood.com/user/additional_info/");
        put("user/basic_info", "https://api.robinhood.com/user/basic_info/");
        put("user/employment", "https://api.robinhood.com/user/employment/");
        put("user/investment_profile", "https://api.robinhood.com/user/investment_profile/");
        put("watchlists", "https://api.robinhood.com/watchlists/");
    }};

    private static final List<String> REQUIRED_ENDPOINT_KEYS = ImmutableList.of("positions", "portfolio", "account");


    public void logIn(){




    }



}
