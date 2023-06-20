package tpFinal.Models;

public class Producto {
    private String codProducto;
    private String nombre;
    private String descripcion;
    private float valor;
    private Enum Categoria;

    public enum Categoria{
        INDUMENTARIA, BAZAR, CALZADO
    }

    public Producto(String codProducto, String nombre, String descripcion, float valor, Enum categoria) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        Categoria = categoria;
    }

    public Producto(){}

    //region SETTERS y GETTERS

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Enum getCategoria() {
        return Categoria;
    }

    public void setCategoria(Enum categoria) {
        Categoria = categoria;
    }

    ///endregion

    @Override
    public String toString() {
        return  "\n" + "-----------------------------------------" + "\n" +
                "Codigo Producto: " + codProducto +  "\n" +
                "         Nombre: " + nombre + "\n" +
                "    Descripcion: " + descripcion + "\n" +
                "          Valor: " + valor + "\n" +
                "      Categoria: " + Categoria + "\n";
    }
}
