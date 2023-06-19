package tpFinal.Services;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Empleado.DirectorTecnico;
import java.util.List;

public interface IDirectorTecnicoService {
    List<DirectorTecnico> listar();
    void agregar(DirectorTecnico objeto);
    void modificar(DirectorTecnico objeto);
    void eliminar(String dni);
    boolean buscarDirectorTecnico(String dni) throws ObjetoNoEncontradoException;
    boolean buscarDirectorTecnico2(String dni) throws ObjetoEncontradoException;
}
