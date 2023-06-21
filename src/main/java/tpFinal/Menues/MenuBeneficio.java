package tpFinal.Menues;

import tpFinal.Models.Beneficio;
import tpFinal.Repositorios.BeneficioRepository;
import tpFinal.Services.BeneficioService;

import java.util.Scanner;

public class MenuBeneficio  {
    BeneficioRepository beneficioRepository = new BeneficioRepository();
    BeneficioService beneficioService = new BeneficioService();

    Scanner scan = new Scanner(System.in);
    private boolean condicion = true;
    private int eleccion = 0;

    public void categorias(){
        while (condicion){
            System.out.println("Por favor elija una opcion: ");
            System.out.println("1- Listar beneficios\n" +
                    "2- Agregar beneficio\n" +
                    "3- Eliminar beneficio");
            eleccion = scan.nextInt();
            switch (eleccion){
                case 1:
                    listarBeneficios();
                    break;
                case 2:
                    agregarBeneficio();
                    break;
                case 3:
                    int estado;
                    System.out.println("Por favor elija la opcion que corresponda.");
                    System.out.println("1- Conozco el id del beneficio que quiero eliminar\n" +
                            "2- No conozco el id del beneficio");
                    estado = scan.nextInt();
                    switch (estado){
                        case 1:
                            System.out.println("por favor ingrese el ID a eliminar.");
                            eliminarBeneficioId(scan.nextLine());
                            break;
                        case 2:
                            eliminarBeneficioSinId();
                            break;
                    }
                    break;

            }

        }
    }

    public void listarBeneficios(){
        System.out.println(beneficioService.listar());
    }

    public void agregarBeneficio(){
        Scanner scanAux = new Scanner(System.in);
        Beneficio agregar = new Beneficio();
        System.out.println("Bienvenido al menu para agregar beneficios");
        System.out.println("Por favor introduzca el id");
        agregar.setId(scanAux.nextLine());
        System.out.println("Por favor introduazca el proveedor.");
        agregar.setProveedor(scanAux.nextLine());
        System.out.println("Por favor introduzca la categoria");
        agregar.setCategoria(scanAux.nextLine());
        System.out.println("Por favor introduzca el tipo de descuento. Recuerde que puede ser un numero plano o porcentual.");
        agregar.setTipoDeDescuento(scanAux.nextLine());
        System.out.println("Por favor introduzca la fecha de vencimiento del descuento. Recuerde utilizar el formato AAAA:MM:DD");
        agregar.setFechaDeUtilidad(scanAux.nextLine());
        beneficioRepository.agregar(agregar);
        System.out.println("Beneficio agregado correctamente");
    }

    public boolean eliminarBeneficioId(String id){
        boolean eliminado = true;
        for (Beneficio beneficio : beneficioRepository.listar()){
            if(beneficio.getId().equals(id)){
                beneficioRepository.eliminar(id);
            }
        }
        for (Beneficio beneficio : beneficioRepository.listar()){
            if(beneficio.getId().equals(id)){
                eliminado = false;
            }
        }
        return eliminado;
    }

    public boolean eliminarBeneficioSinId(){
        Scanner scanAux = new Scanner(System.in);
        boolean eliminado = true;
        System.out.println("Aqui esta la lsita de beneficios disponibles: ");
        beneficioRepository.listar();
        System.out.println("\n\nPor favor ingresar el ID del beneficio a eliminar: ");
        String eliminar = scanAux.nextLine();
        for (Beneficio beneficio : beneficioRepository.listar()){
            if (beneficio.getId().equals(eliminar)){
                beneficioRepository.eliminar(eliminar);
            }
        }
        for (Beneficio beneficio : beneficioRepository.listar()){
            if(beneficio.getId().equals(eliminar))
                eliminado = false;
        }
        return eliminado;
    }
}

