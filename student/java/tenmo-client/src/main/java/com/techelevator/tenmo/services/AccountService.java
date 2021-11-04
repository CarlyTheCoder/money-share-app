package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class AccountService {
    private String API_BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser user;

    public AccountService(String API_BASE_URL) {
       this.API_BASE_URL = API_BASE_URL;
    }

    public Account getAccount() throws AccountServiceException {
       if (this.user == null) {
           throw new AccountServiceException ("No logged in user");
       }
       String path = this.API_BASE_URL + "account/user/" + user.getUser().getId();
        ResponseEntity<Account> response = restTemplate.exchange(path, HttpMethod.GET, makeAuthEntity(), Account.class);
        return response.getBody();
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(user.getToken);
        return new HttpEntity<>(headers);
    }
}
