package tpFinal;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.*;
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

        DirectorTecnicoService dtService = new DirectorTecnicoService();
        DirectorTecnico dt = new DirectorTecnico("MARCELO", "GALLARDO", "1", "1", "1", "DT 1", true, "River Plate", "Futbol", "Primera");
        DirectorTecnico dt2 = new DirectorTecnico("MATIAS", "ALMEYDA", "2", "2424", "2424", "MODIFICACION 2", true, "River Plate", "Volley", "Tercera");

        dtService.eliminar("2");
        System.out.println(dtService.listar());
    }
}