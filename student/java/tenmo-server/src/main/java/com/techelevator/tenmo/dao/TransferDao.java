package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {

    void sendTransfer(Transfer transfer);

    List<Transfer> getAllTransfers(Long userId);

    List<Transfer> getAllPendingTransfers(Long userId);

   // Transfer createTransfer(Transfer transfer);

    String getStatus(String status);

    Boolean checkApproval(boolean isRequestApproved);

    String selectUser(String toUsername);

    Transfer approveTransfer(boolean isRequestApproved, String username);

}
