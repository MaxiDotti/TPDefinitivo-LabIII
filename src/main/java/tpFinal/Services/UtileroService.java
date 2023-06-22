package tpFinal.Services;
import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Empleado.Utilero;
import tpFinal.Repositorios.EmpleadosRepository.UtileroRepository;
import tpFinal.Utilities.Validations;
import java.util.List;

public class UtileroService implements IUtileroService{

    Validations validations = new Validations();

    UtileroRepository utileroRepository = new UtileroRepository();
    @Override
    public List<Utilero> listar() {
        utileroRepository.cargar();
       return this.utileroRepository.listar();
    }

    @Override
    public void agregar(Utilero objeto) {
        try {
            validations.validarUtilero(objeto);
            utileroRepository.cargar();
            if (buscarPersonal(objeto.getDni())) {
                utileroRepository.agregar(objeto);
            }
            utileroRepository.guardar();
        }catch (FormatoDNINoCompatibleException e) {
            System.out.println(e.getMensaje());
        }catch (FormatoUsuarioNoCompatibleException e){
            System.out.println(e.getMensaje());
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }
    }


    @Override
    public void modificar(Utilero objeto) {
        try{
            utileroRepository.cargar();
            if(validations.validarDni(objeto.getDni()) && buscarPersonal(objeto.getDni())){
                utileroRepository.modificar(objeto);
            }
            utileroRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }

    }

    @Override
    public void eliminar(String dni) {
        try {
            utileroRepository.eliminar(dni);
        } catch (Exception e) {
            System.out.println("No se encuentra el Personal en el archivo.");
        }
    }

    public boolean buscarPersonal(String dni) throws ObjetoNoEncontradoException {
        if(utileroRepository.buscar(dni) == null){
            throw new ObjetoNoEncontradoException();
        }
        return true;
    }

    public boolean buscarPersonal2(String dni) throws ObjetoEncontradoException {
        if(utileroRepository.buscar(dni) == null){
            throw new ObjetoEncontradoException();
        }
        return true;
    }
}
