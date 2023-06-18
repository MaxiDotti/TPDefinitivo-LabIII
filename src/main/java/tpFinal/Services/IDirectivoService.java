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
    void listarTodosLosJugadores(String deporte);
    void listarJugadorPorCategoria(String deporte, String categoria);
    void listarPorPosicionYCategoria(String deporte, String categoria, String posicion);
    void agregarEmpleado();
    void modificarEmpleado();
    void eliminarEmpleado();
    void agregarSocio(Socio nuevo);
    void eliminarSocio(String dni);
    void agregarBeneficio();
    void modificarBeneficio();
    void eliminarBeneficio();
}
