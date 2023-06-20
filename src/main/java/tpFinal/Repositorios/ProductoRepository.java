package tpFinal.Repositorios;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import tpFinal.Models.Producto;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepository implements IRepository<Producto>{
    private final File file = new File("src/main/resources/Productos.json");

    private final ObjectMapper mapper = new ObjectMapper();
    private List<Producto> listaProductos;

    @Override
    public void cargar() {
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Producto.class);
            this.listaProductos = mapper.readValue(file, collectionType);
        }catch (IOException e){
            this.listaProductos = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listaProductos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Producto> listar() {
        return this.listaProductos;
    }

    @Override
    public void agregar(Producto objeto) {
        this.listaProductos.add(objeto);
    }

    // CUAL ES EL SENTIDO?
    @Override
    public void agregarLista(List<Producto> lista) {
        cargar();
        this.listaProductos.addAll(lista);
        guardar();
    }

    @Override
    public void eliminar(String codProd){
        this.listaProductos.remove(buscar(codProd));
    }

    @Override
    public void modificar(Producto objeto) {
        for(Producto producto : this.listaProductos){
            if(producto.getCodProducto().equals(objeto.getCodProducto())){
                producto.setNombre(objeto.getNombre());
                producto.setDescripcion(objeto.getDescripcion());
                producto.setValor(objeto.getValor());
            }
        }
    }

    @Override
    public Producto buscar(String codProd) {
        for(Producto producto : this.listaProductos){
            if(producto.getCodProducto().equals(codProd)){
                return producto;
            }
        }
        return null;
    }

    public boolean buscarProducto(Producto objeto){
        for(Producto producto : this.listaProductos){
            if(producto.equals(objeto)){
                return false;
            }
        }
        return true;
    }
}
