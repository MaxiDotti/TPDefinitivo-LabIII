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
<<<<<<< HEAD

    private final File file = new File("src/main/resources/Medico.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Medico> listMedico;
    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Medico.class);
            this.listMedico = mapper.readValue(file, collectionType);
        } catch (IOException e) {
            this.listMedico = new ArrayList<>();
=======
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
>>>>>>> origin/new-branch
        }
    }

    @Override
    public void guardar() {
        try {
<<<<<<< HEAD
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listMedico);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }

=======
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.medicoList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
>>>>>>> origin/new-branch

    @Override
    public List<Medico> listar() {
        cargar();
<<<<<<< HEAD
        return this.listMedico;
=======
        return  this.medicoList;
>>>>>>> origin/new-branch
    }

    @Override
    public void agregar(Medico objeto) {
<<<<<<< HEAD
        this.cargar();
        this.listMedico.add(objeto);
        this.guardar();
=======
        cargar();
        this.medicoList.add(objeto);
        guardar();
>>>>>>> origin/new-branch
    }

    @Override
    public void agregarLista(List<Medico> lista) {
<<<<<<< HEAD
        this.cargar();
        this.listMedico.addAll(lista);
        this.guardar();
=======
        cargar();
        this.medicoList.addAll(lista);
        guardar();
>>>>>>> origin/new-branch
    }

    @Override
    public void eliminar(String dni) {
<<<<<<< HEAD
        this.cargar();
        for(Medico medico : listMedico){
            if(medico.getDni().equals(dni)){
                this.listMedico.remove(medico);
            }
        }
        this.guardar();
=======
        cargar();
        for(Medico persona : medicoList){
            if(persona.getDni().equals(dni))
                this.medicoList.remove(persona);
        }
        guardar();
>>>>>>> origin/new-branch
    }

    @Override
    public void modificar(String dni) {

    }
}
