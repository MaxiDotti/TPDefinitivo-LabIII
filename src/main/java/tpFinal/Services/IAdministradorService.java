package tpFinal.Services;

import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.*;
import tpFinal.Models.Socio;

import java.util.List;

 public interface IAdministradorService {

     List<Socio> listarSocios();
     List<AyudanteDeCampo> listarAyudanteDeCampos();
     List<Directivo> listarDirectivos();
     List<Jugador> listarJugadores();
     List<Medico> listarMedicos();
     List<PersonalLimpieza> listarPersonalLimpieza();
     List<Utilero> listarUtileros();
     List<Benefi>

}
