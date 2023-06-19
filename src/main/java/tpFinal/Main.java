package tpFinal;
import tpFinal.Models.Directivo;
<<<<<<< HEAD
import tpFinal.Models.Empleado.Jugador;
import tpFinal.Services.DirectivoService;
import tpFinal.Services.JugadorService;
=======
import tpFinal.Models.Empleado.Utilero;
import tpFinal.Services.DirectivoService;
import tpFinal.Services.UtileroService;
>>>>>>> origin/develop

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

        JugadorService jugadorService = new JugadorService();
        Jugador nuevo = new Jugador("Maximo", "Dotti", "38210372", "asd", "2235111", "Calle 123", "asd", "Primera", "Futbol", "Mediocampista", true);
        jugadorService.agregar(nuevo);
        System.out.println(jugadorService.listar());


    }
}