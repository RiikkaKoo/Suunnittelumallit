import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {

    // Fibonacci calculation state is maintained in this FibonacciIterator class.
    // This makes it possible to iterate through the same sequence with different iterators
    // if we want to start the iteration process from the start. These are "single use" iterators.
    private int first;
    private int second;
    private int counter;
    private FibonacciSequence fibSequence;

    public FibonacciIterator(FibonacciSequence fibSequence) {
        this.second = 1;
        this.first = 0;
        this.fibSequence = fibSequence;
    }

    @Override
    public boolean hasNext() {
        return fibSequence.getLength() > counter;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int fibNumber = second;
            int newValue = fibSequence.nextValue(first, second);
            this.first = this.second;
            this.second = newValue;
            counter++;
            return fibNumber;
        } else {
            throw new NoSuchElementException("Iterator is done iterating this sequence.");
        }
    }
}
