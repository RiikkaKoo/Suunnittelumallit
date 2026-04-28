import java.util.Iterator;

public class FibonacciSequence implements Sequence {

    private int length;

    public FibonacciSequence(){
        this.length = Integer.MAX_VALUE; // Make length infinite if no parameter is given
    }

    public FibonacciSequence(int length){
        this.length = length;
    }

    // Not sure why we want
    // "This class should have a method to generate the next Fibonacci number when requested by the iterator",
    // but here is a method for calculating the next number.
    public int nextValue(int first, int second) {
        return first + second;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }
}
