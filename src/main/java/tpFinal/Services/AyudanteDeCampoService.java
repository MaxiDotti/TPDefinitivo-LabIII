package tpFinal.Services;

import tpFinal.Models.Empleado.AyudanteDeCampo;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Repositorios.EmpleadosRepository.AyudanteDeCampoRepository;
import tpFinal.Utilities.Utils;

import java.util.List;
import java.util.Objects;

public class AyudanteDeCampoService implements IService<AyudanteDeCampo>{

    AyudanteDeCampoRepository campoRepository = new AyudanteDeCampoRepository();

    @Override
    public void listar() {
        campoRepository.listar().forEach(System.out::println);
    }

    @Override
    public void agregar(AyudanteDeCampo objeto) {
        if(Utils.validateFields(objeto)){
            if(Objects.isNull(buscar(objeto.getDni()))){
                campoRepository.agregar(objeto);
            } else {
                System.out.println("El usuario con el dni " + objeto.getDni() + "ya existe");
            }
        }
    }

    @Override
    public void modificar(AyudanteDeCampo persona) {
        campoRepository.eliminar(persona);
    }

    @Override
    public void eliminar(String dni) {
        try {
            campoRepository.eliminar(buscar(dni));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public AyudanteDeCampo buscar(String dni) {
        List<AyudanteDeCampo> campoList = campoRepository.listar();
        for(AyudanteDeCampo personal : campoList){
            if(personal.getDni().equals(dni)){
                return personal;
            }
        }
        return null;
    }
}
