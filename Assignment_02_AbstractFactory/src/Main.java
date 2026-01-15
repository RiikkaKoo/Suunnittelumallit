public class Main {
    public static void main(String[] args) {
        UIFactory factory = new SimpleFactory();
        Button button = factory.createButton("Press");
        button.display();

        Checkbox checkbox = factory.createCheckbox("Press");
        checkbox.display();

        TextField textField = factory.createTextField("Press");
        textField.display();
    }
}
