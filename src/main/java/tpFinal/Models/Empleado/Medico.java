package tpFinal.Models.Empleado;

import tpFinal.Models.Usuario;

public class Medico extends Usuario {

    private String especialidad;
    private boolean estadoContable;

    public Medico(String especialidad, boolean estadoContable) {
        this.especialidad = especialidad;
        this.estadoContable = estadoContable;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstadoContable() {
        return estadoContable;
    }

    public void setEstadoContable(boolean estadoContable) {
        this.estadoContable = estadoContable;
    }

    void verEstadoContable(){
        if(this.estadoContable){
            System.out.println("Usted a cobrado.");
        }else{
            System.out.println("Aun no posee saldo.");
        }
    }
}
