package sort.java9.examples;

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;

public class Ex11_UTF8PropertiesFixed {
    public static void main(String... args) throws IOException {
        try(InputStream is = Ex11_UTF8PropertiesFixed.class.getResourceAsStream("utf8.properties")) {
            PropertyResourceBundle propBundle = new PropertyResourceBundle(is);
            propBundle.getKeys().asIterator().forEachRemaining(k -> System.out.println(k + " = " + propBundle.getString(k)));
        }
    }
}
