package tpFinal.Repositorios;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.AdministradorDelSistema;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorRepository implements IRepository<AdministradorDelSistema>{
    private final File file = new File("src/main/resources/AdministradorDelSistema.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<AdministradorDelSistema> adminList;

    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, AdministradorDelSistema.class);
            this.adminList = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.adminList = new ArrayList<>();
        }
    }
    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.adminList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AdministradorDelSistema> listar() {
        return this.adminList;
    }

    @Override
    public void agregar(AdministradorDelSistema objeto) {
        this.adminList.add(objeto);
    }

    @Override
    public void agregarLista(List<AdministradorDelSistema> lista) {
        cargar();
        this.adminList.addAll(lista);
        guardar();
    }

    @Override
    public void eliminar(String dni) {
        this.adminList.remove(buscar(dni));
    }

    @Override
    public void modificar(AdministradorDelSistema objeto) {
        for(AdministradorDelSistema admin : this.adminList){
            if(admin.getDni().equals(objeto.getDni())){
                admin.setNombre(objeto.getNombre());
                admin.setApellido(objeto.getApellido());
                admin.setContrasenia(objeto.getContrasenia());
                admin.setTelefono(objeto.getTelefono());
            }
        }
    }

    @Override
    public AdministradorDelSistema buscar(String dni) {
        for(AdministradorDelSistema admin : this.adminList){
            if(admin.getDni().equals(dni)){
                return admin;
            }
        }
        return null;
    }

    // SOLO LO UTILIZAMOS PARA EL MENU
    public AdministradorDelSistema buscarAdministrador(String dni) {
        cargar();
        for(AdministradorDelSistema admin : this.adminList){
            if(admin.getDni().equals(dni)){
                return admin;
            }
        }
        return null;
    }
}
