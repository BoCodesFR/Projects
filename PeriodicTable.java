//
// Name: Aghahowa, Orobosa
// Project: #4
// Due: November 1, 2024
// Course: cs-1400-05-f24
//
// Description:
//  This program reads information from a periodic table data file and uses the file to perfrom tasks like retrieving information and printing the table to a file.
//
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class PeriodicTable {
    public static void main(String[] args) throws IOException 
    {
        final int MAX_ELEMENTS = 128; // Maximum elements size
        Element[] periodicTable = new Element[MAX_ELEMENTS]; // Partially filled array for elements
        int actualSize = readPeriodicTable(periodicTable); // Read data and get actual number of elements
    

        selectionSort(periodicTable, actualSize); // Sort the table alphabetically by name
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Periodic Table by O. Aghahowa");
        System.out.println();
        System.out.println("Periodic table loaded with " + actualSize + " elements.");
        System.out.println();

        char choice;
        do {
            System.out.println("N Search by atomic number");
            System.out.println("S Search by symbol");
            System.out.println("P Print table to a file");
            System.out.println("Q Quit");
            System.out.println();
            System.out.print("Select? ");
            choice = keyboard.next().toUpperCase().charAt(0);

            switch (choice) {
                case 'N':
                    System.out.print("Enter atomic number? ");
                    int number = keyboard.nextInt();
                    int indexNumber = linearSearch(periodicTable, actualSize, number);
                    if (indexNumber == -1) {
                        System.out.println(number + " not found");
                    } else {
                        System.out.println(periodicTable[indexNumber]);
                    }
                    break;

                case 'S':
                    System.out.print("Enter symbol? ");
                    String symbol = keyboard.next();
                    int indexSymbol = linearSearch(periodicTable, actualSize, symbol);
                    if (indexSymbol == -1) {
                        System.out.println(symbol + " not found");
                    } else {
                        System.out.println(periodicTable[indexSymbol]);
                    }
                    break;

                case 'P':
                    System.out.print("Enter file name? ");
                    String fileName = keyboard.next();
                    printTable(periodicTable, actualSize, fileName);
                    System.out.println("Table saved in " + fileName + ".");
                    break;

                case 'Q':
                    break;

                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        } while (choice != 'Q');

        keyboard.close();
    }

    public static int readPeriodicTable(Element[] table) throws IOException {
        Scanner ptFile = new Scanner(new File("periodictable.dat"));
        int index = 0;

        while (ptFile.hasNextInt() && index < table.length) {
            int atomicNumber = ptFile.nextInt();
            String symbol = ptFile.next();
            double mass = ptFile.nextDouble();
            String name = ptFile.next();
            table[index++] = new Element(atomicNumber, name, symbol, mass);
        }
        ptFile.close();
        return index; // Return the actual number of elements loaded
    }

    public static void selectionSort(Element[] table, int actualSize) {
        for (int startScan = 0; startScan < actualSize - 1; startScan++) {
            int minIndex = startScan;
            String minValue = table[startScan].name();

            for (int index = startScan + 1; index < actualSize; index++) {
                if (table[index].name().compareTo(minValue) < 0) {
                    minValue = table[index].name();
                    minIndex = index;
                }
            }
            Element temp = table[minIndex];
            table[minIndex] = table[startScan];
            table[startScan] = temp;
        }
    }

    public static int linearSearch(Element[] table, int actualSize, int number) {
        for (int i = 0; i < actualSize; i++) {
            if (table[i].atomicNumber() == number) {
                return i; // Return index if atomic number is found
            }
        }
        return -1; // Return -1 if not found
    }

    public static int linearSearch(Element[] table, int actualSize, String symbol) {
        for (int i = 0; i < actualSize; i++) {
            if (table[i].symbol().equalsIgnoreCase(symbol)) //ask about this!
            {
                return i; // Return index if symbol is found (case-insensitive)
            }
        }
        return -1; // Return -1 if not found
    }

    public static void printTable(Element[] table, int actualSize, String fileName) throws IOException {
        PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));
        outputFile.println("Periodic Table by O. Aghahowa");
        outputFile.println();
        outputFile.println(actualSize + " elements");
        outputFile.println();
        outputFile.printf("%-4s %-4s %-20s %9s\n", "ANo", "Sym", "Name", "Mass");
        outputFile.println("---  ---  --------------------  --------");

        for (int i = 0; i < actualSize; i++) {
            outputFile.println(table[i]);
        }
        outputFile.close();
    }
}

// Record for Element, following the format provided
record Element(int atomicNumber, String name, String symbol, double mass) {
    @Override
    public String toString() {
        return String.format("%3d %-1s %-3s %-20s %9.2f", atomicNumber,"", symbol, name, mass);
    }
} 