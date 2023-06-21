package tpFinal.Repositorios;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Models.Socio;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DirectivoRepository implements IRepository<Directivo>{
    private final File file = new File("src/main/resources/Directivo.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Directivo> listDirectivo;

    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Directivo.class);
            this.listDirectivo = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.listDirectivo = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listDirectivo);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Directivo> listar() {
        return this.listDirectivo;
    }

    @Override
    public void agregar(Directivo objeto) {
        this.listDirectivo.add(objeto);
    }

    @Override
    public void agregarLista(List<Directivo> lista) {
        cargar();
        this.listDirectivo.addAll(lista);
        guardar();
    }

    @Override
    public void eliminar(String dni) {
        this.listDirectivo.remove(buscar(dni));
    }

    @Override
    public void modificar(Directivo objeto) {
        for(Directivo directivo : this.listDirectivo){
            if(directivo.getDni().equals(objeto.getDni())){
                directivo.setContrasenia(objeto.getContrasenia());
                directivo.setTelefono(objeto.getTelefono());
                directivo.setDireccion(objeto.getDireccion());
            }
        }
    }

    @Override
    public Directivo buscar(String dni) {
        for (Directivo directivo : this.listDirectivo) {
            if (directivo.getDni().equals(dni)) {
                return directivo;
            }
        }
        return null;
    }

    public boolean recuperarContrasenia(String nuevaContrasenia, String dni){
        boolean validador = false;
        for (Directivo directivo : this.listDirectivo){
            if(directivo.getDni().equals(dni)){
                directivo.setContrasenia(nuevaContrasenia);
                validador = true;
            }
        }
        return  validador;
    }

}
