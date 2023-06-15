package tpFinal.Repositorios.EmpleadosRepository;

import tpFinal.Models.Empleado.Medico;
import tpFinal.Repositorios.IRepository;

import java.util.List;

public class MedicoRepository implements IRepository<Medico> {
    @Override
    public void cargar(Medico o) {

    }

    @Override
    public List<Medico> listar() {
        return null;
    }

    @Override
    public void eliminar(String dni) {

    }

    @Override
    public void modificar(String dni) {

    }
}
