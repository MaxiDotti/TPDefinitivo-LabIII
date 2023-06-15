package tpFinal.Services;

import tpFinal.Models.Empleado.Jugador;

public interface IJugadorService {
    void listarJugadorPorCategoria(String deporte, String categoria); // SE DEBE SELECCIONAR DEPORTE
    void listarTodosLosJugadores(String deporte); // SE DEBE SELECCIONAR DEPORTE
    void listarPorPosicionYCategoria(String deporte, String categoria, String posicion); // SE DEBE SELECCIONAR DEPORTE
    void agregarJugador(Jugador nuevo); // SOLO UTILIZA ADMIN O DIRECTIVO
    void modificarJugador(String dni); // SOLO UTILIZA ADMIN O DIRECTIVO
    void eliminarJugador(String dni); // SOLO UTILIZA ADMIN O DIRECTIVO
    void cambiarCategoria();
    void cambiarDeporte();
    void cambiarPosicio();
    boolean estadoContable(String dni);

}
