import java.util.Scanner;

public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    public void handle(Message feedback) {
        if (feedback.getType() == MessageType.GENERAL) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("General feedback handler - Feedback: ");
            System.out.println("Email: " + feedback.getEmail());
            System.out.println("Claim: " + feedback.getContent());
            System.out.println("\nRESPOND: ");
            String response = scanner.nextLine();
            System.out.println("General feedback handler: \nResponse: " + response + "\nSent to: " + feedback.getEmail());
            System.out.println();
        } else {
            System.out.println("General feedback handler: Does not handle this feedback type. Forwarding the feedback to the next handler.");
            System.out.println();
            super.handle(feedback);
        }
    }
}
