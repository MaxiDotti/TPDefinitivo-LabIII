package tpFinal.Services;
import tpFinal.Models.Empleado.Jugador;
import tpFinal.Repositorios.EmpleadosRepository.JugadorRepository;

import java.util.List;

public class JugadorService implements IJugadorService{
    JugadorRepository jugadorRepo = new JugadorRepository();

    @Override
    public void listarJugadorPorCategoria(String deporte, String categoria) {
        List<Jugador> listaJugadores = jugadorRepo.listar();
        for(Jugador jug : listaJugadores){
            if(jug.getDeporte().equals(deporte) && jug.getCategoria() == categoria){
                System.out.println(jug);
            }
        }
    }

    @Override
    public void listarTodosLosJugadores(String deporte) {
        List<Jugador> listaJugadores = jugadorRepo.listar();
        for(Jugador jug : listaJugadores){
            System.out.println(jug.getDeporte().equals(deporte));
        }
    }

    @Override
    public void listarPorPosicionYCategoria(String deporte, String categoria, String posicion) {
        List<Jugador> listaJugadores = jugadorRepo.listar();
        for(Jugador jug : listaJugadores){
            if(jug.getDeporte().equals(deporte) && jug.getCategoria() == categoria && jug.getPosicion() == posicion){
                System.out.println(jug);
            }
        }
    }

    @Override
    public void agregarJugador(Jugador nuevo) {
        jugadorRepo.agregar(nuevo);
    }

    @Override
    public void modificarJugador(String dni) {
        jugadorRepo.modificar(dni);
    }

    @Override
    public void eliminarJugador(String dni) {
        jugadorRepo.eliminar(dni);
    }

    @Override
    public void cambiarCategoria() {

    }

    @Override
    public void cambiarDeporte() {

    }

    @Override
    public void cambiarPosicio() {

    }

    @Override
    public boolean estadoContable(String dni) {

    }
}
