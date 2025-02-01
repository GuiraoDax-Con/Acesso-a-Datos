package Baloncesto.Data.Second;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Autor: Daniel Guirao Coronado
 */
@Entity
@Table(name="pabellon")
public class Pabellon {

    @Id
    @Column(name="codigo_pabellon", length = 2)
    private String codigoPabellon;

    @Column(length=50)
    private String nombre;

    // Constructor
    public Pabellon() {
    }
    public Pabellon(String codigoPabellon, String nombre) {
        this.codigoPabellon = codigoPabellon;
        this.nombre = nombre;
    }

    // Getters and Setters
    public String getCodigoPabellon() {
        return codigoPabellon;
    }
    public void setCodigoPabellon(String codigoPabellon) {
        this.codigoPabellon = codigoPabellon;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString
    @Override
    public String toString() {
        return "Pabellon [codigoPabellon=" + codigoPabellon + ", nombre=" + nombre + "]";
    }
}
