package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {
    private int accountFromId;
    private int accountToId;
    private int userFromId;
    private int userToId;
    private BigDecimal amount;
    private int transferId;
    private int transferTypeId;
    private int transferStatusId;

    public Transfer(int accountFromId, int accountToId, int userFromId, int userToId, BigDecimal amount, int transferId, int transferTypeId, int transferStatusId) {
        this.accountFromId = accountFromId;
        this.accountToId = accountToId;
        this.userFromId = userFromId;
        this.userToId = userToId;
        this.amount = amount;
        this.transferId = transferId;
        this.transferTypeId = transferTypeId;
        this.transferStatusId = transferStatusId;
    }

    public int getAccountFromId() {
        return accountFromId;
    }

    public void setAccountFromId(int accountFromId) {
        this.accountFromId = accountFromId;
    }

    public int getAccountToId() {
        return accountToId;
    }

    public void setAccountToId(int accountToId) {
        this.accountToId = accountToId;
    }

    public int getUserFromId() {
        return userFromId;
    }

    public void setUserFromId(int userFromId) {
        this.userFromId = userFromId;
    }

    public int getUserToId() {
        return userToId;
    }

    public void setUserToId(int userToId) {
        this.userToId = userToId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public int getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public int getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(int transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "accountFromId=" + accountFromId +
                ", accountToId=" + accountToId +
                ", userFromId=" + userFromId +
                ", userToId=" + userToId +
                ", amount=" + amount +
                ", transferId=" + transferId +
                ", transferTypeId=" + transferTypeId +
                ", transferStatusId=" + transferStatusId +
                '}';
    }
}
