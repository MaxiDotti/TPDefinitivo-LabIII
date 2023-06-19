package tpFinal;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.AyudanteDeCampo;
import tpFinal.Models.Empleado.Jugador;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Services.*;
import tpFinal.Models.Empleado.Utilero;
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

        AyudanteDeCampoService ayudanteService = new AyudanteDeCampoService();

        AyudanteDeCampo ayudante = new AyudanteDeCampo("AYUDANTEUNO", "AYUDANTEUNO", "1", "MODIFICACION", "1414", "MODIFICACION", true, "MODIFICACION", "Futbol", "Cuarta");
        AyudanteDeCampo ayudante2 = new AyudanteDeCampo("AYUDANTEDOS", "AYUDANTEDOS", "2", "AYUDANTEDOS", "2", "AYUDANTEDOS", true, "AYUDANTEDOS", "Handball", "Primera");

        ayudanteService.eliminar("2");
        System.out.println(ayudanteService.listar());

    }
}