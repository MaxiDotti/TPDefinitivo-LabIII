package tpFinal.Repositorios.EmpleadosRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Models.Empleado.Utilero;
import tpFinal.Repositorios.IRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtileroRepository implements IRepository<Utilero> {

    private final File file = new File("src/main/resources/Utilero.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Utilero> listUtilero;
    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class,Utilero.class);
            this.listUtilero = mapper.readValue(file,collectionType);
        }catch (IOException e){
            this.listUtilero = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listUtilero);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Utilero> listar() {
        cargar();
        return this.listUtilero;
    }

    @Override
    public void agregar(Utilero objeto) {
        this.cargar();
        this.listUtilero.add(objeto);
        this.guardar();
    }

    @Override
    public void agregarLista(List<Utilero> lista) {
        this.cargar();
        this.listUtilero.addAll(lista);
        this.guardar();
    }

    @Override
    public void eliminar(String dni) {
        this.cargar();
        for(Utilero utilero : listUtilero){
            if(utilero.getDni().equals(dni))
                this.listUtilero.remove(utilero);
        }
        this.guardar();
    }

    @Override
    public void modificar(Utilero objeto) {

    }

    @Override
    public Utilero buscar(String dni) {
        return null;
    }

}