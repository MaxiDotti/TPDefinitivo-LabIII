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

        Jugador jugadorAModificar = new Jugador();
        JugadorService jugadorService = new JugadorService();
        JugadorRepository jugadorRepository = new JugadorRepository();

        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        while (!salir) {
            System.out.println("*****MENU GESTION DE DIRECTOR TECNICO******\n\n");
            System.out.println("1- Alta\n2- Baja\n3- Modificacion\n4- Listar Jugadores\n5- Atras\n0- Salir\n\nOPCION: ");
            opcion = sn.nextInt();
            sn.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("***ALTA DE JUGADOR***\n\n");
                    System.out.println("Ingrese los siguientes datos para dar de alta un jugador: \n\n");
                    System.out.println("Nombre: \n");
                    jugadorAModificar.setNombre(sn.nextLine());
                    System.out.println("Apellido: \n");
                    jugadorAModificar.setApellido(sn.nextLine());
                    System.out.println("DNI: \n");
                    jugadorAModificar.setDni(sn.nextLine());
                    System.out.println("Contrasenia: \n");
                    jugadorAModificar.setContrasenia(sn.nextLine());
                    System.out.println("Telefono: \n");
                    jugadorAModificar.setTelefono(sn.nextLine());
                    System.out.println("Direccion: \n");
                    jugadorAModificar.setDireccion(sn.nextLine());
                    System.out.println("Deporte: \n");
                    jugadorAModificar.setDeporte(sn.nextLine());
                    System.out.println("Categoria: \n");
                    jugadorAModificar.setCategoria(sn.nextLine());
                    System.out.println("Posicion: \n");
                    jugadorAModificar.setPosicion(sn.nextLine());
                    System.out.println("Equipo: \n");
                    jugadorAModificar.setEquipo(sn.nextLine());
                    jugadorAModificar.setEstadoContable(true);

                    jugadorService.agregar(jugadorAModificar);
                    break;
                case 2:
                    System.out.println("***BAJA***\n");
                    System.out.println("Ingrese el DNI: \n");
                    if (jugadorRepository.buscarJugador(sn.nextLine()) != null){
                        jugadorService.eliminar(sn.nextLine());
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
                    if(jugadorRepository.buscarJugador(dni) != null){
                        jugadorAModificar = jugadorRepository.buscarJugador(dni);

                        System.out.println("Ingrese los siguientes datos para dar modificar el socio: \n\n");
                        System.out.println("Contrasenia: ");
                        jugadorAModificar.setContrasenia(sn.nextLine());
                        System.out.println("Telefono: ");
                        jugadorAModificar.setTelefono(sn.nextLine());
                        System.out.println("Direccion: ");
                        jugadorAModificar.setDireccion(sn.nextLine());
                        System.out.println("Deporte: ");
                        jugadorAModificar.setDeporte(sn.nextLine());
                        System.out.println("Categoria: ");
                        jugadorAModificar.setCategoria(sn.nextLine());

                        jugadorService.modificar(jugadorAModificar);
                    }else{
                        System.out.println("El DNI ingresado no se encuentra en la base de datos.");
                    }
                    break;
                case 4:
                    System.out.println(jugadorService.listar());
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
