import java.util.Random;
import java.util.*;
public class Donuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Filling Filling = randomDount();
		System.out.println(Filling);
	}
	enum Filling{Creame, Strawberry, Grape, Apple, Cinamon, Blueberry, Banana}  
	static public Filling randomDount() {
    
	int pick = new Random().nextInt(Filling.values().length);
	System.out.print(Filling.values().length);
	System.out.print(pick);
	
    return Filling.values()[pick];
    
	}
}






		
