//
// Name: Aghahowa, Orobosa
// Homework: #2
// Due: September 19, 2024
// Course: cs-1400-05-f24
//
// Description:
//		This program will make change with coins and only display coins that have a quantity greater than 0.
//


import java.util.Scanner;

public class MakeChange
{
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		int changeAmount, quarters, dimes, nickels, pennies; // = 86; // cents
		System.out.println("Change by O. Aghahowa");
		System.out.println(" ");
		System.out.print("Enter change amount? ");
		changeAmount = keyboard.nextInt();
		System.out.println(" ");


		quarters = (changeAmount / 25);
		changeAmount = changeAmount % 25; // what is left after taken out the quarters
		
		dimes = (changeAmount / 10);
		changeAmount = changeAmount % 10; // what is left after taken out the dimes

		nickels = (changeAmount / 5);
		changeAmount = changeAmount % 5; // What is left after taken out the nickels

		pennies = changeAmount; // What is left overall

		if (quarters > 0){
			System.out.println(quarters + " " + (quarters > 1 ? "quarters" : "quarter"));
		}
		if (dimes > 0){
			System.out.println(dimes + " " + (dimes > 1 ? "dimes" : "dime"));
		}
		if (nickels > 0){
			System.out.println(nickels + " " + (nickels > 1 ? "nickels" : "nickel"));
		}
		if (pennies > 0){
			System.out.println(pennies + " " + (pennies > 1 ? "pennies" : "penny"));
		}

		keyboard.close();
	}
}