package tpFinal.Repositorios;

import java.util.List;

public interface IRepository<T>{

    void cargar();
    void guardar();
    List<T> listar();
    void agregar(T objeto);
    void agregarLista(List<T> lista);
    void eliminar(String dni);
    void modificar(String dni);
}
