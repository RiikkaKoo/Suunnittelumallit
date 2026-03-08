public abstract class FeedbackHandler {

    private FeedbackHandler nextHandler;

    public void handle(Message feedback) {
        if (nextHandler != null) {
            nextHandler.handle(feedback);
        }
    }

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

}
