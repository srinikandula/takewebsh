package com.web.dao;

import com.web.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountDAO extends CrudRepository<Account, String> {
    Account findById(String id);
    Account findById(Long id);
    Iterable<Account> findByFirstNameAndLastName(String firstName, String lastName);

   // @Query("delete from Account a where a.id = ?1")
    void deleteById(Long i);

    Iterable<Account> findByFirstName(String fName);

}
