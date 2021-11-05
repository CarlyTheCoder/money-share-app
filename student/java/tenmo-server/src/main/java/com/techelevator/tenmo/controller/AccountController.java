package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.JdbcTransferDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/account")

public class AccountController {
    private AccountDao accountDao;
    private UserDao userDao;
    private TransferDao transferDao;

    public AccountController(AccountDao accountDao, UserDao userDao, TransferDao transferDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
        this.transferDao = transferDao;
    }

    @RequestMapping (path = "/username", method = RequestMethod.GET)
    public List<User> listOfUsernames() {return userDao.listOfUsernames();}

    @RequestMapping (path = "/balance", method = RequestMethod.GET)
    public BigDecimal getAccountBalance(Principal principal) {
        Long userId = userDao.findByUsername(principal.getName()).getId();
        return accountDao.getAccountBalance(userId);
    }

    @RequestMapping (path = "/transfer", method = RequestMethod.POST)
    public void sendTransfer(@RequestBody Transfer transfer) {
        transferDao.sendTransfer(transfer);
        accountDao.getAccountByUserId(transfer.getAccountFrom());
        //look up accountfrom from the details in the transfer
        transferDao.updateBalance((int) transfer.getAccountFrom(), accountDao.getAccountBalance(accountDao.getAccountByUserId(transfer.getAccountFrom())).subtract(transfer.getAmount()));

        accountDao.getAccountByUserId(transfer.getAccountTo());
        transferDao.updateBalance((int) transfer.getAccountTo(), accountDao.getAccountBalance(accountDao.getAccountByUserId(transfer.getAccountTo())).add(transfer.getAmount()));
    }
}
