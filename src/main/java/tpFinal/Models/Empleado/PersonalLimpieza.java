package tpFinal.Models.Empleado;

import tpFinal.Models.Usuario;

public class PersonalLimpieza extends Usuario {
    private String sector;
    private boolean estadoContable;

    ///CONSTRUCTORES
    public PersonalLimpieza(String sector, boolean estadoContable) {
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
}
