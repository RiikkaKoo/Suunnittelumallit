public class GenerateCodeCommand implements Command {

    private ControlSystem receiver;

    public GenerateCodeCommand(ControlSystem receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.generateCode();
    }
}
