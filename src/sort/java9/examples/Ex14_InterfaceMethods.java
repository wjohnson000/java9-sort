package sort.java9.examples;

import java.util.stream.IntStream;

/**
 * The "sumAll(...)" can now be defined as <strong>private int</strong> instead of
 * <strong>default int</strong>, excluding it from the public API.
 * @author wjohnson000
 *
 */
public interface Ex14_InterfaceMethods {

    default boolean hasEvenSum(int... values) {
        return sumAll(values) % 2 == 0;
    }

    default boolean hasOddSum(int... values) {
        return sumAll(values) % 2 == 1;
    }

    // Java 9 allows private methods
    private int sumAll(int... values) {
        int sum = IntStream.of(values).sum();
        return sum;
    }

}
