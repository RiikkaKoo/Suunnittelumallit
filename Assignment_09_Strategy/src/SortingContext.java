public class SortingContext {

    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public double sortArray(int[] integerList) {
        long stratTime = System.currentTimeMillis();
        sortingStrategy.sort(integerList);
        long endTime = System.currentTimeMillis();
        System.out.println("Milliseconds: " + (endTime - stratTime));
        return (double) ((endTime - stratTime) / 1000);
    }
}
