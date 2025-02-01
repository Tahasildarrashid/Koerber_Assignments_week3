package com.example.service;

import com.example.Exceptions.AccountNotFound;
import com.example.entity.AccountEntity;
import com.example.repository.Bankdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
public class Bankserviceimplementation implements Bankservice {

    private Bankdao bankdao;
    private static final Logger logger = Logger.getLogger(Bankserviceimplementation.class.getName());

    @Autowired
    public Bankserviceimplementation(Bankdao bankdao) {
        this.bankdao = bankdao;
    }

    @Override
    @Transactional
    public void transfer(int from, int to, int amount) {
        AccountEntity fromAccount = bankdao.find(from);
        AccountEntity toAccount = bankdao.find(to);

        if (fromAccount.getBalance() < amount) {
            throw new AccountNotFound("Insufficient funds in the source account");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        bankdao.update(fromAccount);
        bankdao.update(toAccount);
        logger.info("Transfer completed successfully");
    }

    @Override
    @Transactional
    public void deposit(int id, double amount) {
        AccountEntity account = bankdao.find(id);
        account.setBalance(account.getBalance() + amount);
        bankdao.update(account);
        logger.info("Deposit completed successfully");
    }

    @Override
    @Transactional
    public AccountEntity getAccount(int id) {
        try
        {
            return bankdao.find(id);
        }
        catch (Exception e)
        {
            throw new AccountNotFound("Account not found");
        }
    }
}
