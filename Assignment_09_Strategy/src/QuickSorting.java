public class QuickSorting implements SortingStrategy {
    /* QuickSorting algorithm code is from here:
    https://www.geeksforgeeks.org/dsa/quick-sort-algorithm/

    Based on the Divide and Conquer that picks an element as a pivot
    and partitions the given array around the picked pivot by placing the pivot in its correct position in the sorted array.

    - Choose a Pivot: Select an element from the array as the pivot.
      The choice of pivot can vary (e.g., first element, last element, random element, or median).

    - Partition the Array: Re arrange the array around the pivot. After partitioning,
      all elements smaller than the pivot will be on its left, and all elements greater than the pivot will be on its right.

    - Recursively Call: Recursively apply the same process to the two partitioned sub-arrays.

    - Base Case: The recursion stops when there is only one element left in the sub-array, as a single element is already sorted.
     */

    // partition function
    private int partition(int[] arr, int low, int high) {

        // choose the pivot
        int pivot = arr[high];

        // index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // swap function
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // the QuickSort function implementation
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public void sort(int[] integerArray) {
        int n = integerArray.length;
        quickSort(integerArray, 0, n - 1);
    }
}
