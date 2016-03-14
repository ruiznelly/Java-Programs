//**************************************************************************
//Score.java	Programer:Nelly Ruiz
//This progarm calculates the fisrt frame score of bowling,
//generating ramdom numbers.
//***************************************************************************

import java.util.Random;

public class Score
{
	public static void main (String[] args)
	{
		Random generator = new Random();
		int roll1, roll2, roll3, score;
		
		roll1 = generator.nextInt(11);
		System.out.println("first: " +roll1);

		if (roll1 == 10)
		{
			roll2 = generator.nextInt(11); 
			System.out.println("second: " +roll2);	
			
			if (roll2 == 10)
			{
				roll3 = generator.nextInt(11); 
				System.out.println("third: " +roll3);


				if (roll3 == 10)
				{
					score = roll1 +roll2 + roll3; 
					System.out.println("Score is: " +score);
				}

				
			}

			else
			{
				score = roll1 + roll2;
				System.out.println("Score is: " +score);
			}
			
		}
		else 
		{
			roll2 = generator.nextInt(11-roll1); 
			System.out.println("second: " +roll2);	
			score = roll1 + roll2;
			
			if (score == 10)
			{
				roll3 = generator.nextInt(11); 
				System.out.println("third: " +roll3);
				score +=  roll3; 
				
			}
 			
			System.out.println("Score is: " +score);
						
		}
	}
		

		
}

