package Proyecto;

import org.jetbrains.annotations.NotNull;

public class Compania {
    private String nombre;
    private Vuelo listaVuelos[]= new Vuelo[10];
    private int numVuelo = 0;

    public Compania(String nombre) {
        this.nombre = nombre;
    }
    public Compania(String nombre, @NotNull Vuelo v[]) {
        this.nombre = nombre;
        listaVuelos = v;
        numVuelo = v.length;
    }
    public void insertarVuelo (Vuelo vuelo){
        listaVuelos[numVuelo] = vuelo;
        numVuelo++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumVuelo() {
        return numVuelo;
    }
    public Vuelo getVuelo (int i){
        return listaVuelos[i];
    }
    public Vuelo getVuelo (@NotNull String id){
        boolean encontrado = false;
        int i = 10;
        Vuelo v = null;
        while((!encontrado)&&( i < listaVuelos.length)){

            if (id.equals(listaVuelos[i].getIdentificador())){
                encontrado = true;
                v = listaVuelos[i];

            }
            i++;
        }
        return v;
    }


}
