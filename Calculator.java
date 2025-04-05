import java.util.Scanner;
public class Calculator 
{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.print("enter num1 operator num 2: ");
        double num1 = keyboard.nextDouble();
        char operator = keyboard.next().charAt(0);
        double num2 = keyboard.nextDouble();

        if (operator == '+'){
            System.out.println(num1+num2);
        }

        else if (operator == '-'){
            System.out.println(num1-num2);
        }

        else if (operator == '*'){
            System.out.println(num1*num2);
        }

        else if (operator == '/'){
            System.out.println(num1/num2);
        }

    }
}
