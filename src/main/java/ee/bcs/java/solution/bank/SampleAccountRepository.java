package ee.bcs.java.solution.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SampleAccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void f1(String accountNumber) {
        String sql = "INSERT INTO account (account_number, balance) VALUES (:accountNumber, :balance)";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", 0);
        jdbcTemplate.update(sql, paramMap);
    }

    public void updateBalance(String accountNumber, Integer newBalance){
        String sql = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", newBalance);
        jdbcTemplate.update(sql, paramMap);
    }

    public Integer getBalance(String accountNumber){
        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }
}
