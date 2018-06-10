package com.alex.nikitin.model.dto;

import java.util.List;

public class UserDto {
    private long id;
    private String name;
    private String surname;
    private String username;
    private List<Long> orderIds;

    public UserDto(long id, String name, String surname, String username, List<Long> orderIds) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.orderIds = orderIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }
}
