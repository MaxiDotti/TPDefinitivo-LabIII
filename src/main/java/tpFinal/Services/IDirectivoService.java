package tpFinal.Services;

import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.Jugador;
import tpFinal.Models.Socio;

import java.util.List;

public interface IDirectivoService {
    List<Directivo> listar();
    void agregar(Directivo objeto);
    void modificar(Directivo objeto);
    void eliminar(String dni);
    void agregarBeneficio();
    void modificarBeneficio();
    void eliminarBeneficio();
}
