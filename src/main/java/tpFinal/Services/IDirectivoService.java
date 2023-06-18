package tpFinal.Services;

import tpFinal.Models.Empleado.Jugador;
import tpFinal.Models.Socio;

public interface IDirectivoService {
    void listarSocios();
    void listarTodosLosEmpleados();
    void listarEmpleadosSegmentado();
    void listarSociosDeudores();
    void listarActividades();
    void listarBeneficios();
    void agregarJugador(Jugador nuevo);
    void eliminarJugador(String dni);
    void listarJugadores();
    void agregarEmpleado();
    void modificarEmpleado();
    void eliminarEmpleado();
    void agregarSocio(Socio nuevo);
    void eliminarSocio(String dni);
    void agregarBeneficio();
    void modificarBeneficio();
    void eliminarBeneficio();
}
