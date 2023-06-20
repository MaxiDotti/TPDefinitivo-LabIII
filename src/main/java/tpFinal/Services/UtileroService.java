package tpFinal.Services;

import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Models.Empleado.Utilero;
import tpFinal.Repositorios.EmpleadosRepository.UtileroRepository;
import tpFinal.Utilities.Validations;

import java.util.List;

public class UtileroService implements IUtileroService{

    Validations validations;

    UtileroRepository utileroRepository = new UtileroRepository();
    @Override
    public List<Utilero> listar() {
       return this.utileroRepository.listar();
    }

    @Override
    public void agregar(Utilero objeto) {
        try {
            validations.validarUtilero(objeto);
            utileroRepository.agregar(objeto);
        }catch (FormatoDNINoCompatibleException e) {
            System.out.println(e.getMensaje());
        }catch (FormatoUsuarioNoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void modificar(Utilero objeto) {
        utileroRepository.modificar(objeto);
    }

    @Override
    public void eliminar(String dni) {
        try {
            utileroRepository.eliminar(dni);
        } catch (Exception e) {
            System.out.println("No se encuentra el Personal en el archivo.");
        }
    }
}
