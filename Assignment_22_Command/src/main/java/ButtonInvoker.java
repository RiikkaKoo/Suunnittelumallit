public class ButtonInvoker {

    private Command generate;

    public ButtonInvoker(Command command1) {
        this.generate = command1;
    }

    public void generateCode() {
        generate.execute();
    }
}
