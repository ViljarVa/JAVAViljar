package ee.bcs.java.BankService;

import ee.bcs.java.BankRepository.AccountRepository;
import ee.bcs.java.controller.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepository accountRepository;

    public void createAccount(String accountNumber) {
        accountRepository.f1(accountNumber);
    }

    public Integer getAccountBalance(String accountNumber) {
        return accountRepository.f2(accountNumber);

    }


    public void depositMoney(String accountNumber, Integer amount) {
        Integer oldBalance = accountRepository.f3(accountNumber, amount);
        Integer newBalance = oldBalance + amount;
        accountRepository.f4(accountNumber, newBalance);
    }



    public String withdrawMoney(String accountNumber, Integer amount) {
        String sql3 = "SELECT balance FROM bank_accounts WHERE account_number = :accountNumber";
        Map paramMap3 = new HashMap();
        paramMap3.put("accountNumber", accountNumber);
        Integer oldBalance = jdbcTemplate.queryForObject(sql3, paramMap3, Integer.class);
        Integer newBalance = oldBalance - amount;
        if (oldBalance <= amount) {
            return "Not enough funds to withdraw money";
        }
        if (amount <= 0) {
            return "Amount too low";
        }
        String sql = "UPDATE bank_accounts SET balance = :balance WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", newBalance);
        jdbcTemplate.update(sql, paramMap);
        return "Transaction complete";
    }

    public String transferMoney(String fromAccount, String toAccount, Integer amount) {
        if (amount <= 0) {
            return "Summa peab olema suurem kui 0";
        }
        String sql4 = "SELECT balance FROM bank_accounts WHERE accounts_number = :accountNumber";
        Map paramMap4 = new HashMap();
        paramMap4.put("accountNumber", fromAccount);
        Integer fromAccountCurrentBalance = jdbcTemplate.queryForObject(sql4, paramMap4, Integer.class);
        if (fromAccountCurrentBalance < amount) {
            return "Pole piisavalt vahendeid";
        }
        String sql5 = "SELECT balance FROM bank_accounts WHERE accounts_number = :accountNumber";
        Map paramMap5 = new HashMap();
        paramMap5.put("accountNumber", toAccount);
        Integer toAccountCurrentBalance = jdbcTemplate.queryForObject(sql5, paramMap5, Integer.class);

        Integer fromAccountNewBalance = fromAccountCurrentBalance - amount;
        Integer toAccountNewBalance = toAccountCurrentBalance + amount;

        String sql6 = "UPDATE bank_accounts SET balance = :balance WHERE accounts_number = :accountNumber";
        Map paramMap6 = new HashMap();
        paramMap6.put("accountNumber", fromAccount);
        paramMap6.put("balance", fromAccountNewBalance);
        jdbcTemplate.update(sql6, paramMap6);

        String sql7 = "UPDATE bank_accounts SET balance = :balance WHERE accounts_number = :accountNumber";
        Map paramMap7 = new HashMap();
        paramMap7.put("accountNumber", toAccount);
        paramMap7.put("balance", toAccountNewBalance);
        jdbcTemplate.update(sql7, paramMap7);
        return "Ülekanne tehtud";


    }

    public List<AccountDto> getAllAccounts(){
        return accountRepository.getAllAccounts();
    }

}
