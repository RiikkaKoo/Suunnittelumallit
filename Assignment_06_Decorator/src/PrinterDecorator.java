public class PrinterDecorator implements Printer {

    private Printer printer;

    PrinterDecorator(Printer decorable) {
        this.printer = decorable;
    }

    @Override
    public void print(String text) {
        printer.print(text);
    }
}
