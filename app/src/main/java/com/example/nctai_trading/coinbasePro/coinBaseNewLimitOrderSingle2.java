package com.example.nctai_trading.coinbasePro;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class coinBaseNewLimitOrderSingle2 {

    private BigDecimal size;
    private BigDecimal price;
    private Boolean post_only;
    private String client_oid; //optional
    private String type; //default is limit, other types are market and stop
    private String side;
    private String product_id;
    private String stp; //optional: values are dc, co , cn , cb
    private String funds;

    public coinBaseNewLimitOrderSingle2() {}

    public coinBaseNewLimitOrderSingle2(BigDecimal size, BigDecimal price, Boolean post_only, String product_id) {
        this.size = size;
        this.price = price;
        this.post_only = post_only;
        setProduct_id(product_id);
    }

    public coinBaseNewLimitOrderSingle2(BigDecimal size, BigDecimal price, Boolean post_only,
                                String clientOid,
                                String type,
                                String side,
                                String product_id,
                                String stp,
                                String funds) {
        this.size = size;
        this.price = price;
        this.post_only = post_only;
        setClient_oid(clientOid);
        setType(type);
        setSide(side);
        setProduct_id(product_id);
        setStp(stp);
        setFunds(funds);
    }

    public Boolean getPost_only() {
        return post_only;
    }

    public void setPost_only(Boolean post_only) {
        this.post_only = post_only;
    }

    public BigDecimal getPrice() {
        return price.setScale(8, RoundingMode.HALF_UP);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSize() {
        return size.setScale(8, RoundingMode.HALF_UP);
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public String getStp() {
        return stp;
    }

    public void setStp(String stp) {
        this.stp = stp;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getClient_oid() {
        return client_oid;
    }

    public void setClient_oid(String client_oid) {
        this.client_oid = client_oid;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
