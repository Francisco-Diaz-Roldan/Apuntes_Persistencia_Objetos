package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    //Para que esto funcione implementar Serializable a la clase Alumno
        /*try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clase.obj"));
            oos.writeObject(clase);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        guardarClase(clase);

        //Para leer este archivo
        var clase2 = new ArrayList<Alumno>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clase.obj"))){
            clase2=(ArrayList<Alumno>) ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(clase2);

        //Para convertir a json
        var mapper = new ObjectMapper().writerWithDefaultPrettyPrinter();

        //Creo...
        try {
            mapper.writeValue(new File("clase.json"),clase);//Para guardarlo en un archivo
            System.out.println(mapper.writeValueAsString(clase));//Para imprimirlo por consola
        } catch (IOException e) {
            throw new RuntimeException(e);
        }//Como almaceno en un archivo hago u  try/catch


    }

    private static void guardarClase(ArrayList<Alumno> clase) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clase.obj"))) {
            oos.writeObject(clase);
        } catch (IOException e) {
        throw new RuntimeException(e);
        }
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