package Bankapplication;

public class Teller extends Accounts {
	
 
	    Teller(int id, String name, double balance) {
		 super(id, name, balance);
	    }
	    
	
		public double deposit(double amount){
		double balance1= balance+amount;
			System.out.println("After Desposit="  +balance1);
			return balance1;
	
		}
		public double withdraw(double amount){
			double balance2= balance-amount;
				System.out.println("After Withdraw="  +balance2);
				return balance2;
		}
	

	public static void main(String[] args) {
		
		Teller t=new Teller(111, "john", 2000.00);
		t.deposit(500.0);
		t.withdraw(150.0);

	}	}


