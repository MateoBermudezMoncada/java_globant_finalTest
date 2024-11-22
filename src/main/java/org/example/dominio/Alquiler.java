package org.example.dominio;

import java.util.Date;

public class Alquiler {
    private int id;
    private Cliente cliente;  // Relación con Cliente
    private Maquina maquina;  // Relación con Maquina
    private Date fechaInicio;
    private Date fechaFin;
    private String estado; // "Activo" o "Desactivado"

    // Constructor vacío
    public Alquiler() {
        this.id = 0;
        this.cliente = null;
        this.maquina = null;
        this.fechaInicio = null;
        this.fechaFin = null;
        this.estado = "Activo"; // Estado por defecto
    }

    // Constructor completo
    public Alquiler(int id, Cliente cliente, Maquina maquina, Date fechaInicio, Date fechaFin, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.maquina = maquina;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Alquiler(int idAlquiler) {
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Maquina getMaquina() { return maquina; }
    public void setMaquina(Maquina maquina) { this.maquina = maquina; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Alquiler [id=" + id + ", cliente=" + cliente + ", maquina=" + maquina + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + "]";
    }
}