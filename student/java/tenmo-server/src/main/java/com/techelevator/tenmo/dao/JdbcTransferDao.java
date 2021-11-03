package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTransferDao implements TransferDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Transfer getTransfer(Long transferId) {
        return null;
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
    public Transfer createTransfer(Transfer transfer) {return null;}

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
