public class Main {

    final static int SMALL = 200;
    final static int LARGE = 100000;

    public static void main(String[] args) {
        SortingContext sorter = new SortingContext(new SelectionSorting());

        int[] smallArray = new int[SMALL];
        int[] largeArray = new int[LARGE];

        // Generate random integers for the small array
        for (int i = 0; i < SMALL; i++) {
            int num = (int)((Math.random() * (51 - (-51))) + (-51)); // Random number between -50 and 50
            //System.out.println(num);
            smallArray[i] = num;
        }
        // Clone the unsorted array for the other sorting algorithms:
        int[] smallArray2 = smallArray.clone();
        int[] smallArray3 = smallArray.clone();


        // Generate random integers for the large array
        for (int i = 0; i < LARGE; i++) {
            int num = (int)((Math.random() * (51 - (-51))) + (-51)); // Random number between -50 and 50
            //System.out.print(num);
            largeArray[i] = num;
        }
        // Clone the unsorted array for the other sorting algorithms:
        int[] largeArray2 = largeArray.clone();
        int[] largeArray3 = largeArray.clone();

        // Print the small array before sorting
        /*
        for (Integer i : smallArray) {
            System.out.print(i + " | ");
        }
         */

        // Selection Sorting:
        double time1 = sorter.sortArray(smallArray);
        sorter.setStrategy(new BubbleSorting());
        double time2 = sorter.sortArray(smallArray2);
        sorter.setStrategy(new QuickSorting());
        double time3 = sorter.sortArray(smallArray3);

        System.out.println();
        System.out.println("\nSorting with Selection Sorting - Small array: " + time1 + "s");
        System.out.println("Sorting with Bubble Sorting - Small array: " + time2 + "s");
        System.out.println("Sorting with Quick Sorting - Small array: " + time3 + "s");
        System.out.println();

        // Print the small array after sorting
        /*
        for (Integer i : smallArray3) {
            System.out.print(i + " | ");
        }
         */

        // Sort the large arrays:
        sorter.setStrategy(new SelectionSorting());
        double time4 = sorter.sortArray(largeArray);
        sorter.setStrategy(new BubbleSorting());
        double time5 = sorter.sortArray(largeArray2);
        sorter.setStrategy(new QuickSorting());
        double time6 = sorter.sortArray(largeArray3);

        System.out.println();
        System.out.println("\nSorting with Selection Sorting - Large array: " + time4 + "s");
        System.out.println("Sorting with Bubble Sorting - Large array: " + time5 + "s");
        System.out.println("Sorting with Quick Sorting - Large array: " + time6 + "s");

    }

}
