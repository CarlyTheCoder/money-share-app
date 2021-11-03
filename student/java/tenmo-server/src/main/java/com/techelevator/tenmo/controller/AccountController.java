package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserAccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.UserAccount;
import com.techelevator.tenmo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")

public class AccountController {
    private UserAccountDao userAccountDao;
    private UserDao userDao;
    private TransferDao transferDao;

    public AccountController(UserAccountDao userAccountDao, UserDao userDao, TransferDao transferDao) {
        this.userAccountDao = userAccountDao;
        this.userDao = userDao;
        this.transferDao = transferDao;
    }

    public AccountController() {
    }

    @RequestMapping (path = "/users/username", method = RequestMethod.GET)
    public List<User> listOfUsernames() {return userDao.listOfUsernames();}
}
