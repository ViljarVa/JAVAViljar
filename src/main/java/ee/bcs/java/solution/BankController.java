package ee.bcs.java.solution;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {
    Map<String, Integer> accounts = new HashMap<>();
    // accounts.put("EE123", 123);
    // accounts.get("EE123");

    // http://localhost:8080/bank_solution/test
    @GetMapping("bank_solution/test")
    public String bankTest(){
        return "test";
    }

    // http://localhost:8080/bank_solution/test?a=midagi&b=midagimuud
    @GetMapping("bank_solution/test2")
    public String bankTest2(String a, String b){
        return "test";
    }

    // http://localhost:8080/bank_solution/createAccount?accountNr=EE123
    @GetMapping("bank_solution/createAccount")
    public String createAccount(String accountNr){
        accounts.put(accountNr, 0);
        return "Account " + accountNr + " created";
    }
    // accounts.put("EE123", 123);    -- kirjuta EE123 konto jöök üle
    // accounts.get("EE123");  -- kui suur on konto EE123 jääk

    // TODO 1
    // Add command: "createAccount ${accountNr}"
    // this has to store accountNr with 0 balance
    // TODO 2
    // Add command: "getBalance ${accountNr}"
    // this has to display account balance of specific acount
    // http://localhost:8080/bank/getBalance?accountNumber=EE123
    @GetMapping("bank_solution/getBalance")
    public String getBalance(String accountNumber){
        Integer balance = accounts.get(accountNumber);
        return "Konto jääk on: " + balance;
    }
    // TODO 3
    // Add command: "depositMoney ${accountNr} ${amount}
    // this has to add specified amount of money to account
    // You have to check that amount is positive number
    // http://localhost:8080/bank/deposit?accountNr=EE123&amount=12
    @GetMapping("bank_solution/deposit")
    public String depositMoney(String accountNr, Integer amount){
        if(amount <= 0){
            return "Kontole pandav raha peab olema suurem kui 0";
        }
        Integer balance = accounts.get(accountNr);
        Integer newBalance = balance + amount;
        accounts.put(accountNr, newBalance);
        return "Sa pandi kontole " + amount + " raha. Su jääk on " + newBalance;
    }
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

}
