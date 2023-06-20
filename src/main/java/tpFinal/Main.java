package tpFinal;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.*;
import tpFinal.Models.Producto;
import tpFinal.Repositorios.EmpleadosRepository.UtileroRepository;
import tpFinal.Repositorios.ProductoRepository;
import tpFinal.Services.*;
import tpFinal.Services.DirectivoService;
import tpFinal.Utilities.Deporte;

public class Main {
    public static void main(String[] args) {

       /* TestRepository test = new TestRepository();

        //System.out.println("TEST AYUDANTE DE CAMPO");
        //test.testAyudanteDeCampo();
        //System.out.println("TEST DIRECTOR TECNICO");
        //test.testDirectorTecnico();
        //System.out.println("TEST JUGADOR");
        //test.testJugador();
        //System.out.println("TEST MEDICO");
        //test.testMedico();
        //System.out.println("TEST PERSONAL LIMPIEZA");
        //test.testPErsonalLimpieza();
       // System.out.println("TEST UTILERO");
        //test.testUtilero();
       // System.out.println("TEST DIRECTIVO");
        //test.testDirectivo();
        //System.out.println("TEST SOCIO");
        //test.testSocio();
    }*/

        ProductoService productoService = new ProductoService();

        Producto prod1 = new Producto("1", "REMERA", "Casaca", 6700f, Producto.Categoria.INDUMENTARIA);
        ///productoService.agregar(prod1);
        System.out.println(productoService.listar());

    }
}