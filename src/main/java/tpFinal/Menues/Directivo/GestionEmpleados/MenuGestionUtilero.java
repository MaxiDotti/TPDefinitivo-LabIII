package tpFinal.Menues.Directivo.GestionEmpleados;

import tpFinal.Menues.Directivo.MenuPrincipalDirectivo;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.Utilero;
import tpFinal.Repositorios.EmpleadosRepository.UtileroRepository;
import tpFinal.Services.UtileroService;

import java.util.Scanner;

public class MenuGestionUtilero {

    public void menuGestionUtilero(Directivo directivoLogeado) {
        Scanner sn = new Scanner(System.in);


        boolean salir = false;
        int opcion;

        Utilero utilero = new Utilero();
        UtileroService utileroService = new UtileroService();
        UtileroRepository utileroRepository = new UtileroRepository();

        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        while (!salir) {
            System.out.println("*****MENU GESTION DE Utilero******\n\n");
            System.out.println("1- Alta\n2- Baja\n3- Modificacion\n4- Listar Utileros\n5- Atras\n0- Salir\n\nOPCION: ");
            opcion = sn.nextInt();
            sn.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("***ALTA DE UTILEROS***\n\n");
                    System.out.println("Ingrese los siguientes datos para dar de alta un Utilero: \n\n");
                    System.out.println("Nombre: \n");
                    utilero.setNombre(sn.nextLine());
                    System.out.println("Apellido: \n");
                    utilero.setApellido(sn.nextLine());
                    System.out.println("DNI: \n");
                    utilero.setDni(sn.nextLine());
                    System.out.println("Contrasenia: \n");
                    utilero.setContrasenia(sn.nextLine());
                    System.out.println("Telefono: \n");
                    utilero.setTelefono(sn.nextLine());
                    System.out.println("Direccion: \n");
                    utilero.setDireccion(sn.nextLine());
                    System.out.println("Deporte: \n");
                    utilero.setDeporte(sn.nextLine());
                    utilero.setEstadoContable(true);

                    utileroService.agregar(utilero);
                    break;
                case 2:
                    System.out.println("***BAJA***\n");
                    System.out.println("Ingrese el DNI: \n");
                    if (utileroRepository.buscarUtilero(sn.nextLine()) != null){
                        utileroService.eliminar(sn.nextLine());
                        System.out.println("Personal de limpieza eliminado.");
                    }else{
                        System.out.println("El DNI ingresado no existe en la base de datos.");
                    }
                    break;
                case 3:
                    System.out.println("***MODIFICACION***\n");
                    System.out.print("Ingrese el DNI del Medico: ");
                    String dni = sn.nextLine();
                    if(utileroRepository.buscarUtilero(dni) != null){
                        utilero = utileroRepository.buscarUtilero(dni);

                        System.out.println("Ingrese los siguientes datos para dar modificar el socio: \n\n");
                        System.out.println("Contrasenia: ");
                        utilero.setContrasenia(sn.nextLine());
                        System.out.println("Telefono: ");
                        utilero.setTelefono(sn.nextLine());
                        System.out.println("Direccion: ");
                        utilero.setDireccion(sn.nextLine());
                        System.out.println("Deporte: ");
                        utilero.setDeporte(sn.nextLine());

                        utileroService.modificar(utilero);
                    }else{
                        System.out.println("El DNI ingresado no se encuentra en la base de datos.");
                    }
                    break;
                case 4:
                    System.out.println(utileroService.listar());
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
