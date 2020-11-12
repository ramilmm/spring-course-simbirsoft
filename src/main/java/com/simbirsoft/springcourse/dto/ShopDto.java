package com.simbirsoft.springcourse.dto;

import com.simbirsoft.springcourse.model.Status;

import java.time.LocalDate;

public class ShopDto {

    private String name;
    private LocalDate creationDate;
    private Integer monthProfit;
    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getMonthProfit() {
        return monthProfit;
    }

    public void setMonthProfit(Integer monthProfit) {
        this.monthProfit = monthProfit;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
