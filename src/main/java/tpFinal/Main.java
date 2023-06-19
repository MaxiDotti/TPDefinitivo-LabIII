package tpFinal;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.Jugador;
import tpFinal.Services.DirectivoService;
import tpFinal.Services.JugadorService;
import tpFinal.Models.Empleado.Utilero;
import tpFinal.Services.DirectivoService;
import tpFinal.Services.UtileroService;
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

        JugadorService jugadorService = new JugadorService();
        Jugador nuevo = new Jugador("Ariel", "Ortega", "2", "Jugador", "2424", "Calle 123", "asd", "Elite", "Natacion", "Nadador", true);
        Jugador nuevo2 = new Jugador("Martin", "Demichelis", "3", "3434", "3434", "Calle 123", "asd", "Primera", "Futbol", "Mediocampista", true);

        jugadorService.eliminar("3");
        System.out.println(jugadorService.listar());


    }
}