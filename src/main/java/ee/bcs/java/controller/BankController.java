package ee.bcs.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

public class BankController {
    Map<String, Integer> accounts = new HashMap<>();


    @GetMapping("bank/test")
    public String bankTest(String a, String b) {
        return "test";

    }

    @GetMapping("bank/createAccount")
    public String createAccount(String accountNr) {
        accounts.put(accountNr, 0);
        return "Account " + accountNr + " created";
    }

    @GetMapping("bank/accountBalance")
    public String getBalance(String accountNr) {
        Integer accountBalance = accounts.get(accountNr);
        return "Account balance " + accountBalance;
    }

    @GetMapping("bank/depositMoney")
    public String depositMoney(String accountNr, Integer amount) {
        if(amount<=0){
            return "Amount is lower than 0";
        }
        Integer balance = accounts.get(accountNr);
        Integer newBalance = balance + amount;
        accounts.put(accountNr, newBalance);
        return "Added " + amount + ", new balance is" + newBalance;
    }
}




// TODO 1
// Add command: "createAccount ${accountNr}"
// this has to store accountNr with 0 balance
// TODO 2
// Add command: "getBalance ${accountNr}"
// this has to display account balance of specific acount
// TODO 3
// Add command: "depositMoney ${accountNr} ${amount}
// this has to add specified amount of money to account
// You have to check that amount is positive number
// TODO 4
// Add command: "withdrawMoney ${accountNr} ${amount}
// This has to remove specified amount of money from account
// You have to check that amount is positive number
// You may not allow this transaction if account balance would become negative
// TODO 5
// Add command: "transfer ${fromAccount} ${toAccount} ${amount}
// This has to remove specified amount from fromAccount and add it to toAccount
// Your application needs to check that toAccount is positive
// And from account has enough money to do that transaction