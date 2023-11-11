package classes;

import java.util.List;

public class Hoteles {

    public String empresa;

    public int fundacion;

    public String ciudad_sede;

    public String pais_sede;

    public List<Hotel> hotel;


    public Hoteles(String empresa, int fundacion, String ciudad_sede, String pais_sede, List<Hotel> hotel) {
        this.empresa = empresa;
        this.fundacion = fundacion;
        this.ciudad_sede = ciudad_sede;
        this.pais_sede = pais_sede;
        this.hotel = hotel;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setFundacion(short fundacion) {
        this.fundacion = fundacion;
    }

    public void setCiudad_sede(String ciudad_sede) {
        this.ciudad_sede = ciudad_sede;
    }

    public void setPais_sede(String pais_sede) {
        this.pais_sede = pais_sede;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

    public String getEmpresa() {
        return empresa;
    }

    public int getFundacion() {
        return fundacion;
    }

    public String getCiudad_sede() {
        return ciudad_sede;
    }

    public String getPais_sede() {
        return pais_sede;
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

}
