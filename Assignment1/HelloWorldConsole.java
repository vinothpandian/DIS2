import java.util.Scanner;

/**
 * Created by VinothPandianSermugaPandian on 27-04-2017.
 */
public class HelloWorldConsole {

    Boolean repeat;
    String input;

    public HelloWorldConsole(){
        this.repeat = true;
        this.input = null;
        helloConsole();
    }

    private void helloConsole() {
        while (repeat) {
            /*Print the console message*/
            System.out.println("\nSelect one of the following:\n" +
                    " [D]eutsch\n" +
                    " [E]nglish\n" +
                    " [F]rancais\n" +
                    " [Q]uit");

            System.out.print(">");
            Scanner s = new Scanner(System.in);
            this.input = s.nextLine();
            if (!this.input.matches("[A-Za-z]{1}")) {
                this.input = "o";
            }

            switch (this.input) {
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

    public static void main(String args[]) {
        HelloWorldConsole hello = new HelloWorldConsole();
    }
}