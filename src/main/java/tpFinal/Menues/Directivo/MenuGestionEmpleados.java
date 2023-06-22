package tpFinal.Menues.Directivo;

import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Menues.Directivo.GestionEmpleados.MenuGestionAyudanteDeCampo;
import tpFinal.Models.Directivo;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.*;

import java.util.Scanner;

public class MenuGestionEmpleados {
    public void menuGestionDeEmpleados(Directivo directivoLogeado) {
        Scanner sn = new Scanner(System.in);
        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();
        MenuGestionAyudanteDeCampo menuAyudanteDeCampo = new MenuGestionAyudanteDeCampo();

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
                    menuAyudanteDeCampo.menuGestionAyudanteDeCampo(directivoLogeado);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

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

