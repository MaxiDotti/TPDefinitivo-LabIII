package tpFinal.Utilities;

import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Models.Empleado.Utilero;
import tpFinal.Models.Socio;
import tpFinal.Services.UtileroService;

public class Validations extends Exception{

    /*public boolean validarUsuario(Usuario usuario) throws FormatoDNINoCompatibleException, FormatoUsuarioNoCompatibleException {
        if(!validateDni(usuario.getDni())){
            throw new FormatoDNINoCompatibleException();
        }
        if(!validateTelefono(usuario.getTelefono()) || !validateNombre(usuario.getNombre()) || !validateApellido(usuario.getApellido())){
            throw new FormatoUsuarioNoCompatibleException();
        }
        return true;
    }*/

    public boolean validarPersonalLimpieza(PersonalLimpieza personalLimpieza) throws FormatoDNINoCompatibleException, FormatoUsuarioNoCompatibleException {
        if(!validateDni(personalLimpieza.getDni())){
            throw new FormatoDNINoCompatibleException();
        }
        if(!validateTelefono(personalLimpieza.getTelefono()) || !validateNombre(personalLimpieza.getNombre()) || !validateApellido(personalLimpieza.getApellido())){
            throw new FormatoUsuarioNoCompatibleException();
        }
        return true;
    }

    public boolean validarUtilero(Utilero utilero) throws FormatoDNINoCompatibleException, FormatoUsuarioNoCompatibleException {
        if(!validateDni(utilero.getDni())){
            throw new FormatoDNINoCompatibleException();
        }
        if(!validateTelefono(utilero.getTelefono()) || !validateNombre(utilero.getNombre()) || !validateApellido(utilero.getApellido())){
            throw new FormatoUsuarioNoCompatibleException();
        }
        return true;
    }


    public boolean validarSocio(Socio socio) throws FormatoDNINoCompatibleException, FormatoUsuarioNoCompatibleException {
        if(!validateDni(socio.getDni())){
            throw new FormatoDNINoCompatibleException();
        }
        if(!validateTelefono(socio.getTelefono()) || !validateNombre(socio.getNombre()) || !validateApellido(socio.getApellido())){
            throw new FormatoUsuarioNoCompatibleException();
        }
        return true;
    }

    public boolean validarDirectivo(Directivo directivo) throws FormatoDNINoCompatibleException, FormatoUsuarioNoCompatibleException {
        if(!validateDni(directivo.getDni())){
            throw new FormatoDNINoCompatibleException();
        }
        if(!validateTelefono(directivo.getTelefono()) || !validateNombre(directivo.getNombre()) || !validateApellido(directivo.getApellido())){
            throw new FormatoUsuarioNoCompatibleException();
        }
        return true;
    }

    //EN CASO DE QUE LA VALIDACIÓN DEL DNI FALLE, ARROJAMOS EXCEPCIÓN
    public boolean validarDni(String dni) throws FormatoDNINoCompatibleException {
        if(!validateDni(dni)){
            throw new FormatoDNINoCompatibleException();
        }
        return true;
    }
    //VALIDAMOS QUE EL VALOR INGRESADO COINCIDA CON NUMEROS DEL CERO AL NUEVE
    public boolean validateDni(String dni){
        return dni.matches("[0-9]+");
    }

    public boolean validateTelefono(String telefono) {
        return telefono.matches("[0-9]+");
    }

    public boolean validateNombre(String nombre)  {
        return nombre.matches("[a-zA-Z]+");
    }

    public boolean validateApellido(String apellido) {
        return apellido.matches("[a-zA-Z]+");
    }

}
