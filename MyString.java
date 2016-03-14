import java.util.*;
public class MyString
{
	public static void main (String[] arg)
	{
		String s ="Hello";
		System.out.println(s.length());
		
		for (int i=0; i<s.length(); ++i)
		{
		char c = s.charAt(i);
		System.out.println(c);
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String s2 = in.next();
		switch(s2)
		{
		case "bill": System.out.println("Its bill");
			     break;
		case "tom": System.out.println("Its tom");
			    break;
		default: System.out.println("Its somebody else");
		
		}
	}
}