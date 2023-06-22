package tpFinal.Menues;
import tpFinal.Menues.Directivo.MenuGestionEmpleados;
import tpFinal.Menues.Directivo.MenuGestionSocios;
import tpFinal.Menues.MenuesDelAdministrador.MenuGestionSocioParaAdministrador;
import tpFinal.Models.AdministradorDelSistema;
import tpFinal.Models.Directivo;
import java.util.Scanner;

public class MenuPrincipalAdministrador {
    public void menuPrincipalAdministrador(AdministradorDelSistema adminLogeado){

        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        int opcion;


        while (!salir) {
            System.out.println("***** MENU PRINCIPAL DEL ADMINISTRADOR ******\n\n");
            System.out.println("1- Ver información de usuario\n" +
                    "2- Gestion de Socios\n" +
                    "3- Gestión de Empleados\n" +
                    "4- Gestion de Directivos\n" +
                    "4- Gestion de Beneficios\n" +
                    "0- Salir\n");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("***INFORMACION DEL ADMINISTRADOR***\n");
                    System.out.println(adminLogeado);
                    break;
                case 2:
                    System.out.println("***GESTION DE SOCIOS***\n");
                    MenuGestionSocioParaAdministrador menuSocios = new MenuGestionSocioParaAdministrador();
                    menuSocios.menuGestionSocioParaAdministrador(adminLogeado);
                    break;
                case 3:
                    System.out.println("***GESTION DE EMPLEADOS***\n\n");
                    MenuGestionEmpleados menuGestionEmpleados = new MenuGestionEmpleados();
                    Directivo directivoAdmin = new Directivo();
                    menuGestionEmpleados.menuGestionDeEmpleados(directivoAdmin);
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
