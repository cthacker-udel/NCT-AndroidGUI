package com.example.nctai_trading;

public class Common {

    private static String DB_NAME = "test";
    private static String COLLECTION_NAME = "user";
    public static String API_KEY = "829ec172-768a-4992-adf1-1ee631421c24";
    // public key : MPOKYWGC
    // private key : 829ec172-768a-4992-adf1-1ee631421c24

    public static String getAddressSingle(User user){
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("/"+user.get_id().getOid()+"?apiKey="+API_KEY);
        return stringBuilder.toString();
    }

    public static String getAddressAPI(){
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }

}
