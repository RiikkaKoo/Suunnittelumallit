public class MoveCursorLeftCommand implements Command {

    private ControlSystem receiver;

    public MoveCursorLeftCommand(ControlSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveCursorLeft();
    }
}
