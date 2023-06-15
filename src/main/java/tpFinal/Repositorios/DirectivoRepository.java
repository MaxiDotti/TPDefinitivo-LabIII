package tpFinal.Repositorios;

<<<<<<< HEAD
import tpFinal.Models.Directivo;

import java.util.List;

public class DirectivoRepository implements IRepository<Directivo>{

    @Override
    public void cargar(Directivo o) {

=======
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.PersonalLimpieza;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectivoRepository implements IRepository<Directivo> {
    private final File file = new File("src/main/resources/Directivo.json");
    private final ObjectMapper mapper = new ObjectMapper();

    private List<Directivo> listDirectivo;

    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, PersonalLimpieza.class);
            this.listDirectivo = mapper.readValue(file, collectionType);
        } catch (IOException e) {
            this.listDirectivo = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listDirectivo);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
    }

    @Override
    public List<Directivo> listar() {
<<<<<<< HEAD
        return null;
=======
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
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
    }

    @Override
    public void eliminar(String dni) {
<<<<<<< HEAD

=======
        cargar();

        for (Directivo directivo : this.listDirectivo) {
            if (directivo.getDni().equals(dni))
                this.listDirectivo.remove(directivo);
        }
        guardar();
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
    }

    @Override
    public void modificar(String dni) {

    }
}
