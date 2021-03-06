package com.web.HarshaJava;

/**
 * Created by sriharshakota on 7/8/17.
 */
public class Account {
    private int accountId;
    private String name;
    private double balance;
    private transient long ssn;

    public void setName(String name) { this.name = name; }

    public void setBalance(Double balance) { this.balance = balance; }

    public void setAccountId(int accountId){ this.accountId = accountId; }

    public void setSsn(long ssn) { this.ssn = ssn; }

    public int getAccountId() {
        return accountId;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public long getSsn(){return ssn;}
}
