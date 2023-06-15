package tpFinal.Models;

public class Directivo extends  Usuario{


    public Directivo() {
    }



    @Override
    public String toString() {
        return "Directivo{" +
                super.toString() +
                "}";}

    public Directivo(String nombre, String apellido, String dni, String contrasenia, String telefono, String direccion) {
        super(nombre, apellido, dni, contrasenia, telefono, direccion);

    }
}
