package org.example.dominio;

import java.util.List;

public class Cliente {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

    private List<Alquiler> alquileres; // Relación con los alquileres


    // Constructor completo
    public Cliente(int id, String nombre, String correo, String telefono, String direccion, List<Alquiler> alquileres) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.alquileres = alquileres;
    }

    public Cliente(String nombre, String correo, String telefono, String direccion) {
    }

    public Cliente() {

    }

    public Cliente(int idCliente) {
    }

    // Métodos getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + ", alquileres=" + alquileres + "]";
    }
}