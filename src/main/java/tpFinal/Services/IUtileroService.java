package tpFinal.Services;

import tpFinal.Models.Empleado.Utilero;

import java.util.List;

public interface IUtileroService {

   List<Utilero> listar();
    void agregar(Utilero objeto);
    void modificar(Utilero objeto);
    void eliminar(String dni);
}
