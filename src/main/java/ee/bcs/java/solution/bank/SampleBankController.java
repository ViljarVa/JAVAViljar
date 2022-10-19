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

    @Autowired
    private SampleBankService bankService;

    // http://localhost:8080/sample/bank/createAccount?accountNumber=EE124
    @GetMapping("sample/bank/createAccount")
    public void createAccount(String accountNumber){
        bankService.createAccount(accountNumber);
    }

    // http://localhost:8080/sample/bank/getAccountBalance?accountNumber=EE123
    @GetMapping("sample/bank/getAccountBalance")
    public Integer getAccountBalance(String accountNumber){
        return bankService.getAccountBalance(accountNumber);
    }

    // http://localhost:8080/sample/bank/depositMoney?accountNumber=EE123&amount=10
    @GetMapping("sample/bank/depositMoney")
    public String depositMoney(String accountNumber, Integer amount){
        return bankService.depositMoney(accountNumber, amount);
    }

    // http://localhost:8080/sample/bank/withdrawMoney?accountNumber=EE123&amount=5
    @GetMapping("sample/bank/withdrawMoney")
    public String withdrawMoney(String accountNumber, Integer amount){
        if(amount <= 0){
            return "Sisestatud summa peab olema suurem kui 0";
        }
        String sql2 = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNumber);
        Integer oldBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);
        if(oldBalance < amount){
            return "Kontol pole piisavalt raha";
        }
        Integer newBalance = oldBalance - amount;

        String sql = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", newBalance);
        jdbcTemplate.update(sql, paramMap);
        return "Tehing tehtud";
    }

    // http://localhost:8080/sample/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=1
     @GetMapping("sample/bank/transferMoney")
    public String transferMoney(String fromAccount, String toAccount, Integer amount){
        if(amount <= 0){
            return "Sisestatud summa peab olema suurem kui 0";
        }
        String sql1 = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap1 = new HashMap();
        paramMap1.put("accountNumber", fromAccount);
        Integer fromAccountCurrentBalance = jdbcTemplate.queryForObject(sql1, paramMap1, Integer.class);
        if(fromAccountCurrentBalance < amount){
            return "Kontol pole piisavalt raha";
        }
         String sql2 = "SELECT balance FROM account WHERE account_number = :accountNumber";
         Map paramMap2 = new HashMap();
         paramMap2.put("accountNumber", toAccount);
         Integer toAccountCurrentBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);

         Integer fromAccountNewBalance = fromAccountCurrentBalance - amount;
         Integer toAccountNewBalance = toAccountCurrentBalance + amount;

         String sql3 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
         Map paramMap3 = new HashMap();
         paramMap3.put("accountNumber", fromAccount);
         paramMap3.put("balance", fromAccountNewBalance);
         jdbcTemplate.update(sql3, paramMap3);

         String sql4 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
         Map paramMap4 = new HashMap();
         paramMap4.put("accountNumber", toAccount);
         paramMap4.put("balance", toAccountNewBalance);
         jdbcTemplate.update(sql4, paramMap4);
         return "Ülekanne tehtud";
     }

}
