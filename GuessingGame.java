import java.util.Random;
import java.util.Scanner;
public class GuessingGame
{
	public static void main (String[] args)
	{
		int userguess, secretnumber, counter;
		Random rand = new Random();
		if (args.length > 0) 
		{
			rand.setSeed(Long.valueOf(args[0]));
		}
        
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Guess My Number Game by O. Aghahowa");
		System.out.println();
		System.out.println("A secret number between 1-100 has been generated...");
		System.out.println("Enter guess 0 to quit.");
		System.out.println();
		
		secretnumber = rand.nextInt(100)+1;

		userguess=1;
		counter=0;

		while (userguess!=0 && userguess!=secretnumber)
		{
			System.out.print("Enter your guess? ");
			userguess= keyboard.nextInt();
			counter++;
			if (userguess > secretnumber) 
			{
				System.out.println("Guess is high, try again.");
			} 
			else if (userguess!=0 && userguess < secretnumber ) 
			{
				System.out.println("Guess is low, try again.");
			} 
			else if (userguess==secretnumber && counter!=0)
			{
				System.out.println();
				System.out.println("Correct in " + "#" + counter +  " guesses.");
			}
		}
		//Outside Loop
		if (userguess==secretnumber&&counter==1)
		{
			System.out.println();
			System.out.println("Congratulations, you got it in 1 guess!");
		}
		if (userguess==0)
		{
			System.out.println();
			System.out.println("The secret number is " + secretnumber + ".");
		}
	}
}

