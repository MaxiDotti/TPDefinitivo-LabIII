package tpFinal.Services;
import tpFinal.Models.Producto;
import java.util.List;

public interface IProductoService {
    List<Producto> listar();
    void agregar(Producto objeto);
    void modificar(Producto objeto);
    void eliminar(String dni);
}
