package tpFinal.Services;

import tpFinal.Models.Socio;

public interface IDirectivoService {
    void listarSocios();
    void listarTodosLosEmpleados();
    void listarEmpleadosSegmentado();
    void listarSociosDeudores();
    void listarActividades();
    void listarBeneficios();
    void agregarEmpleado();
    void modificarEmpleado();
    void eliminarEmpleado();
    void agregarSocio(Socio nuevo);
    void modificarSocio(String dni);
    void eliminarSocio(String dni);
    void agregarBeneficio();
    void modificarBeneficio();
    void eliminarBeneficio();
}
