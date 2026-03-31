public class Main {
    public static void main(String[] args) {
        Directory directory1 = new Directory("FirstDirectory");
        Directory directory2 = new Directory("SecondDirectory");

        FileSystemElement file1 = new File("FirstFile.txt", 12);
        FileSystemElement file2 = new File("SecondFile.png", 25);
        FileSystemElement file3 = new File("ThirdFile.txt", 9);

        directory2.addAnElement(file1);
        directory2.addAnElement(file2);

        directory1.addAnElement(directory2);
        directory1.addAnElement(file3);

        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();
        SearchVisitor searchVisitor1 = new SearchVisitor(".txt");
        SearchVisitor searchVisitor2 = new SearchVisitor("dir");

        System.out.println();

        // SizeCalculatorVisitor traverses the filesystem:
        directory1.accept(sizeCalculatorVisitor);
        System.out.println("Total Size of the File System: " + sizeCalculatorVisitor.getAccumulatedSize() + "MB");

        System.out.println();

        // SearchVisitor1 traverses the filesystem:
        directory1.accept(searchVisitor1);
        System.out.println("Files with key \".txt\" found in the System: ");
        searchVisitor1.displayFoundFiles();

        System.out.println();

        System.out.println("Directories with key \".txt\" found in the System: ");
        searchVisitor1.displayFoundDirectories();

        System.out.println();
        System.out.println();

        // SearchVisitor2 traverses the filesystem:
        directory1.accept(searchVisitor2);
        System.out.println("Files with key \"dir\" found in the System: ");
        searchVisitor2.displayFoundFiles();

        System.out.println();

        System.out.println("Directories with key \"dir\" found in the System: ");
        searchVisitor2.displayFoundDirectories();
    }
}
