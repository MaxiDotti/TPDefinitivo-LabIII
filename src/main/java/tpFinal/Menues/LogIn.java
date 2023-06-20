package tpFinal.Menues;

import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.SocioService;

import java.util.Scanner;

public class LogIn {

    public void logInMenu() {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion = 0;
        SocioService socioService = new SocioService();
        SociosRepository sociosRepository = new SociosRepository();

        while (!salir) {
            System.out.println("BIENVENIDO AL CLUB SOCIAL Y DEPORTIVO\n\n\n");
            System.out.println("1- Loguearse\n2- Recuperar contraseña\n0- Salir\n");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("***MENU DE LOGUEO***\n\n");
                    System.out.println("Ingrese ");
                    break;
                case 2:
                    System.out.println("***RECUPERAR CONTRASEÑA***\n\n");
                    System.out.println("Por favor ingrese su numero de DNI \n\n");
                    String dni = sn.nextLine();
                    if(sociosRepository.buscar(dni) != null){
                        System.out.println(sociosRepository.buscar(dni).getNombre()+", un administrador se contactará con usted para reestablecer su contraseña, gracias");
                    }else{
                        System.out.println("DNI no valido.");
                    }
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

