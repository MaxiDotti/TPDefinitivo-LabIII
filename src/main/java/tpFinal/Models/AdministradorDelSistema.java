package tpFinal.Models;

public class AdministradorDelSistema {
    private String dni;
    private String contrasenia;
    private String codigoSecreto;

    public AdministradorDelSistema(String dni, String contrasenia, String codigoSecreto) {
        this.dni = dni;
        this.contrasenia = contrasenia;
        this.codigoSecreto = codigoSecreto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCodigoSecreto() {
        return codigoSecreto;
    }

    public void setCodigoSecreto(String codigoSecreto) {
        this.codigoSecreto = codigoSecreto;
    }

    @Override
    public String toString() {
        return "AdministradorDelSistema{" +
                "dni='" + dni + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", codigoSecreto='" + codigoSecreto + '\'' +
                '}';
    }
}
