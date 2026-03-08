import java.util.Scanner;

public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handle(Message feedback) {
        if (feedback.getType() == MessageType.CONTACT) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Contact Request handler - Contact request: ");
            System.out.println("Email: " + feedback.getEmail());
            System.out.println("Claim: " + feedback.getContent());
            System.out.println("\nFORWARD TO: ");
            System.out.println("1. Marketing department");
            System.out.println("2. Sales department");
            System.out.println("3. IT department");
            System.out.println("4. Development department");
            boolean isCorrectInput = false;
            while (!isCorrectInput) {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Contact Request handler: Request forwarded to the Marketing department.");
                        System.out.println();
                        isCorrectInput = true;
                        break;
                    case 2:
                        System.out.println("Contact Request handler: Request forwarded to the Sales department.");
                        System.out.println();
                        isCorrectInput = true;
                        break;
                    case 3:
                        System.out.println("Contact Request handler: Request forwarded to the IT department.");
                        System.out.println();
                        isCorrectInput = true;
                        break;
                    case 4:
                        System.out.println("Contact Request handler: Request forwarded to the Development department.");
                        System.out.println();
                        isCorrectInput = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
        } else {
            System.out.println("Contact Request handler: Does not handle this feedback type. Forwarding the feedback to the next handler.");
            System.out.println();
            super.handle(feedback);
        }
    }
}
