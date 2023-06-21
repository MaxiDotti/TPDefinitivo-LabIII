package tpFinal;


import tpFinal.Models.Partido;
import tpFinal.Services.PartidoService;

public class Main {
    public static void main(String[] args) {

        PartidoService partidoService = new PartidoService();
        Partido nuevoPartido = new Partido("1234", "6/11/2023", "Basquet", "Lakers", "5");
        //partidoService.agregar(nuevoPartido);
        //partidoService.eliminar("1");
        partidoService.modificar(nuevoPartido);
        System.out.println(partidoService.listar());


    }
}