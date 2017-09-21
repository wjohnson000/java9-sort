package sort.java9.examples;

public class Ex99_DumpSystemProperties {
    public static void main(String... args) {
        System.getProperties().forEach((k,v) -> System.out.println(k + " --> " + v));
    }
}
