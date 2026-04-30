public class MoveCursorDownCommand implements Command {

    private ControlSystem receiver;

    public MoveCursorDownCommand(ControlSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveCursorDown();
    }
}
