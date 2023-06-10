package tpFinal.Services;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.DirectivoRepository;

public class DirectivoService implements IDirectivoService{
    DirectivoRepository directivoRepo = new DirectivoRepository();
    SocioService sociosService = new SocioService();
    ///EmpleadoService empleadoService = new EmpleadoService();
    ///JugadorService jugadorService = new JugadorService();

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
    public void modificarSocio(String dni) {
        sociosService.modificar(dni);
    }

    @Override
    public void eliminarSocio(String dni) {
        sociosService.eliminar(dni);
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
