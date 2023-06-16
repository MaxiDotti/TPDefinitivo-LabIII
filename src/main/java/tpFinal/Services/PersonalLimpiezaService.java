package tpFinal.Services;

import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Repositorios.EmpleadosRepository.PersonalLimpiezaRepository;
import tpFinal.Utilities.Utils;

import java.util.List;
import java.util.Objects;

public class PersonalLimpiezaService implements IService<PersonalLimpieza>{

    PersonalLimpiezaRepository personalLimpiezaRepository = new PersonalLimpiezaRepository();

    @Override
    public void listar() {
        personalLimpiezaRepository.listar().forEach(System.out::println);
    }

    @Override
    public void agregar(PersonalLimpieza objeto) {
        if(Utils.validateFields(objeto)){
            if(Objects.isNull(buscar(objeto.getDni()))){
                personalLimpiezaRepository.agregar(objeto);
            } else {
                System.out.println("El Usuario con dni " + objeto.getDni() + " ya existe");
            }
        }
    }

    @Override
    public void modificar(PersonalLimpieza persona) {
        personalLimpiezaRepository.modificar(persona);
    }

    @Override
    public void eliminar(String dni) {
        try{
            personalLimpiezaRepository.eliminar(buscar(dni));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public PersonalLimpieza buscar(String dni) {
        List<PersonalLimpieza> personalLimpiezas = personalLimpiezaRepository.getListPersonalLimpieza();
        for(PersonalLimpieza personal : personalLimpiezas){
            if(personal.getDni().equals(dni)){
                return personal;
            }
        }
        return null;
    }

}