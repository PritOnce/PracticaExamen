package org.example;

import classes.Direccion;
import classes.Hotel;
import classes.Hoteles;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

        Gson gson = gsonBuilder.create();

//        fromJsonEj1(gson);

//        Hotel newHotel = new Hotel("Pensión Paqui", 5, 654982316,
//                new Direccion("Calle Anuel", 5, "Palma", 07003, "ES"));

//        newHotelEj2(gson, newHotel);

//        addStarEj3(gson);

        addHotelsEj4(gson);
    }

    private static void fromJsonEj1(Gson gson){
        try {

            Hoteles hoteles = gson.fromJson(new FileReader("src/main/resources/hotels.json"),
                    Hoteles.class);

            List<Hotel> hotel = hoteles.getHotel();

            for(Hotel nomHotel : hotel){
                System.out.println(nomHotel.getNombre());
            }

        }catch (Exception e){

        }
    }

    private static void newHotelEj2(Gson gson, Hotel hotel){
        try {
            String nuevo = altaNuevoHotel(gson, hotel);
            saveInf(nuevo, "src/main/resources/hotels.json");
        }catch (Exception e){

        }
    }

    private static void addStarEj3(Gson gson){
        try{
            Hoteles hoteles = gson.fromJson(new FileReader("src/main/resources/hotels.json"),
                    Hoteles.class);

            List<Hotel> hotel = hoteles.getHotel();

            for(Hotel nomHotel : hotel){
                int estrellas = nomHotel.getEstrellas();
                if(estrellas == 4){
                    nomHotel.setEstrellas((short) 5);
                }
                String actualizarJson = gson.toJson(hoteles);

                FileWriter fw = new FileWriter("src/main/resources/hotels.json");

                fw.write(actualizarJson);
                fw.flush();
                fw.close();
            }

        } catch (FileNotFoundException e){
            System.out.println("ERROR EN I/O");
        } catch (Exception e){
            System.out.println("ERROR GENERAL");
        }
    }

    private static void addHotelsEj4(Gson gson){
        try {
            Hoteles hotelesNuevos = gson.fromJson(new FileReader("src/main/resources/hotels_nous.json"),
                    Hoteles.class);

            List<Hotel> hotelNuevo = hotelesNuevos.getHotel();

            for(Hotel hotelNuevo1 : hotelNuevo){
                String nuevo = altaNuevoHotel(gson, hotelNuevo1);
                saveInf(nuevo, "src/main/resources/hotels.json");
            }

        }catch (Exception e){
            System.out.println("ERROR GENERAL EJ4");
        }
    }

    /*
    ACTIVIDAD 5:
        GSON VENTAJAS:
            - Bueno es los procesos de serializarción y deserialización de datos pequeños, es decir, es rápido
            - Fácil serializaciól y deserialización (toJson/fromJson)
        GSON DESVENTAJAS:
            - Sufrir problemas de rendimiento con archivos grandes.
            - Se necesita meterlos en cadenas o listas para trabajar con los datos.

       JACKSON VENTAJAS:
            - Buen rendimiento en archivos grandes
       JACKSON DESVENTAJAS:
            - Dificil documentación


     */



    private static String altaNuevoHotel(Gson gson, Hotel hotel){
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
            System.out.println("ERROR GENERAL saveInf");
        }
    }
}