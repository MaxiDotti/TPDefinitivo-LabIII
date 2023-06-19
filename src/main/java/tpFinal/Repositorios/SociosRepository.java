package tpFinal.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
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
        return this.listaSocios;
    }

    @Override
    public void agregar(Socio objeto) {
        this.listaSocios.add(objeto);
    }

    // CUAL ES EL SENTIDO?
    @Override
    public void agregarLista(List<Socio> lista) {
        cargar();
        this.listaSocios.addAll(lista);
        guardar();
    }

    @Override
    public void eliminar(String dni){
        this.listaSocios.remove(buscarSocio(dni));
    }

    public Socio buscarSocio(String dni){
        for(Socio socio : this.listaSocios){
            if(socio.getDni().equals(dni)){
                return socio;
            }
        }
        return null;
    }

    @Override
    public void modificar(Socio objeto) {
        for(Socio socio : this.listaSocios){
            if(socio.getDni().equals(objeto.getDni())){
                socio.setContrasenia(objeto.getContrasenia());
                socio.setTelefono(objeto.getTelefono());
                socio.setDireccion(objeto.getDireccion());
            }
        }
    }

    @Override
    public Socio buscar(String dni) {
        return null;
    }

    public boolean estadoContable(String dni){
        cargar();
        for(Socio socio : this.listaSocios){
            if(socio.getDni().equals(dni)){
                if (socio.isEstadoContable()) {
                    return true;
                }
            }
        }
        return false;
    }
}

/* CODIGO DE MODIFICACION PARA EL MENU


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
                if (cambio.equals(cambio2)) {
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
*/
