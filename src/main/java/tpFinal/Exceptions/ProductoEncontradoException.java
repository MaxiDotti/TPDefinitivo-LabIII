package tpFinal.Exceptions;

public class ProductoEncontradoException extends Exception{
    private final String mensaje;

    public ProductoEncontradoException(){
        this.mensaje = "El producto ingresado ya se encuentra en la base de datos.";
    }

    public String getMensaje(){
        return this.mensaje;
    }
}
