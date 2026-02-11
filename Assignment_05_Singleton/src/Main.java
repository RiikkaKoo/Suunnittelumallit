public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Set filename to open the logger for writing
        logger.setFileName("new_log.txt");
        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");

        // Create a new file (since it does not exist)
        logger.setFileName("another_log.txt");
        logger.write("First line to a new file!");
        logger.write("Another line.");

        // Close the file and try to write (should not work)
        logger.close();
        logger.write("THIS SHOULD NOT BE WRITTEN TO THE FILE!");

        // Open the first file again. New lines should be appended after the existing ones.
        logger.setFileName("new_log.txt");
        logger.write("Second simulation started");
        logger.write("Processing data...");
        logger.write("Second simulation finished");

        logger.close();
    }
}
