package com.alex.nikitin.model.dto;

public class MovieSummaryDto {
    private String timeOfDay;
    private long priceSum;
    private long clientSum;

    public MovieSummaryDto(String timeOfDay, long priceSum, long clientSum) {
        this.timeOfDay = timeOfDay;
        this.priceSum = priceSum;
        this.clientSum = clientSum;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public long getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(long priceSum) {
        this.priceSum = priceSum;
    }

    public long getClientSum() {
        return clientSum;
    }

    public void setClientSum(long clientSum) {
        this.clientSum = clientSum;
    }
}
