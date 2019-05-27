package com.alex.nikitin.model.dto;

public class PeriodDto {
    private String periodStart;
    private String periodEnd;

    public PeriodDto(String periodStart, String periodEnd) {
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

    public String getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(String periodStart) {
        this.periodStart = periodStart;
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
    }
}
