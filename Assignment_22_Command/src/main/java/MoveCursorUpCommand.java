public class MoveCursorUpCommand implements Command {

    private ControlSystem receiver;

    public MoveCursorUpCommand(ControlSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveCursorUp();
    }
}
