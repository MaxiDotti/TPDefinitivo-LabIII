package tpFinal;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.*;
import tpFinal.Repositorios.EmpleadosRepository.UtileroRepository;
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

        /*MedicoService medicoService = new MedicoService();

        Medico dr = new Medico("ALBERTO", "MIGUENS", "1", "1414", "1414", "MODI 1", "Psicologo", true);
        Medico dr2 = new Medico("OSVALDO", "SPICHINO", "2", "2", "2", "MEDICO 2", "TRAUMATOLOGO", true);

        medicoService.agregar(dr2);
        System.out.println(medicoService.listar());*/

        UtileroService utileroService = new UtileroService();

        Utilero test= new Utilero("Juan","Carlos","123","preba21","124","csl12",true,"Basquet");
        utileroService.agregar(test);
        UtileroRepository test2 = new UtileroRepository();
        System.out.println(test2.listar());

    }
}