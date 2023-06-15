package tpFinal.Services;

import tpFinal.Models.Socio;

public interface ISocioService {
    void listar();
    void agregar(Socio objeto);
    void modificar(String dni);
    void eliminar(String dni);
    boolean buscarSocio(String dni);
    void comprarEntrada();
    void comprarMerchandasing();
    boolean verEstadoContable(String dni);
    void listarBeneficios();
}
