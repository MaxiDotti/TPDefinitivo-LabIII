package tpFinal.Models;
import tpFinal.Utilities.Deporte;

import java.io.Serializable;

public class Socio extends Usuario implements Serializable {

    private Deporte deporte;
    private boolean estadoContable; /// DEUDOR o AL DIA

    public Socio(String nombre, String apellido, String dni, String contrasenia, String telefono, String direccion, Deporte deporte, boolean estadoContable) {
        super(nombre, apellido, dni, contrasenia, telefono, direccion);
        this.deporte = deporte;
        this.estadoContable = estadoContable;
    }

    public Socio() {
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public boolean isEstadoContable() {
        return estadoContable;
    }

    public void setEstadoContable(boolean estadoContable) {
        this.estadoContable = estadoContable;
    }

    @Override
    public String toString() {
        return "\n╔═  Socio: " + " ══════════════════════════" + '\n' +
                 super.toString() + '\n' +
                "╠═ Deporte:" + getDeporte() + '\n' +
                "╠═ Estado Contable: " + isEstadoContable() + "\n" +
                "╚══════════════════════════════════════\n";
    }

}
