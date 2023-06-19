package tpFinal.Services;

import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Models.Empleado.AyudanteDeCampo;

import java.util.List;

public interface IAyudanteDeCampoService {
    List<AyudanteDeCampo> listar();
    void agregar(AyudanteDeCampo objeto);
    void modificar(AyudanteDeCampo objeto);
    void eliminar(String dni);
    boolean buscarAyudante(String dni) throws ObjetoNoEncontradoException;
    boolean buscarAyudante2(String dni) throws ObjetoEncontradoException;
}
