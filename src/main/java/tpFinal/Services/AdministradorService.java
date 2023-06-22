package tpFinal.Services;

import tpFinal.Models.AdministradorDelSistema;
import tpFinal.Models.Beneficio;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.*;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.AdministradorRepository;

import java.util.List;

public class AdministradorService implements IAdministradorService{

    DirectivoService directivoService = new DirectivoService();
    AdministradorRepository administradorRepository = new AdministradorRepository();

    public List<AdministradorDelSistema> listar(){
        return administradorRepository.listar();
    }
    public void agregar(AdministradorDelSistema admin){
        administradorRepository.cargar();
        administradorRepository.agregar(admin);
        administradorRepository.guardar();
    }

    public void modificar(AdministradorDelSistema admin){
        administradorRepository.cargar();
        administradorRepository.modificar(admin);
        administradorRepository.guardar();
    }

    public void eliminar(String dni){
        administradorRepository.cargar();
        administradorRepository.eliminar(dni);
        administradorRepository.guardar();
    }

    @Override
    public List<Directivo> listarDirectivos() {
        return directivoService.listar();
    }
    @Override
    public void agregarDirectivo(Directivo directivo) {
        directivoService.agregar(directivo);
    }
    @Override
    public void modificarDirectivo(Directivo directivo) {
        directivoService.modificar(directivo);
    }
    @Override
    public void eliminarDirectivo(String dni) {
        directivoService.eliminar(dni);
    }
    @Override
    public void modificarBeneficio(Beneficio beneficio) {

    }

    @Override
    public void agregarBeneficio(Beneficio beneficio) {

    }
}
