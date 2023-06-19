package tpFinal.Services;

import tpFinal.Models.Empleado.PersonalLimpieza;

import java.util.List;

public interface IPersonalLimpiezaService {
    List<PersonalLimpieza> listar();
    void agregar(PersonalLimpieza objeto);
    void modificar(PersonalLimpieza objeto);
    void eliminar(String dni);
}