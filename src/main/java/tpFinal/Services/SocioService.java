package tpFinal.Services;

import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Utilities.Validations;

import java.util.List;

public class SocioService implements ISocioService{

    SociosRepository sociosRepository = new SociosRepository();
    Validations validations = new Validations();

    @Override
    public List<Socio> listar() {
        return sociosRepository.listar();
    }

    @Override
    public void agregar(Socio objeto) {
        sociosRepository.agregar(objeto);
    }

    @Override
    public void modificar(String dni) {
        sociosRepository.modificar(dni);
    }

    @Override
    public void eliminar(String dni) {
        try{
            sociosRepository.cargar();
            if(validations.validarDni(dni) && buscarSocio(dni) != null){
                    sociosRepository.eliminar(dni);
            }
            sociosRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    public Socio buscarSocio(String dni) throws ObjetoNoEncontradoException{
        return sociosRepository.buscarSocio(dni);
    }

    @Override
    public void comprarEntrada() {

    }

    @Override
    public void comprarMerchandasing() {

    }

    @Override
    public boolean verEstadoContable(String dni) {
        return sociosRepository.estadoContable(dni);
    }

    @Override
    public void listarBeneficios() {

    }

}
