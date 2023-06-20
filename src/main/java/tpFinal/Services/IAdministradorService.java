package tpFinal.Services;

import tpFinal.Models.Beneficio;
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
     List<Beneficio> listarBeneficios();

     void eliminarSocio(String dni);
     void eliminarAyudanteDeCampo(String dni);
     void eliminarDirectorTecnico(String dni);
     void eliminarJugador(String dni);
     void eliminarMedico(String dni);
     void eliminarPersonalDeLimpieza(String dni);
     void eliminarUtilero(String dni);
     void eliminarBeneficio(String dni);
     void eliminarDirectivo(String dni);

     void modificarSocio(Socio socio);
     void modificarAyudanteDeCampo(AyudanteDeCampo ayudanteDeCampo);
     void modificarDirectorTecnico(DirectorTecnico directorTecnico);
     void modificarJugador(Jugador jugador);
     void modificarMedico(Medico medico);
     void modificarPersonalDeLimpieza(PersonalLimpieza personalLimpieza);
     void modificarUtilero(Utilero utilero);
     void modificarBeneficio(Beneficio beneficio);
     void modificarDirectivo(Directivo directivo);

     void agregarSocio(Socio socio);
     void agregarDirectivo(Directivo directivo);
     void agregarBeneficio(Beneficio beneficio);
     void agregarAyudanteDeCampo(AyudanteDeCampo ayudanteDeCampo);
     void agregarDirectorTecnico(DirectorTecnico directorTecnico);
     void agregarJugador(Jugador jugador);
     void agregarMedico(Medico medico);
     void agregarPersonalDeLimpieza(PersonalLimpieza personalLimpieza);
     void agregarUtilero(Utilero utilero);
}
