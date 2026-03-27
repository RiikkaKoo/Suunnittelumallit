public class SizeCalculatorVisitor implements FileSystemVisitor {

    private int accumulatedSize = 0;

    public int getAccumulatedSize() {
        return this.accumulatedSize;
    }

    @Override
    public void visit(File file) {
        accumulatedSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        int elements = directory.getElements().size();
        System.out.println(directory.getDirectoryName() + "-directory contains " + elements + " elements.");
    }
}
