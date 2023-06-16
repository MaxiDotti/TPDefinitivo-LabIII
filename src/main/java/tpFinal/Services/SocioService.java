package tpFinal.Services;

import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Utilities.Validations;

import java.util.List;

public class SocioService implements ISocioService{

    SociosRepository sociosRepo = new SociosRepository();
    Validations validations = new Validations();

    @Override
    public List<Socio> listar() {
        return sociosRepo.listar();
    }

    @Override
    public void agregar(Socio objeto) {
        sociosRepo.agregar(objeto);
    }

    @Override
    public void modificar(String dni) {
        sociosRepo.modificar(dni);
    }

    @Override
    public void eliminar(String dni) {
        try{
            sociosRepo.cargar();
            if(validations.validarDni(dni) && buscarSocio(dni) != null){
                    sociosRepo.eliminar(dni);
            }
            sociosRepo.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    public Socio buscarSocio(String dni) throws ObjetoNoEncontradoException{
        return sociosRepo.buscarSocio(dni);
    }

    @Override
    public void comprarEntrada() {

    }

    @Override
    public void comprarMerchandasing() {

    }

    @Override
    public boolean verEstadoContable(String dni) {
        return sociosRepo.estadoContable(dni);
    }

    @Override
    public void listarBeneficios() {

    }

}
