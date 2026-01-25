public class ButtonB extends Button {

    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {

        String borderTop = " ,*";
        String borderBottom = " '*";
        for (int i = 0; i < super.text.length(); i++) {
            borderTop += "~";
            borderBottom += "~";
        }
        borderTop += "*, ";
        borderBottom += "*' ";

        System.out.println(borderTop +
                           "\n{  " + super.text + "  }\n" +
                           borderBottom);
    }
}
