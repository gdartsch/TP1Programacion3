package ParteD;

import java.util.ArrayList;

public class Barrio {
    private long id;
    private String nombre;
    private String empresaConstructura;
    private ArrayList<Vivienda> viviendas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresaConstructura() {
        return empresaConstructura;
    }

    public void setEmpresaConstructura(String empresaConstructura) {
        this.empresaConstructura = empresaConstructura;
    }

    public ArrayList<Vivienda> getViviendas() {
        return viviendas;
    }

    public void setViviendas(ArrayList<Vivienda> viviendas) {
        this.viviendas = viviendas;
    }
    
    public double getSuperficieTotalTerreno(){
        double superficieTotal = 0.0;
        for (Vivienda vivienda : getViviendas()) {
            superficieTotal += vivienda.getSuperficieTerreno();
        }
        return superficieTotal;
    } 
    
    public double getSuperficieTotalCubierta() throws Exception{
        double superficieTotalCubierta = 0.0;
        for (Vivienda vivienda : getViviendas()) {
            superficieTotalCubierta += vivienda.getMetrosCuadradosCubiertos();
        }
        return superficieTotalCubierta;
    }
}
