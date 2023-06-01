package tpFinal.Models.Empleado;

import tpFinal.Models.Usuario;

public class DirectorTecnico extends Usuario {

    private boolean estadoContable;
    private String plantel;
    private String deporte;
    private String categoria;

    public DirectorTecnico(boolean estadoContable, String plantel, String deporte, String categoria) {
        this.estadoContable = estadoContable;
        this.plantel = plantel;
        this.deporte = deporte;
        this.categoria = categoria;
    }

    public DirectorTecnico(){}

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

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    void verEstadoContable(){
        if(this.estadoContable){
            System.out.println("Usted a cobrado.");
        }else{
            System.out.println("Aun no posee saldo.");
        }
    }

}
