package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.math.BigDecimal;

public interface AccountDao {

    BigDecimal getAccountBalance(int userId);

    Integer getAccountByUserId(int userId);


    //get account by userId

    /*BigDecimal addToBalance();

    BigDecimal transferBalance();*/

}
