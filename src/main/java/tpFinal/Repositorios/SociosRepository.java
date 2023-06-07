package tpFinal.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Socio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class SociosRepository implements IRepository<Socio> {
    private final File archivo = new File("C:\test");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Socio> listaSocios;


    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Socio.class);
            this.listaSocios = mapper.readValue(archivo, collectionType);
        }catch (IOException e){
            this.listaSocios = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {

    }

    @Override
    public List<Socio> listar() {
        return null;
    }

    @Override
    public void agregar(Socio objeto) {

    }

    @Override
    public void agregarLista(List<Socio> lista) {

    }

    @Override
    public void eliminar(String dni) {

    }

    @Override
    public void modificar(String dni) {

    }
}
