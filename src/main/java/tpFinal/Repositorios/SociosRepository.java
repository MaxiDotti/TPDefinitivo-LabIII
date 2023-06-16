package tpFinal.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Models.Socio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class SociosRepository implements IRepository<Socio> {
    private final File file = new File("src/main/resources/Socio.json");
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
    public void eliminar(Socio persona) {
        cargar();
        this.listaSocios.remove(persona);
        guardar();
    }

    @Override
    public void modificar(Socio persona) {

    }
}
