package tpFinal.Services;
import tpFinal.Models.Empleado.Jugador;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.DirectivoRepository;

public class DirectivoService implements IDirectivoService{
    DirectivoRepository directivoRepo = new DirectivoRepository();
    SocioService sociosService = new SocioService();
    ///EmpleadoService empleadoService = new EmpleadoService();
    JugadorService jugadorService = new JugadorService();

    @Override
    public void listarSocios() {
        sociosService.listar();
    }

    @Override
    public void listarTodosLosEmpleados() {

    }

    @Override
    public void listarEmpleadosSegmentado() {

    }

    @Override
    public void listarSociosDeudores() {

    }

    @Override
    public void listarActividades() {

    }

    @Override
    public void listarBeneficios() {

    }

    @Override
    public void agregarJugador(Jugador nuevo) {
        jugadorService.agregarJugador(nuevo);
    }

    @Override
    public void eliminarJugador(String dni) {
        jugadorService.eliminarJugador(dni);
    }

    @Override
    public void listarJugadores() {

    }

    @Override
    public void agregarEmpleado() {

    }

    @Override
    public void modificarEmpleado() {

    }

    @Override
    public void eliminarEmpleado() {

    }

    @Override
    public void agregarSocio(Socio nuevo) {
        sociosService.agregar(nuevo);
    }


    @Override
    public void eliminarSocio(String dni) {
        try{
            sociosService.eliminar(dni);
        }catch (Exception e){
            System.out.println("El socio ingresado no existe.");
        }
    }

    @Override
    public void agregarBeneficio() {

    }

    @Override
    public void modificarBeneficio() {

    }

    @Override
    public void eliminarBeneficio() {

    }
}
