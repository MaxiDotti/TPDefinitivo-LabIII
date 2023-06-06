package tpFinal.Models.Empleado;

import tpFinal.Models.Usuario;

public class Utilero extends Usuario {

    private boolean estadoContable;
    private String deporte;

    public Utilero(){}
    public Utilero(boolean estadoContable, String deporte) {
        this.estadoContable = estadoContable;
        this.deporte = deporte;
    }

    public boolean isEstadoContable() {
        return estadoContable;
    }

    public void setEstadoContable(boolean estadoContable) {
        this.estadoContable = estadoContable;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    void verEstadoContable(){
        if(this.estadoContable){
            System.out.println("Usted a cobrado.");
        }else{
            System.out.println("Aun no posee saldo.");
        }
    }
}
