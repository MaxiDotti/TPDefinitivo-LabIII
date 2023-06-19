package tpFinal.Services;
import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Empleado.Jugador;
import tpFinal.Repositorios.EmpleadosRepository.JugadorRepository;
import tpFinal.Utilities.Validations;
import java.util.List;

public class JugadorService implements IJugadorService{
    JugadorRepository jugadorRepository = new JugadorRepository();
    Validations validations = new Validations();

    @Override
    public void listarJugadorPorCategoria(String deporte, String categoria) {
        List<Jugador> listaJugadores = jugadorRepository.listar();
        for(Jugador jug : listaJugadores){
            if(jug.getDeporte().equals(deporte) && jug.getCategoria() == categoria){
                System.out.println(jug);
            }
        }
    }

    @Override
    public void listarPorPosicionYCategoria(String deporte, String categoria, String posicion) {
        List<Jugador> listaJugadores = jugadorRepository.listar();
        for(Jugador jug : listaJugadores){
            if(jug.getDeporte().equals(deporte) && jug.getCategoria() == categoria && jug.getPosicion() == posicion){
                System.out.println(jug);
            }
        }
    }

    @Override
    public List<Jugador> listar() {
        jugadorRepository.cargar();
        return jugadorRepository.listar();
    }

    @Override
    public void agregar(Jugador objeto) {
        try {
            validations.validarJugador(objeto);
            jugadorRepository.cargar();
            if(buscarJugador2(objeto.getDni())){
                jugadorRepository.agregar(objeto);
            }
            jugadorRepository.guardar();
        } catch (FormatoDNINoCompatibleException e) {
            System.out.println(e.getMensaje());
        } catch (FormatoUsuarioNoCompatibleException e){
            System.out.println(e.getMensaje());
        } catch (ObjetoEncontradoException e){
            System.out.println(e.getMensaje());
        }
    }

    // Se puede modificar CONTRASEÑA, TELEFONO, DIRECCION, POSICION, CATEGORIA y DEPORTE.
    @Override
    public void modificar(Jugador objeto) {
        try{
            jugadorRepository.cargar();
            if(validations.validarDni(objeto.getDni()) && buscarJugador(objeto.getDni())){
                jugadorRepository.modificar(objeto);
            }
            jugadorRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void eliminar(String dni) {
        try{
            jugadorRepository.cargar();
            if(validations.validarDni(dni) && buscarJugador(dni)){
                jugadorRepository.eliminar(dni);
            }
            jugadorRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }
    @Override
    public boolean buscarJugador(String dni) throws ObjetoNoEncontradoException {
        if(jugadorRepository.buscar(dni) == null){
            throw new ObjetoNoEncontradoException();
        }
        return true;
    }

    // buscarJugador y buscarJugador2 no se pueden unificar ya hay casos que vamos a necesitar que si lo encuentra o no,
    // no arroje ninguna excepcion. Por ej: en el metodo eliminar o agregar.
    @Override
    public boolean buscarJugador2(String dni) throws ObjetoEncontradoException {
        if(jugadorRepository.buscar(dni) != null){
            throw new ObjetoEncontradoException();
        }
        return true;
    }

    @Override
    public boolean estadoContable(String dni) {
    return false;
    }
}
