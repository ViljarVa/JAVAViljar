package ee.bcs.java.solution.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SampleBankService {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private SampleAccountRepository accountRepository;


    public void createAccount(String accountNumber) {
        accountRepository.f1(accountNumber);
    }

    public Integer getAccountBalance(String accountNumber) {
        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        Integer balance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return balance;
    }

    public String depositMoney(String accountNumber, Integer amount) {
        if(amount <= 0){
            return "Sisestatud summa peab olema suurem kui 0";
        }
        Integer oldBalance = accountRepository.getBalance(accountNumber);
        Integer newBalance = oldBalance + amount;
        accountRepository.updateBalance(accountNumber, newBalance);
        return "Raha kontole lisatud";
    }
}
