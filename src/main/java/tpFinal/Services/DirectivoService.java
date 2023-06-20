package tpFinal.Services;
import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Beneficio;
import tpFinal.Models.Directivo;
import tpFinal.Repositorios.BeneficioRepository;
import tpFinal.Repositorios.DirectivoRepository;
import tpFinal.Utilities.Validations;

import java.util.List;

public class DirectivoService implements IDirectivoService{
    DirectivoRepository directivoRepository = new DirectivoRepository();
    Validations validations = new Validations();

    @Override
    public List<Directivo> listar() {
        directivoRepository.cargar();
        return directivoRepository.listar();
    }

    @Override
    public void agregar(Directivo objeto) {
        try {
            validations.validarDirectivo(objeto);
            directivoRepository.cargar();
            if(buscarDirectivo2(objeto.getDni())){
                directivoRepository.agregar(objeto);
            }
            directivoRepository.guardar();
        } catch (FormatoDNINoCompatibleException e) {
            System.out.println(e.getMensaje());
        } catch (FormatoUsuarioNoCompatibleException e){
            System.out.println(e.getMensaje());
        } catch (ObjetoEncontradoException e){
            System.out.println(e.getMensaje());
        }
    }

    // Se puede modificar CONTRASEÑA, TELEFONO O DIRECCION.
    @Override
    public void modificar(Directivo objeto) {
        try{
            directivoRepository.cargar();
            if(validations.validarDni(objeto.getDni()) && buscarDirectivo(objeto.getDni())){
                directivoRepository.modificar(objeto);
            }
            directivoRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void eliminar(String dni) {
        try{
            directivoRepository.cargar();
            if(validations.validarDni(dni) && buscarDirectivo(dni)){
                directivoRepository.eliminar(dni);
            }
            directivoRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    public boolean buscarDirectivo(String dni) throws ObjetoNoEncontradoException {
        if(directivoRepository.buscar(dni) == null){
            throw new ObjetoNoEncontradoException();
        }
        return true;
    }

    // buscarDirectivo y buscarDirectivo2 no se pueden unificar ya hay casos que vamos a necesitar que si lo encuentra o no,
    // no arroje ninguna excepcion. Por ej: en el metodo eliminar o agregar.
    public boolean buscarDirectivo2(String dni) throws ObjetoEncontradoException{
        if(directivoRepository.buscar(dni) != null){
            throw new ObjetoEncontradoException();
        }
        return true;
    }

    @Override
    public void agregarBeneficio() {

    }

    @Override
    public void modificarBeneficio() {

    }

    @Override
    public void eliminarBeneficio() {

    }
}
