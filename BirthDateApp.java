//
// Name: Aghahowa, Orobosa
// Homework:#4
// Due:October 15, 2024
// Course: cs-1400-05-f24
//
// Description:
//   This program asks the user for their birth date and then displays the day of the week and month name corresponding to that date. 
//

import java.util.Scanner;
public class BirthDateApp
{
	public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Birth Date by O. Aghahowa");
        System.out.println();
        System.out.print("Enter your birth date month day year? ");
        int month = keyboard.nextInt();
        int day = keyboard.nextInt();
        int year = keyboard.nextInt();

        System.out.println();

        int dayofWeek = getDayOfTheWeek (day, month, year);
        String weekDay = getDayName(dayofWeek);
		String monthName = getMonthName (month);

        System.out.println("You were born on " + weekDay + ", " + monthName + " "+ day + ", " + year + ".");
    }
    public static int getDayOfTheWeek (int day, int month, int year)
    {
    int a = (14 - month) / 12;
    int y = year - a;
    int m = month + (12 * a) - 2;
        int d = (day + y + (y / 4) - (y / 100) + (y / 400) + ((31 * m) / 12)) % 7;
        return d;
    }

public static String getMonthName (int month)
{
    switch (month)
    {
        case 1: 
        return "January";
        case 2: 
        return "February";
        case 3: 
        return "March";
        case 4: 
        return "April";
        case 5: 
        return "May";
        case 6: 
        return "June";
        case 7: 
        return "July";
        case 8: 
        return "August";
        case 9: 
        return "September";
        case 10: 
        return "October";
        case 11: 
        return "November";
        case 12: 
        return "December";
        default: 
        return "";
    }
}

    public static String getDayName(int dayofWeek)
    {
    switch(dayofWeek)
    {
        case 0:  return "Sunday";
            case 1:  return "Monday";
            case 2:  return "Tuesday";
            case 3:  return "Wednesday";
            case 4:  return "Thursday";
            case 5:  return "Friday";
            case 6:  return "Saturday";
            default: return "Invalid Day";
    }
}
}
