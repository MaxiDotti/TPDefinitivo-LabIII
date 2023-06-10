package tpFinal.Services;

import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;

public class SocioService implements ISocioService{
    SociosRepository sociosRepo = new SociosRepository();

    @Override
    public void listar() {
        sociosRepo.listar().forEach(System.out::println);
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
        sociosRepo.eliminar(dni);
    }

    @Override
    public boolean buscarSocio(String dni) {
        if(sociosRepo.buscarSocio(dni)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void comprarEntrada() {

    }

    @Override
    public void comprarMerchandasing() {

    }

    @Override
    public void verEstadoContable() {

    }

    @Override
    public void listarBeneficios() {

    }
}
