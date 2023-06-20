package tpFinal.Services;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Exceptions.ProductoEncontradoException;
import tpFinal.Models.Producto;
import tpFinal.Repositorios.ProductoRepository;
import tpFinal.Utilities.Validations;
import java.util.List;

public class ProductoService implements IProductoService{
    ProductoRepository productoRepository = new ProductoRepository();
    Validations validations = new Validations();

    @Override
    public List<Producto> listar() {
        productoRepository.cargar();
        return productoRepository.listar();
    }

    @Override
    public void agregar(Producto objeto) {
        try {
            validations.validarProducto(objeto);
            productoRepository.cargar();
            if(buscarProducto2(objeto)){
                productoRepository.agregar(objeto);
            }
            productoRepository.guardar();
        } catch (FormatoUsuarioNoCompatibleException e){
            System.out.println(e.getMensaje());
        } catch (ProductoEncontradoException e){
            System.out.println(e.getMensaje());
        }
    }

    // Se puede modificar NOMBRE, DESCRIPCION y VALOR.
    @Override
    public void modificar(Producto objeto) {
        try{
            productoRepository.cargar();
            if(buscarProducto(objeto.getCodProducto())){
                productoRepository.modificar(objeto);
            }
            productoRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void eliminar(String codProducto) {
        try{
            productoRepository.cargar();
            if(buscarProducto(codProducto)){
                productoRepository.eliminar(codProducto);
            }
            productoRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }
    }

    public boolean buscarProducto(String codProducto) throws ObjetoNoEncontradoException{
        if(productoRepository.buscar(codProducto) == null){
            throw new ObjetoNoEncontradoException();
        }
        return true;
    }

    public boolean buscarProducto2(Producto objeto) throws ProductoEncontradoException {
        if(productoRepository.buscarProducto(objeto) != null){
            throw new ProductoEncontradoException();
        }
        return true;
    }
}
