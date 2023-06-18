package tpFinal.Services;


import tpFinal.Models.Socio;

import java.util.List;

public interface ISocioService {
    List<Socio> listar();
    void agregar(Socio objeto);
    void modificar(Socio objeto);
    void eliminar(String dni);
    void comprarEntrada();
    void comprarMerchandasing();
    boolean verEstadoContable(String dni);
    void listarBeneficios();
}
