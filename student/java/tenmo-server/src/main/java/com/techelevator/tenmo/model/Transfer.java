package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private Long transferId;
    private String username;
    private Long userId;
    private String status;
    private boolean isRequestApproved = false;
    private BigDecimal transferAmount;

    public Transfer(Long transferId, String username, Long userId,
                    String status, boolean isRequestApproved, BigDecimal transferAmount) {
        this.transferId = transferId;
        this.username = username;
        this.userId = userId;
        this.status = status;
        this.isRequestApproved = isRequestApproved;
        this.transferAmount = transferAmount;
    }

    public Transfer() {
    }

    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isRequestApproved() {
        return isRequestApproved;
    }

    public void setRequestApproved(boolean requestApproved) {
        isRequestApproved = requestApproved;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }
}
