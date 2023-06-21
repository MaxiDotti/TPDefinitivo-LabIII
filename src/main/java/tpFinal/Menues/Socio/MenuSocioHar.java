package tpFinal.Menues.Socio;

import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.SocioService;

import java.util.Scanner;

public class MenuSocioHar {

    public void menuPrincipalSocio(Socio socioLogeado) throws ObjetoNoEncontradoException, ObjetoEncontradoException {

        SocioService socioService = new SocioService();
        socioService.agregar(socioLogeado);
        SociosRepository sociosRepository = new SociosRepository();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Ingrese el número de opción que desea realizar: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Información personal:");
                    System.out.println("Nombre: Juan Pérez");
                    System.out.println("Apellido: Pérez");
                    System.out.println("Edad: 35 años");
                    System.out.println("Dirección: Calle Falsa 123");
                    System.out.println("Teléfono: 555-1234");
                    System.out.println("DNI: 4578218");
                    System.out.println("Contraseña : LSas1.@ad312");
                    socioLogeado.toString();
                    break;
                case 2:
                    System.out.println("Agregar socio:");
                    sociosRepository.guardar();
                    break;
                case 3:
                    System.out.println("Eliminar Socio:");
                    socioService.buscarSocio(socioLogeado.getDni());
                    socioService.eliminar(socioLogeado.getDni());
                    break;
                case 4:
                    System.out.println("Modificar Socio:");
                    socioService.buscarSocio2(socioLogeado.getDni());
                    socioService.modificar(socioLogeado);
                    socioService.cambiarContrasenia(socioLogeado.getContrasenia(),socioLogeado.getDni());
                    break;
                case 5:
                    System.out.println("***ESTADO CONTABLE***\n\n");
                    if(socioLogeado.isEstadoContable()){
                        System.out.println("Estado contable: AL DIA\n");
                    }else{
                        System.out.println("Estado contable: EN DEUDA\n");
                    }
                    break;
                case 6:
                    System.out.println("----SALIR----");
                    scanner.nextLine();
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número válido.");
                    break;
            }
        } while (opcion != 4);
    }

    public static void mostrarMenu() {
        System.out.println("*****MENU GESTION DE SOCIOS******\n\n\n");
        System.out.println("1- Agregar Socio" +
                "\n2-Eliminar Socio\n3- Modificacion de Socio" +
                "\n4- ESTADO CONTABLE\n0- Salir\n");
    }

}



