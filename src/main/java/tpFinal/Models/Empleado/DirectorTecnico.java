package tpFinal.Models.Empleado;

import tpFinal.Models.Usuario;

public class DirectorTecnico extends Usuario {

    private boolean estadoContable;

    private String plantel;

    public DirectorTecnico(boolean estadoContable, String plantel) {
        this.estadoContable = estadoContable;
        this.plantel = plantel;
    }

    public boolean isEstadoContable() {
        return estadoContable;
    }

    public void setEstadoContable(boolean estadoContable) {
        this.estadoContable = estadoContable;
    }

    public String getPlantel() {
        return plantel;
    }

    public void setPlantel(String plantel) {
        this.plantel = plantel;
    }

    void verEstadoContable(){
        if(this.estadoContable){
            System.out.println("Usted a cobrado.");
        }else{
            System.out.println("Aun no posee saldo.");
        }
    }


}
