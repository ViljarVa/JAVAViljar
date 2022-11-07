package ee.bcs.java.BankRepository;

import ee.bcs.java.controller.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void f1(String accountNumber) {
        String sql = "INSERT INTO bank_accounts (accounts_number, balance) VALUES  (:accountNumber, :amount)";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("amount", 0);
        jdbcTemplate.update(sql, paramMap);
    }

    public Integer f2(String accountNumber) {
        String sql = "SELECT balance FROM bank_accounts WHERE accounts_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        Integer balance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return balance;
    }

    public Integer f3(String accountNumber, Integer amount) {
        String sql2 = "SELECT balance FROM bank_accounts WHERE accounts_number = :accountNumber";
        Map paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNumber);
        Integer oldBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);
        return oldBalance;
    }

    public void f4(String accountNumber, Integer newBalance) {
        String sql = "UPDATE bank_accounts SET balance = :balance WHERE accounts_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", newBalance);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<AccountDto> getAllAccounts(){
        String sql = "SELECT * FROM bank_accounts";
        Map paramMap = new HashMap();
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(AccountDto.class));
    }

}

