//
// Name: Aghahowa, Orobosa
// Project: #1
// Due: September 19, 2024
// Course: cs-1400-05-f24
//
// Description:
//      This application will act as a quadratic equation solver by prompting the user for coefficents a,b, and c and then printing out solutions.
//

import java.util.Scanner;

public class QuadraticEquationSolver
{
    public static void main(String[] args) 
    {
    	Scanner keyboard = new Scanner(System.in);
        double coeffecient_a, coeffecient_b, coeffecient_c,x1, x2, discriminant;

        //Introduction
        System.out.println("Quadratic Equation Solver by O. Aghahowa");
        System.out.println(" ");

        //Ask for Coefficient A
        System.out.print("Enter coefficient a? ") ;
        coeffecient_a = keyboard.nextDouble();

        //Ask for Coefficient B
        System.out.print("Enter coefficient b? ");
        coeffecient_b = keyboard.nextDouble();

        //Ask for Coefficient C
        System.out.print("Enter coefficient c? ");
        coeffecient_c = keyboard.nextDouble();

        discriminant = Math.pow(coeffecient_b,2)-(4*coeffecient_a*coeffecient_c);

        //Equations
        x1 = ((-coeffecient_b + Math.sqrt(discriminant))/(2*coeffecient_a));
        x2 = ((-coeffecient_b - Math.sqrt(discriminant))/(2*coeffecient_a));
        System.out.println(" ");

        //Solutions
        System.out.println("The solutions:");
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
        
    }
}