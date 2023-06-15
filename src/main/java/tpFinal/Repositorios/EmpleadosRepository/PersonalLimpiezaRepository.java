package tpFinal.Repositorios.EmpleadosRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.IRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonalLimpiezaRepository implements IRepository<PersonalLimpieza> {

    private final File file = new File("src/main/resources/personalLimpieza.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<PersonalLimpieza> listPersonalLimpieza;

    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, PersonalLimpieza.class);
            this.listPersonalLimpieza = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.listPersonalLimpieza = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listPersonalLimpieza);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<PersonalLimpieza> listar() {
        cargar();
        return this.listPersonalLimpieza;
    }

    @Override
    public void agregar(PersonalLimpieza objeto) {
        this.cargar();
        this.listPersonalLimpieza.add(objeto);
        this.guardar();

    }

    @Override
    public void agregarLista(List<PersonalLimpieza> lista) {
        this.cargar();
        this.listPersonalLimpieza.addAll(lista);
        this.guardar();

    }

    @Override
    public void eliminar(String dni) {
        this.cargar();
        for(PersonalLimpieza persona : listPersonalLimpieza){
            if(persona.getDni().equals(dni))
                this.listPersonalLimpieza.remove(persona);
        }
        this.guardar();
    }

    @Override
    public void modificar(String dni) {

    }
}
