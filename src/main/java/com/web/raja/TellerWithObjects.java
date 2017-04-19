import java.io.*;


public class TellerWithObjects {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int option = 0;
        do{
            System.out.println("1. Create Account");
            System.out.println("2. Find Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("0. Exit");
            System.out.println("please enter your option");
            option = Integer.parseInt(bufferedReader.readLine());
            switch (option) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    findBalance();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
            }
        }while(option != 0);
    }

    private static void deposit() throws IOException, ClassNotFoundException {

        FileOutputStream fos = null;
                try {
                        System.out.println("Please enter your account number");
                        int accountNumber = Integer.parseInt(bufferedReader.readLine());
                        File f = new File("accounts/"+accountNumber+".txt");
                        if(!f.exists()) {
                                System.err.print("Account not found");
                            } else {
                                System.out.println("Please enter Deposit amount");
                                double amount = Double.valueOf(bufferedReader.readLine());
                                Account accountRecord =  (Account)new ObjectInputStream(new FileInputStream(f)).readObject();
                                double balance = accountRecord.getBalance();
                                balance = amount + balance;
                                accountRecord.setBalance(balance);
                                System.out.println("Balance is "+ balance);
                                fos = new FileOutputStream(f);
                                ObjectOutputStream oos = new ObjectOutputStream(fos);
                                oos.writeObject(accountRecord);
                            }
                    } catch (NumberFormatException ex) {
                        System.out.println("Not a number !");
                    }catch (ClassNotFoundException exe) {
                        System.out.println("Class not found !");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if(fos != null) {
                                fos.close();
                            }
                    }
    }

    private static void withdraw() throws IOException, ClassNotFoundException {

        FileOutputStream fos = null;
        try {
            System.out.println("Please enter your account number");
            int accountNumber = Integer.parseInt(bufferedReader.readLine());
            File f = new File("accounts/"+accountNumber+".txt");
            if(!f.exists()) {
                System.err.print("Account not found");
            } else {
                System.out.println("Please enter Withdraw amount");
                double amount = Double.valueOf(bufferedReader.readLine());
                Account accountRecord =  (Account)new ObjectInputStream(new FileInputStream(f)).readObject();
                double balance = accountRecord.getBalance();
                balance =  balance - amount ;
                accountRecord.setBalance(balance);
                System.out.println("Balance is "+ balance);
                fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(accountRecord);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Not a number !");
        }catch (ClassNotFoundException exe) {
            System.out.println("Class not found !");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null) {
                fos.close();
            }
        }
    }

    private static void findBalance() throws IOException, ClassNotFoundException {
        System.out.println("Please enter your account number");

        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        File f = new File("accounts/"+accountNumber+".txt");
        if(!f.exists()) {
            System.err.print("Account not found");
        } else {
            Account accountRecord =  (Account)new ObjectInputStream(new FileInputStream(f)).readObject();
            System.out.println("Balance is "+ accountRecord.getBalance());
        }
    }

    private static void createAccount() throws IOException {
        FileOutputStream fos = null;
        try {
            Account account = new Account();
            System.out.println("Please enter name");
            account.setName(bufferedReader.readLine());
            System.out.println("Please enter deposit balance");
            account.setBalance(Double.valueOf(bufferedReader.readLine()));
            account.setAccountId((int)(Math.random()*10000)); //324234.53443

            File f = new File("accounts/"+account.getAccountId()+".txt");
            while(f.exists()) {
                account.setAccountId((int)(Math.random()*10000)); //324234.53443
                f = new File("accounts/"+account.getAccountId()+".txt");
            }
            fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(account);
            System.out.println("Account is created with number "+ account.getAccountId());

        } catch (NumberFormatException ex) {
            System.out.println("Not a number !");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null) {
                fos.close();
            }

        }
    }
}

