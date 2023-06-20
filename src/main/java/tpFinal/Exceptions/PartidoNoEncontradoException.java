package tpFinal.Exceptions;

public class PartidoNoEncontradoException extends Exception {

    private final String mensaje;

    public PartidoNoEncontradoException(){
        this.mensaje = "ID de partido no encontrado.";
    }

    public String getMensaje() {
        return mensaje;
    }
}
