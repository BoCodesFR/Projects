// This program will roll a dice 6 100 times and count how many times it landed on 1 and 6.
import java.util.Random;
public class DiceCube
{
	public static void main (String [] args)
	{
		int rand, dice6count, dice1count, counter;

		Random diceroll = new Random();

		counter=0;
		dice6count=0;
		dice1count=0;
		
		
		while(counter<=100)
		{
			rand=diceroll.nextInt(6)+1;
			counter++;
			if (rand==6)
			{
				dice6count++;
			}
			else if (rand==1)
			{
				dice1count++;
			}
		}
		System.out.println("The number of times the dice rolled a 6: " + dice6count);
		System.out.println("The number of times the dice rolled a 1: " + dice1count);
	}
}