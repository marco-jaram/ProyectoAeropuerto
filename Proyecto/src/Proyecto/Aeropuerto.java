package Proyecto;

import org.jetbrains.annotations.NotNull;

public class Aeropuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private Compania listaCompanias [] = new Compania[10];
    private int numCompania;
    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numCompania = 0;
    }
    public Aeropuerto(String nombre, String ciudad, String pais, @NotNull Compania c[]) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        listaCompanias = c;
        this.numCompania = c.length;
    }

    public void insertarCompania (Compania compania){
        listaCompanias[numCompania] = compania;
        numCompania++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Compania[] getListaCompanias (){
        return listaCompanias;
    }

    public int getNumCompania() {
        return numCompania;
    }

    public Compania getCompania (int i){
        return listaCompanias[i];
    }
    public Compania getCompania (String nombre) {
        boolean encontrado = false;
        int i = 0;
        Compania c = null;
        while ((!encontrado) && (i < listaCompanias.length)) {

            if (nombre.equals(listaCompanias[i].getNombre())) {
                encontrado = true;
                c = listaCompanias[i];
            }
            i++;
        }
        return c;
    }
}
