package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {

    void sendTransfer(Transfer transfer);

    void updateBalance (int userId, BigDecimal newBalance);


    List<Transfer> getAllTransfers(Long userId);

    List<Transfer> getAllPendingTransfers(Long userId);

    List<Transfer> getTransferActivityHistory(Long transferId);

    Transfer getTransferDetails(int transferId);

   // Transfer createTransfer(Transfer transfer);

    String getStatus(String status);

    Boolean checkApproval(boolean isRequestApproved);

    String selectUser(String toUsername);

    Transfer approveTransfer(boolean isRequestApproved, String username);

    long getAccountTo();

    long getAccountFrom();

}
