package tpFinal.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Models.Socio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SociosRepository implements IRepository<Socio> {
    private final File file = new File("src/main/resources/Socios.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Socio> listaSocios;

    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Socio.class);
            this.listaSocios = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.listaSocios = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listaSocios);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Socio> listar() {
        cargar();
        return this.listaSocios;
    }

    @Override
    public void agregar(Socio objeto) {
        cargar();
        this.listaSocios.add(objeto);
        guardar();
    }

    @Override
    public void agregarLista(List<Socio> lista) {
        cargar();
        this.listaSocios.addAll(lista);
        guardar();
    }

    @Override
    public void eliminar(String dni) {
        cargar();
        for (Socio socio : this.listaSocios)
            if (socio.getDni().equals(dni))
                this.listaSocios.remove(socio);

       guardar();
    }

    public boolean buscarSocio(String dni){ // RETORNA TRUE SI EL SOCIO EXISTE EN EL ARCHIVO
        cargar();
        for(Socio socio : this.listaSocios){
            if(socio.getDni() == dni){
                return true;
            }
        }
        return false;
    }

    @Override
    public void modificar(String dni) {
        cargar();
        for(Socio socio : this.listaSocios){
            if(socio.getDni() == dni){
                Socio modificado = modificarAux();
                socio.setContrasenia(modificado.getContrasenia());
                socio.setTelefono(modificado.getTelefono());
                socio.setDireccion(modificado.getDireccion());
            }
        }
        guardar();
    }

    public Socio modificarAux(){
        Socio nuevo = new Socio();

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
                    nuevo.setContrasenia(cambio2);
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
            nuevo.setTelefono(cambio);
            System.out.println("EL TELEFONO FUE MODIFICADO CORRECTAMENTE.");
        }

        System.out.print("MODIFICAR DIRECCION? 1 SI - 2 NO: ");
        opcion = leer.nextInt();

        if(opcion == 1){
            System.out.print("INGRESE LA DIRECCION: ");
            cambio = leer.next();
            nuevo.setDireccion(cambio);
            System.out.println("LA DIRECCION FUE MODIFICADA CORRECTAMENTE.");
        }
        return nuevo;
    }
}
