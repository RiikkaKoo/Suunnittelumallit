public abstract class UIElement {
    protected String text;

    public UIElement(String text) {
        this.text = text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    public abstract void display();
}
