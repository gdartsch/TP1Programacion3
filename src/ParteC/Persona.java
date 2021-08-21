package ParteC;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String tipoDocumento;
    private long nroDocumento;
    private int telefono;
    private String email;
    private String celular;
    private Sector sector;
    private ArrayList<Actividad> actividades;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(long nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    public double totalPuntosAsignados(){
        double totalPuntosAsignados = 0.0;
        
        for (Actividad actividad : getActividades()) {
            totalPuntosAsignados += actividad.getTipoActividad().getPuntosAsignados();
        }
        
        return totalPuntosAsignados;
    }
    
    public double totalPuntosAsignados(int codigo){
        double totalPuntosAsignados = 0.0;
        
        for (Actividad actividad : getActividades()) {
            if (actividad.getTipoActividad().getCodigo() == codigo) {
                totalPuntosAsignados += actividad.getTipoActividad().getPuntosAsignados();
            }
        }
        
        return totalPuntosAsignados;
    }
    public double totalPuntosAsignados(int codigo, int anio){
        double totalPuntosAsignados = 0.0;
        
        for (Actividad actividad : getActividades()) {
            if (actividad.getTipoActividad().getCodigo() == codigo) {
                if (actividad.getFechaInicio().getYear() == anio || actividad.getFechaFin().getYear() == anio) {
                    totalPuntosAsignados += actividad.getTipoActividad().getPuntosAsignados();
                }
            }
        }
        
        return totalPuntosAsignados;
    }
}
