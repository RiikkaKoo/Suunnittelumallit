public abstract class TextField {

    public String text;

    public TextField( String text) {
        this.text = text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    public abstract void display();
}
