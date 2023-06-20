package tpFinal.Menues.Directivo;

import tpFinal.Models.Directivo;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.*;

import java.util.Scanner;

public class MenuPrincipalDirectivo {

    public void menuPrincipalDirectivo(Directivo directivoLogeado){

        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        int opcion;

        SocioService socioService = new SocioService();
        SociosRepository sociosRepository = new SociosRepository();

        AyudanteDeCampoService ayudanteDeCampoService = new AyudanteDeCampoService();
        JugadorService jugadorService = new JugadorService();
        MedicoService medicoService = new MedicoService();
        PersonalLimpiezaService personalLimpiezaService = new PersonalLimpiezaService();
        UtileroService utileroService = new UtileroService();

        BeneficioService beneficioService = new BeneficioService();

        while (!salir) {
            System.out.println("*****MENU PRINCIPAL DIRECTIVO******\n\n\n");
            System.out.println("1- Ver información de usuario\n2- Gestion de Socios\n3- Gestión de Empleados\n4- Gestion de Beneficios\n0- Salir\n");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("***INFORMACION DE USUARIO***\n\n");
                    //directivoLogeado.toString();
                    break;
                case 2:
                    System.out.println("***GESTION DE SOCIOS***\n");
                    MenuGestionSocios menuGestionSocios = new MenuGestionSocios();
                    menuGestionSocios.menuGestionDeSocios(directivoLogeado);
                    break;
                case 3:
                    System.out.println("***GESTION DE EMPLEADOS***\n\n");
                    /*System.out.println("Listado de ayudantes de campo: "+ayudanteDeCampoService.listar()+
                            "\nListado de Jugadores: "+jugadorService.listar()+"\n"+"Listado de Medicos: \n"+medicoService.listar()+
                            "\nListado de personal de limpieza: \n"+personalLimpiezaService.listar()+
                            "\nListado de utileros: "+utileroService.listar());*/
                    //menu que va para el gestor de empleados
                    break;
                case 4:
                    System.out.println("GESTION DE BENEFICIOS\n\n");
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Por favor ingrese una opción valida\n");
                    break;
            }
        }
    }

}
