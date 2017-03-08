package com.web.controller;

import com.web.controller.util.ControllerUtils;
import com.web.dao.AccountDAO;
import com.web.model.Account;
import com.web.service.AccountService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

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

    @RequestMapping(value = "/list", method = { RequestMethod.GET }, produces = ControllerUtils.JSON_UTF8)
    public Iterable<Account> getAccounts(final HttpServletRequest request) throws Exception {
        return accountDAO.findAll();
    }

    @RequestMapping(value = "/create", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN)
    public String createAccount(final HttpServletRequest request, @RequestParam(name = "fName") String firstName,
                                @RequestParam(name = "lName") String lastName,
                                @RequestParam(name = "balance") String balance) throws Exception {
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

    @RequestMapping(value = "/{id}", method = { RequestMethod.GET }, produces = ControllerUtils.JSON_UTF8)
    public Account getAccount(final HttpServletRequest request, @PathVariable String id) throws Exception {
        Account account = accountDAO.findById(new Long(id));
        return account;
    }

    @RequestMapping(value = "/update/{id}", method = { RequestMethod.PUT }, produces = MediaType.TEXT_PLAIN)
    public String updateAccount(final HttpServletRequest request, @PathVariable String id,
                                @RequestParam(name = "firstName") String firstName,
                                @RequestParam(name = "lastName") String lastName,
                                @RequestParam(name = "balance") String balance) throws Exception {
        accountService.updateAccount(id, firstName, lastName, Long.parseLong(balance));
        return "Account updated successfully";
    }

    @RequestMapping(value = "/delete", method = { RequestMethod.DELETE }, produces = MediaType.TEXT_PLAIN)
    public String deleteAccount(final HttpServletRequest request, @RequestParam(name = "id") String id ) throws Exception {
        Account account = accountDAO.findById(new Long(id));
        accountDAO.delete(account);
        return "Account deleted successfully";
    }


    @RequestMapping(value = "/hasFirstNameUsed", method = { RequestMethod.GET } , produces = MediaType.TEXT_PLAIN)
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
