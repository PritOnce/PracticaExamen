package org.example;

import classes.Direccion;
import classes.Hotel;
import classes.Hoteles;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

        Gson gson = gsonBuilder.create();

//        fromJsonEj1(gson);

        Hotel newHotel = new Hotel("Pensión Paqui", 5, 654982316,
                new Direccion("Calle Anuel", 5, "Palma", 07003, "ES"));

        newHotelEj2(gson, newHotel);
    }

    private static void fromJsonEj1(Gson gson){
        try {

            Hoteles hoteles = gson.fromJson(new FileReader("src/main/resources/hotels.json"),
                    Hoteles.class);

            List<Hotel> hotel = hoteles.getHotel();

            for(Hotel nomHotel : hotel){
                System.out.println(nomHotel.nombre);
            }

        }catch (Exception e){

        }
    }

    private static void newHotelEj2(Gson gson, Hotel hotel){
        try {
            String nuevo = altaJugador(gson, hotel);
            saveInf(nuevo, "src/main/resources/hotels.json");
        }catch (Exception e){

        }
    }

    private static void addStarEj3(Gson gson){
        
    }

    private static String altaJugador(Gson gson, Hotel hotel){
        String anadirHotel = null;
        try{
            Hoteles objHoteles = gson.fromJson(new FileReader("src/main/resources/hotels.json"),
                                    Hoteles.class);

            List<Hotel> hotels = objHoteles.getHotel();
            Hotel[] finalHotel = appendHotel(hotel, hotels);
            objHoteles.setHotel(List.of(finalHotel));
            anadirHotel = gson.toJson(objHoteles);

        }catch (Exception e){

        }
        return anadirHotel;
    }

    private static Hotel[] appendHotel(Hotel hotel, List<Hotel> hotels){
        Hotel[] hotelArray = null;

        try{

            ArrayList<Hotel> hotelRes = new ArrayList<Hotel>(hotels);

            String nombre = hotel.getNombre();
            boolean exist = false;

            for (Hotel hotelActual: hotelRes) {
                String nombreExiste = hotelActual.getNombre();
                if(nombreExiste.toUpperCase().equals(nombre.toUpperCase())){
                    exist = true;
                    break;
                }
            }

            if(!exist){
                hotelRes.add(hotel);
            }

            hotelArray = new Hotel[hotelRes.size()];
            hotelArray = hotelRes.toArray(hotelArray);
        }catch (Exception e){

        }
        return hotelArray;
    }

    private static void saveInf(String nuevoHotel, String path){
        try{
            FileWriter fw = new FileWriter(path);
            fw.write(nuevoHotel);
            fw.close();
        }catch (Exception e){

        }
    }
}