package tpFinal.Repositorios;

import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Exceptions.PartidoNoEncontradoException;

import java.util.List;

public interface IRepository<T>{

    void cargar();
    void guardar();
    List<T> listar();
    void agregar(T objeto);
    void agregarLista(List<T> lista);
    void eliminar(String dni) throws PartidoNoEncontradoException;
    void modificar(T objeto);
    T buscar(String dni);

}
