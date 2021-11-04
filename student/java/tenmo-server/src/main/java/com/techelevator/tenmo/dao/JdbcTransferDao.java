package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
@Component
public class JdbcTransferDao implements TransferDao {

    private JdbcTemplate jdbcTemplate;


    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public void sendTransfer(Transfer transfer) {
        jdbcTemplate.execute("BEGIN TRANSACTION");
        String sql = "INSERT INTO transfers (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "VALUES (DEFAULT, ?, 1, ?, ?, ?;)";
        jdbcTemplate.update(sql, transfer.getTransferId(), transfer.getTransferTypeId(), transfer.getTransferStatusId(),
                transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
    }


      public void updateBalance (int userId, BigDecimal newBalance) {
          String sql = "UPDATE accounts SET balance = ? WHERE user_id = ?;";
          jdbcTemplate.update(sql, newBalance, userId);
      }



    @Override
    public List<Transfer> getAllTransfers(Long userId) {
        return null;
    }

    @Override
    public List<Transfer> getAllPendingTransfers(Long userId) {
        return null;
    }

    //@Override
   // public Transfer createTransfer(Transfer transfer) {return null;}

    @Override
    public String getStatus(String status) {
        return null;
    }

    @Override
    public Boolean checkApproval(boolean isRequestApproved) {
        return null;
    }

    @Override
    public String selectUser(String toUsername) {
        return null;
    }

    @Override
    public Transfer approveTransfer(boolean isRequestApproved, String username) {
        return null;
    }
}
