package tpFinal.Repositorios.EmpleadosRepository;

<<<<<<< HEAD
import tpFinal.Models.Empleado.DirectorTecnico;
import tpFinal.Repositorios.IRepository;

import java.util.List;

public class DirectorTecnicoRepository implements IRepository<DirectorTecnico> {

    @Override
    public void cargar(DirectorTecnico directorTecnico) {

=======
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
<<<<<<< HEAD
import tpFinal.Models.Empleado.AyudanteDeCampo;
=======
>>>>>>> origin/new-branch
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
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
    }

    @Override
    public List<DirectorTecnico> listar() {
<<<<<<< HEAD
        return null;
=======
        cargar();
<<<<<<< HEAD
        return  this.tecnicoList;
=======
        return this.tecnicoList;
>>>>>>> origin/new-branch
    }

    @Override
    public void agregar(DirectorTecnico objeto) {
        cargar();
        this.tecnicoList.add(objeto);
        guardar();
<<<<<<< HEAD

=======
>>>>>>> origin/new-branch
    }

    @Override
    public void agregarLista(List<DirectorTecnico> lista) {
        cargar();
        this.tecnicoList.addAll(lista);
        guardar();
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
    }

    @Override
    public void eliminar(String dni) {
<<<<<<< HEAD

=======
        cargar();
<<<<<<< HEAD
        for (DirectorTecnico tecnico : this.tecnicoList)
            if(tecnico.getDni().equals(dni))
                this.tecnicoList.remove(tecnico);
=======
        for(DirectorTecnico persona : tecnicoList){
            if(persona.getDni().equals(dni))
                this.tecnicoList.remove(persona);
        }
>>>>>>> origin/new-branch
        guardar();
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
    }

    @Override
    public void modificar(String dni) {

    }
}
