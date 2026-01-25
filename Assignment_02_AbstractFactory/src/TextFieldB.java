public class TextFieldB extends TextField {

    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {

        String border = "**--";
        for (int i = 0; i < super.text.length(); i++) {
            border += "-";
        }
        border += "--**";

        System.out.println(border +
                "\n:  '" + super.text + "'  :\n"  +
                           border);
    }
}
