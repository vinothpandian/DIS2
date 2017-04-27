import java.io.IOException;
import java.util.Scanner;

/**
 * Created by VinothPandianSermugaPandian on 27-04-2017.
 */
public class HelloWorldConsole {

    public static void main(String args[]) {
        Boolean repeat = true;
        String input = null;

        while (repeat) {
            /*Print the console message*/
            System.out.println("\nSelect one of the following:\n" +
                    " [D]eutsch\n" +
                    " [E]nglish\n" +
                    " [F]rancais\n" +
                    " [Q]uit");

            System.out.print(">");
            Scanner s = new Scanner(System.in);
            input = s.nextLine();
            if (!input.matches("[A-Za-z]{1}")) {
                input = "o";
            }

            switch (input) {
                case "d":
                case "D":
                    System.out.println("Guten Tag!");
                    break;
                case "e":
                case "E":
                    System.out.println("Good Day!");
                    break;
                case "f":
                case "F":
                    System.out.println("Bonne Journee!");
                    break;
                case "q":
                case "Q":
                    System.out.println("\nQuiting...");
                    repeat = false;
                    break;
                default:
                    System.out.println("We are sorry! We don't speak that language yet..\nPlease try one of our offered language options");
                    break;
            }
        }
    }
}
