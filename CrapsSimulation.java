//
// Name: Aghahowa, Orobosa
// Homework: #3
// Due: September 24, 2024
// Course: cs-1400-05-f24
//
// Description:
//             This program that simulates rolling two dice 9 times and displays the results. For each roll, it will output the values of the dice along with an applicable roll name depending on the combination.
//

import java.util.Random;
public class CrapsSimulation
{
    public static void main(String[] args)
    {

        Random generator = new Random();
        System.out.println("Craps Simulation by O. Aghahowa");
        System.out.println(" ");
        int counter =1;
        while (counter<=9){

        int dice1 = generator.nextInt(6)+1;
        int dice2 = generator.nextInt(6)+1;
        
        System.out.println(counter + ":\t" + dice1 + " " + dice2 + (dice1==1 && dice2==1 ? " Snake Eyes" : " ") + (dice1==6 && dice2==6 ? " Boxcars" : " ") + ((dice1==4 && dice2==1)||(dice1==4 && dice2==1)? " Fever Five" : " "));
        counter++;
        }
    }
}