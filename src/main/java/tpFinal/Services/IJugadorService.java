package tpFinal.Services;

public interface IJugadorService {
    void listarJugadorPorCategoria(); // SE DEBE SELECCIONAR DEPORTE
    void listarTodosLosJugadores(); // SE DEBE SELECCIONAR DEPORTE
    void listarPorPosicionYCategoria(); // SE DEBE SELECCIONAR DEPORTE
    void agregarJugador(); // SOLO UTILIZA ADMIN O DIRECTIVO
    void modificarJugador(); // SOLO UTILIZA ADMIN O DIRECTIVO
    void eliminarJugador(); // SOLO UTILIZA ADMIN O DIRECTIVO
    void cambiarCategoria();
    void cambiarDeporte();
    void cambiarPosicio();
    boolean estadoContable();

}
