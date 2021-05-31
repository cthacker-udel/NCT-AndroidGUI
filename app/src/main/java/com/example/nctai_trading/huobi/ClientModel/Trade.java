package com.example.nctai_trading.huobi.ClientModel;

import com.example.nctai_trading.huobi.Client.HuobiClient;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Trade extends HuobiClient {

    private String contractCode;
    private Long clientOrderId;
    private Double price;
    private Long volume;
    private String direction;
    private String offset;
    private Integer leverRate;
    private String orderPriceType;
    private Double tpTriggerPrice;
    private Double tpOrderPrice;
    private String tpOrderPriceType;
    private Double slTriggerPrice;
    private Double slOrderPrice;
    private String slOrderPriceType;
    private List<Object> orders_data = new LinkedList<>();
    private String orderId;
    private Long createdAt;
    private Integer orderType;
    private Integer pageIndex;
    private Integer pageSize;
    private String sortBy;
    private Integer tradeType;
    private Integer type;
    private String orderStatus;
    private Integer createDate;


    public TreeMap<String,Object> generateQueries(){

        TreeMap<String,Object> queries = new TreeMap<>();
        if(this.type != null){
            queries.put("type",this.type);
        }
        if(this.orderStatus != null){
            queries.put("status",this.orderStatus);
        }
        if(this.createDate != null){
            queries.put("createDate",this.createDate);
        }
        if(this.contractCode != null){
            queries.put("contract_code",this.contractCode);
        }
        if(this.clientOrderId != null){
            queries.put("client_order_id",this.clientOrderId);
        }
        if(this.price != null){
            queries.put("price",this.price);
        }
        if(this.volume != null){
            queries.put("volume",this.volume);
        }
        if(this.direction != null){
            queries.put("direction",this.direction);
        }
        if(this.offset != null){
            queries.put("offset",this.offset);
        }
        if(this.leverRate != null){
            queries.put("lever_rate",this.leverRate);
        }
        if(this.orderPriceType != null){
            queries.put("order_price_type",this.orderPriceType);
        }
        if(this.tpTriggerPrice != null){
            queries.put("tp_trigger_price",this.tpTriggerPrice);
        }
        if(this.tpOrderPrice != null){
            queries.put("tp_order_price",this.tpOrderPrice);
        }
        if(this.tpOrderPriceType != null){
            queries.put("tp_order_price_type",this.tpOrderPriceType);
        }
        if(this.slTriggerPrice != null){
            queries.put("sl_trigger_price",this.slTriggerPrice);
        }
        if(this.slOrderPrice != null){
            queries.put("sl_order_price",this.slOrderPrice);
        }
        if(this.slOrderPriceType != null){
            queries.put("sl_order_price_type",this.slOrderPriceType);
        }
        if(this.orders_data.size() > 0){
            queries.put("orders_data",this.orders_data);
        }
        if(this.orderId != null){
            queries.put("order_id", this.orderId);
        }
        if(this.createdAt != null){
            queries.put("created_at",this.createdAt);
        }
        if(this.orderType != null){
            queries.put("order_type",this.orderType);
        }
        if(this.pageIndex != null){
            queries.put("page_index",this.pageIndex);
        }
        if(this.pageSize != null){
            queries.put("page_size",this.pageSize);
        }
        if(this.sortBy != null){
            queries.put("sort_by",this.sortBy);
        }
        if(this.tradeType != null){
            queries.put("trade_type",this.tradeType);
        }
        return queries;
    }

    public void clearQueries(){

        this.contractCode= null;
        this.clientOrderId= null;
        this.price= null;
        this.volume= null;
        this.direction= null;
        this.offset= null;
        this.leverRate= null;
        this.orderPriceType= null;
        this.tpTriggerPrice= null;
        this.tpOrderPrice= null;
        this.tpOrderPriceType= null;
        this.slTriggerPrice= null;
        this.slOrderPrice= null;
        this.slOrderPriceType= null;
        this.orders_data = new LinkedList<>();
        this.orderId= null;
        this.createdAt= null;
        this.orderType= null;
        this.pageIndex= null;
        this.pageSize= null;
        this.sortBy = null;
        this.tradeType = null;
        this.type = null;
        this.orderStatus = null;
        this.createDate = null;
    }

    public List<Object> getOrders_data() {
        return orders_data;
    }

    public void setOrders_data(List<Object> orders_data) {
        this.orders_data = orders_data;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Long getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(Long clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public Integer getLeverRate() {
        return leverRate;
    }

    public void setLeverRate(Integer leverRate) {
        this.leverRate = leverRate;
    }

    public String getOrderPriceType() {
        return orderPriceType;
    }

    public void setOrderPriceType(String orderPriceType) {
        this.orderPriceType = orderPriceType;
    }

    public Double getTpTriggerPrice() {
        return tpTriggerPrice;
    }

    public void setTpTriggerPrice(Double tpTriggerPrice) {
        this.tpTriggerPrice = tpTriggerPrice;
    }

    public Double getTpOrderPrice() {
        return tpOrderPrice;
    }

    public void setTpOrderPrice(Double tpOrderPrice) {
        this.tpOrderPrice = tpOrderPrice;
    }

    public String getTpOrderPriceType() {
        return tpOrderPriceType;
    }

    public void setTpOrderPriceType(String tpOrderPriceType) {
        this.tpOrderPriceType = tpOrderPriceType;
    }

    public Double getSlTriggerPrice() {
        return slTriggerPrice;
    }

    public void setSlTriggerPrice(Double slTriggerPrice) {
        this.slTriggerPrice = slTriggerPrice;
    }

    public Double getSlOrderPrice() {
        return slOrderPrice;
    }

    public void setSlOrderPrice(Double slOrderPrice) {
        this.slOrderPrice = slOrderPrice;
    }

    public String getSlOrderPriceType() {
        return slOrderPriceType;
    }

    public void setSlOrderPriceType(String slOrderPriceType) {
        this.slOrderPriceType = slOrderPriceType;
    }
}
