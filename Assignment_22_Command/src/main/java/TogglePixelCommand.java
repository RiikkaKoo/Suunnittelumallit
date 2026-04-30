public class TogglePixelCommand implements Command {

    private ControlSystem receiver;

    public TogglePixelCommand(ControlSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.togglePixel();
    }
}
