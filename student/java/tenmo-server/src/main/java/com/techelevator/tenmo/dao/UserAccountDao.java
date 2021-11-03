package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.UserAccount;

import java.math.BigDecimal;

public interface UserAccountDao {

    UserAccount getAccountBalance(Long userId);

    UserAccount addToBalance();

    UserAccount transferBalance();

}
