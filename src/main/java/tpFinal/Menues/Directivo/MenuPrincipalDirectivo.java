package tpFinal.Menues.Directivo;

import tpFinal.Menues.Directivo.GestionEmpleados.MenuGestionAyudanteDeCampo;
import tpFinal.Models.Directivo;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.*;

import java.util.Scanner;

public class MenuPrincipalDirectivo {

    public void menuPrincipalDirectivo(Directivo directivoLogeado){

        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        int opcion;

        MenuGestionAyudanteDeCampo menuGestionAyudanteDeCampo = new MenuGestionAyudanteDeCampo();

        while (!salir) {
            System.out.println("***** MENU PRINCIPAL DIRECTIVO ******\n\n");
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
                    MenuGestionEmpleados menuGestionEmpleados = new MenuGestionEmpleados();
                    menuGestionEmpleados.menuGestionDeEmpleados(directivoLogeado);
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
