package tpFinal.Menues.Directivo;

import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.*;

import java.util.Scanner;

public class MenuGestionSocios {
    public void menuGestionDeSocios() {
        Scanner sn = new Scanner(System.in);
        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        boolean salir = false;
        int opcion;

        Socio socioAModificar = new Socio();
        SocioService socioService = new SocioService();
        SociosRepository sociosRepository = new SociosRepository();

        AyudanteDeCampoService ayudanteDeCampoService = new AyudanteDeCampoService();
        JugadorService jugadorService = new JugadorService();
        MedicoService medicoService = new MedicoService();
        PersonalLimpiezaService personalLimpiezaService = new PersonalLimpiezaService();
        UtileroService utileroService = new UtileroService();

        BeneficioService beneficioService = new BeneficioService();

        while (!salir) {
            System.out.println("*****MENU GESTION DE SOCIOS******\n\n\n");
            System.out.println("1- Alta de Socio\n2- Baja de Socio\n3- Modificacion de Socio\n4- Atras\n0- Salir\n");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:

                    System.out.println("***ALTA DE SOCIO***\n\n");
                    System.out.println("Ingrese los siguientes datos para dar de alta un socio: \n\n");
                    System.out.println("Nombre: \n");
                    socioAModificar.setNombre(sn.nextLine());
                    System.out.println("Apellido: \n");
                    socioAModificar.setApellido(sn.nextLine());
                    System.out.println("DNI: \n");
                    socioAModificar.setDireccion(sn.nextLine());
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
                    socioService.eliminar(sn.nextLine());
                    break;
                case 3:
                    System.out.println("***MODIFICACION DE SOCIO***\n");
                    System.out.println("Ingrese el DNI del socio a modificar: \n");
                    try {
                        if(socioService.buscarSocio(sn.nextLine())){
                            socioAModificar = sociosRepository.buscar(sn.nextLine());

                            System.out.println("Ingrese los siguientes datos para dar modificar el socio: \n\n");
                            System.out.println("Nombre: \n");
                            socioAModificar.setNombre(sn.nextLine());
                            System.out.println("Apellido: \n");
                            socioAModificar.setApellido(sn.nextLine());
                            System.out.println("Contrasenia: \n");
                            socioAModificar.setContrasenia(sn.nextLine());
                            System.out.println("Telefono: \n");
                            socioAModificar.setTelefono(sn.nextLine());
                            System.out.println("Direccion: \n");
                            socioAModificar.setDireccion(sn.nextLine());

                            socioService.modificar(socioAModificar);
                        }
                    } catch (ObjetoNoEncontradoException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    menuPrincipalDirectivo.menuPrincipalDirectivo();
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
