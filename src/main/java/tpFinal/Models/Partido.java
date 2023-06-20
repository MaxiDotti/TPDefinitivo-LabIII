package tpFinal.Models;

public class Partido {

    private String id;
    private String categoria;
    private String fecha;
    private String deporte;
    private String rival;

    public Partido(String categoria, String fecha, String deporte, String rival, String id) {
        this.categoria = categoria;
        this.fecha = fecha;
        this.deporte = deporte;
        this.rival = rival;
        this.id = id;
    }

    public Partido() {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getRival() {
        return rival;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "id='" + id + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fecha='" + fecha + '\'' +
                ", deporte='" + deporte + '\'' +
                ", rival='" + rival + '\'' +
                '}';
    }
}
