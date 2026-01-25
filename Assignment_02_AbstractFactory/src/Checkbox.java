public abstract class Checkbox {

    public String text;

    public Checkbox( String text) {
        this.text = text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    public abstract void display();
}
