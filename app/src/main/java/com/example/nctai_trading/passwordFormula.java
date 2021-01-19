package com.example.nctai_trading;


import org.apache.commons.codec.digest.DigestUtils;

class passwordFormula {
    private String salt;
    //private MessageDigest md;
    //private byte[] digest;
    private String md5Hex;

    public passwordFormula(){
        super();
    }

    private String passwordHasher(String password) {
        this.salt = "WHTCcRfAMyyG3xF9";
        //this.md = MessageDigest.getInstance("MD5");
        //this.md.update((password+salt).getBytes());
        //this.digest = md.digest();
        //hashValidator = DatatypeConverter.printHexBinary(digest).toUpperCase();
        this.md5Hex = DigestUtils.md5Hex(password + salt).toUpperCase();
        return md5Hex;
    }


}
