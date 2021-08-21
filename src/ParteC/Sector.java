package ParteC;

import java.util.ArrayList;
import java.util.List;

public class Sector {
    private int numero;
    private String denominacion;
    private String tipo;
    private Sector sectorPadre;
    private ArrayList<Sector> sectoresHijos;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Sector getSectorPadre() {
        return sectorPadre;
    }

    public void setSectorPadre(Sector sectorPadre) {
        this.sectorPadre = sectorPadre;
    }

    public ArrayList<Sector> getSectoresHijos() {
        return sectoresHijos;
    }

    public void setSectoresHijos(ArrayList<Sector> sectoresHijos) {
        this.sectoresHijos = sectoresHijos;
    }
    
    public List<Sector> obtenerTotalSubsectores(){
        
        List<Sector> sectoresRecurs = new ArrayList<Sector>();
        listaExpedientes(this, sectoresRecurs);
        return sectoresRecurs;
    }
    
    public void listaExpedientes(Sector sector, List<Sector> sectores){
       
        sectores.add(sector); 
        
        if (sector.getSectoresHijos()!= null) {            
            for (Sector sectorHijo : sector.getSectoresHijos()) {
                listaExpedientes(sector, sectores);
            }
        }
    }
}
