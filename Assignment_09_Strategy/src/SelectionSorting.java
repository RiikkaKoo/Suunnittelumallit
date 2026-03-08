public class SelectionSorting implements SortingStrategy {

    @Override
    public void sort(int[] integerArray) {
        // SelectionSorting algorithm code is from here:
        // https://www.geeksforgeeks.org/dsa/selection-sort-algorithm-2/

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
