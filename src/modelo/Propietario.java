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
// Clase Propietario para guardar los datos del dueño de las mascotas
public class Propietario {

    // Nombre del dueño
    private String nombre;

    // Documento de identidad (puede ser cédula, por ejemplo)
    private String documento;

    // Número de teléfono del propietario
    private String telefono;

    // Lista de mascotas que tiene este dueño
    private ArrayList<Mascota> mascotas;

    // Constructor que pide los datos del propietario al crearlo
    public Propietario(String nombre, String documento, String telefono) {
        /*this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
         */
        // ✅ Refactor: ahora usamos setters para validar los datos
        setNombre(nombre);
        setDocumento(documento);
        setTelefono(telefono);

        // Se crea la lista de mascotas vacía (aún no tiene registradas)
        this.mascotas = new ArrayList<>();
    }

    // Devuelve el nombre del propietario
    public String getNombre() {
        return nombre;
    }

    /*
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     */
    // ✅ Refactor: validación del nombre
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    // Devuelve el número de documento del dueño
    public String getDocumento() {
        return documento;
    }

    /*
    public void setDocumento(String documento) {
        this.documento = documento;
    }
     */
    // ✅ Refactor: validación del documento
    public void setDocumento(String documento) {
        if (documento == null || documento.length() < 5           ) {
            throw new IllegalArgumentException("Documento inválido.");
        }
        this.documento = documento;
    }

    // Devuelve el teléfono guardado
    public String getTelefono() {
        return telefono;
    }

    /*
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
     */
    // ✅ Refactor: validación del teléfono
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 7) {
            throw new IllegalArgumentException("Teléfono inválido.");
        }
        this.telefono = telefono;
    }

    // Método para agregar una mascota a la lista del propietario
    public void agregarMascota(Mascota mascota) {
        if (mascota != null) {
            mascotas.add(mascota); // Solo se agrega si no es null
        }
    }

    // Devuelve la lista de mascotas de este propietario
    public ArrayList<Mascota> getMascotas() {
        // return mascotas;
        return new ArrayList<>(mascotas); // Se devuelve una copia para proteger la lista original
    }

    // Muestra toda la información del propietario
    public String mostrarInformacion() {
        String info = "Nombre: " + nombre + "\n";
        info += "Documento: " + documento + "\n";
        info += "Telefono: " + telefono + "\n";
        return info;
    }

    public String mostrarMascotas() {
        // Recorre la lista de mascotas y muestra los datos de cada una
        String info = " ";
        for (Mascota mascota : mascotas) {
            info += " \n -- Mascota --\n" + mascota.toString() + "\n";
        }
        return info;
    }
}
