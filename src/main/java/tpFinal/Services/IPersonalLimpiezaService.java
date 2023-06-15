package tpFinal.Services;

import tpFinal.Models.Empleado.PersonalLimpieza;

public interface IPersonalLimpiezaService {
    void listar();
    void agregar(PersonalLimpieza objeto);
    void modificar(String dni);
    void eliminar(String dni);
    PersonalLimpieza buscarPersonal(String dni);
}