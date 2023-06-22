package tpFinal.Menues.Socio;

import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.SocioService;

import java.util.Scanner;

public class MenuSocioHar {

    public boolean menuPrincipalSocio(Socio socioLogeado) throws ObjetoNoEncontradoException, ObjetoEncontradoException {

        SocioService socioService = new SocioService();
        SociosRepository sociosRepository = new SociosRepository();
        mostrarSocio();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarSocio();
            System.out.print("Ingrese el número de opción que desea realizar: ");
            opcion = scanner.nextInt();

            System.out.println("===== Menú del Socio =====");
            System.out.println("1. Ver información del Socio");
            scanner.nextLine();
            mostrarSocio();
            System.out.println("2. Actualizar información del Socio");
            scanner.nextLine();
            System.out.println("3. Eliminar Socio");
            scanner.nextLine();
            System.out.println("4. Salir");
            scanner.nextLine();
            System.out.print("Ingrese una opción: ");
            try {
                opcion = scanner.nextInt();
            } catch (Throwable e) {
                System.out.println("Caracter invalido, debe ingresar un numero");
                scanner.nextLine();
            }


            switch (opcion) {
                case 1:
                    System.out.println("AGREGAR SOCIO");
                    sociosRepository.guardar();
                    mostrarSocio();
                    break;
                case 2:
                    System.out.println("Eliminar Socio:");
                    socioService.eliminar(socioLogeado.getDni());
                    break;
                case 3:
                    System.out.println("Modificar Socio:");
                    socioService.buscarSocio2(socioLogeado.getDni());
                    socioService.modificar(socioLogeado);
                    socioService.cambiarContrasenia(socioLogeado.getContrasenia(), socioLogeado.getDni());
                    break;
                case 4:
                    System.out.println("***ESTADO CONTABLE***\n\n");
                    if (socioLogeado.isEstadoContable()) {
                        System.out.println("Estado contable: AL DIA\n");
                    } else {
                        System.out.println("Estado contable: EN DEUDA\n");
                    }
                    mostrarSocio();
                    break;
                case 5:
                    System.out.println("----SALIR----");
                    scanner.nextLine();
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número válido.");
                    break;
            }
        } while (opcion != 4);
        return false;
    }


    public static void mostrarSocio() {
        System.out.println("Información personal:");
        System.out.println("Nombre: Juan");
        System.out.println("Apellido: Pérez");
        System.out.println("Edad: 35 años");
        System.out.println("Dirección: Calle Falsa 123");
        System.out.println("Teléfono: 555-1234");
        System.out.println("DNI: 4578218");
        System.out.println("Contraseña : LSas1.@ad312");
    }


    }



