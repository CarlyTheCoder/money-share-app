package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserAccount;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;

public class JdbcUserAccountDao implements UserAccountDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcUserAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserAccount getAccountBalance(Long userId) {
        BigDecimal balance = null;
        String sql = "SELECT * FROM accounts WHERE accounts.account_id = ?;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, userId);
        if (rows.next()){
            balance = mapRowToUserAccount(rows);
        }
        return balance;
    }

    @Override
    public UserAccount addToBalance() {
        return null;
    }

    @Override
    public UserAccount transferBalance() {
        return null;
    }

    private UserAccount mapRowToUserAccount(SqlRowSet rs) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(rs.getLong("account_id"));
        userAccount.setUserId(rs.getLong("user_id"));
        userAccount.setBalance(rs.getBigDecimal("balance"));
        return userAccount;
    }
}
