package tpFinal.Menues.Directivo.GestionEmpleados;

import tpFinal.Menues.Directivo.MenuPrincipalDirectivo;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.Medico;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Repositorios.EmpleadosRepository.MedicoRepository;
import tpFinal.Repositorios.EmpleadosRepository.PersonalLimpiezaRepository;
import tpFinal.Services.MedicoService;
import tpFinal.Services.PersonalLimpiezaService;

import java.util.Scanner;

public class MenuPersonalLimpieza {

    public void menuGestionPersonalLimpieza(Directivo directivoLogeado) {
        Scanner sn = new Scanner(System.in);


        boolean salir = false;
        int opcion;
        String dni;

        PersonalLimpieza personalLimpiezaAModificar = new PersonalLimpieza();
        PersonalLimpiezaService personalLimpiezaService = new PersonalLimpiezaService();
        PersonalLimpiezaRepository personalLimpiezaRepository = new PersonalLimpiezaRepository();

        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        while (!salir) {
            System.out.println("*****MENU GESTION DE Personal Limpieza******\n\n");
            System.out.println("1- Alta\n2- Baja\n3- Modificacion\n4- Listar Personal de Limpieza\n5- Atras\n0- Salir\n\nOPCION: ");
            opcion = sn.nextInt();
            sn.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("***ALTA DE Personal de Limpieza***\n\n");
                    System.out.println("Ingrese los siguientes datos para dar de alta un Medico: \n\n");
                    System.out.println("Nombre: \n");
                    personalLimpiezaAModificar.setNombre(sn.nextLine());
                    System.out.println("Apellido: \n");
                    personalLimpiezaAModificar.setApellido(sn.nextLine());
                    System.out.println("DNI: \n");
                    personalLimpiezaAModificar.setDni(sn.nextLine());
                    System.out.println("Contrasenia: \n");
                    personalLimpiezaAModificar.setContrasenia(sn.nextLine());
                    System.out.println("Telefono: \n");
                    personalLimpiezaAModificar.setTelefono(sn.nextLine());
                    System.out.println("Direccion: \n");
                    personalLimpiezaAModificar.setDireccion(sn.nextLine());
                    System.out.println("Sector: \n");
                    personalLimpiezaAModificar.setSector(sn.nextLine());
                    personalLimpiezaAModificar.setEstadoContable(true);

                    personalLimpiezaService.agregar(personalLimpiezaAModificar);
                    break;
                case 2:
                    System.out.println("***BAJA de PERSONAL DE LIMPIEZA***\n");
                    System.out.println("Ingrese el DNI: \n");
                    dni = sn.nextLine();
                    if (personalLimpiezaRepository.buscarPersonalLimpieza(dni) != null){
                        personalLimpiezaService.eliminar(dni);
                        System.out.println("Personal de limpieza eliminado.");
                    }else{
                        System.out.println("El DNI ingresado no existe en la base de datos.");
                    }
                    break;
                case 3:
                    System.out.println("***MODIFICACION***\n");
                    System.out.print("Ingrese el DNI del PERSONAL DE LIMPIEZA: ");
                    dni = sn.nextLine();
                    if(personalLimpiezaRepository.buscarPersonalLimpieza(dni) != null){
                        personalLimpiezaAModificar = personalLimpiezaRepository.buscarPersonalLimpieza(dni);

                        System.out.println("Ingrese los siguientes datos a modificar: \n\n");
                        System.out.println("Contrasenia: ");
                        personalLimpiezaAModificar.setContrasenia(sn.nextLine());
                        System.out.println("Telefono: ");
                        personalLimpiezaAModificar.setTelefono(sn.nextLine());
                        System.out.println("Direccion: ");
                        personalLimpiezaAModificar.setDireccion(sn.nextLine());
                        System.out.println("Especialidad: ");
                        personalLimpiezaAModificar.setSector(sn.nextLine());

                        personalLimpiezaService.modificar(personalLimpiezaAModificar);
                    }else{
                        System.out.println("El DNI ingresado no se encuentra en la base de datos.");
                    }
                    break;
                case 4:
                    System.out.println(personalLimpiezaService.listar());
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
