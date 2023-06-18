package tpFinal.Services;

import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;

import java.util.List;

public class SocioService implements ISocioService{
    SociosRepository sociosRepo = new SociosRepository();

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
    public void eliminar(String dni) throws Exception {
        sociosRepo.eliminar(dni);
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
