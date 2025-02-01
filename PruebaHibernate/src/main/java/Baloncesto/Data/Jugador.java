package Baloncesto.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Autor: Daniel Guirao Coronado
 */
@Entity
@Table(name="jugadores")
public class Jugador {
    @Id
    @Column(name="codigo_jugador")
    private int codJugador;

    @Column(name="nombre_jugador")
    private String nombreJugador;

    @Column(name="puesto")
    private String puesto;

    @Column(name="estatura")
    private int estatura;

    @Column(name="equipo")
    private int codEquipo;

        // Getters y Setters
    public int getCodEquipo() {
        return codEquipo;
    }
    public void setCodEquipo(int codEquipo) {
        this.codEquipo = codEquipo;
    }

    public int getEstatura() {
        return estatura;
    }
    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getCodJugador() {
        return codJugador;
    }
    public void setCodJugador(int codJugador) {
        this.codJugador = codJugador;
    }

    // toString
    @Override
    public String toString() {
        return "Jugador [codJugador=" + codJugador + ", nombreJugador=" + nombreJugador + ", puesto=" + puesto + ", estatura=" + estatura + ", codEquipo=" + codEquipo + "]";
    }
}
