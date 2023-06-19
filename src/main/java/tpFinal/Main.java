package tpFinal;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.Utilero;
import tpFinal.Services.DirectivoService;
import tpFinal.Services.UtileroService;

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

        DirectivoService direService = new DirectivoService();
        Directivo nuevo = new Directivo("Maximo", "Dotti", "38210372", "MODI", "MODI1", "MODI2");
        direService.modificar(nuevo);
        System.out.println(direService.listar());



    }
}