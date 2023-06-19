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
        return this.listPersonalLimpieza;
    }

    @Override
    public void agregar(PersonalLimpieza objeto) {
        this.listPersonalLimpieza.add(objeto);
    }

    @Override
    public void agregarLista(List<PersonalLimpieza> lista) {
        this.cargar();
        this.listPersonalLimpieza.addAll(lista);
        this.guardar();
    }

    @Override
    public void eliminar(String dni) {
        this.listPersonalLimpieza.remove(buscar(dni));
    }

    @Override
    public void modificar(PersonalLimpieza objeto) {
        for(PersonalLimpieza personalLimpieza : this.listPersonalLimpieza){
            if(personalLimpieza.getDni().equals(objeto.getDni())){
                personalLimpieza.setContrasenia(objeto.getContrasenia());
                personalLimpieza.setTelefono(objeto.getTelefono());
                personalLimpieza.setDireccion(objeto.getDireccion());
                personalLimpieza.setSector(objeto.getSector());
            }
        }
    }

    @Override
    public PersonalLimpieza buscar(String dni) {
        for(PersonalLimpieza personalLimpieza : this.listPersonalLimpieza){
            if(personalLimpieza.getDni().equals(dni)){
                return personalLimpieza;
            }
        }
        return null;
    }
}
