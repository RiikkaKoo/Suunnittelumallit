public class BubbleSorting implements SortingStrategy {

    @Override
    public void sort(int[] integerArray) {
        // BubbleSorting algorithm code is from here:
        // https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/

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
