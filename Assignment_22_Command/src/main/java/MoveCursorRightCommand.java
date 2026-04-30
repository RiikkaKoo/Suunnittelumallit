public class MoveCursorRightCommand implements Command {

    private ControlSystem receiver;

    public MoveCursorRightCommand(ControlSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveCursorRight();
    }
}
