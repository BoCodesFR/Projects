////
// Name: Aghahowa, Orobosa
// Project: #3
// Due: October 15,2024
// Course: cs-1400-05-f24
//
// Description:
// This porgram outputs a monthly calendar for a given month and year into a file.
//
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MonthlyCalendarGenerator
{
    public static void main(String[] args) throws IOException 
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Calendar by F. Last");
        System.out.println();
        System.out.print("Enter month year? ");
        int month = keyboard.nextInt();
        int year = keyboard.nextInt();

        // Generate file name
        String fileName = "11-2023.txt";
        PrintWriter outputFile = new PrintWriter(fileName);
        String monthName = getMonthName(month);

        // Print the month and year to file and console
        outputFile.println(monthName + " " + year);
        outputFile.println();

        // Print the header (days of the week)
        outputFile.println("Sun  Mon  Tue  Wed  Thu  Fri  Sat");
        outputFile.println("---------------------------------");

        // Calculate days in the month and the starting day
        int daysInMonth = getNumberOfDaysInMonth(month, year);
        int startDay = getDayOfTheWeek(1, month, year);

        // Print spaces for the starting day of the month
        for (int i = 0; i < startDay; i++) {
            outputFile.print("     "); // Five spaces for each empty day
            System.out.print("     ");
        }

        // Print each day of the month
        for (int day = 1; day <= daysInMonth; day++) {
            outputFile.printf("%-5d", day);  // Write day with formatting
            startDay++;

            // New line after Saturday
            if (startDay == 7) {
                outputFile.println();
                startDay = 0; // Reset to Sunday
            }
        }

        // Ensure the file ends with a new line
        outputFile.println();
        outputFile.close();
        System.out.println("\n" + fileName + " generated.");
    }

    public static int getDayOfTheWeek(int day, int month, int year)
    {
        int a = (14 - month) / 12;
        int y = year - a;
        int m = month + (12 * a) - 2;
        int d = (day + y + (y / 4) - (y / 100) + (y / 400) + ((31 * m) / 12)) % 7;
        return d; // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
		
    }

    public static boolean isLeapYear(int year)
    {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getNumberOfDaysInMonth(int month, int year)
    {
        switch (month)
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }

    public static String getMonthName(int month)
    {
        switch (month)
        {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "";
        }
    }
}
