package ee.bcs.java.solution.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleBankController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/sample/bank/createAccount?accountNumber=EE253
    @GetMapping("sample/bank/createAccount")
    public void createAccount(String accountNumber){
        String sql = "INSERT INTO account (account_number, balance) VALUES (:accountNumber, :amount)";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("amount", 0);
        jdbcTemplate.update(sql, paramMap);
    }

    // http://localhost:8080/sample/bank/getAccountBalance?accountNumber=EE123
    @GetMapping("sample/bank/getAccountBalance")
    public Integer getAccountBalance(String accountNumber){
        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        Integer balance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return balance;
    }

    // http://localhost:8080/sample/bank/depositMoney?accountNumber=EE123&amount=10
    @GetMapping("sample/bank/depositMoney")
    public void depositMoney(String accountNumber, Integer amount){
        String sql2 = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNumber);
        Integer oldBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);

        Integer newBalance = oldBalance + amount;

        String sql = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", newBalance);
        jdbcTemplate.update(sql, paramMap);
    }

    public void withdrawMoney(String accountNumber, Integer amount){

    }

    public void transferMoney(String fromAccount, String toAccount, Integer amount){

    }

}
