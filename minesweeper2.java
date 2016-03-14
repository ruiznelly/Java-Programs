//**************************************************************************
//Score.java	Programer:Nelly Ruiz
//This program simulates the Minesweeper game using arrays.
//***************************************************************************

import java.util.Random;
import java.util.Scanner;

public class minesweeper2
{
	static int y=0;
	static int x = 0;	
	static int key;
	static int size;
	static int Limit = 12;
	static boolean gameOver = false;
	
	public static void main (String[] args)
	{
		
		
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the board size between 3-12: ");
		size = scan.nextInt();
		
		if (size >= 3 && size <= Limit)
		{
			char [][] table = new char[size][size];
			
			System.out.println();
			
			for(int row = 0; row < size; row++){
				for (int col = 0; col < size; col++){	
					table [row][col]= '_';
				}
			}
			table[0][0] = 'P';
			MyBomb(size, table);
			do
			{
				//print table
				printBoard(table);
				do
				{
				System.out.print("Press (1) to move down, (2) to move to the right or (3) to exit");
				key = scan.nextInt();
			
				}while(key < 1 || key > 3);
				
				Move(key, table);
			}while(gameOver==false);
		}
		else {
			System.out.println("you enter a game board size less than 3X3");
		}

	}
	
//Functions
	static public void printBoard(char[][] Myboard) 
	{
		for(int row = 0; row < Myboard.length; row++)
		{
			for (int col = 0; col < Myboard[row].length; col++)
					
			System.out.print(Myboard[row][col] + " ");
			System.out.println();
		}
		if (Myboard[size-1][size-1]=='P'){
			System.out.print("You Won!!!");
			gameOver = true;
		}
		
	}

	static public void MyBomb(int ArrSize, char[][] MyArr)
	{
		
		Random ran = new Random();
		int x=0;
		int y=0;
	
			for(int i=0;i<ArrSize-2;i++){
				x = ran.nextInt(ArrSize);
				y = ran.nextInt(ArrSize);
				
				checkStartEnd(MyArr);
				checkPrevExist(i,MyArr);
				MyArr[x][y] = 'B';
		
			}
	}

	static public void Move(int move, char[][]MyGame)
	{
	
		switch(move)
		{
			case 1:
				if (MyGame[x+1][y]=='B'){
					System.out.print("BOOM!! You Lose.");
					gameOver=true;
				}
				else{
					x++;
					MyGame[x][y] = 'P';
					MyGame[x-1][y] = '_';
				
				}
			break;
			case 2:
				if (MyGame[x][y+1]=='B'){
					System.out.print("BOOM!! You Lose.");
					gameOver=true;
				}
				else{
					y++;
					MyGame[x][y] = 'P';
					MyGame[x][y-1] = '_';
				}
			break;
			default:
			System.out.println("Wrong key. Try again");
			
		}
	}

	static public boolean checkStartEnd (char[][] arr) {
		int[] start= new int[]{0,0};
		int[] end=new int[]{size,size};
		
		if(arr.equals(start) || arr.equals(end)) {
			return false;	
		}
		else {
			return true;
		}
	}	

	static public boolean checkPrevExist (int pos, char[][] arr) {
		for(int i=0;i<pos;i++){
			if(arr[pos].equals(arr[i])){
				return false;
			}			
		}
		return true;
	}	
}




		
				

