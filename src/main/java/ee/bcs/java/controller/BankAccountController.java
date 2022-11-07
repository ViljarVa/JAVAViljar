package ee.bcs.java.controller;

import ee.bcs.java.BankService.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankAccountController {


    @Autowired
    private BankService bankService;

    // http://localhost:8080/bank/createAccount?accountNumber=EE555
    @GetMapping("bank/createAccount")
    public void createAccount(String accountNumber) {
        bankService.createAccount(accountNumber);

    }

    // http://localhost:8080/bank/getAccountBalance?accountNumber=EE123
    @GetMapping("bank/getAccountBalance")
    public Integer getAccountBalance(String accountNumber) {
        return bankService.getAccountBalance(accountNumber);
    }

    // http://localhost:8080/bank/depositMoney?accountNumber=EE123&amount=10
    @GetMapping("bank/depositMoney")
    public void depositMoney(String accountNumber, Integer amount) {
        bankService.depositMoney(accountNumber, amount);
    }

    // http://localhost:8080/bank/withdrawMoney?accountNumber=EE123&amount=10
    @GetMapping("bank/withdrawMoney")
    public String withdrawMoney(String accountNumber, Integer amount) {
        return bankService.withdrawMoney(accountNumber, amount);
    }

    // http://localhost:8080/bank/transferMoney?fromAccount=EE123&toAccount=EE555&amount=10
    @GetMapping("bank/transferMoney")
    public String transferMoney(String fromAccount, String toAccount, Integer amount) {
        return bankService.transferMoney(fromAccount, toAccount, amount);

    }

    // http://localhost:8080/bank/allAccounts
    @GetMapping("bank/allAccounts")
    public List<AccountDto> getAllAccounts() {return bankService.getAllAccounts();}

}
