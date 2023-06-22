package tpFinal.Menues.Directivo.GestionEmpleados;
import tpFinal.Menues.Directivo.MenuPrincipalDirectivo;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.AyudanteDeCampo;
import tpFinal.Repositorios.EmpleadosRepository.AyudanteDeCampoRepository;
import tpFinal.Services.*;
import java.util.Scanner;

public class MenuGestionAyudanteDeCampo {
    public void menuGestionAyudanteDeCampo(Directivo directivoLogeado) {
        Scanner sn = new Scanner(System.in);
        MenuPrincipalDirectivo menuPrincipalDirectivo = new MenuPrincipalDirectivo();

        boolean salir = false;
        int opcion;
        String dni;

        AyudanteDeCampo ayudanteDeCampoAModificar = new AyudanteDeCampo();
        AyudanteDeCampoService ayudanteDeCampoService = new AyudanteDeCampoService();
        AyudanteDeCampoRepository ayudanteDeCampoRepository = new AyudanteDeCampoRepository();

        while (!salir) {
            System.out.println("*****MENU GESTION DE AYUDANTE DE CAMPO******\n\n");
            System.out.println("1- Alta\n2- Baja\n3- Modificacion\n4- Listar Ayudantes de campo\n5- Atras\n0- Salir\n\nOPCION: ");
            opcion = sn.nextInt();
            sn.nextLine();
            switch (opcion) {
                case 1:

                    System.out.println("***ALTA DE AYUDANTE DE CAMPO***\n\n");
                    System.out.println("Ingrese los siguientes datos para dar de alta un ayudante de campo: \n\n");
                    System.out.println("Nombre: \n");
                    ayudanteDeCampoAModificar.setNombre(sn.nextLine());
                    System.out.println("Apellido: \n");
                    ayudanteDeCampoAModificar.setApellido(sn.nextLine());
                    System.out.println("DNI: \n");
                    ayudanteDeCampoAModificar.setDni(sn.nextLine());
                    System.out.println("Contrasenia: \n");
                    ayudanteDeCampoAModificar.setContrasenia(sn.nextLine());
                    System.out.println("Telefono: \n");
                    ayudanteDeCampoAModificar.setTelefono(sn.nextLine());
                    System.out.println("Direccion: \n");
                    ayudanteDeCampoAModificar.setDireccion(sn.nextLine());
                    System.out.println("Plantel: \n");
                    ayudanteDeCampoAModificar.setPlantel(sn.nextLine());
                    System.out.println("Deporte: \n");
                    ayudanteDeCampoAModificar.setDeporte(sn.nextLine());
                    System.out.println("Categoria: \n");
                    ayudanteDeCampoAModificar.setCategoria(sn.nextLine());
                    ayudanteDeCampoAModificar.setEstadoContable(true);

                    ayudanteDeCampoService.agregar(ayudanteDeCampoAModificar);
                    break;
                case 2:
                    System.out.println("***BAJA de AYUDANTE DE CAMPO***\n");
                    System.out.println("Ingrese el DNI del ayudante de campo: ");
                    dni = sn.nextLine();
                    if (ayudanteDeCampoRepository.buscarAyudante(dni) != null){
                        ayudanteDeCampoService.eliminar(dni);
                        System.out.println("Ayudante de campo eliminado.");
                    }else{
                        System.out.println("El DNI ingresado no existe en la base de datos.");
                    }
                    break;
                case 3:
                    System.out.println("***MODIFICACION DE AYUDANTE DE CAMPO***\n");

                    System.out.print("Ingrese el DNI del ayudante de campo a modificar: ");
                    dni = sn.nextLine();
                    if(ayudanteDeCampoRepository.buscarAyudante(dni) != null){
                        ayudanteDeCampoAModificar = ayudanteDeCampoRepository.buscarAyudante(dni);

                        System.out.println("Ingrese los siguientes datos para a modificar: \n\n");
                        System.out.println("Contrasenia: ");
                        ayudanteDeCampoAModificar.setContrasenia(sn.nextLine());
                        System.out.println("Telefono: ");
                        ayudanteDeCampoAModificar.setTelefono(sn.nextLine());
                        System.out.println("Direccion: ");
                        ayudanteDeCampoAModificar.setDireccion(sn.nextLine());

                        ayudanteDeCampoService.modificar(ayudanteDeCampoAModificar);
                    }else{
                        System.out.println("El DNI ingresado no se encuentra en la base de datos.");
                    }
                    break;
                case 4:
                    System.out.println(ayudanteDeCampoService.listar());
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
