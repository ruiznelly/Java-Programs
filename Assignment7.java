import java.util.*;

public class Assignment7 {
	public static void main(String[] args) {
		DolphinsFan john = new DolphinsFan ("john");
		DolphinsFan mike = new DolphinsFan ("mike");
		DolphinsFan ray = new DolphinsFan ("ray");
		DolphinsFan alice = new DolphinsFan ("alice");
		JetsFan steve = new JetsFan ("steve");

		SportsAlertsApp app = new SportsAlertsApp ();
		app.registerForAlerts (john);
		app.registerForAlerts (mike);
		app.registerForAlerts (ray);
		app.registerForAlerts (alice);
		app.registerForAlerts (steve);

		Scanner in = new Scanner (System.in);
		do {	
		for (int i=0;i<5; i++) {
			System.out.print ("\n\nWho scored? (d or j)" );
			if (in.next().equals("d"))
				app.sendOutAlert (Team.DOLPHINS);
			else
				app.sendOutAlert (Team.JETS);
		}
		
		}while(in.next()!= "d" && in.next() != "j");
	}
}

enum Team {DOLPHINS, JETS}

abstract class SportFan {
	String name;
	
	public abstract void reactToSportsAlert(Team t);
}

class DolphinsFan extends SportFan {
	public DolphinsFan(String n) {
		name = n;
	}
	
	public void reactToSportsAlert(Team t) {
		if(t == Team.DOLPHINS) {
			System.out.println(name + " cheers");
		}
		else {
			System.out.println(name + " groans");
		}
	}	
}

class JetsFan extends SportFan {
	public JetsFan(String n) {
		name = n;
	}
	
	public void reactToSportsAlert(Team t) {
		if(t == Team.JETS) {
			System.out.println(name + " cheers");
		}
		else {
			System.out.println(name + " groans");
		}
	}
}

class SportsAlertsApp {
	SportFan[] fans = new SportFan[5];
	int counter = 0;
	
	public void registerForAlerts(SportFan f){
		fans[counter++] = f;
	}
	
	public void sendOutAlert(Team t) {
		for(int i = 0; i < counter; i++) {
			fans[i].reactToSportsAlert(t);
		}
	}
}
