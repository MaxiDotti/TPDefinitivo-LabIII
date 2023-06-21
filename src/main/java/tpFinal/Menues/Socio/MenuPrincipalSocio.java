package tpFinal.Menues.Socio;

import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.BeneficioService;
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

        BeneficioService beneficioService = new BeneficioService();

        while (!salir) {
            System.out.println("*****MENU PRINCIPAL SOCIO******\n\n\n");
            System.out.println("1- Ver información personal\n" +
                    "2- Adquirir entrada\n" +
                    "3- Ver estado contable\n" +
                    "4-Tienda\n" +
                    "5-Beneficios\n" +
                    "0- Salir\n");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("***INFORMACION PERSONAL***\n\n");
                    socioLogeado.toString();
                    break;
                case 2:
                    //en este caso tenemos que definir qué hacemos con el tema de las entradas.
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
                    //acá hay q armar el json de la tienda y mostrar todo
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
