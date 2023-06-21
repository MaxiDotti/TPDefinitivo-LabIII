package tpFinal.Exceptions;

public class BeneficioNuloException extends Exception{

    private final String mensaje;

    public BeneficioNuloException(){
        this.mensaje = "El beneficio no contiene datos.";
    }

    public String getMensaje(){
        return this.mensaje;
    }

}
