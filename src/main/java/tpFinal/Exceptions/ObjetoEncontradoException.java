package tpFinal.Exceptions;

public class ObjetoEncontradoException extends Exception{
    private final String mensaje;

    public ObjetoEncontradoException(){
        this.mensaje = "El DNI ingresado ya se encuentra registrado.";
    }

    public String getMensaje(){
        return this.mensaje;
    }
}
