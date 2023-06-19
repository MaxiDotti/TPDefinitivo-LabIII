package tpFinal.Services;

import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Repositorios.EmpleadosRepository.PersonalLimpiezaRepository;
import tpFinal.Utilities.Validations;

import java.util.List;

public class PersonalLimpiezaService implements IPersonalLimpiezaService {

    PersonalLimpiezaRepository personalLimpiezaRepository = new PersonalLimpiezaRepository();
    Validations validations = new Validations();

    @Override
    public List<PersonalLimpieza> listar() {
        personalLimpiezaRepository.cargar();
        return personalLimpiezaRepository.listar();
    }

    @Override
    public void agregar(PersonalLimpieza objeto) {
        try {
            validations.validarPersonalLimpieza(objeto);
            personalLimpiezaRepository.cargar();
            if(buscarPersonal2(objeto.getDni())){
                personalLimpiezaRepository.agregar(objeto);
            }
            personalLimpiezaRepository.guardar();
        } catch (FormatoDNINoCompatibleException e) {
            System.out.println(e.getMensaje());
        } catch (FormatoUsuarioNoCompatibleException e){
            System.out.println(e.getMensaje());
        } catch (ObjetoEncontradoException e){
            System.out.println(e.getMensaje());
        }
    }

    // Se puede modificar CONTRASEÑA, TELEFONO, DIRECCION y SECTOR.
    @Override
    public void modificar(PersonalLimpieza objeto) {
        try{
            personalLimpiezaRepository.cargar();
            if(validations.validarDni(objeto.getDni()) && buscarPersonal(objeto.getDni())){
                personalLimpiezaRepository.modificar(objeto);
            }
            personalLimpiezaRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void eliminar(String dni) {
        try{
            personalLimpiezaRepository.cargar();
            if(validations.validarDni(dni) && buscarPersonal(dni)){
                personalLimpiezaRepository.eliminar(dni);
            }
            personalLimpiezaRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    public boolean buscarPersonal(String dni) throws ObjetoNoEncontradoException {
        if(personalLimpiezaRepository.buscar(dni) == null){
            throw new ObjetoNoEncontradoException();
        }
        return true;
    }

    // buscarPersonal y buscarPersonal2 no se pueden unificar ya hay casos que vamos a necesitar que si lo encuentra o no,
    // no arroje ninguna excepcion. Por ej: en el metodo eliminar o agregar.
    public boolean buscarPersonal2(String dni) throws ObjetoEncontradoException{
        if(personalLimpiezaRepository.buscar(dni) != null){
            throw new ObjetoEncontradoException();
        }
        return true;
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