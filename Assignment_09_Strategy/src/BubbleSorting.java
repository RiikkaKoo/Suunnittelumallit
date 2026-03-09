public class BubbleSorting implements SortingStrategy {

    @Override
    public void sort(int[] integerArray) {
        /* BubbleSorting algorithm code is from here:
        https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/

        Works by repeatedly swapping the adjacent elements if they are in the wrong order.

        - Sorts the array using multiple passes. After the first pass, the maximum goes to end (its correct position).
          Same way, after second pass, the second largest goes to second last position and so on.

        - In every pass, process only those that have already not moved to correct position.
          After k passes, the largest k must have been moved to the last k positions.

        - In a pass, we consider remaining elements and compare all adjacent and swap if larger element is before a smaller element.
          If we keep doing this, we get the largest (among the remaining elements) at its correct position.
         */

        int n = integerArray.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (integerArray[j] > integerArray[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = integerArray[j];
                    integerArray[j] = integerArray[j + 1];
                    integerArray[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
}
