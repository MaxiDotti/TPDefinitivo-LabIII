package tpFinal.Repositorios.EmpleadosRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.PersonalLimpieza;
<<<<<<< HEAD
import tpFinal.Models.Socio;
=======
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
import tpFinal.Repositorios.IRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonalLimpiezaRepository implements IRepository<PersonalLimpieza> {
<<<<<<< HEAD

=======
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
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
<<<<<<< HEAD
    public void eliminar(String dni) {
        this.cargar();
        for(PersonalLimpieza persona : listPersonalLimpieza){
            if(persona.getDni().equals(dni))
                this.listPersonalLimpieza.remove(persona);
        }
=======
    public void eliminar(String dni){
        this.cargar();
        this.listPersonalLimpieza.remove(dni);
        this.guardar();
    }

    public void eliminarPersonal(PersonalLimpieza personal){
        this.cargar();
        this.listPersonalLimpieza.remove(personal);
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
        this.guardar();
    }

    @Override
    public void modificar(String dni) {

    }
<<<<<<< HEAD
}
=======

    public List<PersonalLimpieza> getListPersonalLimpieza(){
        this.cargar();
        return this.listPersonalLimpieza;
    }
}
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
