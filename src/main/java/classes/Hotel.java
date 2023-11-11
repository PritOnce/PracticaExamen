package classes;

public class Hotel {

    public String nombre;
    public int estrellas;
    public int telefono;
    public Direccion direccion;



    public Hotel(String nombre, int estrellas, int telefono, Direccion direccion) {
        this.nombre = nombre;
        this.estrellas = estrellas;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstrellas(short estrellas) {
        this.estrellas = estrellas;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public int getTelefono() {
        return telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

}
