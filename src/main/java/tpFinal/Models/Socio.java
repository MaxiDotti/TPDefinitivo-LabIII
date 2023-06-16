package tpFinal.Models;
import java.io.Serializable;

public class Socio extends Usuario implements Serializable {
    private boolean estadoContable; /// DEUDOR o AL DIA

    public Socio(String nombre, String apellido, String dni, String contrasenia, String telefono, String direccion, boolean estadoContable) {
        super(nombre, apellido, dni, contrasenia, telefono, direccion);
        this.estadoContable = estadoContable;
    }
    public Socio(){}

    public boolean isEstadoContable() {
        return estadoContable;
    }

    public void setEstadoContable(boolean estadoContable) {
        this.estadoContable = estadoContable;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "Estado contable: " + estadoContable + super.toString();
    }
}
