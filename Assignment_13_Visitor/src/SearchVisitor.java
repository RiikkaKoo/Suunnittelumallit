import java.util.ArrayList;

public class SearchVisitor implements FileSystemVisitor {

    private String key;
    private ArrayList<File> foundFiles = new ArrayList<>();
    private ArrayList<Directory> foundDirectories = new ArrayList<>();

    public SearchVisitor(String key) {
        this.key = key;
    }

    public void displayFoundFiles() {
        for (File file : foundFiles) {
            System.out.println("   " + file.getFileName() + " - " + file.getSize() + "MB");
        }
    }

    public void displayFoundDirectories() {
        for (Directory directory : foundDirectories) {
            System.out.println("   " + directory.getDirectoryName());
        }
    }

    @Override
    public void visit(File file) {
        if (file.getFileName().toUpperCase().contains(key.toUpperCase())) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        if (directory.getDirectoryName().toUpperCase().contains(key.toUpperCase())) {
            foundDirectories.add(directory);
        }
    }
}
