package tpFinal.Services;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Empleado.Jugador;
import java.util.List;

public interface IJugadorService {
    List<Jugador> listar();
    void agregar(Jugador objeto);
    void modificar(Jugador objeto);
    void eliminar(String dni);
    boolean buscarJugador(String dni) throws ObjetoNoEncontradoException;
    boolean buscarJugador2(String dni) throws ObjetoEncontradoException;
    void listarJugadorPorCategoria(String deporte, String categoria);
    void listarPorPosicionYCategoria(String deporte, String categoria, String posicion);
    void cambiarCategoria();
    void cambiarDeporte();
    void cambiarPosicion();
    boolean estadoContable(String dni);

}
