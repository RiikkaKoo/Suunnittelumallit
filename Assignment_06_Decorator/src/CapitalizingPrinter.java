public class CapitalizingPrinter extends PrinterDecorator {

    public CapitalizingPrinter(Printer decorable) {
        super(decorable);
    }

    @Override
    public void print(String text) {
        super.print(text.toUpperCase());
    }
}
