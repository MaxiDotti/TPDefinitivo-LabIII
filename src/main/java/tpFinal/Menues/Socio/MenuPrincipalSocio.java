package tpFinal.Menues.Socio;

import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.BeneficioService;
import tpFinal.Services.PartidoService;
import tpFinal.Services.ProductoService;
import tpFinal.Services.SocioService;

import java.util.Scanner;

public class MenuPrincipalSocio {
    public void menuPrincipalSocio(Socio socioLogeado){
        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        int opcion;
        String dni;
        String contrasenia;

        SocioService socioService = new SocioService();
        SociosRepository sociosRepository = new SociosRepository();
        PartidoService partidoService = new PartidoService();
        BeneficioService beneficioService = new BeneficioService();
        ProductoService productoService = new ProductoService();

        while (!salir) {
            System.out.println("\n\n*****MENU PRINCIPAL SOCIO******\n\n");
            System.out.println("1- Ver información personal\n" +
                    "2- Visualizar próximos partidos \n" +
                    "3- Ver estado contable\n" +
                    "4- Visualizar tienda del club\n" +
                    "5- Beneficios para el socio\n" +
                    "0- Salir\n");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("***INFORMACION PERSONAL***\n\n");
                    System.out.println(socioLogeado);
                    System.out.println("\n------------------------------------");
                    break;
                case 2:
                    System.out.println(partidoService.listar());
                    break;
                case 3:
                    System.out.println("***ESTADO CONTABLE***\n\n");
                    if(socioLogeado.isEstadoContable()){
                        System.out.println("Estado contable: AL DIA\n");
                    }else{
                        System.out.println("Estado contable: EN DEUDA\n");
                    }
                    break;
                case 4:
                    System.out.println(productoService.listar());
                    break;
                case 5:
                    System.out.println("***BENEFICIOS DEL CLUB***\n\n");
                    System.out.println(beneficioService.listar());
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
