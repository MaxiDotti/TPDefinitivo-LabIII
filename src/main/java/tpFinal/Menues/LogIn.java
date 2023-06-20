package tpFinal.Menues;

import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Menues.Directivo.MenuPrincipalDirectivo;
import tpFinal.Menues.Socio.MenuPrincipalSocio;
import tpFinal.Models.Directivo;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.DirectivoRepository;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.DirectivoService;
import tpFinal.Services.SocioService;

import java.util.Scanner;

public class LogIn {

    public void logInMenu() {

        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        int opcion;
        String dni;
        String contrasenia;

        DirectivoService directivoService = new DirectivoService();
        DirectivoRepository directivoRepository = new DirectivoRepository();

        SocioService socioService = new SocioService();
        SociosRepository sociosRepository = new SociosRepository();

        MenuPrincipalSocio menuPrincipalSocio = new MenuPrincipalSocio();
        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        while (!salir) {
            System.out.println("BIENVENIDO A EXCELSIOR CLUB DEPORTIVO Imperium\"\n\n\n");
            System.out.println("1- Loguearse\n2- Recuperar contraseña\n0- Salir\n");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("***MENU DE LOGUEO***\n\n");
                    System.out.println("Ingrese DNI\n");
                    dni = sn.nextLine();
                    System.out.println("Por favor ingrese contrasenia\n\n");
                    contrasenia = sn.nextLine();
                    try {
                        //Nos fijamos si los datos de logeo corresponden a un Socio
                        if(socioService.buscarSocio(dni)){
                            Socio socioLogeado = sociosRepository.buscar(dni);
                            menuPrincipalSocio.menuPrincipalSocio(socioLogeado);
                        }
                        //Nos fijamos si los datos de logeo corresponden a un Directivo
                        if(directivoService.buscarDirectivo(dni)){
                            Directivo directivoLogeado = directivoRepository.buscar(dni);
                            menuPrincipalDirectivo.menuPrincipalDirectivo(directivoLogeado);
                        }
                    } catch (ObjetoNoEncontradoException e) {
                        System.out.println("Usuario y/o contrasenia incorrectos.\n\n");
                    }
                    break;
                case 2:
                    System.out.println("***RECUPERAR CONTRASEÑA***\n\n");
                    System.out.println("Por favor ingrese su numero de DNI \n\n");
                    dni = sn.nextLine();
                    System.out.println("Por favor ingrese contrasenia\n\n");
                    contrasenia = sn.nextLine();
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

