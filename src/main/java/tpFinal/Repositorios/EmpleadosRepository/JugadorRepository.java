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
<<<<<<< HEAD
    private List<Jugador> listJugador;
=======
    private List<Jugador> jugadorList;
>>>>>>> origin/new-branch
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Jugador.class);
<<<<<<< HEAD
            this.listJugador = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.listJugador = new ArrayList<>();
=======
            this.jugadorList = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.jugadorList = new ArrayList<>();
>>>>>>> origin/new-branch
        }
    }

    @Override
    public void guardar() {
        try {
<<<<<<< HEAD
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listJugador);
=======
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.jugadorList);
>>>>>>> origin/new-branch
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Jugador> listar() {
<<<<<<< HEAD
        this.cargar();
        return this.listJugador;
=======
        cargar();
        return  this.jugadorList;
>>>>>>> origin/new-branch
    }

    @Override
    public void agregar(Jugador objeto) {
        cargar();
<<<<<<< HEAD
        this.listJugador.add(objeto);
        guardar();

=======
        this.jugadorList.add(objeto);
        guardar();
>>>>>>> origin/new-branch
    }

    @Override
    public void agregarLista(List<Jugador> lista) {
        cargar();
<<<<<<< HEAD
        this.listJugador.addAll(lista);
        guardar();

=======
        this.jugadorList.addAll(lista);
        guardar();
>>>>>>> origin/new-branch
    }

    @Override
    public void eliminar(String dni) {
<<<<<<< HEAD
        for(Jugador jugador : this.listJugador)
            if (jugador.getDni().equals(dni))
                listJugador.remove(jugador);
=======
        cargar();
        for(Jugador persona : jugadorList){
            if(persona.getDni().equals(dni))
                this.jugadorList.remove(persona);
        }
>>>>>>> origin/new-branch
        guardar();
    }

    @Override
    public void modificar(String dni) {

    }
}
