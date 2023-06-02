package org.Models;

import java.util.Scanner;

public class Socio extends Usuario{
    private boolean estadoContable; /// DEUDOR o AL DIA

    public Socio(String nombre, String apellido, String dni, String contrasenia, String telefono, String direccion, boolean estadoContable) {
        super(nombre, apellido, dni, contrasenia, telefono, direccion);
        this.estadoContable = estadoContable;
    }
    public Socio(){}

    public boolean isEstadoContable() {
        return estadoContable;
    }

    public void setEstadoContable(boolean estadoContable) {
        this.estadoContable = estadoContable;
    }

    void comprarEntrada(){
        // listar deportes para seleccionar uno
        // listar categorias para seleccionar una
    }

    void comprarMerchandasing(){

    }

    void modificarSocio(){
        Scanner leer = new Scanner(System.in);
        String cambio; // USO ESTA VARIABLE PARA GUARDAR LOS CAMBIOS SI ASI EL SOCIO LO DESEA

        System.out.print("MODIFICAR CONTRASEÑA? 1 SI - 2 NO: ");
        int opcion = leer.nextInt();

        if(opcion == 1){
            System.out.print("NUEVA CONTRASEÑA: ");
            cambio = leer.next();

            while(opcion == 1) {
                System.out.print("INGRESE NUEVAMENTE LA CONTRASEÑA: ");
                String cambio2 = leer.next();
                if (cambio == cambio2) {
                    setContrasenia(cambio);
                    System.out.println("LA CONTRASEÑA FUE MODIFICADA CORRECTAMENTE.");
                    opcion = -1;
                } else {
                    System.out.println("LA CONTRASEÑA INGRESADA NO COINCIDE. INTENTE NUEVAMENTE.");
                }
            }
        }

        System.out.print("MODIFICAR TELEFONO? 1 SI - 2 NO: ");
        opcion = leer.nextInt();

        if(opcion == 1){
            System.out.print("INGRESE EL TELEFONO: ");
            cambio = leer.next();
            setTelefono(cambio);
            System.out.println("EL TELEFONO FUE MODIFICADO CORRECTAMENTE.");
        }

        System.out.print("MODIFICAR DIRECCION? 1 SI - 2 NO: ");
        opcion = leer.nextInt();

        if(opcion == 1){
            System.out.print("INGRESE LA DIRECCION: ");
            cambio = leer.next();
            setDireccion(cambio);
            System.out.println("LA DIRECCION FUE MODIFICADA CORRECTAMENTE.");
        }
    }

    void verEstadoContable(){
        if(this.estadoContable){
            System.out.println("USTED ESTA AL DIA.");
        }else{
            System.out.println("USTED POSEE DEUDA.");
        }
    }

    void verBeneficios(){
        // listar beneficios del club para los socios
    }

}
