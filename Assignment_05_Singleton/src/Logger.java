import java.io.*;

public class Logger {

    private BufferedWriter writer;
    private static Logger instance;
    private String filename;

    // Set the default filename (but why?)
    private Logger() {
        this.filename = "log.txt";
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // A method for setting a new filename and closing the current file if it is open. Open/create new file and set it as the open file.
    public void setFileName(String filename) {
        try {
            this.filename = filename;
            // Save and close the previous open file (if exists).
            if (this.writer != null) {
                this.writer.flush();
                this.writer.close();
            }
            // Open/create new file:
            this.writer = new BufferedWriter(new FileWriter(this.filename, true)); // True = New lines are appended to an existing file.
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // A method for writing a new line to the open file
    public void write(String text) {
        if (this.writer != null) {
            try {
                this.writer.write(text);
                this.writer.newLine();
                this.writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {System.out.println("Logger is closed. Set filename to open it.");}
    }

    public void close() {
        try {
            this.writer.close();
            this.writer = null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
