package tpFinal.Repositorios.EmpleadosRepository;

<<<<<<< HEAD
import tpFinal.Models.Empleado.AyudanteDeCampo;
import tpFinal.Repositorios.IRepository;

import java.util.List;

public class AyudanteDeCampoRepository implements IRepository<AyudanteDeCampo> {

    @Override
    public void cargar(AyudanteDeCampo ayudanteDeCampo) {

=======
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Empleado.AyudanteDeCampo;
<<<<<<< HEAD
import tpFinal.Models.Empleado.Jugador;
=======
import tpFinal.Models.Empleado.PersonalLimpieza;
>>>>>>> origin/new-branch
import tpFinal.Repositorios.IRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AyudanteDeCampoRepository implements IRepository<AyudanteDeCampo> {
    private final File file = new File("src/main/resources/AyudanteDeCampo.json");
    private final ObjectMapper mapper = new ObjectMapper();
<<<<<<< HEAD
    private List<AyudanteDeCampo> ayudanteDeCampoList;
=======
    private List<AyudanteDeCampo> campoList;
>>>>>>> origin/new-branch
    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, AyudanteDeCampo.class);
<<<<<<< HEAD
            this.ayudanteDeCampoList = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.ayudanteDeCampoList = new ArrayList<>();
        }
=======
            this.campoList = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.campoList = new ArrayList<>();
        }

>>>>>>> origin/new-branch
    }

    @Override
    public void guardar() {
        try {
<<<<<<< HEAD
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.ayudanteDeCampoList);
=======
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.campoList);
>>>>>>> origin/new-branch
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
    }

    @Override
    public List<AyudanteDeCampo> listar() {
<<<<<<< HEAD
        return null;
=======
        cargar();
<<<<<<< HEAD
        return this.ayudanteDeCampoList;
=======
        return this.campoList;
>>>>>>> origin/new-branch
    }

    @Override
    public void agregar(AyudanteDeCampo objeto) {
        cargar();
<<<<<<< HEAD
        this.ayudanteDeCampoList.add(objeto);
=======
        this.campoList.add(objeto);
>>>>>>> origin/new-branch
        guardar();
    }

    @Override
    public void agregarLista(List<AyudanteDeCampo> lista) {
        cargar();
<<<<<<< HEAD
        this.ayudanteDeCampoList.addAll(lista);
=======
        this.campoList.addAll(lista);
>>>>>>> origin/new-branch
        guardar();
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
    }

    @Override
    public void eliminar(String dni) {
<<<<<<< HEAD

=======
        cargar();
<<<<<<< HEAD
        for (AyudanteDeCampo ayudanteDeCampo : this.ayudanteDeCampoList )
            if (ayudanteDeCampo.getDni().equals(dni))
                this.ayudanteDeCampoList.remove(ayudanteDeCampo);
=======
        for(AyudanteDeCampo persona : campoList){
            if(persona.getDni().equals(dni))
                this.campoList.remove(persona);
        }
>>>>>>> origin/new-branch
        guardar();
>>>>>>> 13cf3f7bcbeda342a0ca410346733f1968924052
    }

    @Override
    public void modificar(String dni) {

    }
}
