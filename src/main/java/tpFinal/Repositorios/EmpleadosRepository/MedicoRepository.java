package tpFinal.Repositorios.EmpleadosRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.Jugador;
import tpFinal.Models.Empleado.Medico;
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
        return this.listMedico;
    }

    @Override
    public void agregar(Medico objeto) {
        this.listMedico.add(objeto);
    }

    @Override
    public void agregarLista(List<Medico> lista) {
        this.cargar();
        this.listMedico.addAll(lista);
        this.guardar();
    }

    @Override
    public void eliminar(String dni) {
        this.listMedico.remove(buscar(dni));
    }

    @Override
    public void modificar(Medico objeto) {
        for(Medico medico : this.listMedico){
            if(medico.getDni().equals(objeto.getDni())){
                medico.setContrasenia(objeto.getContrasenia());
                medico.setTelefono(objeto.getTelefono());
                medico.setDireccion(objeto.getDireccion());
                medico.setEspecialidad(objeto.getEspecialidad());
            }
        }
    }

    @Override
    public Medico buscar(String dni) {
        for(Medico medico : this.listMedico){
            if(medico.getDni().equals(dni)){
                return medico;
            }
        }
        return null;
    }

    // SOLO LO UTILIZAMOS PARA EL MENU
    public Medico buscarMedico(String dni) {
        cargar();
        for(Medico medico : this.listMedico){
            if(medico.getDni().equals(dni)){
                return medico;
            }
        }
        return null;
    }

}
