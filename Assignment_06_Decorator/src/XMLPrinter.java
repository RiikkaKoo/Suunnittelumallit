public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer decorable) {
        super(decorable);
    }

    @Override
    public void print(String text) {
        super.print("<text>" + text + "</text>");
    }
}
