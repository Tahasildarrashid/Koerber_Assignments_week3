package com.example.dto;

public class Accountbean {
    private int from;
    private int to;
    private int amount;

    public Accountbean() {}

    public Accountbean(int from, int to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
