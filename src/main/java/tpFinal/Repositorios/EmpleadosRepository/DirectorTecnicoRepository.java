package tpFinal.Repositorios.EmpleadosRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.DirectorTecnico;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Repositorios.IRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectorTecnicoRepository implements IRepository<DirectorTecnico> {
    private final File file = new File("src/main/resources/DirectorTecnico.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<DirectorTecnico> tecnicoList;
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, DirectorTecnico.class);
            this.tecnicoList = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.tecnicoList = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.tecnicoList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DirectorTecnico> listar() {
        cargar();
        return this.tecnicoList;
    }

    @Override
    public void agregar(DirectorTecnico objeto) {
        cargar();
        this.tecnicoList.add(objeto);
        guardar();
    }

    @Override
    public void agregarLista(List<DirectorTecnico> lista) {
        cargar();
        this.tecnicoList.addAll(lista);
        guardar();
    }

    @Override
    public void eliminar(String dni) {
        cargar();
        for(DirectorTecnico persona : tecnicoList){
            if(persona.getDni().equals(dni))
                this.tecnicoList.remove(persona);
        }
        guardar();
    }

    @Override
    public void modificar(String dni) {

    }
}
