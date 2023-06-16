package tpFinal.Exceptions;

public class FormatoDNINoCompatibleException extends Exception {

    private final String mensaje;

    public FormatoDNINoCompatibleException(){
        this.mensaje = "El formato del DNI ingresado es incorrecto.";
    }

    public String getMensaje() {
        return mensaje;
    }
}
