package com.alex.nikitin.model.dto;

public class ItemDto {
    private long id;
    private long orderId;
    private String name;
    private long price;

    public ItemDto(long id, long orderId, String name, long price) {
        this.id = id;
        this.orderId = orderId;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
