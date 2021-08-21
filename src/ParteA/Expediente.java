package ParteA;

import java.util.ArrayList;
import java.util.List;


public class Expediente {
    private int id;
    private String letra;
    private int numero;
    private String descripcion;
    private String tipo;
    private String ambito;
    private ArrayList<Control> controles = new ArrayList<Control>();
    private Expediente expedientePadre;
    private List<Expediente> expedientesHijos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }
    
    public String getCaratulaExpediente(){
        return getNumero() + "-" + getLetra() + "-" + getDescripcion();
    }

    public ArrayList<Control> getControles() {
        return controles;
    }

    public void setControles(ArrayList<Control> controles) {
        this.controles = controles;
    }

    public Expediente getExpedientePadre() {
        return expedientePadre;
    }

    public void setExpedientePadre(Expediente expedientePadre) {
        this.expedientePadre = expedientePadre;
    }

    public List<Expediente> getExpedientesHijos() {
        return expedientesHijos;
    }

    public void setExpedientesHijos(List<Expediente> expedientesHijos) {
        this.expedientesHijos = expedientesHijos;
    }
    
    
    
    public String getControlesObligatorios (){
        String controlesObligatorios = "";
        
        for(Control control : controles){
            if (control.getEsObligatorio()) {
                controlesObligatorios += control.getDenominacion() + ", ";
            }
        }
        
        return controlesObligatorios;
    }
    
    public boolean getEstadoControles(){
        
        for(Control control : controles){
            if (control.getEsObligatorio()) {
                if (control.getEstado().getAprobado() == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public List<Expediente> listaExpedientes(){
        
        List<Expediente> expedientesRecurs = new ArrayList<Expediente>();
        listaExpedientes(this, expedientesRecurs);
        return expedientesRecurs;
    }
    
    public void listaExpedientes(Expediente expediente, List<Expediente> expedientes){
       
        expedientes.add(expediente); 
        
        if (expediente.getExpedientesHijos() != null) {            
            for (Expediente expedienteHijo : expediente.getExpedientesHijos()) {
                listaExpedientes(expediente, expedientes);
            }
        }
    }
}
