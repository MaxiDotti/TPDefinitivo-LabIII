package tpFinal.Services;

import tpFinal.Models.Empleado.DirectorTecnico;
import tpFinal.Repositorios.EmpleadosRepository.DirectorTecnicoRepository;
import tpFinal.Utilities.Utils;

import java.util.List;
import java.util.Objects;

public class DirectorTecnicoService implements IService<DirectorTecnico> {

    DirectorTecnicoRepository tecnicoRepository = new DirectorTecnicoRepository();
    @Override
    public void listar() {
        tecnicoRepository.listar().forEach(System.out::println);
    }

    @Override
    public void agregar(DirectorTecnico objeto) {
        if(Utils.validateFields(objeto)){
            if(Objects.isNull(buscar(objeto.getDni()))){
                tecnicoRepository.agregar(objeto);
            } else {
                System.out.println("El Usuario con dni " + objeto.getDni() + " ya existe");
            }
        }
    }

    @Override
    public void modificar(DirectorTecnico persona) {
        tecnicoRepository.modificar(persona);
    }

    @Override
    public void eliminar(String dni) {
        try{
            tecnicoRepository.eliminar(buscar(dni));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public DirectorTecnico buscar(String dni) {
        List<DirectorTecnico> tecnicoList = tecnicoRepository.listar();
        for(DirectorTecnico personal : tecnicoList){
            if(personal.getDni().equals(dni)){
                return personal;
            }
        }
        return  null;
    }
}
