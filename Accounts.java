package Bankapplication;

public class Accounts {
	int id;
	String name;
	double balance;
	
	Accounts(int id,String name,double balance)
	{
		this.id=id;
		this.name=name;
		this.balance=balance;
		System.out.println("id= " +id + " name= " +name + " balance= " +balance);
		
	}
	   public static void main(String[] args) {
		
		   Accounts a=new Accounts(111, "john", 2000.00);
	}
		
	}
	
	


