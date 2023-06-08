package tpFinal.Repositorios.EmpleadosRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.AyudanteDeCampo;
import tpFinal.Models.Empleado.Jugador;
import tpFinal.Repositorios.IRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AyudanteDeCampoRepository implements IRepository<AyudanteDeCampo> {
    private final File file = new File("src/main/resources/AyudanteDeCampo.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<AyudanteDeCampo> ayudanteDeCampoList;
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, AyudanteDeCampo.class);
            this.ayudanteDeCampoList = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.ayudanteDeCampoList = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.ayudanteDeCampoList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AyudanteDeCampo> listar() {
        cargar();
        return this.ayudanteDeCampoList;
    }

    @Override
    public void agregar(AyudanteDeCampo objeto) {
        cargar();
        this.ayudanteDeCampoList.add(objeto);
        guardar();
    }

    @Override
    public void agregarLista(List<AyudanteDeCampo> lista) {
        cargar();
        this.ayudanteDeCampoList.addAll(lista);
        guardar();
    }

    @Override
    public void eliminar(String dni) {
        cargar();
        for (AyudanteDeCampo ayudanteDeCampo : this.ayudanteDeCampoList )
            if (ayudanteDeCampo.getDni().equals(dni))
                this.ayudanteDeCampoList.remove(ayudanteDeCampo);

    }

    @Override
    public void modificar(String dni) {

    }
}
