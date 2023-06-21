package tpFinal.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Beneficio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeneficioRepository implements IRepository<Beneficio>{

    private final File file = new File("src/main/resources/Beneficio.json");

    private final ObjectMapper mapper = new ObjectMapper();
    private List<Beneficio> listaBeneficios;

    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Beneficio.class);
            this.listaBeneficios = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.listaBeneficios = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listaBeneficios);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Beneficio> listar() {
        return this.listaBeneficios;
    }

    @Override
    public void agregar(Beneficio objeto) {
        this.listaBeneficios.add(objeto);
    }

    @Override
    public void agregarLista(List<Beneficio> lista) {

    }

    @Override
    public void eliminar(String id) {
        this.listaBeneficios.remove(buscar(id));
    }

    @Override
    public void modificar(Beneficio objeto) {
        for(Beneficio beneficio : this.listaBeneficios){
            if(beneficio.getId().equals(objeto.getId())){
                beneficio.setProveedor(objeto.getProveedor());
                beneficio.setCategoria(objeto.getCategoria());
                beneficio.setTipoDeDescuento(objeto.getTipoDeDescuento());
                beneficio.setFechaDeUtilidad(objeto.getFechaDeUtilidad());
            }
        }
    }

    @Override
    public Beneficio buscar(String id) {
        for(Beneficio beneficio : this.listaBeneficios){
            if(beneficio.getId().equals(id)){
                return beneficio;
            }
        }
        return null;
    }

    //CTRL + ALT+ SHIFT + J PARA SELECCIONAR OCURRENCIAS IGUALES, ATAJO JE
}
