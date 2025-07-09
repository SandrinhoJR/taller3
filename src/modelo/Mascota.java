/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import modelo.Historial;

/**
 *
 * @author sandro rendon
 */
public class Mascota {

    // Nombre de la mascota
    private String nombre;

    // Tipo de animal, por ejemplo: perro, gato, etc.
    private String especie;

    // Edad en años
    private int edad;

    // private ArrayList<Consulta> consultas;
    // Antes se usaba una lista directamente en esta clase para guardar las consultas
    // ✅ Refactor: delegar a clase Historial
    private Historial historial; // Ahora usamos una clase aparte para manejar las consultas

    // Constructor para crear una mascota con su nombre, especie y edad
    public Mascota(String nombre, String especie, int edad) {
        /* this.nombre = nombre;
           this.especie = especie;
           this.edad = edad;
         */
        // ✅ Refactor: usar setters + historial
        setNombre(nombre); // Se valida y asigna el nombre
        setEspecie(especie); // Se valida y asigna la especie
        setEdad(edad); // Se valida y asigna la edad
        this.historial = new Historial(); // Se crea el historial vacío
    }

    public void agregarConsulta(Consulta consulta) {
        // consultas.add(consulta);
        historial.agregarConsulta(consulta); // ✅ delegar: ahora se agrega al historial
    }

    // Devuelve el nombre de la mascota
    public String getNombre() {
        return nombre;
    }

    /*
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido."); // Validación básica
        }
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        if (especie == null || especie.isBlank()) {
            throw new IllegalArgumentException("Especie inválida."); // Validación básica
        }
        this.especie = especie;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad no puede ser negativa."); // Validación básica
        }
        this.edad = edad;
    }

    // Devuelve la especie de la mascota
    public String getEspecie() {
        return especie;
    }

    /*
    public void setEspecie(String especie) {
        this.especie = especie;
    }
     */
    // Devuelve la edad actual
    public int getEdad() {
        return edad;
    }

    /*
    public void setEdad(int edad) {
        this.edad = edad;
    }
     */
    // Método para mostrar el historial de la mascota
    public void mostrarHistorial() {
        System.out.println("📋 Mascota: " + nombre + " | Especie: " + especie + " | Edad: " + edad + " años");
        System.out.println("Historial de consultas:");

        historial.mostrarConsultas(); // ✅ nuevo método: se encarga de imprimir las consultas
    }

    // Devuelve toda la info de la mascota como un texto ordenado
    @Override
    public String toString() {
        String info = "Nombre: " + nombre + "\n";
        info += "Especie: " + especie + "\n";
        info += "Edad: " + edad + " anios\n";
        info += "\n";
        info += "Historial de consultas: \n";
        info += historial.mostrarConsultas(); // Se agrega el texto del historial

        return info;
    }
}
