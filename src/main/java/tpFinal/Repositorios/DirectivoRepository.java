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
    private List<Directivo> listDirectivo;
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, PersonalLimpieza.class);
            this.listDirectivo = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.listDirectivo = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, PersonalLimpieza.class);
            this.listDirectivo = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.listDirectivo = new ArrayList<>();
        }
    }

    @Override
    public List<Directivo> listar() {
        cargar();
        return this.listDirectivo;
    }

    @Override
    public void agregar(Directivo objeto) {
        cargar();
        this.listDirectivo.add(objeto);
        guardar();
    }

    @Override
    public void agregarLista(List<Directivo> lista) {
        cargar();
        this.listDirectivo.addAll(lista);
        guardar();

    }

    @Override
    public void eliminar(String dni) {
        cargar();
        for (Directivo directivo : this.listDirectivo)
            if(directivo.getDni().equals(dni))
                this.listDirectivo.remove(directivo);
        guardar();
    }

    @Override
    public void modificar(String dni) {

    }
}
