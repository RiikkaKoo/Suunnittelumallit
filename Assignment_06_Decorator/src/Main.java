public class Main {
    public static void main(String[] args) {

        Printer printer0 = new BasicPrinter();
        printer0.print("Hello World!");

        // Encrypt --> Print
        Printer printer1 = new EncryptedPrinter(new BasicPrinter());
        printer1.print("Encrypt this line.");

        // Capitalize --> Encrypt --> Print
        Printer printer2 = new CapitalizingPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer2.print("Encrypt this line.");

        // Encrypt --> Capitalize --> Print
        Printer printer3 = new EncryptedPrinter(new CapitalizingPrinter(new BasicPrinter()));
        printer3.print("Encrypt this line.");

        // XML --> Print
        Printer printer4 = new XMLPrinter(new BasicPrinter());
        printer4.print("Hello World!");

        // XML --> Encrypt --> Print
        Printer printer5 = new XMLPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer5.print("Hello World!");

        // Encrypt --> XML --> Print
        Printer printer6 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer6.print("Hello World!");
    }
}
