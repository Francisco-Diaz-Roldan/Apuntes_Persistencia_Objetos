package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        InputStream is = Main.class.getClassLoader().getResourceAsStream("database.properties");
//También sirve         var is = Main.class.getClassLoader().getResourceAsStream("database.properties");

        Properties config = new Properties();

        try {
            //config.load(new FileReader("database.properties"));
            config.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*config.put("version", "1.0");
        try {
            config.store(new FileWriter("database.properties"),"Añadida la version");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        System.out.println(config.get("url"));
        System.out.println(config.get("user"));
        System.out.println(config.get("port"));
        System.out.println(config.get("pass"));
    }
}