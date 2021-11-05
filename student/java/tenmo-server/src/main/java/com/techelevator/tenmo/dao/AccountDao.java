package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.math.BigDecimal;

public interface AccountDao {

    BigDecimal getAccountBalance(Long userId);

    Long getAccountByUserId(Long userId);
    //get account by userId

    /*BigDecimal addToBalance();

    BigDecimal transferBalance();*/

}
