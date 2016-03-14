import java.util.*;

public class HouseFootage 
{
	public static void main(String[] args)
	{
		String str, another ="y";
		float sqs, sum = 0f;
		int roomNum;
		Scanner scan = new Scanner(System.in);
		
		
		while (another.equalsIgnoreCase("y"))
		{
		  	System.out.println("Enter the total rooms in the house: ");
		  	roomNum = scan.nextInt();
		  	if (roomNum != 0)
		  	{
				for (int i =1; i <= roomNum; i++)
				{
				System.out.println("Enter sqs of room number " +i+ ":");
				sqs = scan.nextFloat();
				
				if (sqs < 0)
				System.out.println("You enter a negative number!!! Run the program again");
				else
				{
					sum += sqs;
					System.out.println("The footage of room number " +i+ " is: " +sum+ "sqs");
				}
				System.out.println("The total footage of the house is:" +sum);
			}
			   
		   	
		  	
			System.out.println("You enter 0");
			System.out.println("Do you what to messure another house?");
			another = scan.nextLine();
		   	
	       }
				
	}
}
	
	