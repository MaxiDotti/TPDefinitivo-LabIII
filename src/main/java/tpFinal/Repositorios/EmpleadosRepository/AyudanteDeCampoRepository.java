package tpFinal.Repositorios.EmpleadosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.AyudanteDeCampo;
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
        return this.ayudanteDeCampoList;
    }

    @Override
    public void agregar(AyudanteDeCampo objeto) {
        this.ayudanteDeCampoList.add(objeto);
    }

    @Override
    public void agregarLista(List<AyudanteDeCampo> lista) {
        cargar();
        this.ayudanteDeCampoList.addAll(lista);
        guardar();
    }

    @Override
    public void eliminar(String dni) {
        this.ayudanteDeCampoList.remove(buscar(dni));
    }

    @Override
    public void modificar(AyudanteDeCampo objeto) {
        for(AyudanteDeCampo ayudanteDeCampo : this.ayudanteDeCampoList){
            if(ayudanteDeCampo.getDni().equals(objeto.getDni())){
                ayudanteDeCampo.setContrasenia(objeto.getContrasenia());
                ayudanteDeCampo.setTelefono(objeto.getTelefono());
                ayudanteDeCampo.setDireccion(objeto.getDireccion());
                ayudanteDeCampo.setDeporte(objeto.getDeporte());
                ayudanteDeCampo.setCategoria(objeto.getCategoria());
            }
        }
    }

    @Override
    public AyudanteDeCampo buscar(String dni) {
        for(AyudanteDeCampo ayudanteDeCampo : this.ayudanteDeCampoList){
            if(ayudanteDeCampo.getDni().equals(dni)){
                return ayudanteDeCampo;
            }
        }
        return null;
    }

}
