package com.web.service;


import com.web.dao.AccountDAO;
import com.web.service.AccountService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.*;

/**
 * Created by skandula on 4/4/16.
 */
public class AccountServiceTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testSaveAccountWithNoFirstName() throws Exception {
        AccountService accountService = new AccountService();
        String id = "123";
        String firstName = null;
        String lastName = "lName";
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Invalid data for firstname");
        accountService.updateAccount(id, firstName, lastName);
    }

    @Test
    public void testUpdateAccountWithInvalidId() throws Exception {
        AccountService accountService = new AccountService();
        String id = "123";
        String firstName = "Foo";
        String lastName = "lName";
        AccountDAO accountDAO = mock(AccountDAO.class);
        when(accountDAO.findById("123")).thenThrow(NullPointerException.class);
        accountService.setAccountDAO(accountDAO);
        expectedEx.expect(NullPointerException.class);
        accountService.updateAccount(id, firstName, lastName);
    }
}