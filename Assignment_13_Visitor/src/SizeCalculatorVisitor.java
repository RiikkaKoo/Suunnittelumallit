public class SizeCalculatorVisitor implements FileSystemVisitor {

    private int accumulatedSize = 0;

    public int getAccumulatedSize() {
        return this.accumulatedSize;
    }

    @Override
    public void visit(File file) {
        accumulatedSize += file.getSize();
    }

    // Directories themselves do not have size so they do not contribute to the accumulated size.
    // Method prints info on how many elements it contains.
    @Override
    public void visit(Directory directory) {
        int elements = directory.getElements().size();
        System.out.println(directory.getDirectoryName() + "-directory contains " + elements + " elements.");
    }
}
