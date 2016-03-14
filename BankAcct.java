
import java.text.*;
public class BankAcct
{
	public static void main (String[] arg)
	{


	float initialDeposit = 1000f;
	Account tinasAccount = new Account(initialDeposit);
	tinasAccount.deposit(100);
	tinasAccount.deposit(50);
	tinasAccount.withdraw(382.1f);
	NumberFormat nf = NumberFormat.getCurrencyInstance();
	System.out.println(nf.format(tinasAccount.getBalance()));
	}
}


class Account 
{
	private float balance;
	
	//constructor
	public Account(float d)
	{
	balance =d;
	}
	//contructor 
	public void deposit (float d)
	{
	balance = balance + d;
	}	
	//constructor 
	public void withdraw(float w)
	{
		if (w <= balance)
			balance = balance -w;
		else
			balance =0;
	}

	public float getBalance()
	{
		return balance;
	}	

}


