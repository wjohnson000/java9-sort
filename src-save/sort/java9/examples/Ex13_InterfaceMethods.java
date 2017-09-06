package sort.java9.examples;

import java.util.stream.IntStream;

/**
 * There is a slight improvement in this version of the class with regards to the common
 * method "sumAll(...)" that can be used by both of the "real" methods. 
 * <p/>
 * Unfortunately in Java 1.8 the new method must be declared as "default", and hence will
 * be part of the public interface, even if that is not desired.
 * <p/>
 * The fixed version of the code is in example {@link Ex14_InterfaceMethods}.
 * 
 * @author wjohnson000
 *
 */
public interface Ex13_InterfaceMethods {

    default boolean hasEvenSum(int... values) {
        return sumAll(values) % 2 == 0;
    }

    default boolean hasOddSum(int... values) {
        return sumAll(values) % 2 == 1;
    }

    // This method perforce becomes public, which may not be desirable
    default int sumAll(int... values) {
        return IntStream.of(values).sum();
    }
}
