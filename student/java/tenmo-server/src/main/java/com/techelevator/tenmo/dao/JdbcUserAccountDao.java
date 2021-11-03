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
    public BigDecimal getAccountBalance(Long userId) {
        BigDecimal balance = null;
        String sql = "SELECT * FROM accounts WHERE accounts.user_id = ?;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, userId);
        if (rows.next()){
            balance = rows.getBigDecimal("balance");
        }
        return balance;
    }

    /*@Override
    public BigDecimal addToBalance() {
        return null;
    }*/

    /*@Override
    public BigDecimal transferBalance() {
        return null;
    }*/

    private UserAccount mapRowToUserAccount(SqlRowSet rs) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(rs.getLong("account_id"));
        userAccount.setUserId(rs.getLong("user_id"));
        userAccount.setBalance(rs.getBigDecimal("balance"));
        return userAccount;
    }
}
