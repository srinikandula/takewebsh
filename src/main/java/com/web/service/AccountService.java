package com.web.service;

import com.web.dao.AccountDAO;
import com.web.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by BusDa001 on 12/22/2015.
 */
@Service
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountDAO accountDAO;

    public Account createAccount(final String firstName, final String lastName){
        if(firstName == null || firstName.trim().length() == 0){
            throw new NullPointerException("First name is not valid");
        }
        if(lastName == null || lastName.trim().length() == 0){
            throw new NullPointerException("Last name is not valid");
        }
        Account account = new Account();
        account.setFirstName(firstName);
        account.setLastName(lastName);
        return accountDAO.save(account);
    }

}
