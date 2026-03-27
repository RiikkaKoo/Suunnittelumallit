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
        SearchVisitor searchVisitor= new SearchVisitor(".txt");

        System.out.println();

        directory1.accept(sizeCalculatorVisitor);
        System.out.println("Total Size of the File System: " + sizeCalculatorVisitor.getAccumulatedSize() + "MB");

        System.out.println();

        directory1.accept(searchVisitor);
        System.out.println("Searched Files in the System: ");
        searchVisitor.displayFoundFiles();

        System.out.println();

        System.out.println("Searched Directories in the System: ");
        searchVisitor.displayFoundDirectories();
    }
}
