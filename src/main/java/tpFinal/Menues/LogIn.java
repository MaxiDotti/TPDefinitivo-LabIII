package tpFinal.Menues;

import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Menues.Directivo.MenuPrincipalDirectivo;
import tpFinal.Menues.Socio.MenuPrincipalSocio;
import tpFinal.Models.Directivo;
import tpFinal.Models.Socio;
import tpFinal.Models.Usuario;
import tpFinal.Repositorios.DirectivoRepository;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.DirectivoService;
import tpFinal.Services.SocioService;
import tpFinal.Utilities.Deporte;

import java.util.ArrayList;
import java.util.Arrays;
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
                    "3- Crear cuenta\n" +
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
                    if(sociosRepository.buscarSocio(dni) != null && sociosRepository.buscarSocio(dni).getContrasenia().equals(contrasenia)){
                        Socio socioLogueado = sociosRepository.buscarSocio(dni);
                        menuPrincipalSocio.menuPrincipalSocio(socioLogueado);
                    }
                    //Nos fijamos si los datos de logeo corresponden a un Directivo
                    if(directivoRepository.buscarDirectivo(dni) != null && directivoRepository.buscar(dni).getContrasenia().equals(contrasenia)){
                        Directivo directivo = directivoRepository.buscarDirectivo(dni);
                        menuPrincipalDirectivo.menuPrincipalDirectivo(directivo);
                    }
                    else{
                        System.out.println("Los datos ingresados son incorrectos.");
                    }
                    break;
                case 2:
                    System.out.println("***RECUPERAR CONTRASEÑA***\n\n");
                    System.out.print("Ingrese DNI: ");
                    dni = sn.nextLine();

                    if(sociosRepository.buscarSocio(dni) != null){
                        System.out.println("Un administrador se contactara con usted.");
                    }else{
                        System.out.println("DNI no valido.");
                    }
                    break;
                case 3:
                    if(crearUsuario())
                        System.out.println("Usuario creado con exito. Por favor logear para cotinuar");
                    else
                        System.out.println("Fallo al crear el usuario. Vuelva a intentar mas tarde ");
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


    public boolean crearUsuario() {
        SociosRepository repository = new SociosRepository();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar nombre: ");
        String nombre = scan.nextLine();

        System.out.println("Ingresar apellido: ");
        String apellido = scan.nextLine();

        System.out.println("Ingresar dni: ");
        String dni = scan.nextLine();

        System.out.println("Ingresar telefono: ");
        String telefono = scan.nextLine();

        System.out.println("Ingresar direccion: ");
        String direccion = scan.nextLine();

        System.out.println("Por favor, elija el deporte al que quiere registratse: \n" +
                "1- Futbol\n" +
                "2- Basquet\n" +
                "3- Volley\n" +
                "4- Handball\n" +
                "5- Natacion\n" +
                "6- Tennis");

        int eleccion = scan.nextInt();
        String deporte = "";
        Deporte deporteElegido = Deporte.VOLLEY;

        switch (eleccion) {
            case 1:
                deporteElegido = Deporte.FUTBOL;
                deporte = deporteElegido.name();

            case 2:
                deporteElegido = Deporte.BASQUET;
                deporte = deporteElegido.name();
                break;
            case 3:
                deporteElegido = Deporte.VOLLEY;
                deporte = deporteElegido.name();
                break;
            case 4:
                deporteElegido = Deporte.HANDBALL;
                deporte = deporteElegido.name();
                break;
            case 5:
                deporteElegido = Deporte.NATACION;
                deporte = deporteElegido.name();
                break;
            case 6:
                deporteElegido = Deporte.TENNIS;
                deporte = deporteElegido.name();
                break;
        }

        boolean validacion = true;
        String contrasenia = "";
        while (validacion) {
            System.out.println("Ingresar contraseña de al menos 8 digitos: ");
            contrasenia = scan.nextLine();

            if (contrasenia.length() < 8)
                System.out.println("Contraseña demasiado corta");
            else
                validacion = false;

        }

        Socio socio = new Socio(nombre, apellido, dni, contrasenia, telefono, direccion, deporteElegido, true);
        repository.agregar(socio);
        boolean agregado = false;
        for (Socio socio1 : repository.listar()) {
            if (socio1.getDni().equals(socio.getDni())) {
                agregado = true;
            }
        }
        return agregado;
    }
}

