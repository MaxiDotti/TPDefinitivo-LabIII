package tpFinal.Repositorios.EmpleadosRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.AyudanteDeCampo;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Repositorios.IRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AyudanteDeCampoRepository implements IRepository<AyudanteDeCampo> {
    private final File file = new File("src/main/resources/AyudanteDeCampo.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<AyudanteDeCampo> campoList;
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, AyudanteDeCampo.class);
            this.campoList = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.campoList = new ArrayList<>();
        }

    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.campoList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AyudanteDeCampo> listar() {
        cargar();
        return this.campoList;
    }

    @Override
    public void agregar(AyudanteDeCampo objeto) {
        cargar();
        this.campoList.add(objeto);
        guardar();
    }

    @Override
    public void agregarLista(List<AyudanteDeCampo> lista) {
        cargar();
        this.campoList.addAll(lista);
        guardar();
    }

    @Override
    public void eliminar(AyudanteDeCampo persona) {
        cargar();
        this.campoList.remove(persona);
        guardar();
    }

    @Override
    public void modificar(AyudanteDeCampo dni) {

    }
}
