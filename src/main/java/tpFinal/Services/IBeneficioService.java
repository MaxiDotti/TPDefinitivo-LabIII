package tpFinal.Services;

import tpFinal.Models.Beneficio;

import java.util.List;

public interface IBeneficioService {

    List<Beneficio> listar();
    void agregar (Beneficio beneficio);
    void modificar(Beneficio beneficio);
    void eliminar(Beneficio beneficio);

}
