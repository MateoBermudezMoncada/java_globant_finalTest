package org.example.dominio;

public class Maquina {
    private int id;
    private String modelo;
    private String numeroSerie;
    private String estado; // "Disponible" o "Alquilada"

    // Constructor vacío
    public Maquina() {
        this.id = 0;
        this.modelo = "";
        this.numeroSerie = "";
        this.estado = "Disponible"; // El estado por defecto es "Disponible"
    }

    // Constructor completo
    public Maquina(int id, String modelo, String numeroSerie, String estado) {
        this.id = id;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.estado = estado;
    }

    public Maquina(int idMaquina) {
    }

    public Maquina(String modelo, String numeroSerie, String estado) {
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Maquina [id=" + id + ", modelo=" + modelo + ", numeroSerie=" + numeroSerie + ", estado=" + estado + "]";
    }
}