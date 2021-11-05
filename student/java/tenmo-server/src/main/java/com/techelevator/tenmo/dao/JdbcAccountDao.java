package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BigDecimal getAccountBalance(Long userId) {
        BigDecimal balance = null;
        String sql = "SELECT * FROM accounts WHERE accounts.user_id = ?;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, userId);
        if (rows.next()){
            balance = rows.getBigDecimal("balance");
        }
        return balance;
    }

    @Override
    public Long getAccountByUserId(Long userId) {
        Long account = null;
        String sql = "SELECT accounts.account_id FROM accounts WHERE accounts.user_id = ?;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, userId);
        if (rows.next()) {
            account = rows.getLong("account_id");
        }
        return account;
    }

    private Account mapRowToUserAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setId(rs.getLong("account_id"));
        account.setUserId(rs.getLong("user_id"));
        account.setBalance(rs.getBigDecimal("balance"));
        return account;
    }
}
