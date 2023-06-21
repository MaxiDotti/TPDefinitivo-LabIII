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
            System.out.println("BIENVENIDO AL CLUB SOCIAL Y DEPORTIVO\n\n\n");
            System.out.println("1- Loguearse\n" +
                    "2- Recuperar contraseña\n" +
                    "0- Salir\n");

            System.out.print("OPCION: ");
            opcion = sn.nextInt();
            sn.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("***MENU DE LOGUEO***\n\n");
                    System.out.print("Ingrese DNI: ");
                    dni = sn.nextLine();
                    System.out.print("Ingrese contraseña: ");
                    contrasenia = sn.nextLine();

                    //Nos fijamos si los datos de logeo corresponden a un Socio
                    if(sociosRepository.buscarSocio(dni) != null){
                        Socio socioLogueado = sociosRepository.buscarSocio(dni);
                        if(socioLogueado.getContrasenia().equals(contrasenia)){
                            menuPrincipalSocio.menuPrincipalSocio(socioLogueado);
                        }
                    }
                    //Nos fijamos si los datos de logeo corresponden a un Directivo
                    if(directivoRepository.buscarDirectivo(dni) != null){
                        Directivo directivo = directivoRepository.buscarDirectivo(dni);
                        if(directivo.getContrasenia().equals(contrasenia)){
                            menuPrincipalDirectivo.menuPrincipalDirectivo(directivo);
                        }
                    }else{
                        System.out.println("Los datos ingresados son incorrectos.");
                    }
                    break;
                case 2:
                    System.out.println("***RECUPERAR CONTRASEÑA***\n\n");
                    System.out.println("Por favor ingrese su numero de DNI \n\n");
                    dni = sn.nextLine();
                    System.out.println("Por favor ingrese contrasenia\n\n");
                    contrasenia = sn.nextLine();
                    if(sociosRepository.buscarSocio(dni) != null){
                        Socio socio = sociosRepository.buscarSocio(dni);
                        if(socio.getContrasenia().equals(contrasenia)){
                            System.out.println("Ingresar nueva contrasenia");
                            String nuevaContrasenia = sn.nextLine();
                            System.out.println("Repita la contrasenia");
                            String validarContrasenia = sn.nextLine();
                            if(nuevaContrasenia.equals(validarContrasenia)){
                                if (socioService.cambiarContrasenia(nuevaContrasenia,dni))
                                    System.out.println("Contrasenia cambiada correctamente.");
                            }
                        }
                    } else if (directivoRepository.buscar(dni) != null) {
                        if(directivoRepository.buscar(dni) != null){
                            Directivo directivo = directivoRepository.buscar(dni);
                            if(directivo.getContrasenia().equals(contrasenia)){
                                System.out.println("Ingresar nueva contrasenia");
                                String nuevaContrasenia = sn.nextLine();
                                System.out.println("Repita la contrasenia");
                                String validarContrasenia = sn.nextLine();
                                if(nuevaContrasenia.equals(validarContrasenia)){
                                    if (directivoService.cambiarContrasenia(nuevaContrasenia,dni))
                                        System.out.println("Contrasenia cambiada correctamente.");
                                }
                            }
                        }
                    } else{
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

