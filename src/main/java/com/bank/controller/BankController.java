package com.bank.controller;

import com.bank.model.Account;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bank")
public class BankController {

    Map<Integer, Account> accounts = new HashMap<>();

    @PostMapping("/create")
    public String createAccount(@RequestBody Account account) {
        accounts.put(account.getAccountNumber(), account);
        return "Account Created Successfully";
    }

    @GetMapping("/balance/{accNo}")
    public double checkBalance(@PathVariable int accNo) {
        return accounts.get(accNo).getBalance();
    }

    @PostMapping("/deposit/{accNo}/{amount}")
    public String deposit(@PathVariable int accNo, @PathVariable double amount) {
        Account acc = accounts.get(accNo);
        acc.setBalance(acc.getBalance() + amount);
        return "Amount Deposited";
    }

    @PostMapping("/withdraw/{accNo}/{amount}")
    public String withdraw(@PathVariable int accNo, @PathVariable double amount) {
        Account acc = accounts.get(accNo);
        acc.setBalance(acc.getBalance() - amount);
        return "Amount Withdrawn";
    }
}