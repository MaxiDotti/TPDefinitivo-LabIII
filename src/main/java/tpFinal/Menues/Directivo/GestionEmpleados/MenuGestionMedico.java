package tpFinal.Menues.Directivo.GestionEmpleados;

import tpFinal.Menues.Directivo.MenuPrincipalDirectivo;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.Medico;
import tpFinal.Repositorios.EmpleadosRepository.MedicoRepository;
import tpFinal.Services.MedicoService;

import java.util.Scanner;

public class MenuGestionMedico {

    public void menuGestionMedico(Directivo directivoLogeado) {
        Scanner sn = new Scanner(System.in);


        boolean salir = false;
        int opcion;

        Medico medicoAModificar = new Medico();
        MedicoService medicoService = new MedicoService();
        MedicoRepository medicoRepository = new MedicoRepository();

        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        while (!salir) {
            System.out.println("*****MENU GESTION DE MEDICO******\n\n");
            System.out.println("1- Alta\n2- Baja\n3- Modificacion\n4- Listar Medicos\n5- Atras\n0- Salir\n\nOPCION: ");
            opcion = sn.nextInt();
            sn.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("***ALTA DE Medico***\n\n");
                    System.out.println("Ingrese los siguientes datos para dar de alta un Medico: \n\n");
                    System.out.println("Nombre: \n");
                    medicoAModificar.setNombre(sn.nextLine());
                    System.out.println("Apellido: \n");
                    medicoAModificar.setApellido(sn.nextLine());
                    System.out.println("DNI: \n");
                    medicoAModificar.setDni(sn.nextLine());
                    System.out.println("Contrasenia: \n");
                    medicoAModificar.setContrasenia(sn.nextLine());
                    System.out.println("Telefono: \n");
                    medicoAModificar.setTelefono(sn.nextLine());
                    System.out.println("Direccion: \n");
                    medicoAModificar.setDireccion(sn.nextLine());
                    System.out.println("Especialidad: \n");
                    medicoAModificar.setEspecialidad(sn.nextLine());
                    medicoAModificar.setEstadoContable(true);

                    medicoService.agregar(medicoAModificar);
                    break;
                case 2:
                    System.out.println("***BAJA***\n");
                    System.out.println("Ingrese el DNI: \n");
                    if (medicoRepository.buscarMedico(sn.nextLine()) != null){
                        medicoService.eliminar(sn.nextLine());
                        System.out.println("Medico eliminado.");
                    }else{
                        System.out.println("El DNI ingresado no existe en la base de datos.");
                    }
                    break;
                case 3:
                    System.out.println("***MODIFICACION***\n");
                    System.out.print("Ingrese el DNI del Medico: ");
                    String dni = sn.nextLine();
                    if(medicoRepository.buscarMedico(dni) != null){
                        medicoAModificar = medicoRepository.buscarMedico(dni);

                        System.out.println("Ingrese los siguientes datos para dar modificar el socio: \n\n");
                        System.out.println("Contrasenia: ");
                        medicoAModificar.setContrasenia(sn.nextLine());
                        System.out.println("Telefono: ");
                        medicoAModificar.setTelefono(sn.nextLine());
                        System.out.println("Direccion: ");
                        medicoAModificar.setDireccion(sn.nextLine());
                        System.out.println("Especialidad: ");
                        medicoAModificar.setEspecialidad(sn.nextLine());

                        medicoService.modificar(medicoAModificar);
                    }else{
                        System.out.println("El DNI ingresado no se encuentra en la base de datos.");
                    }
                    break;
                case 4:
                    System.out.println(medicoService.listar());
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
