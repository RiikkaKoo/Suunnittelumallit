public class KeyboardInvoker {

    private Command down;
    private Command up;
    private Command left;
    private Command right;
    private Command toggle;


    public KeyboardInvoker(Command command1, Command command2, Command command3, Command command4, Command command5) {
        this.down = command1;
        this.up = command2;
        this.left = command3;
        this.right = command4;
        this.toggle = command5;
    }

    public void cursorDown() {
        down.execute();
    }

    public void cursorUp() {
        up.execute();
    }

    public void cursorLeft() {
        left.execute();
    }

    public void cursorRight() {
        right.execute();
    }

    public void togglePixel() {
        toggle.execute();
    }
}
