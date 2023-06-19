package tpFinal.Services;

import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Empleado.AyudanteDeCampo;
import tpFinal.Repositorios.EmpleadosRepository.AyudanteDeCampoRepository;
import tpFinal.Utilities.Validations;

import java.util.List;

public class AyudanteDeCampoService implements IAyudanteDeCampoService{
    AyudanteDeCampoRepository ayudanteDeCampoRepository = new AyudanteDeCampoRepository();
    Validations validations = new Validations();
    @Override
    public List<AyudanteDeCampo> listar() {
        ayudanteDeCampoRepository.cargar();
        return ayudanteDeCampoRepository.listar();
    }

    @Override
    public void agregar(AyudanteDeCampo objeto) {
        try {
            validations.validarAyudanteDeCampo(objeto);
            ayudanteDeCampoRepository.cargar();
            if(buscarAyudante2(objeto.getDni())){
                ayudanteDeCampoRepository.agregar(objeto);
            }
            ayudanteDeCampoRepository.guardar();
        } catch (FormatoDNINoCompatibleException e) {
            System.out.println(e.getMensaje());
        } catch (FormatoUsuarioNoCompatibleException e){
            System.out.println(e.getMensaje());
        } catch (ObjetoEncontradoException e){
            System.out.println(e.getMensaje());
        }
    }

    //Se puede modificar CONTRASEÑA, TELEFONO, DIRECCION, DEPORTE y CATEGORIA.
    @Override
    public void modificar(AyudanteDeCampo objeto) {
        try{
            ayudanteDeCampoRepository.cargar();
            if(validations.validarDni(objeto.getDni()) && buscarAyudante(objeto.getDni())){
                ayudanteDeCampoRepository.modificar(objeto);
            }
            ayudanteDeCampoRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void eliminar(String dni) {
        try{
            ayudanteDeCampoRepository.cargar();
            if(validations.validarDni(dni) && buscarAyudante(dni)){
                ayudanteDeCampoRepository.eliminar(dni);
            }
            ayudanteDeCampoRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public boolean buscarAyudante(String dni) throws ObjetoNoEncontradoException{
        if(ayudanteDeCampoRepository.buscar(dni) == null){
            throw new ObjetoNoEncontradoException();
        }
        return true;
    }

    @Override
    public boolean buscarAyudante2(String dni) throws ObjetoEncontradoException{
        if(ayudanteDeCampoRepository.buscar(dni) != null){
            throw new ObjetoEncontradoException();
        }
        return true;
    }
}
