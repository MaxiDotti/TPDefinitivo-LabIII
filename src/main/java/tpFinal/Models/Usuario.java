package tpFinal.Models;

public abstract class Usuario {
    private String nombre;
    private String apellido;
    private String dni;
    private String contrasenia;
    private String telefono;
    private String direccion;

    //region Constructores
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String dni, String contrasenia, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    //endregion

    //region Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //endregion

    //region Equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return dni.equals(usuario.dni);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        return result;
    }
    //endregion

    //region toString
    @Override
    public String toString() {
        return "---> Usuario" +
                "    Nombre: " + nombre +
                "  Apellido:" + apellido +
                "       DNI: " + dni +
                "Contraseña: " + contrasenia +
                "  Telefono: " + telefono +
                " Direccion: " + direccion;
    }
    //endregion
}
