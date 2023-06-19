package tpFinal.Models.Empleado;

import tpFinal.Models.Usuario;
import tpFinal.Utilities.Deporte;

public class Jugador extends Usuario {
    private String equipo;
    private String categoria;
    private String deporte;
    private String posicion;
    private Boolean estadoContable;


    ///Constructores


    public Jugador(String nombre, String apellido, String dni, String contrasenia, String telefono, String direccion, String equipo, String categoria, String deporte, String posicion, Boolean estadoContable) {
        super(nombre, apellido, dni, contrasenia, telefono, direccion);
        this.equipo = equipo;
        this.categoria = categoria;
        this.deporte = deporte;
        this.posicion = posicion;
        this.estadoContable = estadoContable;
    }

    public Jugador() {
    }

    ///GETTERS & SETTERS


    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Boolean getEstadoContable() {
        return estadoContable;
    }

    public void setEstadoContable(Boolean estadoContable) {
        this.estadoContable = estadoContable;
    }


}
