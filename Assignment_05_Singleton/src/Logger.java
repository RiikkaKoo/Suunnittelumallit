import java.io.*;

public class Logger {

    private BufferedWriter writer;
    private static Logger instance;
    private String filename;

    private Logger() {
        this.filename = "log.txt";
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String filename) {
        try {
            this.filename = filename;
            if (this.writer != null) {
                this.writer.close();
            }
            this.writer = new BufferedWriter(new FileWriter(this.filename, true)); // True = New lines are appended to an existing file.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String text) {
        try {
            this.writer.write(text);
            this.writer.newLine();
            this.writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.writer.close();
            this.writer = null;
            instance = null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
