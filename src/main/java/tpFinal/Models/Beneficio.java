package tpFinal.Models;

public final class Beneficio {

    private String id;
    //Empresa que provee el tipoDeDescuento
    private String proveedor;

    //A qué sector pertenece, gastronomía, indumentaria, etc.
    private String categoria;

    //Porcentaje o tipo de descuento
    private String tipoDeDescuento;


    //¿Cuándo podemos utilizar el tipoDeDescuento?
    private String fechaDeUtilidad;

    public Beneficio(String id, String proveedor, String categoria, String tipoDeDescuento, String fechaDeUtilidad) {
        this.id = id;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.tipoDeDescuento = tipoDeDescuento;
        this.fechaDeUtilidad = fechaDeUtilidad;
    }

    public Beneficio() {
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoDeDescuento() {
        return tipoDeDescuento;
    }

    public void setTipoDeDescuento(String tipoDeDescuento) {
        this.tipoDeDescuento = tipoDeDescuento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaDeUtilidad() {
        return fechaDeUtilidad;
    }

    public void setFechaDeUtilidad(String fechaDeUtilidad) {
        this.fechaDeUtilidad = fechaDeUtilidad;
    }

    @Override
    public String toString() {
        return "tipoDeDescuento{" +
                "id='" + id + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", tipoDeDescuento='" + tipoDeDescuento + '\'' +
                ", fechaDeUtilidad='" + fechaDeUtilidad + '\'' +
                '}';
    }
}
