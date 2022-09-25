package Proyecto;

import org.jetbrains.annotations.NotNull;

public class AeropuertoPrivado extends Aeropuerto{
    private String listaEmpresas[] = new String [10];
    private int numEmpresa;

    public AeropuertoPrivado(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);

    }

    public AeropuertoPrivado(String nombre, String ciudad, String pais, Compania[] c, @NotNull String e[]) {
        super(nombre, ciudad, pais, c);
        this.listaEmpresas = e;
        numEmpresa = e.length;
    }
    public void insertarEmpresas (@NotNull String e[]){
        this.listaEmpresas = e;
        this.numEmpresa = e.length;
    }
    public void insertarEmpresa (String e){
        listaEmpresas[numEmpresa] = e;
        numEmpresa++;
    }

    public String[] getListaEmpresas() {
        return listaEmpresas;
    }

    public int getNumEmpresa() {
        return numEmpresa;
    }
}
