package tpFinal;
import tpFinal.Models.Directivo;
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

        PersonalLimpiezaService personalService = new PersonalLimpiezaService();

        PersonalLimpieza personal = new PersonalLimpieza("PersonalUNO", "PersonalUNO", "1", "ModificarUNO", "1414", "Modificar 123", "Duchas", true);
        PersonalLimpieza personal2 = new PersonalLimpieza("PersonalDOS", "PersonalDOS", "2", "PersonalDOS", "2", "PersonalDOS", "Campo de Juego", true);

        personalService.eliminar("2");
        System.out.println(personalService.listar());

    }
}