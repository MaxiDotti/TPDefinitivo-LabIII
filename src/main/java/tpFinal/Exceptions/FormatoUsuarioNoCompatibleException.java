package tpFinal.Exceptions;

public class FormatoUsuarioNoCompatibleException extends Exception{

    private final String mensaje;

    public FormatoUsuarioNoCompatibleException(){
        this.mensaje = "El formato de uno o más campos no son compatibles.";
    }

    public String getMensaje() {
        return this.mensaje;
    }
}
