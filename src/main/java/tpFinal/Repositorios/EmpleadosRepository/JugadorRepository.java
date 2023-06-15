package tpFinal.Repositorios.EmpleadosRepository;

import tpFinal.Models.Empleado.Jugador;
import tpFinal.Repositorios.IRepository;

import java.util.List;

public class JugadorRepository implements IRepository<Jugador> {
    @Override
    public void cargar(Jugador jugador) {

    }

    @Override
    public List<Jugador> listar() {
        return null;
    }

    @Override
    public void eliminar(String dni) {

    }

    @Override
    public void modificar(String dni) {

    }
}
