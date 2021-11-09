package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcTransferDao implements TransferDao {

    private JdbcTemplate jdbcTemplate;


    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    //methods and sql below used in tenmo controller

    @Override
    public void sendTransfer(Transfer transfer) {
        jdbcTemplate.execute("BEGIN TRANSACTION");

        String sql = "INSERT INTO transfers (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, transfer.getTransferTypeId(), transfer.getTransferStatusId(),
                transfer.getAccountFromId(), transfer.getAccountToId(), transfer.getAmount());
    }


      public void updateBalance (int userId, BigDecimal newBalance) {
          String sql = "UPDATE accounts SET balance = ? WHERE user_id = ?;";
          jdbcTemplate.update(sql, newBalance, userId);
      }

    @Override
    public List<Transfer> getTransferActivityHistory(Long userId) {
        List<Transfer> transferActivity = new ArrayList<>();
        String sql ="SELECT transfer_id, transfers.transfer_type_id, transfer_status_id, account_from, account_to, amount, " +
                "transfer_types.transfer_type_desc FROM transfers JOIN " +
                "transfer_types ON transfers.transfer_type_id = transfer_types.transfer_type_id WHERE " +
                "(transfers.account_from = ? OR transfers.account_to = ?) AND (transfer_types.transfer_type_id BETWEEN 1 AND 2);";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
        while(results.next()){
            Transfer transfer = mapRowtoTransfer(results);
            transferActivity.add(transfer);
        }
        return transferActivity;
    }


    @Override
    public List<Transfer> getAllTransfers(Long userId) {
        return null;
    }

    @Override
    public List<Transfer> getAllPendingTransfers(Long userId) {
        return null;
    }

    @Override
    public Transfer getTransferDetails(int transferId) {
        Transfer transferDetails = null;
        String sql = "SELECT * FROM transfers WHERE transfer_id = ?;";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql, transferId);
        if (results.next()) {
            transferDetails = mapRowtoTransfer(results);
        }
        return transferDetails;
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

    @Override
    public long getAccountTo() {
        return 0;
    }

    @Override
    public long getAccountFrom() {
        return 0;
    }

    private Transfer mapRowtoTransfer(SqlRowSet rowSet) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rowSet.getInt("transfer_id"));
        transfer.setTransferTypeId(rowSet.getInt("transfer_type_id"));
        transfer.setTransferStatusId(rowSet.getInt("transfer_status_id"));
        transfer.setAccountFromId(rowSet.getInt("account_from"));
        transfer.setAccountToId(rowSet.getInt("account_to"));
        transfer.setAmount(rowSet.getBigDecimal("amount"));
        return transfer;
    }
}

