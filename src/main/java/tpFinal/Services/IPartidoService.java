package tpFinal.Services;

import tpFinal.Models.Partido;


import java.util.List;

public interface IPartidoService {
    List<Partido> listar();
    void agregar(Partido objeto);
    void modificar(Partido objeto);
    void eliminar(String dni);
}
