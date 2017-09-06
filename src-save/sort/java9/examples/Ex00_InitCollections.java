package sort.java9.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Illustrates how to create immutable collections (List, Set or Map) using the ".of(...)"
 * operator.  NOTE: if you look at the underlying code, there are methods that take between
 * zero and nine parameters, and an additional one taking a VARARG.  This pattern is altered
 * for the "Map" factory.
 * 
 * @author wjohnson000
 *
 */
public class Ex00_InitCollections {
    public static void main(String... args) {
        createListOld();
        createList();
        createSet();
        createMap();
        createLargeMap();
    }

    /**
     * Create an immutable 'List' of values
     */
    static void createListOld() {
        List<String> numbers = Arrays.asList("one", "two", "three", "four");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Creating a 'List' ...");
        System.out.println("  Class: " + numbers.getClass().getName());
        System.out.println("  Value: " + numbers);

        // The following operation is invalid
//      numbers.add("five");
    }

    /**
     * Create an immutable 'List' of values
     */
    static void createList() {
        List<String> numbers = List.of("one", "two", "three", "four");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Creating a 'List' ...");
        System.out.println("  Class: " + numbers.getClass().getName());
        System.out.println("  Value: " + numbers);

        // The following operation is invalid
//      numbers.add("five");
    }

    /**
     * Create an immutable 'Set' of values
     */
    static void createSet() {
        Set<String> numbers = Set.of("one", "two", "three", "four");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Creating a 'Set' ...");
        System.out.println("  Class: " + numbers.getClass().getName());
        System.out.println("  Value: " + numbers);
    }

    /**
     * Create an immutable 'Map' of values
     */
    static void createMap() {
        Map<Integer,String> numbers = Map.of(1, "one", 2, "two", 3, "three", 4, "four");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Creating a 'Map' ...");
        System.out.println("  Class: " + numbers.getClass().getName());
        System.out.println("  Value: " + numbers);
    }

    /**
     * Create an immutable 'Map' of values, with lots of entries
     */
    static void createLargeMap() {
        Map<Integer,String> numbers = Map.ofEntries(
            Map.entry( 1, "one"),
            Map.entry( 2, "two"),
            Map.entry( 3, "three"),
            Map.entry( 4, "four"),
            Map.entry( 5, "five"),
            Map.entry( 6, "six"),
            Map.entry( 7, "seven"),
            Map.entry( 8, "eight"),
            Map.entry( 9, "nine"),
            Map.entry(10, "ten"),
            Map.entry(11, "eleven"),
            Map.entry(12, "a-dozen")
        );

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Creating a 'Map' ...");
        System.out.println("  Class: " + numbers.getClass().getName());
        System.out.println("  Value: " + numbers);
    }
}