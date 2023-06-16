package tpFinal.Services;

import tpFinal.Models.Empleado.Jugador;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Repositorios.EmpleadosRepository.JugadorRepository;
import tpFinal.Utilities.Utils;

import java.util.List;
import java.util.Objects;

public class JugadorService implements IService<Jugador>{

    JugadorRepository jugadorRepository = new JugadorRepository();
    @Override
    public void listar() {
    jugadorRepository.listar().forEach(System.out::println);
    }

    @Override
    public void agregar(Jugador objeto) {
        if(Utils.validateFields(objeto)){
            if(Objects.isNull(buscar(objeto.getDni()))){
                jugadorRepository.agregar(objeto);
            } else {
                System.out.println("El Usuario con dni " + objeto.getDni() + " ya existe");
            }
        }
    }

    @Override
    public void modificar(Jugador objeto) {
        jugadorRepository.modificar(objeto);
    }

    @Override
    public void eliminar(String dni) {
        try{
            jugadorRepository.eliminar(buscar(dni));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Jugador buscar(String dni) {
        List<Jugador> jugadorList = jugadorRepository.listar();
        for(Jugador personal : jugadorList){
            if(personal.getDni().equals(dni)){
                return personal;
            }
        }
        return null;
    }
}
