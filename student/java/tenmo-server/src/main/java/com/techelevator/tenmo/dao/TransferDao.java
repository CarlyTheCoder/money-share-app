package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {

    Transfer getTransfer(Long transferId);

    List<Transfer> getAllTransfers(Long userId);

    List<Transfer> getAllPendingTransfers(Long userId);

    Transfer createTransfer(Transfer transfer);

    Transfer getStatus(String status);

    Transfer checkApproval(boolean isRequestApproved);

    Transfer selectUser(String toUsername);

    Transfer approveTransfer(boolean isRequestApproved, String username);

}
