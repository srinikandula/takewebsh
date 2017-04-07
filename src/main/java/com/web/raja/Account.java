/**
 * Created by HOME on 4/7/2017.
 */
public class Account implements AccountInterface {
    private double balance;

    public double getBalance(){

        return balance;
    }


    public void setBalance(double amount) {
        this.balance = amount;
    }
}
