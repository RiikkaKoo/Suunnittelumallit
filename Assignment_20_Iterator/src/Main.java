import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Make a limited fibonacci sequence
        Sequence limitedSequence = new FibonacciSequence(10);

        // Make a fibonacci sequence that can be generated infinitely
        Sequence infiniteSequence = new FibonacciSequence();

        Iterator iterator = limitedSequence.iterator();
        Iterator iterator2 = infiniteSequence.iterator();

        System.out.println("The limited sequence:");
        // This will print the first ten numbers of the fibonacci sequence
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nThe infinite sequence (to stop press \"s\"):");
        // This will print numbers of the fibonacci sequence until stopped
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
            String input = scanner.nextLine();
            if (input.equals("s")) {
                break;
            }
        }
    }
}
