package tpFinal.Services;

import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Utilities.Validations;

import java.util.List;

public class SocioService implements ISocioService{

    SociosRepository sociosRepository = new SociosRepository();
    BeneficioService beneficioService = new BeneficioService();
    ProductoService productoService = new ProductoService();
    PartidoService partidoService = new PartidoService();
    Validations validations = new Validations();

    @Override
    public List<Socio> listar() {
        sociosRepository.cargar();
        return sociosRepository.listar();
    }

    @Override
    public void agregar(Socio objeto) {
        try {
            validations.validarSocio(objeto);
            sociosRepository.cargar();
            if(buscarSocio2(objeto.getDni())){
                sociosRepository.agregar(objeto);
            }
            sociosRepository.guardar();
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
    public void modificar(Socio objeto) {
        try{
            sociosRepository.cargar();
            if(validations.validarDni(objeto.getDni()) && buscarSocio(objeto.getDni())){
                sociosRepository.modificar(objeto);
            }
            sociosRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void eliminar(String dni) {
        try{
            sociosRepository.cargar();
            if(validations.validarDni(dni) && buscarSocio(dni)){
                sociosRepository.eliminar(dni);
            }
            sociosRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    public boolean buscarSocio(String dni) throws ObjetoNoEncontradoException{
        if(sociosRepository.buscar(dni) == null){
            throw new ObjetoNoEncontradoException();
        }
        return true;
    }

    // buscarSocio y buscarSocio2 no se pueden unificar ya hay casos que vamos a necesitar que si lo encuentra o no,
    // no arroje ninguna excepcion. Por ej: en el metodo eliminar o agregar.
    public boolean buscarSocio2(String dni) throws ObjetoEncontradoException{
        if(sociosRepository.buscar(dni) != null){
            throw new ObjetoEncontradoException();
        }
        return true;
    }

    @Override
    public void comprarEntrada() {
        partidoService.listar();
    }

    @Override
    public void comprarMerchandasing() {
        productoService.listar();
    }

    @Override
    public boolean verEstadoContable(String dni) {
        return sociosRepository.estadoContable(dni);
    }

    @Override
    public void listarBeneficios() {
        beneficioService.listar();
    }

}
