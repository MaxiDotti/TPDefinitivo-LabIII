package tpFinal.Menues.MenuesDelAdministrador;
import tpFinal.Menues.Directivo.GestionEmpleados.*;
import tpFinal.Menues.Directivo.MenuPrincipalDirectivo;
import tpFinal.Models.Directivo;

import java.util.Scanner;

public class MenuGestionEmpleadosParaAdministrador {
    public void menuGestionEmpleadosParaAdministrador(Directivo directivoLogeado) {
        Scanner sn = new Scanner(System.in);
        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        boolean salir = false;
        int opcion;


        while (!salir) {
            System.out.println("*****MENU GESTION DE EMPLEADOS******\n\n\n");
            System.out.println("1- Ayudante de campo\n" +
                    "2- Director Tecnico\n" +
                    "3- Jugador\n" +
                    "4- Medico\n" +
                    "5- Personal de limpieza\n" +
                    "6- Utilero\n" +
                    "7- Atras\n\n" +
                    "OPCION: ");
            opcion = sn.nextInt();
            sn.nextLine();
            switch (opcion) {
                case 1:
                    MenuGestionAyudanteDeCampo menuAyudanteDeCampo = new MenuGestionAyudanteDeCampo();
                    menuAyudanteDeCampo.menuGestionAyudanteDeCampo(directivoLogeado);
                    break;
                case 2:
                    MenuGestionDirectorTecnico menuGestionDirectorTecnico = new MenuGestionDirectorTecnico();
                    menuGestionDirectorTecnico.menuGestionDirectorTecnico(directivoLogeado);
                    break;
                case 3:
                    MenuGestionJugador menuGestionJugador = new MenuGestionJugador();
                    menuGestionJugador.menuGestionJugador(directivoLogeado);
                    break;
                case 4:
                    MenuGestionMedico menuGestionMedico = new MenuGestionMedico();
                    menuGestionMedico.menuGestionMedico(directivoLogeado);
                    break;
                case 5:
                    MenuPersonalLimpieza menuPersonalLimpieza = new MenuPersonalLimpieza();
                    menuPersonalLimpieza.menuGestionPersonalLimpieza(directivoLogeado);
                    break;
                case 6:
                    MenuGestionUtilero menuGestionUtilero = new MenuGestionUtilero();
                    menuGestionUtilero.menuGestionUtilero(directivoLogeado);
                    break;
                case 7:
                    menuPrincipalDirectivo.menuPrincipalDirectivo(directivoLogeado);
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
