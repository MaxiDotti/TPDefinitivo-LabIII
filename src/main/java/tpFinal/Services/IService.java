package tpFinal.Services;

public interface IService<T> {
    void listar();
    void agregar(T objeto);
    void modificar(T objeto);
    void eliminar(String dni);
    T buscar(String dni);
}
