package tpFinal.Services;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Empleado.Medico;
import java.util.List;

public interface IMedicoService {
    List<Medico> listar();
    void agregar(Medico objeto);
    void modificar(Medico objeto);
    void eliminar(String dni);
    boolean buscarMedico(String dni) throws ObjetoNoEncontradoException;
    boolean buscarMedico2(String dni) throws ObjetoEncontradoException;
}
