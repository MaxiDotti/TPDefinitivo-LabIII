package tpFinal.Services;

import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Empleado.DirectorTecnico;
import tpFinal.Repositorios.EmpleadosRepository.DirectorTecnicoRepository;
import tpFinal.Utilities.Validations;

import java.util.List;

public class DirectorTecnicoService implements IDirectorTecnicoService{
    DirectorTecnicoRepository directorTecnicoRepository = new DirectorTecnicoRepository();
    Validations validations = new Validations();

    @Override
    public List<DirectorTecnico> listar() {
        directorTecnicoRepository.cargar();
        return directorTecnicoRepository.listar();
    }

    @Override
    public void agregar(DirectorTecnico objeto) {
        try {
            validations.validarDirectorTecnico(objeto);
            directorTecnicoRepository.cargar();
            if(buscarDirectorTecnico2(objeto.getDni())){
                directorTecnicoRepository.agregar(objeto);
            }
            directorTecnicoRepository.guardar();
        } catch (FormatoDNINoCompatibleException e) {
            System.out.println(e.getMensaje());
        } catch (FormatoUsuarioNoCompatibleException e){
            System.out.println(e.getMensaje());
        } catch (ObjetoEncontradoException e){
            System.out.println(e.getMensaje());
        }
    }

    // SE PUEDE MODIFICAR CONTRASEÑA, TELEFONO, DIRECCION, DEPORTE y CATEGORIA.
    @Override
    public void modificar(DirectorTecnico objeto) {
        try{
            directorTecnicoRepository.cargar();
            if(validations.validarDni(objeto.getDni()) && buscarDirectorTecnico(objeto.getDni())){
                directorTecnicoRepository.modificar(objeto);
            }
            directorTecnicoRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void eliminar(String dni) {
        try{
            directorTecnicoRepository.cargar();
            if(validations.validarDni(dni) && buscarDirectorTecnico(dni)){
                directorTecnicoRepository.eliminar(dni);
            }
            directorTecnicoRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public boolean buscarDirectorTecnico(String dni) throws ObjetoNoEncontradoException {
        if(directorTecnicoRepository.buscar(dni) == null){
            throw new ObjetoNoEncontradoException();
        }
        return true;
    }

    @Override
    public boolean buscarDirectorTecnico2(String dni) throws ObjetoEncontradoException {
        if(directorTecnicoRepository.buscar(dni) != null){
            throw new ObjetoEncontradoException();
        }
        return true;
    }
}
