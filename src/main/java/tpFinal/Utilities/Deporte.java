package tpFinal.Utilities;

public enum Deporte {

    FUTBOL("Futbol"),
    BASQUET("Basquet"),
    VOLLEY("Volley"),
    HANDBALL("Handball"),
    NATACION("Natacion"),
    TENNIS("Tennis");

    private String deporte;

    Deporte(String deporte) {
        this.deporte = deporte;
    }
    public String getDeporte() {
        return deporte;
    }
}
