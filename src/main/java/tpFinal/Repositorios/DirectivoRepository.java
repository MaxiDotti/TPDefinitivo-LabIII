package tpFinal.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.PersonalLimpieza;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectivoRepository implements IRepository<Directivo>{
    private final File file = new File("src/main/resources/Directivo.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Directivo> directivoList;
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Directivo.class);
            this.directivoList = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.directivoList = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.directivoList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Directivo> listar() {
        cargar();
        return this.directivoList;
    }

    @Override
    public void agregar(Directivo objeto) {
        cargar();
        this.directivoList.add(objeto);
        guardar();
    }

    @Override
    public void agregarLista(List<Directivo> lista) {
        cargar();
        this.directivoList.addAll(lista);
        guardar();

    }

    @Override
    public void eliminar(String dni) {
        cargar();
        for (Directivo directivo : this.directivoList)
            if(directivo.getDni().equals(dni))
                this.directivoList.remove(directivo);
        guardar();
    }

    @Override
    public void modificar(String dni) {

    }
}
