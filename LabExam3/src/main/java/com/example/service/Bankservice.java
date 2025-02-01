package com.example.service;

import com.example.entity.AccountEntity;

public interface Bankservice {
    public void transfer(int from, int to, int amout);
    public void deposit(int id, double amount);
    public AccountEntity getAccount(int id);
}
