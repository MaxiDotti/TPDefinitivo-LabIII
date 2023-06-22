package tpFinal.Menues.Directivo.GestionEmpleados;

import tpFinal.Menues.Directivo.MenuPrincipalDirectivo;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.DirectorTecnico;
import tpFinal.Repositorios.EmpleadosRepository.DirectorTecnicoRepository;
import tpFinal.Services.DirectorTecnicoService;

import java.util.Scanner;

public class MenuGestionDirectorTecnico {


    public void menuGestionDirectorTecnico(Directivo directivoLogeado) {
        Scanner sn = new Scanner(System.in);


        boolean salir = false;
        int opcion;

        DirectorTecnico directorTecnicoAModificar = new DirectorTecnico();
        DirectorTecnicoService directorTecnicoService = new DirectorTecnicoService();
        DirectorTecnicoRepository directorTecnicoRepository = new DirectorTecnicoRepository();

        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        while (!salir) {
            System.out.println("*****MENU GESTION DE DIRECTOR TECNICO******\n\n");
            System.out.println("1- Alta\n2- Baja\n3- Modificacion\n4- Listar Directores Tecnicos\n5- Atras\n0- Salir\n\nOPCION: ");
            opcion = sn.nextInt();
            sn.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("***ALTA DE DIRECTOR TECNICO***\n\n");
                    System.out.println("Ingrese los siguientes datos para dar de alta un director tecnico: \n\n");
                    System.out.println("Nombre: \n");
                    directorTecnicoAModificar.setNombre(sn.nextLine());
                    System.out.println("Apellido: \n");
                    directorTecnicoAModificar.setApellido(sn.nextLine());
                    System.out.println("DNI: \n");
                    directorTecnicoAModificar.setDni(sn.nextLine());
                    System.out.println("Contrasenia: \n");
                    directorTecnicoAModificar.setContrasenia(sn.nextLine());
                    System.out.println("Telefono: \n");
                    directorTecnicoAModificar.setTelefono(sn.nextLine());
                    System.out.println("Direccion: \n");
                    directorTecnicoAModificar.setDireccion(sn.nextLine());
                    System.out.println("Deporte: \n");
                    directorTecnicoAModificar.setDeporte(sn.nextLine());
                    System.out.println("Categoria: \n");
                    directorTecnicoAModificar.setCategoria(sn.nextLine());
                    System.out.println("Plantel: \n");
                    directorTecnicoAModificar.setPlantel(sn.nextLine());
                    directorTecnicoAModificar.setEstadoContable(true);

                    directorTecnicoService.agregar(directorTecnicoAModificar);
                    break;
                case 2:
                    System.out.println("***BAJA DE DIRECTOR TECNICO***\n" +
                            "Ingrese el DNI del director tecnico: ");
                    String datoIngresado = sn.nextLine();
                    if (directorTecnicoRepository.buscarDirectorTecnico(datoIngresado) != null){
                        directorTecnicoService.eliminar(datoIngresado);
                        System.out.println("Director tecnico eliminado.");
                    }else{
                        System.out.println("El DNI ingresado no existe en la base de datos.");
                    }
                    break;
                case 3:
                    System.out.println("***MODIFICACION DE DIRECTOR TECNICO***\n");
                    //SE PUEDE MODIFICAR CONTRASEÑA, TELEFONO, DIRECCION, DEPORTE y CATEGORIA
                    System.out.print("Ingrese el DNI del director tecnico a modificar: ");
                    String dni = sn.nextLine();
                    if(directorTecnicoRepository.buscarDirectorTecnico(dni) != null){
                        directorTecnicoAModificar = directorTecnicoRepository.buscarDirectorTecnico(dni);

                        System.out.println("Ingrese los siguientes datos para dar modificar el socio: \n\n");
                        System.out.println("Contrasenia: ");
                        directorTecnicoAModificar.setContrasenia(sn.nextLine());
                        System.out.println("Telefono: ");
                        directorTecnicoAModificar.setTelefono(sn.nextLine());
                        System.out.println("Direccion: ");
                        directorTecnicoAModificar.setDireccion(sn.nextLine());
                        System.out.println("Deporte: ");
                        directorTecnicoAModificar.setDeporte(sn.nextLine());
                        System.out.println("Categoria: ");
                        directorTecnicoAModificar.setCategoria(sn.nextLine());

                        directorTecnicoService.modificar(directorTecnicoAModificar);
                    }else{
                        System.out.println("El DNI ingresado no se encuentra en la base de datos.");
                    }
                    break;
                case 4:
                    System.out.println(directorTecnicoService.listar());
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
