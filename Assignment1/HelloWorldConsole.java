/*
* DIS2 - Assignment 01
* A simple console (text-based) UI program
*
* Group 12:
*    Arijit Gupta
*    Vincentius Renaldi
*    Vinoth Pandian Sermuga Pandian
*
* A simple console (text-based) UI program in Java. The program presents the
* user with a list of languages. The user can select an option by typing in
* the first letter of that language, followed by 'enter', and the system
* will output 'Hello' in that language.
*
*/

import java.util.Scanner;

public class HelloWorldConsole {

    //  Variable to repeat loop
    Boolean repeat;
    //  Input to the console
    String input;

    /*
    *  constructor to call language selection
    */
    public HelloWorldConsole() {
        languageSelection();
    }


    /*
    *   Console UI Application - provides a list of languages for user to choose
    */
    private void languageSelection() {
        repeat = true;
        input = null;

        while (repeat) {
            //  Print the console message
            System.out.println("\nSelect one of the following:\n" +
                    " [D]eutsch\n" +
                    " [E]nglish\n" +
                    " [F]rancais\n" +
                    " [Q]uit");
            System.out.print(">");

            // get input from console
            Scanner s = new Scanner(System.in);
            this.input = s.nextLine();
            //  Accept the input only if it is a single alphabet character otherwise assign default switch message
            if (!this.input.matches("[A-Za-z]{1}")) {
                this.input = "error";
            }

            // Process input and output the message or quit
            switch (this.input) {
                // for d or D - Deutsch
                case "d":
                case "D":
                    System.out.println("Guten Tag!");
                    break;
                // for e or E - English
                case "e":
                case "E":
                    System.out.println("Good Day!");
                    break;
                // for f or F - French
                case "f":
                case "F":
                    System.out.println("Bonne Journee!");
                    break;
                // for q or Q - Quit
                case "q":
                case "Q":
                    System.out.println("\nQuiting...");
                    repeat = false;
                    break;
                // for any other input - show error
                case "error":
                default:
                    System.out.println("We are sorry! We don't speak that language yet..\nPlease try one of our offered language options");
                    break;
            }
        }
    }

    /*
    *  Main function to call Console UI application class
    */
    public static void main(String args[]) {
        HelloWorldConsole hello = new HelloWorldConsole();
    }
}
