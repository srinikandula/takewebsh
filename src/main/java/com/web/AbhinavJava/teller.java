class teller extends account{
   account acc = new account();
    int accId = acc.getId();
    String na = acc.getName();
    double bala = acc.getBalance();
    
    public double deposit(double amo){
        bala = bala+amo;
        return bala;
    }
    public double withdraw(double amo){
        bala = bala-amo;
        return bala;
    }
}