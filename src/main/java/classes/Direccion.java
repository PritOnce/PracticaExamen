package classes;

import com.google.gson.annotations.SerializedName;

public class Direccion {
    public String calle;

    public int numero;

    public String ciudad;

    @SerializedName("codigoPostal")
    public int codigo_postal;

    public String pais;

    public Direccion(String calle, int numero, String ciudad, int codigo_postal, String pais) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
        this.pais = pais;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCodigo_postal(short codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public String getPais() {
        return pais;
    }
}

