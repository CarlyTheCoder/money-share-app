package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.UserAccount;

import java.math.BigDecimal;

public interface UserAccountDao {

    BigDecimal getAccountBalance(Long userId);

    /*BigDecimal addToBalance();

    BigDecimal transferBalance();*/

}
