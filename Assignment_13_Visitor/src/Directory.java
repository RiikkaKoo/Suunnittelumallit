import java.util.ArrayList;

public class Directory implements FileSystemElement {

    private String directoryName;
    private ArrayList<FileSystemElement> elements = new ArrayList<>();

    public Directory(String name) {
        this.directoryName = name;
    }

    public void addAnElement(FileSystemElement element) {
        elements.add(element);
    }

    public ArrayList<FileSystemElement> getElements() {
        return this.elements;
    }

    public String getDirectoryName() {
        return this.directoryName;
    }


    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);

        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}
