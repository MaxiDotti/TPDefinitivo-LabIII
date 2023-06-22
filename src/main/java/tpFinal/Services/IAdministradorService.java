package tpFinal.Services;

import tpFinal.Models.Beneficio;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.*;
import tpFinal.Models.Socio;

import java.util.List;

 public interface IAdministradorService {

     List<Directivo> listarDirectivos();
     void eliminarDirectivo(String dni);
     void modificarBeneficio(Beneficio beneficio);
     void modificarDirectivo(Directivo directivo);
     void agregarDirectivo(Directivo directivo);
     void agregarBeneficio(Beneficio beneficio);

}
