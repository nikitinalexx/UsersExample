package com.alex.nikitin.model.dto;

import java.util.List;

public class ItemOrderDto {
    private long id;
    private long customerId;
    private String name;
    private String description;
    private List<Long> itemIds;

    public ItemOrderDto(long id, long customerId, String name, String description, List<Long> itemIds) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.description = description;
        this.itemIds = itemIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
