import java.util.Scanner;

public class SuggestionHandler extends FeedbackHandler {
    @Override
    public void handle(Message feedback) {
        if (feedback.getType() == MessageType.SUGGESTION) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Suggestion handler - Development suggestion: ");
            System.out.println("Email: " + feedback.getEmail());
            System.out.println("Claim: " + feedback.getContent());
            System.out.println("\nSET PRIORITY: ");
            System.out.println("1. Low");
            System.out.println("2. Medium");
            System.out.println("3. High");
            boolean isCorrectInput = false;
            while (!isCorrectInput) {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Suggestion handler: Suggestion logged - Priority: Low");
                        System.out.println();
                        isCorrectInput = true;
                        break;
                    case 2:
                        System.out.println("Suggestion handler: Suggestion logged - Priority: Medium");
                        System.out.println();
                        isCorrectInput = true;
                        break;
                    case 3:
                        System.out.println("Suggestion handler: Suggestion logged - Priority: High");
                        System.out.println();
                        isCorrectInput = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
        } else {
            System.out.println("Suggestion handler: Does not handle this feedback type. Forwarding the feedback to the next handler.");
            System.out.println();
            super.handle(feedback);
        }
    }
}
