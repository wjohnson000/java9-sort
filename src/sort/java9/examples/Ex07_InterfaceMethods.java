package sort.java9.examples;

import java.util.stream.IntStream;

/**
 * This simple interface has two <strong>default</strong> methods, a feature which has been
 * available since Java 1.8.  But notice that the duplicate code in both methods to generate
 * the sum of the given integer values.
 * <p/>
 * The refactored version of the code is in example {@link Ex08_InterfaceMethods}.
 * 
 * @author wjohnson000
 *
 */
public interface Ex07_InterfaceMethods {

    default boolean hasEvenSum(int... values) {
        int sum = IntStream.of(values).sum();
        return sum % 2 == 0;
    }

    default boolean hasOddSum(int... values) {
        int sum = IntStream.of(values).sum();
        return sum % 2 == 1;
    }

}
