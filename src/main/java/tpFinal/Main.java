package tpFinal;

import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Repositorios.EmpleadosRepository.PersonalLimpiezaRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PersonalLimpieza> limpiezaList = new ArrayList<>();
        PersonalLimpieza limpieza1 = new PersonalLimpieza("Baños",
                true,
                "Jaime",
                "ana",
                " asfafd",
                "asnjodasnf",
                "asbfijasf",
                "jbafjosjbfa");
        PersonalLimpieza limpieza2 = new PersonalLimpieza("Cocina",
                false,
                "Pep",
                "Guardiola",
                "1234567",
                "Pepe123",
                "Pepe123",
                "Pepe123"
                );
    }
}