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
    private List<Jugador> listJugador;
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Jugador.class);
            this.listJugador = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.listJugador = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listJugador);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Jugador> listar() {
        this.cargar();
        return this.listJugador;
    }

    @Override
    public void agregar(Jugador objeto) {
        cargar();
        this.listJugador.add(objeto);
        guardar();

    }

    @Override
    public void agregarLista(List<Jugador> lista) {
        cargar();
        this.listJugador.addAll(lista);
        guardar();

    }

    @Override
    public void eliminar(String dni) {
        for(Jugador jugador : this.listJugador)
            if (jugador.getDni().equals(dni))
                listJugador.remove(jugador);

    }

    @Override
    public void modificar(String dni) {

    }
}
