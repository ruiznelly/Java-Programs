//******************************************************************************
// Payroll.java 
// This program calculates the payroll for 3 employess. Where those thatn worked 
// more than 40 hours will be paid 1.5 time as the regular base salary
//******************************************************************************

import java.text.NumberFormat;
import java.util.Scanner;

public class Payroll
{
	public static void main (String[] args)
	{
		final int NumEmployees = 3; //Total numner of Employees
		final int Standard = 40;
		Scanner scan = new Scanner(System.in);

		double pay = 0.0; //variable for total paid
		
		for (int i = 1; i <= NumEmployees; i++)
		{
		

		System.out.print("Enter hourly rate for Employee " + i + ":");
		double rate  = scan.nextDouble();
	
		System.out.print("Enter hours worked for Employee " + i + ":");
		double hours = scan.nextDouble();
		
			if (hours > Standard)
				pay = Standard * rate + (hours-Standard) * (rate *1.5);
 			else
				pay = hours * rate;

		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		System.out.println("Pay for Employee" + i + " is: " +fmt.format(pay));
		}
	}
}