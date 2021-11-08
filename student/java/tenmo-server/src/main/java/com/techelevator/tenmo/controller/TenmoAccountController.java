package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.JdbcTransferDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/account")

public class TenmoAccountController {

    @Autowired
    TransferDao transferDao;
    @Autowired
    AccountDao accountDao;
    @Autowired
    UserDao userDao;



    @RequestMapping (path = "/username", method = RequestMethod.GET)
    public List<User> listOfUsernames() {
        return userDao.listOfUsernames();
    }

    @RequestMapping (path = "/balance", method = RequestMethod.GET)
    public BigDecimal getAccountBalance(Principal principal) {
        Integer userId = userDao.findByUsername(principal.getName()).getId();
        return accountDao.getAccountBalance(userId);
    }
    /*TODO
    -
    - can't send more TE bucks than I have in my account: try/catch or if statement balance is > request amount
    - sending transfer has initial status of "approve": in JdbcTransferDao getStatus --> 2 and statusApproval --> true
     */

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping (path = "/transfer", method = RequestMethod.POST)
    public void sendTransfer(@RequestBody Transfer transfer) {

        int userFromId = transfer.getUserFromId();
        int accountFromId = accountDao.getAccountByUserId(userFromId);
        int userToId = transfer.getUserToId();
        int accountToId = accountDao.getAccountByUserId(userToId);
        BigDecimal moneyTo = accountDao.getAccountBalance(userFromId).subtract(transfer.getAmount());
        BigDecimal moneyFrom = accountDao.getAccountBalance(userToId).add(transfer.getAmount());
        transfer.setAccountFromId(accountFromId);
        transfer.setAccountToId(accountToId);
        transferDao.sendTransfer(transfer);
        transferDao.updateBalance(userFromId, moneyTo);
        transferDao.updateBalance(userToId, moneyFrom);
    }

    @RequestMapping (path = "/transfer/history/{userId}", method = RequestMethod.GET)
    public List<Transfer> getTransferActivityHistory(@PathVariable Long userId){
        return transferDao.getTransferActivityHistory(userId);
    }

    @RequestMapping (path = "/transfer/{transferId}", method = RequestMethod.GET)
    public Transfer getTransferDetails (@PathVariable int transferId){
        return transferDao.getTransferDetails(transferId);
    }

}
