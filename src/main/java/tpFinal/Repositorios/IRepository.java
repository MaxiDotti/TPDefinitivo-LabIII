package tpFinal.Repositorios;

import java.util.List;

public interface IRepository<T>{
    void cargar(T o);
    List<T> listar();
    void eliminar(String dni);
    void modificar(String dni);
}
