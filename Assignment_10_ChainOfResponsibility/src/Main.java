public class Main {
    public static void main(String[] args) {

        FeedbackHandler primaryHandler;

        FeedbackHandler compensationHandler = new CompensationClaimHandler();
        FeedbackHandler contactHandler = new ContactRequestHandler();
        FeedbackHandler suggestionHandler = new SuggestionHandler();
        FeedbackHandler generalHandler = new GeneralFeedbackHandler();

        generalHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(compensationHandler);
        primaryHandler = generalHandler;

        Message message1 = new Message("The website for the online shop is really slow. Please look into it.", "suggester111@email.com", MessageType.SUGGESTION);
        primaryHandler.handle(message1);

        Message message2 = new Message("I cannot login to the online shop. What should I do?", "user333@email.com", MessageType.CONTACT);
        primaryHandler.handle(message2);

        Message message3 = new Message("I love all your products! I always find something new from the selection and ordering is super easy.", "happy.customer@email.com", MessageType.GENERAL);
        primaryHandler.handle(message3);

        Message message4 = new Message("Hello. I recently bought an ceramic mug from your online store. When I received the mug, it was damaged. Can I get my money back or get a new mug?", "compensation.claimer@email.com", MessageType.COMPENSATION);
        primaryHandler.handle(message4);
    }
}
