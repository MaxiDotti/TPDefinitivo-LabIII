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

    public void testAyudanteDeCampo(){
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

        campoList.add(campo1);
        campoRepository.agregar(campo2);
        campoRepository.agregarLista(campoList);

        System.out.println(campoRepository.listar());
    }

    public void testDirectorTecnico(){

        DirectorTecnico tecnico1 = new DirectorTecnico("Nombre1",
                "Apellido1",
                "Dni1",
                "Contrasenia1",
                "Telefono1",
                "Direccion1",
                false,
                "Plantel1",
                "Deporte1",
                "Categoria1");

        DirectorTecnico tecnico2 = new DirectorTecnico("Nombre2",
                "Apellido2",
                "Dni2",
                "Contrasenia2",
                "Telefono2",
                "Direccion2",
                true,
                "Plantel2",
                "Deporte2",
                "Categoria2");

        tecnicoList.add(tecnico2);
        tecnicoRepository.agregar(tecnico1);
        tecnicoRepository.agregarLista(tecnicoList);

        System.out.println(tecnicoRepository.listar());
    }

    public void testJugador(){
        Jugador jugador1 = new Jugador("Nombre1",
                "Apellido1",
                "Dni1",
                "Contrasenia1",
                "Telefono1",
                "Direccion1",
                "Equipo1",
                "Categoria1",
                "Deporte1",
                "Posicion1",
                true);

        Jugador jugador2 = new Jugador("Nombre2",
                "Apellido2",
                "Dni2",
                "Contrasenia2",
                "Telefono2",
                "Direccion2",
                "Equipo2",
                "Categoria2",
                "Deporte2",
                "Posicion2",
                true);

        jugadorList.add(jugador1);
        jugadorRepository.agregar(jugador2);
        jugadorRepository.agregarLista(jugadorList);

        System.out.println(jugadorRepository.listar());

    }

    public void testMedico(){
        Medico medico1 = new Medico("Nombre1",
                "Apellido1",
                "Dni1",
                "Contrasenia1",
                "Telefono1",
                "Direccion1",
                "Especialidad1",
                true);

        Medico medico2 = new Medico("Nombre1",
                "Apellido2",
                "Dni2",
                "Contrasenia2",
                "Telefono2",
                "Direccion2",
                "Especialidad2",
                true);

        medicoList.add(medico1);
        medicoRepository.agregar(medico2);
        medicoRepository.agregarLista(medicoList);

        System.out.println(medicoRepository.listar());
    }

    public void testPErsonalLimpieza(){
        PersonalLimpieza personal1 = new PersonalLimpieza("Nombre1",
                "Apellido1",
                "Dni1",
                "Contresenia1",
                "Telefono1",
                "Direccion1",
                "Sector1",
                false);

        PersonalLimpieza personal2 = new PersonalLimpieza("Nombre1",
                "Apellido2",
                "Dni2",
                "Contresenia2",
                "Telefono2",
                "Direccion2",
                "Sector2",
                true);

        limpiezaList.add(personal2);
        limpiezaRepository.agregar(personal1);
        limpiezaRepository.agregarLista(limpiezaList);

        System.out.println(limpiezaRepository.listar());
    }

    public  void testUtilero(){
        Utilero utilero1 = new Utilero("Nombre1",
                "Apellido1",
                "Dni1",
                "Contrasenia1",
                "Telefono1",
                "Direccion1",
                true,
                "Deporte1");

        Utilero utilero2 = new Utilero("Nombre2",
                "Apellido2",
                "Dni2",
                "Contrasenia2",
                "Telefono2",
                "Direccion2",
                false,
                "Deporte2");

        utileroList.add(utilero2);
        utileroRepository.agregar(utilero1);
        utileroRepository.agregarLista(utileroList);

        System.out.println(utileroRepository.listar());
    }

    public void testDirectivo(){
        Directivo directivo1 = new Directivo("Nombre1",
                "Apellido1",
                "Dni1",
                "Contrasenia1",
                "Telefono1",
                "Direccion1");

        Directivo directivo2 = new Directivo("Nombre2",
                "Apellido2",
                "Dni2",
                "Contrasenia2",
                "Telefono2",
                "Direccion2");

        directivoList.add(directivo1);
        directivoRepository.agregar(directivo2);
        directivoRepository.agregarLista(directivoList);

        System.out.println(directivoRepository.listar());
    }

    public void testSocio(){
        Socio socio1 = new Socio("Nombre1",
                "Apellido1",
                "Dni1",
                "Contrasenia1",
                "Telefono1",
                "Direccion1",
                true);
        Socio socio2 = new Socio("Nombre2",
                "Apellido2",
                "Dni2",
                "Contrasenia2",
                "Telefono2",
                "Direccion2",
                false);

        socioList.add(socio1);
        sociosRepository.agregar(socio2);
        sociosRepository.agregarLista(socioList);

        System.out.println(sociosRepository.listar());
        }

}
