package tpFinal.Models;
import tpFinal.Utilities.CategoriaProducto;
import java.io.Serializable;

public class Producto implements Serializable{
    private String codProducto;
    private String nombre;
    private String descripcion;
    private float valor;
    private CategoriaProducto categoria;

    public Producto(String codProducto, String nombre, String descripcion, float valor, CategoriaProducto categoria) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.categoria = categoria;
    }
    public Producto(){}

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

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return  "\n" + "-----------------------------------------" + "\n" +
                "Codigo Producto: " + codProducto +  "\n" +
                "         Nombre: " + nombre + "\n" +
                "    Descripcion: " + descripcion + "\n" +
                "          Valor: " + valor + "\n" +
                "      Categoria: " + categoria + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;

        if (Float.compare(producto.valor, valor) != 0) return false;
        if (!codProducto.equals(producto.codProducto)) return false;
        if (!nombre.equals(producto.nombre)) return false;
        if (!descripcion.equals(producto.descripcion)) return false;
        return categoria == producto.categoria;
    }

    @Override
    public int hashCode() {
        int result = codProducto.hashCode();
        result = 31 * result + nombre.hashCode();
        result = 31 * result + descripcion.hashCode();
        result = 31 * result + (valor != +0.0f ? Float.floatToIntBits(valor) : 0);
        result = 31 * result + categoria.hashCode();
        return result;
    }
}


