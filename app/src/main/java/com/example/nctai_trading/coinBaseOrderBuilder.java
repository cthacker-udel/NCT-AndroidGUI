package com.example.nctai_trading;

public class coinBaseOrderBuilder {

    private String id;
    private String size;
    private String price;
    private String product_id;
    private String status;
    private String filled_size;
    private String fill_fees;
    private String side;
    private String created_at;
    private Boolean settled;

    public coinBaseOrderBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public coinBaseOrderBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public coinBaseOrderBuilder setPrice(String price) {
        this.price = price;
        return this;
    }

    public coinBaseOrderBuilder setProduct_id(String product_id) {
        this.product_id = product_id;
        return this;
    }

    public coinBaseOrderBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public coinBaseOrderBuilder setFilled_size(String filled_size) {
        this.filled_size = filled_size;
        return this;
    }

    public coinBaseOrderBuilder setFill_fees(String fill_fees) {
        this.fill_fees = fill_fees;
        return this;
    }

    public coinBaseOrderBuilder setSettled(Boolean settled) {
        this.settled = settled;
        return this;
    }

    public coinBaseOrderBuilder setSide(String side) {
        this.side = side;
        return this;
    }

    public coinBaseOrderBuilder setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getStatus() {
        return status;
    }

    public String getFilled_size() {
        return filled_size;
    }

    public String getFill_fees() {
        return fill_fees;
    }

    public Boolean getSettled() {
        return settled;
    }

    public String getSide() {
        return side;
    }

    public String getCreated_at() {
        return created_at;
    }

    public coinBaseOrder build() {
        return new coinBaseOrder(this);
    }

}
