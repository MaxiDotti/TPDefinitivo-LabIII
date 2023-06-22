package tpFinal;
import tpFinal.Menues.Directivo.GestionEmpleados.MenuGestionAyudanteDeCampo;
import tpFinal.Menues.Directivo.GestionEmpleados.MenuGestionDirectorTecnico;
import tpFinal.Menues.Directivo.GestionEmpleados.MenuGestionJugador;
import tpFinal.Menues.Directivo.GestionEmpleados.MenuGestionMedico;
import tpFinal.Menues.Directivo.MenuGestionSocios;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.*;
import tpFinal.Models.Producto;
import tpFinal.Repositorios.EmpleadosRepository.UtileroRepository;
import tpFinal.Repositorios.ProductoRepository;
import tpFinal.Services.*;
import tpFinal.Services.DirectivoService;
import tpFinal.Utilities.CategoriaProducto;
import tpFinal.Utilities.Deporte;
import tpFinal.Menues.Iniciador;
import tpFinal.Models.Partido;
import tpFinal.Services.PartidoService;

public class Main {
    public static void main(String[] args) {
        Iniciador iniciador = new Iniciador();
        iniciador.comenzar();



    }
}