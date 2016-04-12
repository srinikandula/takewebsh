package com.web.controller;

import com.web.dao.AccountDAO;
import com.web.model.Account;
import com.web.service.AccountService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by BusDa001 on 12/22/2015.
 */
@Api(value = "Account Controller")
@RestController
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired(required = true)
    private AccountService accountService;

    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value = "/accountsList", method = { RequestMethod.GET })
    public ModelAndView getAccounts(final HttpServletRequest request) throws Exception {
        return gotoAccountListpage();
    }

    private ModelAndView gotoAccountListpage() {
        ModelAndView modelAndView = new ModelAndView("accountsList");
        modelAndView.addObject("accounts", accountDAO.findAll());
        modelAndView.addObject("employees", accountDAO.findAll());

        return modelAndView;
    }

    @RequestMapping(value = "/account", method = { RequestMethod.POST })
    public ModelAndView createAccount(final HttpServletRequest request) throws Exception {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Account account = new Account();
        account.setFirstName(firstName);
        account.setLastName(lastName);
        accountDAO.save(account);
        return gotoAccountListpage();
    }


    @RequestMapping(value = "/updateAccount", method = { RequestMethod.PUT })
    public ModelAndView updateAccount(final HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        accountService.updateAccount(id, firstName, lastName);
        return gotoAccountListpage();
    }



    @RequestMapping(value = "/test", method = { RequestMethod.GET })

    public String test(final HttpServletRequest request) {
        return "helloWorld";
    }
    @RequestMapping(value = "/testMVC", method = { RequestMethod.GET })
    public ModelAndView testMVC(final HttpServletRequest request) {
        return new ModelAndView("helloWorld");
    }


}
