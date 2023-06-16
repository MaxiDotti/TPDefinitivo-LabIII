package tpFinal.Services;

import tpFinal.Models.Socio;

import java.util.List;

public interface ISocioService {
    List<Socio> listar();
    void agregar(Socio objeto);
    void modificar(String dni);
    void eliminar(String dni) throws Exception;
    void comprarEntrada();
    void comprarMerchandasing();
    boolean verEstadoContable(String dni);
    void listarBeneficios();
}
