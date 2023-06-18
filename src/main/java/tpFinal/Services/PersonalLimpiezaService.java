package tpFinal.Services;

import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Repositorios.EmpleadosRepository.PersonalLimpiezaRepository;
import tpFinal.Utilities.Validations;

public class PersonalLimpiezaService implements IPersonalLimpiezaService {

    Validations validations;

    PersonalLimpiezaRepository personalLimpiezaRepository = new PersonalLimpiezaRepository();

    @Override
    public void listar() {
        personalLimpiezaRepository.listar().forEach(System.out::println);
    }

    @Override
    public void agregar(PersonalLimpieza objeto) {
        try {
            validations.validarPersonalLimpieza(objeto);
            personalLimpiezaRepository.agregar(objeto);
        } catch (FormatoDNINoCompatibleException e) {
            System.out.println(e.getMensaje());
        }
        catch (FormatoUsuarioNoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void modificar(PersonalLimpieza objeto) {
        personalLimpiezaRepository.modificar(objeto);
    }

    @Override
    public void eliminar(String dni) {
        try {
            personalLimpiezaRepository.eliminar(dni);
        } catch (Exception e) {
            System.out.println("No se encuentra el Personal en el archivo.");
        }
    }

    /* Reemplazado por la clase "Validations" ¡¡REVISAR EN CASO DE DUDAS!!
    private boolean validateFields(Usuario personal){
        boolean validFields = true;
        if(!validateDni(personal.getDni())){
            //System.out.println("El formato para el dni es invalido");
            validFields = false;
        }
        if(!validateNombre(personal.getNombre())){
            //System.out.println("El formato para el nombre es invalido");
            validFields = false;
        }
        if(!validateApellido(personal.getApellido())){
            //System.out.println("El formato para el nombre es invalido");
            validFields = false;
        }
        if(!validateTelefono(personal.getTelefono())){
            //System.out.println("El formato para el teléfono es invalido");
            validFields = false;
        }
        return validFields;
    }*/

}