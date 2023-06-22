package tpFinal.Menues;

import tpFinal.Repositorios.EmpleadosRepository.*;
import tpFinal.Services.*;

import java.util.Scanner;

public class MenuEmpleados {

    Scanner scan = new Scanner(System.in);
    AyudanteDeCampoRepository campoRepository = new AyudanteDeCampoRepository();
    DirectorTecnicoRepository tecnicoRepository = new DirectorTecnicoRepository();
    MedicoRepository medicoRepository = new MedicoRepository();
    PersonalLimpiezaRepository limpiezaRepository = new PersonalLimpiezaRepository();
    UtileroRepository utileroRepository = new UtileroRepository();

    AyudanteDeCampoService campoService = new AyudanteDeCampoService();
    DirectorTecnicoService tecnicoService = new DirectorTecnicoService();
    MedicoService medicoService = new MedicoService();
    PersonalLimpiezaService limpiezaService = new PersonalLimpiezaService();
    UtileroService utileroService = new UtileroService();

    public void mostrarOpciones(){
        boolean repite = true;
        int eleccion;

        while(repite){
            System.out.println("Bienvenido al menu de Empleados. Por favor elija la opcion deseada: ");
            System.out.println("1- Menu Ayudante de Campo\n" +
                    "2- Menu Director Tecnico\n" +
                    "3- Menu Jugador\n" +
                    "4- Menu Medico\n" +
                    "5- Menu Personal de Limpieza\n" +
                    "6- Menu Utilero\n" +
                    "0- Salir");
            eleccion = scan.nextInt();
            switch (eleccion){
                case 1:
            }

        }
    }
}
