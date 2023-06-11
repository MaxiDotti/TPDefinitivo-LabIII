package tpFinal.Repositorios.EmpleadosRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.Jugador;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Repositorios.IRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JugadorRepository implements IRepository<Jugador> {
    private final File file = new File("src/main/resources/Jugador.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Jugador> jugadorList;
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Jugador.class);
            this.jugadorList = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.jugadorList = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.jugadorList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Jugador> listar() {
        cargar();
        return  this.jugadorList;
    }

    @Override
    public void agregar(Jugador objeto) {
        cargar();
        this.jugadorList.add(objeto);
        guardar();
    }

    @Override
    public void agregarLista(List<Jugador> lista) {
        cargar();
        this.jugadorList.addAll(lista);
        guardar();
    }

    @Override
    public void eliminar(String dni) {
        cargar();
        for(Jugador persona : jugadorList){
            if(persona.getDni().equals(dni))
                this.jugadorList.remove(persona);
        }
        guardar();
    }

    @Override
    public void modificar(String dni) {

    }
}
