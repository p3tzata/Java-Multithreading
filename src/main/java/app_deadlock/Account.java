package app_deadlock;

public class Account {
	
	Integer balance=1000;

	public Integer getBalance() {
		return balance;
	}
	
	
	public void deposit(Integer amount) {
		this.balance+=amount;
	}
	
	public void withdraw(Integer amount) {
		this.balance-=amount;
	}
	
	public static void transffer(Account acc1,Account acc2, Integer amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
		
	}	
	

}
