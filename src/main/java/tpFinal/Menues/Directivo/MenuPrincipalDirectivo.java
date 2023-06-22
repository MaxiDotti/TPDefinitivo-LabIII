package tpFinal.Menues.Directivo;

import tpFinal.Menues.Directivo.GestionEmpleados.MenuGestionDirectorTecnico;
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
        MedicoService medicoService = new MedicoService();
        PersonalLimpiezaService personalLimpiezaService = new PersonalLimpiezaService();
        UtileroService utileroService = new UtileroService();
        BeneficioService beneficioService = new BeneficioService();

        MenuGestionDirectorTecnico tecnicoMenu = new MenuGestionDirectorTecnico();

        while (!salir) {
            System.out.println("*****MENU PRINCIPAL DIRECTIVO******\n\n\n");
            System.out.println("1- Ver información de usuario\n" +
                    "2- Gestion de Socios\n" +
                    "3- Gestión de Empleados\n" +
                    "4- Gestion de Beneficios\n" +
                    "0- Salir\n");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("***INFORMACION DE DIRECTIVO***\n");
                    System.out.println(directivoLogeado);
                    break;
                case 2:
                    System.out.println("***GESTION DE SOCIOS***\n");
                    MenuGestionSocios menuGestionSocios = new MenuGestionSocios();
                    menuGestionSocios.menuGestionDeSocios(directivoLogeado);
                    break;
                case 3:
                    System.out.println("***GESTION DE EMPLEADOS***\n\n");
                    boolean continuar = true;
                    int eleccion = 0;
                    while (continuar){
                        System.out.println("Elija la opcion deseada");
                        System.out.println("1- Gestion ayudante de campo\n" +
                                "2- Gestion Director Tecnico\n" +
                                "3- Gestion Jugador\n" +
                                "4- Gestion Medico\n" +
                                "5- Gestion Personal Limpieza\n" +
                                "6- Gestion Utilero\n" +
                                "0- Salir");
                        eleccion = sn.nextInt();
                        switch (eleccion){
                            case 1:
                            //tecnicoMenu.menuGestionDirectorTecnico();
                            break;
                        }
                    }
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
