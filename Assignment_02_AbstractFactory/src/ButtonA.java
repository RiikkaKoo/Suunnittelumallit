public class ButtonA extends Button {

    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {

        String topBorder = ".==";
        String bottomBorder = "'==";
        for (int i = 0; i < super.text.length(); i++) {
            topBorder += "=";
            bottomBorder += "=";
        }
        topBorder += "==.";
        bottomBorder += "=='";

        System.out.println(topBorder +
                           "\n|  " + super.text + "  |\n" +
                           bottomBorder);
    }
}
