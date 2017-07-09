import java.io.Serializable;

        public class Account implements Serializable {
            private int accountId;
            private String name;
            private double balance;

                    public void setName(String name) {

                        this.name = name;
                }

                    public void setBalance(Double balance) {
                    this.balance = balance;
                }

                    public void setAccountId(int accountId) {
                    this.accountId = accountId;
                }

                    public int getAccountId() {
                    return accountId;
                }
            public String getName() {
                    return name;
                }
            public double getBalance() {
                    return balance;
                }
    }