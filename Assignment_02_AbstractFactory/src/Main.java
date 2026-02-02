public class Main {
    public static void main(String[] args) {
        UIFactory factory = new SimpleFactory();
        UIElement button = factory.createButton("Button");
        button.display();

        button.setText("Longer button");
        button.display();

        UIElement checkbox = factory.createCheckbox("Select this");
        checkbox.display();

        checkbox.setText("Select this option!");
        checkbox.display();

        UIElement textField = factory.createTextField("This is a prompt text");
        textField.display();

        textField.setText("A new prompt text for this field");
        textField.display();
    }
}
