public class File implements FileSystemElement {

    private String fileName;
    private int fileSize;

    public File(String name, int size) {
        this.fileName = name;
        this.fileSize = size;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getSize() {
        return this.fileSize;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
