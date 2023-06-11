package tpFinal.Repositorios.EmpleadosRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.Medico;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Repositorios.IRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedicoRepository implements IRepository<Medico> {
    private final File file = new File("src/main/resources/Medico.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Medico> medicoList;
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Medico.class);
            this.medicoList = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.medicoList = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.medicoList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Medico> listar() {
        cargar();
        return  this.medicoList;
    }

    @Override
    public void agregar(Medico objeto) {
        cargar();
        this.medicoList.add(objeto);
        guardar();
    }

    @Override
    public void agregarLista(List<Medico> lista) {
        cargar();
        this.medicoList.addAll(lista);
        guardar();
    }

    @Override
    public void eliminar(String dni) {
        cargar();
        for(Medico persona : medicoList){
            if(persona.getDni().equals(dni))
                this.medicoList.remove(persona);
        }
        guardar();
    }

    @Override
    public void modificar(String dni) {

    }
}
