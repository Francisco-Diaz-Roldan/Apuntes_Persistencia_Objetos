package org.example;

import org.example.model.Alumno;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

    Alumno fer = new Alumno();
    fer.setNombre("Fernando");
    fer.setApellido("Perez");

    Alumno pablo = new Alumno();
    pablo.setNombre("Pablo");
    pablo.setApellido("Postigo");

    var clase = new ArrayList<Alumno>();
    clase.add(pablo);
    clase.add(fer);
    System.out.println(clase);

    }


    public static void main2(String[] args) {

        InputStream is = Main.class.getClassLoader().getResourceAsStream("database.properties");
//También sirve         var is = Main.class.getClassLoader().getResourceAsStream("database.properties");

        Properties config = new Properties();

        try {
            //config.load(new FileReader("database.properties"));
            config.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Para guardarlo como XML
        try {
            config.storeToXML(new FileOutputStream("datanase.properties"),"ok");
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