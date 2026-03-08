import java.util.Scanner;

public class CompensationClaimHandler extends FeedbackHandler {

    @Override
    public void handle(Message feedback) {
        if (feedback.getType() == MessageType.COMPENSATION) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Compensation handler - Compensation claim: ");
            System.out.println("Email: " + feedback.getEmail());
            System.out.println("Claim: " + feedback.getContent());
            System.out.println("\n1. Approve compensation claim");
            System.out.println("2. Reject compensation claim");
            boolean isCorrectInput = false;
            while (!isCorrectInput) {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Compensation handler: Compensation reviewed and approved.");
                        System.out.println();
                        isCorrectInput = true;
                        break;
                    case 2:
                        System.out.println("Compensation handler: Compensation rejected.");
                        System.out.println();
                        isCorrectInput = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
        } else {
            System.out.println("Compensation handler: Does not handle this feedback type. Forwarding the feedback to the next handler.");
            System.out.println();
            super.handle(feedback);
        }
    }
}
