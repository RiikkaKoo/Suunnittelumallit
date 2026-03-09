public class SelectionSorting implements SortingStrategy {

    @Override
    public void sort(int[] integerArray) {
        /* SelectionSorting algorithm code is from here:
        https://www.geeksforgeeks.org/dsa/selection-sort-algorithm-2/

        1. Find the smallest element and swap it with the first element. This way we get the smallest element at its correct position.
        2. Then find the smallest among remaining elements (or second smallest) and swap it with the second element.
        3. We keep doing this until we get all elements moved to correct position.
        */

            int n = integerArray.length;
            for (int i = 0; i < n - 1; i++) {

                // Assume the current position holds
                // the minimum element
                int min_idx = i;

                // Iterate through the unsorted portion
                // to find the actual minimum
                for (int j = i + 1; j < n; j++) {
                    if (integerArray[j] < integerArray[min_idx]) {

                        // Update min_idx if a smaller element
                        // is found
                        min_idx = j;
                    }
                }

                // Move minimum element to its
                // correct position
                int temp = integerArray[i];
                integerArray[i] = integerArray[min_idx];
                integerArray[min_idx] = temp;
            }
    }
}
