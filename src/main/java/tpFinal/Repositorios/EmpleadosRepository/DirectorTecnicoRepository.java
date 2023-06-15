package tpFinal.Repositorios.EmpleadosRepository;

import tpFinal.Models.Empleado.DirectorTecnico;
import tpFinal.Repositorios.IRepository;

import java.util.List;

public class DirectorTecnicoRepository implements IRepository<DirectorTecnico> {

    @Override
    public void cargar(DirectorTecnico directorTecnico) {

    }

    @Override
    public List<DirectorTecnico> listar() {
        return null;
    }

    @Override
    public void eliminar(String dni) {

    }

    @Override
    public void modificar(String dni) {

    }
}
