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
    private List<Medico> listMedico;
    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Medico.class);
            this.listMedico = mapper.readValue(file, collectionType);
        } catch (IOException e) {
            this.listMedico = new ArrayList<>();
        }
    }


    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listMedico);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public List<Medico> listar() {
        cargar();
        return this.listMedico;
    }


    @Override
    public void agregar(Medico objeto) {
        this.cargar();
        this.listMedico.add(objeto);
        this.guardar();
    }


    @Override
    public void agregarLista(List<Medico> lista) {
        this.cargar();
        this.listMedico.addAll(lista);
        this.guardar();
    }


    @Override
    public void eliminar(String dni) {
        this.cargar();
        for(Medico medico : listMedico){
            if(medico.getDni().equals(dni)){
                this.listMedico.remove(medico);
            }
        }
        this.guardar();
    }

    @Override
    public void modificar(Medico objeto) {

    }

    @Override
    public Medico buscar(String dni) {
        return null;
    }

}
