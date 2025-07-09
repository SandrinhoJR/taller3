/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author sandro rendon
 */
public class Historial {

    private ArrayList<Consulta> consultas;

    public Historial() {
        this.consultas = new ArrayList<>();
// Se crea una lista vacía para guardar las consultas de la mascota

    }

// Método para agregar una consulta a la lista
    public void agregarConsulta(Consulta consulta) {
        if (consulta != null) {
            consultas.add(consulta); // Si la consulta no es nula, se agrega a la lista
        }
    }

// Método para mostrar todas las consultas de la mascota
    public String mostrarConsultas() {
        String info = ""; // Variable para guardar el texto con la información

        if (consultas.isEmpty()) {
            // Si no hay consultas, se muestra un mensaje
            System.out.println("Sin consultas registradas.");
        } else {
            // Si hay consultas, se recorre la lista y se agrega cada una al texto
            for (Consulta c : consultas) {
                info += c.toString() + "\n" + "------------------" + "\n";
            }
        }
        return info; // Se devuelve el texto con toda la información
    }

// Método para obtener la lista de consultas (se devuelve una copia)
    public ArrayList<Consulta> getConsultas() {
        return new ArrayList<>(consultas); // Se devuelve una nueva lista con las mismas consultas
    }
}
