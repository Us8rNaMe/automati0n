package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Red {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/configurations.properties");
        properties.load(fileInputStream);

        System.out.println(properties.getProperty("url"));
        System.out.println(properties.getProperty("userId"));
        System.out.println(properties.getProperty("userPassword"));



    }
}
