package tpFinal.Services;

import tpFinal.Models.Beneficio;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.*;
import tpFinal.Models.Socio;

import java.util.List;

public class AdministradorService implements IAdministradorService{

    SocioService socioService = new SocioService();
    DirectivoService directivoService = new DirectivoService();
    AyudanteDeCampoService ayudanteDeCampoService = new AyudanteDeCampoService();
    DirectorTecnico directorTecnico = new DirectorTecnico();
    JugadorService jugadorService = new JugadorService();
    MedicoService medicoService = new MedicoService();
    PersonalLimpiezaService personalLimpiezaService = new PersonalLimpiezaService();
    UtileroService utileroService = new UtileroService();
    BeneficioService beneficioService = new BeneficioService();
    DirectorTecnicoService directorTecnicoService = new DirectorTecnicoService();

    @Override
    public List<Socio> listarSocios() {
        return socioService.listar();
    }

    @Override
    public List<AyudanteDeCampo> listarAyudanteDeCampos() {
        return ayudanteDeCampoService.listar();
    }

    @Override
    public List<Directivo> listarDirectivos() {
        return directivoService.listar();
    }

    @Override
    public List<Jugador> listarJugadores() {
        return jugadorService.listar();
    }

    @Override
    public List<Medico> listarMedicos() {
        return medicoService.listar();
    }

    @Override
    public List<PersonalLimpieza> listarPersonalLimpieza() {
        return personalLimpiezaService.listar();
    }

    @Override
    public List<Utilero> listarUtileros() {
        return utileroService.listar();
    }

    @Override
    public List<Beneficio> listarBeneficios() {
        return beneficioService.listar();
    }

    @Override
    public void eliminarSocio(String dni) {
        socioService.eliminar(dni);
    }

    @Override
    public void eliminarAyudanteDeCampo(String dni) {
        ayudanteDeCampoService.eliminar(dni);
    }

    @Override
    public void eliminarDirectorTecnico(String dni) {
        directorTecnicoService.eliminar(dni);
    }

    @Override
    public void eliminarJugador(String dni) {
        jugadorService.eliminar(dni);
    }

    @Override
    public void eliminarMedico(String dni) {
        medicoService.eliminar(dni);
    }

    @Override
    public void eliminarPersonalDeLimpieza(String dni) {
        personalLimpiezaService.eliminar(dni);
    }

    @Override
    public void eliminarUtilero(String dni) {
        utileroService.eliminar(dni);
    }

    @Override
    public void eliminarBeneficio(String dni) {
        beneficioService.eliminar(beneficioService.beneficioRepository.buscar(dni));
    }

    @Override
    public void eliminarDirectivo(String dni) {
        directivoService.eliminar(dni);
    }

    @Override
    public void modificarSocio(Socio socio) {
        socioService.modificar(socio);
    }

    @Override
    public void modificarAyudanteDeCampo(AyudanteDeCampo ayudanteDeCampo) {
        ayudanteDeCampoService.modificar(ayudanteDeCampo);
    }

    @Override
    public void modificarDirectorTecnico(DirectorTecnico directorTecnico) {
        directorTecnicoService.modificar(directorTecnico);
    }

    @Override
    public void modificarJugador(Jugador jugador) {
        jugadorService.modificar(jugador);
    }

    @Override
    public void modificarMedico(Medico medico) {
        medicoService.modificar(medico);
    }

    @Override
    public void modificarPersonalDeLimpieza(PersonalLimpieza personalLimpieza) {
        personalLimpiezaService.modificar(personalLimpieza);
    }

    @Override
    public void modificarUtilero(Utilero utilero) {
        utileroService.modificar(utilero);
    }

    @Override
    public void modificarBeneficio(Beneficio beneficio) {
        beneficioService.modificar(beneficio);
    }

    @Override
    public void modificarDirectivo(Directivo directivo) {
        directivoService.modificar(directivo);
    }

    @Override
    public void agregarSocio(Socio socio) {
        socioService.agregar(socio);
    }

    @Override
    public void agregarDirectivo(Directivo directivo) {
        directivoService.agregar(directivo);
    }

    @Override
    public void agregarBeneficio(Beneficio beneficio) {
        beneficioService.agregar(beneficio);
    }

    @Override
    public void agregarAyudanteDeCampo(AyudanteDeCampo ayudanteDeCampo) {
        ayudanteDeCampoService.agregar(ayudanteDeCampo);
    }

    @Override
    public void agregarDirectorTecnico(DirectorTecnico directorTecnico) {
        directorTecnicoService.agregar(directorTecnico);
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        jugadorService.agregar(jugador);
    }

    @Override
    public void agregarMedico(Medico medico) {
        medicoService.agregar(medico);
    }

    @Override
    public void agregarPersonalDeLimpieza(PersonalLimpieza personalLimpieza) {
        personalLimpiezaService.agregar(personalLimpieza);
    }

    @Override
    public void agregarUtilero(Utilero utilero) {
        utileroService.agregar(utilero);
    }




}
