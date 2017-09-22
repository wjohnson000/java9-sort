package sort.java9.examples;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Ex10_UTF8PropertiesFail {
    public static void main(String... args) throws IOException {
//        System.setProperty("java.util.PropertyResourceBundle.encoding", "UTF-8");
        try(InputStream inputStream = Ex10_UTF8PropertiesFail.class.getResourceAsStream("utf8.properties")) {
            Properties props = new Properties();
            props.load(inputStream);
            props.forEach((k,v) -> System.out.println(k + " = " + v));
        }
    }
}
