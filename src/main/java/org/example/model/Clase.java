package org.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Clase implements Serializable {
    private ArrayList<Alumno>alumnos = new ArrayList<>(0);
}

//Hacemos esta segunda clase para que lo reconozca el mapper
