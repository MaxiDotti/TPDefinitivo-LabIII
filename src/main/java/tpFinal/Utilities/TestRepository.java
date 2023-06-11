package tpFinal.Utilities;

import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.*;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.DirectivoRepository;
import tpFinal.Repositorios.EmpleadosRepository.*;
import tpFinal.Repositorios.SociosRepository;

import java.util.ArrayList;
import java.util.List;

public class TestRepository {

    AyudanteDeCampoRepository campoRepository = new AyudanteDeCampoRepository();
    DirectorTecnicoRepository tecnicoRepository = new DirectorTecnicoRepository();
    JugadorRepository jugadorRepository = new JugadorRepository();
    MedicoRepository medicoRepository = new MedicoRepository();
    PersonalLimpiezaRepository limpiezaRepository = new PersonalLimpiezaRepository();
    UtileroRepository utileroRepository = new UtileroRepository();
    DirectivoRepository directivoRepository = new DirectivoRepository();
    SociosRepository sociosRepository = new SociosRepository();

    List<AyudanteDeCampo> campoList = new ArrayList<>();
    List<DirectorTecnico> tecnicoList = new ArrayList<>();
    List<Jugador> jugadorList = new ArrayList<>();
    List<Medico> medicoList = new ArrayList<>();
    List<PersonalLimpieza> limpiezaList = new ArrayList<>();
    List<Utilero> utileroList = new ArrayList<>();
    List<Directivo> directivoList = new ArrayList<>();
    List<Socio> socioList = new ArrayList<>();

    void testAyudanteDeCampo(){
        AyudanteDeCampo campo1 = new AyudanteDeCampo("Nombre1",
                "Apellido1",
                "Dni1",
                "Contrasenia1",
                "Telefono1",
                "Direccion1",
                true,
                "Plantel1",
                "Deporte1",
                "Categoria1");

        AyudanteDeCampo campo2 = new AyudanteDeCampo("Nombre1",
                "Apellido2",
                "Dni2",
                "Contrasenia2",
                "Telefono2",
                "Direccion2",
                false,
                "Plantel2",
                "Deporte2",
                "Categoria2");


    }
}
