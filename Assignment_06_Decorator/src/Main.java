public class Main {
    public static void main(String[] args) {

        Printer printer;

        printer = new BasicPrinter();
        printer.print("Hello World!");

        // Encrypt --> Print
        printer = new EncryptedPrinter(new BasicPrinter());
        printer.print("Encrypt this line.");

        // Capitalize --> Encrypt --> Print
        printer = new CapitalizingPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer.print("Encrypt this line.");

        // Encrypt --> Capitalize --> Print
        printer = new EncryptedPrinter(new CapitalizingPrinter(new BasicPrinter()));
        printer.print("Encrypt this line.");

        // XML --> Print
        printer = new XMLPrinter(new BasicPrinter());
        printer.print("Hello World!");

        // XML --> Encrypt --> Print
        printer = new XMLPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer.print("Hello World!");

        // Encrypt --> XML --> Print
        printer = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer.print("Hello World!");
    }
}
