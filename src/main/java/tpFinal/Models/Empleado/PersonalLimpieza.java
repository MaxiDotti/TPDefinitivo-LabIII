package tpFinal.Models.Empleado;

import tpFinal.Models.Usuario;

public class PersonalLimpieza extends Usuario {
    private String sector;
    private boolean estadoContable;

    ///CONSTRUCTORES


    public PersonalLimpieza(String nombre, String apellido, String dni, String contrasenia, String telefono, String direccion, String sector, boolean estadoContable) {
        super(nombre, apellido, dni, contrasenia, telefono, direccion);
        this.sector = sector;
        this.estadoContable = estadoContable;
    }

    public PersonalLimpieza() {
    }

    ///GETTERS & SETTERS


    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public boolean isEstadoContable() {
        return estadoContable;
    }

    public void setEstadoContable(boolean estadoContable) {
        this.estadoContable = estadoContable;
    }

    @Override
    public String toString() {
        return "PersonalLimpieza{" +
                "sector='" + sector + '\'' +
                ", estadoContable=" + estadoContable +
                '}' +
                super.toString();
    }
}
