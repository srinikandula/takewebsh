package com.web.controller;

import com.web.dao.AccountDAO;
import com.web.model.Account;
import com.web.service.AccountService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by BusDa001 on 12/22/2015.
 */
@Api(value = "Account Controller")
@RequestMapping(value = "/api/account")
@RestController
public class AccountRestController {
    private static final Logger logger = LoggerFactory.getLogger(AccountRestController.class);

    @Autowired(required = true)
    private AccountService accountService;

    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value = "/list", method = { RequestMethod.GET })
    public Iterable<Account> getAccounts(final HttpServletRequest request) throws Exception {
        return accountDAO.findAll();
    }

    @RequestMapping(value = "/create", method = { RequestMethod.POST })
    public String createAccount(final HttpServletRequest request) throws Exception {
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String balance = request.getParameter("balance");
        Iterable<Account> accounts = accountDAO.findByFirstNameAndLastName(firstName, lastName);
        if(accounts.iterator().hasNext()) {
            throw new RuntimeException("Account with same names found");
        }
        Account account = new Account();
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setBalance(Long.parseLong(balance));
        accountDAO.save(account);
        return "Account created successfully";
    }

    @RequestMapping(value = "/{id}", method = { RequestMethod.GET })
    public String getAccount(final HttpServletRequest request) throws Exception {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Account account = new Account();
        account.setFirstName(firstName);
        account.setLastName(lastName);
        accountDAO.save(account);
        return "Account created successfully";
    }

    @RequestMapping(value = "/update/{id}", method = { RequestMethod.PUT })
    public String updateAccount(final HttpServletRequest request, @PathVariable String id) throws Exception {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        accountService.updateAccount(id, firstName, lastName);
        return "Account updated successfully";
    }

    @RequestMapping(value = "/delete", method = { RequestMethod.DELETE })
    public String updateAccount(final HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        Account account = accountDAO.findById(new Long(id));
        accountDAO.delete(account);
        return "Account deleted successfully";
    }


    @RequestMapping(value = "/hasFirstNameUsed", method = { RequestMethod.GET })
    public boolean findAccountByFirstName(final HttpServletRequest request) throws Exception {
        String fName = request.getParameter("fNmae");
        Iterable<Account> accounts = accountDAO.findByFirstName(fName);
        if(accounts != null && accounts.iterator().hasNext()) {
            return true;
        }else {
            return false;
        }
    }

}
