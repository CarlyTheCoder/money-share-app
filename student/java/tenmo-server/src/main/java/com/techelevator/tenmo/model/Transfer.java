package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private int transferId;
    private int transferTypeId;
    private int transferStatusId;
    private long accountTo;
    private long accountFrom;
    private int userFromId;
    private int userToId;
    private BigDecimal amount;


    public Transfer(int transferId, int transferTypeId, int transferStatusId, long accountTo, long accountFrom, int userFromId, int userToId, BigDecimal amount) {
        this.transferId = transferId;
        this.transferTypeId = transferTypeId;
        this.transferStatusId = transferStatusId;
        this.accountTo = accountTo;
        this.accountFrom = accountFrom;
        this.amount = amount;
        this.userFromId = userFromId;
        this.userToId = userToId;
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

    public long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo() {
        this.accountTo = accountTo;
    }

    public long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom() {
        this.accountFrom = accountFrom;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getUserFromId() {
        return userFromId;
    }

    public int getUserToId() {
        return userToId;
    }
}
