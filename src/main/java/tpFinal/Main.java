package tpFinal;
import tpFinal.Exceptions.ObjetoEncontradoException;
import tpFinal.Exceptions.ObjetoNoEncontradoException;
import tpFinal.Menues.Iniciador;
import tpFinal.Menues.Socio.MenuSocioHar;
import tpFinal.Models.Directivo;
import tpFinal.Models.Empleado.*;
import tpFinal.Models.Socio;
import tpFinal.Repositorios.BeneficioRepository;
import tpFinal.Repositorios.SociosRepository;
import tpFinal.Services.*;
import tpFinal.Services.DirectivoService;
import tpFinal.Utilities.Deporte;

public class Main {
    public static void main(String[] args) throws ObjetoEncontradoException, ObjetoNoEncontradoException {

       /* Iniciador iniciador = new Iniciador();
        iniciador.comenzar();*/
        MenuSocioHar menuPrincipalSocio = new MenuSocioHar();
        //menuPrincipalSocio.menuPrincipalSocio(new Socio());
        MenuSocioHar.mostrarSocio();

    }
}