package com.web.dao;

import com.web.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountDAO extends CrudRepository<Account, String> {
    Account findById(String id);
}
