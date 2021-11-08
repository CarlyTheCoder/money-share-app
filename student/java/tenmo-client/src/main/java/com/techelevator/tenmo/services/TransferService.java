package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.web.client.RestTemplate;

public class TransferService {
    private String API_BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser user;

    public TransferService(String API_BASE_URL) {
        this.API_BASE_URL = API_BASE_URL;
    }

    /*public showUsernames(){

    }*/

    /*public Transfer sendTransfer() {
        Transfer transfer = restTemplate.getForObject(API_BASE_URL + "/transfer/", )
    }*/
}
