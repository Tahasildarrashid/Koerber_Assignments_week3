package com.example.controller;

import com.example.service.Bankservice;
import com.example.dto.Accountbean;
import com.example.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private Bankservice accountService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody Accountbean accountBean) {
        try {
            accountService.transfer(accountBean.getFrom(), accountBean.getTo(), accountBean.getAmount());
            return new ResponseEntity<>("Transfer successful", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Transfer failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam int id, @RequestParam double amount) {
        try {
            accountService.deposit(id, amount);
            return new ResponseEntity<>("Deposit successful", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deposit failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountEntity> getAccount(@PathVariable int id) {
        try {
            AccountEntity account = accountService.getAccount(id);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
