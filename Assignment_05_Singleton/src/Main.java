public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setFileName("new_log.txt");
        logger.write("Simulation 2 started");
        logger.write("Processing data...");
        logger.write("Simulation 2 finished");
        logger.setFileName("another_log.txt");
        logger.write("First line to a new file!");
        logger.write("Another line.");
        logger.close();
    }
}
