package tpFinal.Services;
import tpFinal.Exceptions.FormatoDNINoCompatibleException;
import tpFinal.Exceptions.FormatoUsuarioNoCompatibleException;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Empleado.Medico;
import tpFinal.Repositorios.EmpleadosRepository.MedicoRepository;
import tpFinal.Utilities.Validations;
import java.util.List;

public class MedicoService implements IMedicoService{
    MedicoRepository medicoRepository = new MedicoRepository();
    Validations validations = new Validations();

    @Override
    public List<Medico> listar() {
        medicoRepository.cargar();
        return medicoRepository.listar();
    }

    @Override
    public void agregar(Medico objeto) {
        try {
            validations.validarMedico(objeto);
            medicoRepository.cargar();
            if(buscarMedico2(objeto.getDni())){
                medicoRepository.agregar(objeto);
            }
            medicoRepository.guardar();
        } catch (FormatoDNINoCompatibleException e) {
            System.out.println(e.getMensaje());
        } catch (FormatoUsuarioNoCompatibleException e){
            System.out.println(e.getMensaje());
        } catch (ObjetoEncontradoException e){
            System.out.println(e.getMensaje());
        }
    }

    // SE PUEDE MODIFICAR CONTRASEÑA, TELEFONO, DIRECCION y ESPECIALIDAD.
    @Override
    public void modificar(Medico objeto) {
        try{
            medicoRepository.cargar();
            if(validations.validarDni(objeto.getDni()) && buscarMedico(objeto.getDni())){
                medicoRepository.modificar(objeto);
            }
            medicoRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void eliminar(String dni) {
        try{
            medicoRepository.cargar();
            if(validations.validarDni(dni) && buscarMedico(dni)){
                medicoRepository.eliminar(dni);
            }
            medicoRepository.guardar();
        }catch (ObjetoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }catch(FormatoDNINoCompatibleException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public boolean buscarMedico(String dni) throws ObjetoNoEncontradoException {
        if(medicoRepository.buscar(dni) == null){
            throw new ObjetoNoEncontradoException();
        }
        return true;
    }

    @Override
    public boolean buscarMedico2(String dni) throws ObjetoEncontradoException {
        if(medicoRepository.buscar(dni) != null){
            throw new ObjetoEncontradoException();
        }
        return true;
    }
}
