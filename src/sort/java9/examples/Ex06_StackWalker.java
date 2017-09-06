package sort.java9.examples;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.lang.StackWalker.StackFrame;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Two ways of walking the current stack trace:
 * <ul>
 *   <li><strong>OLD - </strong>Create a new {@link Throwable} and pull the stack trace</li>
 *   <li><strong>NEW - </strong>Retrieve a {@link StackWalker} and walk the stack</li>
 * </ul>
 * 
 * @author wjohnson000
 *
 */
public class Ex06_StackWalker {
    public static void main(String... args) throws IOException, InterruptedException {
//      System.out.println("Len('ABCDEF'): " + countCharsUgly("ABCDEF"));
        System.out.println("Len('ABCDEF'): " + countChars("ABCDEF"));
    }

    static int countCharsUgly(String someString) {
        System.out.println("=========================================================");
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Arrays.stream(stackTrace).limit(10).forEach(System.out::println);

        if (someString == null) {
            return 0;
        } else if (someString.isEmpty()) {
            return 0;
        } else {
            return 1 + countCharsUgly(someString.substring(1));
        }
    }

    static int countChars(String someString) {
        System.out.println("=========================================================");
        StackWalker walker = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE);
        System.out.println("Caller: " + walker.getCallerClass());
        List<StackFrame> stack = walker.walk(s -> s.limit(10).collect(Collectors.toList()));
        stack.forEach(System.out::println);

        if (someString == null) {
            return 0;
        } else if (someString.isEmpty()) {
            return 0;
        } else {
            return 1 + countChars(someString.substring(1));
        }
    }
}