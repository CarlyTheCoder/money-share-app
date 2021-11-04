package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

public interface AccountDao {

    BigDecimal getAccountBalance(Long userId);

    /*BigDecimal addToBalance();

    BigDecimal transferBalance();*/

}
