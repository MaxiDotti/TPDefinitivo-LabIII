package tpFinal.Models;

import java.io.Serializable;

public class AdministradorDelSistema extends Usuario implements Serializable{
    private String codigoSecreto;

    public AdministradorDelSistema(String nombre, String apellido, String dni, String contrasenia, String telefono, String direccion, String codigoSecreto) {
        super(nombre, apellido, dni, contrasenia, telefono, direccion);
        this.codigoSecreto = codigoSecreto;
    }

    public AdministradorDelSistema(){}

    public String getCodigoSecreto() {
        return codigoSecreto;
    }

    public void setCodigoSecreto(String codigoSecreto) {
        this.codigoSecreto = codigoSecreto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdministradorDelSistema that)) return false;
        if (!super.equals(o)) return false;

        return codigoSecreto.equals(that.codigoSecreto);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + codigoSecreto.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return  super.toString();
    }
}
