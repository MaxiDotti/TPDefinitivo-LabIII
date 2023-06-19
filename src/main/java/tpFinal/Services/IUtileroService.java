package tpFinal.Services;

import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Empleado.Utilero;

import java.util.List;

public interface IUtileroService {

   List<Utilero> listar();
    void agregar(Utilero objeto);
    void modificar(Utilero objeto);
    void eliminar(String dni);
    boolean buscarPersonal(String dni) throws ObjetoNoEncontradoException;
    boolean buscarPersonal2(String dni) throws ObjetoEncontradoException;
}
