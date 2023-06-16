package tpFinal.Utilities;

import tpFinal.Models.Usuario;

public class Utils {

    public static boolean validateFields(Usuario personal){
        boolean validFields = true;
        if(!validateDni(personal.getDni())){
            System.out.println("El formato para el dni es invalido");
            validFields = false;
        }
        if(!validateNombre(personal.getNombre())){
            System.out.println("El formato para el nombre es invalido");
            validFields = false;
        }
        if(!validateApellido(personal.getApellido())){
            System.out.println("El formato para el nombre es invalido");
            validFields = false;
        }
        if(!validateTelefono(personal.getTelefono())){
            System.out.println("El formato para el teléfono es invalido");
            validFields = false;
        }
        return validFields;
    }

    private static boolean validateDni(String dni){
        return dni.matches("[0-9]+");
    }

    private static boolean validateTelefono(String telefono){
        return telefono.matches("[0-9]+");
    }

    private static boolean validateNombre(String nombre){
        return nombre.matches("[a-zA-Z]+");
    }

    private static boolean validateApellido(String apellido){
        return apellido.matches("[a-zA-Z]+");
    }
}
