package tpFinal.Services;

import tpFinal.Exceptions.PartidoNoEncontradoException;
import tpFinal.Models.Partido;
import tpFinal.Repositorios.PartidoRepository;

import java.util.List;

public class PartidoService implements IPartidoService{

    PartidoRepository partidoRepository = new PartidoRepository();

    @Override
    public List<Partido> listar() {
        return partidoRepository.listar();
    }

    @Override
    public void agregar(Partido objeto) {
        partidoRepository.cargar();
        partidoRepository.agregar(objeto);
        partidoRepository.guardar();
    }

    @Override
    public void modificar(Partido objeto) {
        partidoRepository.modificar(objeto);
    }

    @Override
    public void eliminar(String dni) {
        partidoRepository.cargar();
        try{
            if (partidoRepository.buscar(dni) != null){
                partidoRepository.eliminar(dni);
            }
            partidoRepository.guardar();
        }catch(PartidoNoEncontradoException e){
            System.out.println(e.getMensaje());
        }

    }
}
