package tpFinal.Repositorios;

import java.util.List;

public interface IRepository<T>{
<<<<<<< HEAD
    void cargar(T o);
    List<T> listar();
=======
    void cargar();
    void guardar();
    List<T> listar();
    void agregar(T objeto);
    void agregarLista(List<T> lista);
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
    void eliminar(String dni);
    void modificar(String dni);
}
