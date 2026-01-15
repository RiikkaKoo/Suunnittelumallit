public class SimpleFactory extends UIFactory {

    @Override
    public Button createButton(String text) {
        return new ButtonA();
        }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA();
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA();
    }

}
