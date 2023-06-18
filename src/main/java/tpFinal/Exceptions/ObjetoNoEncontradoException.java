package tpFinal.Exceptions;

public class ObjetoNoEncontradoException extends Exception{

    private final String mensaje;

    public ObjetoNoEncontradoException(){
        this.mensaje = "Lo solicitado no se encuentra en nuestros registros.";
    }

    public String getMensaje(){
        return this.mensaje;
    }

}
