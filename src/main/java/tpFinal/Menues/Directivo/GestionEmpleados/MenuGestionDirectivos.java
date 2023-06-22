package tpFinal.Menues.Directivo.GestionEmpleados;

import tpFinal.Menues.Directivo.MenuPrincipalDirectivo;
import tpFinal.Menues.MenuPrincipalAdministrador;
import tpFinal.Models.AdministradorDelSistema;
import tpFinal.Models.Directivo;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.DirectivoRepository;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.DirectivoService;
import tpFinal.Services.SocioService;

import java.util.Scanner;

public class MenuGestionDirectivos {

    public void menuGestionDirectivos(AdministradorDelSistema adminLogeado){
        Scanner sn = new Scanner(System.in);
        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        boolean salir = false;
        int opcion;

        MenuPrincipalAdministrador menuPrincipalAdministrador = new MenuPrincipalAdministrador();
        Directivo directivoAModificar = new Directivo();
        DirectivoService directivoService = new DirectivoService();
        DirectivoRepository directivoRepository = new DirectivoRepository();

        while (!salir) {
            System.out.println("*****MENU GESTION DE DIRECTIVOS******\n\n");
            System.out.println("1- Alta de Directivo\n2- Baja de Directivo\n3- Modificacion de Directivo\n4- Listar Directivo\n5- Atras\n0- Salir\n\nOPCION: ");
            opcion = sn.nextInt();
            sn.nextLine();
            switch (opcion) {
                case 1:

                    System.out.println("***ALTA DE Directivo***\n\n");
                    System.out.println("Ingrese los siguientes datos para dar de alta un Directivo: \n\n");
                    System.out.println("Nombre: \n");
                    directivoAModificar.setNombre(sn.nextLine());
                    System.out.println("Apellido: \n");
                    directivoAModificar.setApellido(sn.nextLine());
                    System.out.println("DNI: \n");
                    directivoAModificar.setDni(sn.nextLine());
                    System.out.println("Contrasenia: \n");
                    directivoAModificar.setContrasenia(sn.nextLine());
                    System.out.println("Telefono: \n");
                    directivoAModificar.setTelefono(sn.nextLine());
                    System.out.println("Direccion: \n");
                    directivoAModificar.setDireccion(sn.nextLine());

                    directivoService.agregar(directivoAModificar);
                    break;
                case 2:
                    System.out.println("***BAJA DE DIRECTIVO***\n");
                    System.out.println("Ingrese el DNI del directivo: \n");
                    String dni = sn.nextLine();
                    if (directivoRepository.buscarDirectivo(dni) != null){
                        directivoService.eliminar(dni);
                        System.out.println("directivo eliminado.");
                    }else{
                        System.out.println("El DNI ingresado no existe en la base de datos.");
                    }

                    break;
                case 3:
                    System.out.println("***MODIFICACION DE DIRECTIVO***\n");

                    System.out.print("Ingrese el DNI del directivo a modificar: ");
                    String dniIngresado = sn.nextLine();
                    if(directivoRepository.buscarDirectivo(dniIngresado) != null){
                        directivoAModificar = directivoRepository.buscarDirectivo(dniIngresado);

                        System.out.println("Ingrese los siguientes datos para dar modificar el directivo: \n\n");
                        System.out.println("Contrasenia: ");
                        directivoAModificar.setContrasenia(sn.nextLine());
                        System.out.println("Telefono: ");
                        directivoAModificar.setTelefono(sn.nextLine());
                        System.out.println("Direccion: ");
                        directivoAModificar.setDireccion(sn.nextLine());

                        directivoService.modificar(directivoAModificar);
                    }else{
                        System.out.println("El DNI ingresado no se encuentra en la base de datos.");
                    }
                    break;
                case 4:
                    System.out.println(directivoService.listar());
                    break;
                case 5:
                    menuPrincipalAdministrador.menuPrincipalAdministrador(adminLogeado);
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
