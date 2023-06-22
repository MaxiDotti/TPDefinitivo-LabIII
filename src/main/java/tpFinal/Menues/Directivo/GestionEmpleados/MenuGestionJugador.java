package tpFinal.Menues.Directivo.GestionEmpleados;
import tpFinal.Menues.Directivo.MenuPrincipalDirectivo;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.Jugador;
import tpFinal.Repositorios.EmpleadosRepository.JugadorRepository;
import tpFinal.Services.JugadorService;

import java.util.Scanner;

public class MenuGestionJugador {
    public void menuGestionJugador(Directivo directivoLogeado) {
        Scanner sn = new Scanner(System.in);


        boolean salir = false;
        int opcion;

        Jugador JugadorAModificar = new Jugador();
        JugadorService JugadorService = new JugadorService();
        JugadorRepository JugadorRepository = new JugadorRepository();

        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        while (!salir) {
            System.out.println("*****MENU GESTION DE DIRECTOR TECNICO******\n\n");
            System.out.println("1- Alta\n" +
                    "2- Baja\n" +
                    "3- Modificacion\n" +
                    "4- Listar Jugadores\n" +
                    "5- Atras\n" +
                    "0- Salir\n\n" +
                    "OPCION: ");
            opcion = sn.nextInt();
            sn.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("***ALTA DE JUGADOR***\n\n");
                    System.out.println("Ingrese los siguientes datos para dar de alta un jugador: \n\n");
                    System.out.println("Nombre: \n");
                    JugadorAModificar.setNombre(sn.nextLine());
                    System.out.println("Apellido: \n");
                    JugadorAModificar.setApellido(sn.nextLine());
                    System.out.println("DNI: \n");
                    JugadorAModificar.setDni(sn.nextLine());
                    System.out.println("Contrasenia: \n");
                    JugadorAModificar.setContrasenia(sn.nextLine());
                    System.out.println("Telefono: \n");
                    JugadorAModificar.setTelefono(sn.nextLine());
                    System.out.println("Direccion: \n");
                    JugadorAModificar.setDireccion(sn.nextLine());
                    System.out.println("Deporte: \n");
                    JugadorAModificar.setDeporte(sn.nextLine());
                    System.out.println("Categoria: \n");
                    JugadorAModificar.setCategoria(sn.nextLine());
                    System.out.println("Posicion: \n");
                    JugadorAModificar.setPosicion(sn.nextLine());
                    System.out.println("Equipo: \n");
                    JugadorAModificar.setEquipo(sn.nextLine());
                    JugadorAModificar.setEstadoContable(true);

                    JugadorService.agregar(JugadorAModificar);
                    break;
                case 2:
                    System.out.println("***BAJA***\n");
                    System.out.println("Ingrese el DNI: \n");
                    String dniBuscar = sn.nextLine();
                    if (JugadorRepository.buscarJugador(dniBuscar) != null){
                        JugadorService.eliminar(dniBuscar);
                        System.out.println("Jugador eliminado.");
                    }else{
                        System.out.println("El DNI ingresado no existe en la base de datos.");
                    }
                    break;
                case 3:
                    System.out.println("***MODIFICACION***\n");
                    //SE PUEDE MODIFICAR CONTRASEÑA, TELEFONO, DIRECCION, DEPORTE y CATEGORIA
                    System.out.print("Ingrese el DNI del jugador: ");
                    String dni = sn.nextLine();
                    if(JugadorRepository.buscarJugador(dni) != null){
                        JugadorAModificar = JugadorRepository.buscarJugador(dni);

                        System.out.println("Ingrese los siguientes datos para dar modificar el socio: \n\n");
                        System.out.println("Contrasenia: ");
                        JugadorAModificar.setContrasenia(sn.nextLine());
                        System.out.println("Telefono: ");
                        JugadorAModificar.setTelefono(sn.nextLine());
                        System.out.println("Direccion: ");
                        JugadorAModificar.setDireccion(sn.nextLine());
                        System.out.println("Deporte: ");
                        JugadorAModificar.setDeporte(sn.nextLine());
                        System.out.println("Categoria: ");
                        JugadorAModificar.setCategoria(sn.nextLine());

                        JugadorService.modificar(JugadorAModificar);
                    }else{
                        System.out.println("El DNI ingresado no se encuentra en la base de datos.");
                    }
                    break;
                case 4:
                    System.out.println(JugadorService.listar());
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
