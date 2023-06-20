package tpFinal.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Exceptions.PartidoNoEncontradoException;
import tpFinal.Models.Partido;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartidoRepository implements IRepository<Partido>{

    private final File file = new File("src/main/resources/Partidos.json");

    private final ObjectMapper mapper = new ObjectMapper();
    private List<Partido> listaPartidos;

    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Partido.class);
            this.listaPartidos = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.listaPartidos = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listaPartidos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Partido> listar() {
        cargar();
        return this.listaPartidos;
    }

    @Override
    public void agregar(Partido objeto) {
        listaPartidos.add(objeto);
    }

    @Override
    public void agregarLista(List<Partido> lista) {

    }

    @Override
    public void eliminar(String dni) throws PartidoNoEncontradoException {
        this.listaPartidos.remove(buscar(dni));
    }

    @Override
    public void modificar(Partido objeto) {
        cargar();
        for(Partido partido : this.listaPartidos){
            if(partido.getId().equals(objeto.getId())){
                partido.setCategoria(objeto.getCategoria());
                partido.setFecha(objeto.getFecha());
                partido.setRival(objeto.getRival());
                partido.setDeporte(objeto.getDeporte());
            }
        }
        guardar();
    }

    @Override
    public Partido buscar(String dni) {
        for(Partido partido : this.listaPartidos){
            if(partido.getId().equals(dni)){
                return partido;
            }
        }
        return null;
    }
}
