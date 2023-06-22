package tpFinal.Menues.Directivo;

import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Directivo;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.*;

import java.util.Scanner;

public class MenuGestionSocios {
    public void menuGestionDeSocios(Directivo directivoLogeado) {
        Scanner sn = new Scanner(System.in);
        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        boolean salir = false;
        int opcion;
        String dni;

        Socio socioAModificar = new Socio();
        SocioService socioService = new SocioService();
        SociosRepository sociosRepository = new SociosRepository();

        while (!salir) {
            System.out.println("*****MENU GESTION DE SOCIOS******\n\n");
            System.out.println("1- Alta de Socio\n2- Baja de Socio\n3- Modificacion de Socio\n4- Listar Socios\n5- Atras\n0- Salir\n\nOPCION: ");
            opcion = sn.nextInt();
            sn.nextLine();
            switch (opcion) {
                case 1:

                    System.out.println("***ALTA DE SOCIO***\n\n");
                    System.out.println("Ingrese los siguientes datos para dar de alta un socio: \n\n");
                    System.out.println("Nombre: \n");
                    socioAModificar.setNombre(sn.nextLine());
                    System.out.println("Apellido: \n");
                    socioAModificar.setApellido(sn.nextLine());
                    System.out.println("DNI: \n");
                    socioAModificar.setDni(sn.nextLine());
                    System.out.println("Contrasenia: \n");
                    socioAModificar.setContrasenia(sn.nextLine());
                    System.out.println("Telefono: \n");
                    socioAModificar.setTelefono(sn.nextLine());
                    System.out.println("Direccion: \n");
                    socioAModificar.setDireccion(sn.nextLine());
                    socioAModificar.setEstadoContable(true);

                    socioService.agregar(socioAModificar);
                    break;
                case 2:
                    System.out.println("***BAJA DE SOCIO***\n");
                    System.out.println("Ingrese el DNI del socio: \n");
                    dni = sn.nextLine();
                    if (sociosRepository.buscarSocio(dni) != null){
                        socioService.eliminar(dni);
                        System.out.println("Socio eliminado.");
                    }else{
                        System.out.println("El DNI ingresado no existe en la base de datos.");
                    }

                    break;
                case 3:
                    System.out.println("***MODIFICACION DE SOCIO***\n");

                    System.out.print("Ingrese el DNI del socio a modificar: ");
                    dni = sn.nextLine();
                        if(sociosRepository.buscarSocio(dni) != null){
                            socioAModificar = sociosRepository.buscarSocio(dni);

                            System.out.println("Ingrese los siguientes datos para dar modificar el socio: \n\n");
                            System.out.println("Contrasenia: ");
                            socioAModificar.setContrasenia(sn.nextLine());
                            System.out.println("Telefono: ");
                            socioAModificar.setTelefono(sn.nextLine());
                            System.out.println("Direccion: ");
                            socioAModificar.setDireccion(sn.nextLine());

                            socioService.modificar(socioAModificar);
                        }else{
                            System.out.println("El DNI ingresado no se encuentra en la base de datos.");
                        }
                    break;
                case 4:
                    System.out.println(socioService.listar());
                    break;
                case 5:
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
