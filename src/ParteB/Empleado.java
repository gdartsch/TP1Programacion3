package ParteB;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private long cuit;
    private String domicilio;
    private String email;
    private RegimenHorario regimenHorario;
    private ArrayList<Asistencia> asistencias;
    private ArrayList<Tardanza> tardanzas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegimenHorario getRegimenHorario() {
        return regimenHorario;
    }

    public void setRegimenHorario(RegimenHorario regimenHorario) {
        this.regimenHorario = regimenHorario;
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(ArrayList<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public ArrayList<Tardanza> getTardanzas() {
        return tardanzas;
    }

    public void setTardanzas(ArrayList<Tardanza> tardanzas) {
        this.tardanzas = tardanzas;
    }
    
    public List<Asistencia> getAsistenciaXMesXAnio(int mes, int anio){
        List<Asistencia> asistenciasPedidas = new ArrayList<Asistencia>();
        for (Asistencia asistencia : this.getAsistencias()) {
            if (asistencia.getFecha().getYear() == anio) {
                if (asistencia.getFecha().getMonth() == mes) {
                    asistenciasPedidas.add(asistencia);
                }
            }
        }
        return asistenciasPedidas;
    }
    
     public List<Tardanza> getDiasConTardanza(int mes, int anio){
        for (Asistencia asistencia : this.getAsistenciaXMesXAnio(mes, anio)) {
            if (asistencia.getTipo().equals("E")) {
                if (this.getRegimenHorario().getMinutoIngreso() < asistencia.getMinuto()) {
                    if (this.getRegimenHorario().getHoraIngreso() < asistencia.getHora()) {
                        if (this.getRegimenHorario().getMinutoIngreso() - asistencia.getMinuto() > 15) {
                            Tardanza tardanza = new Tardanza();
                            tardanza.setEmpleado(this);
                            tardanza.setFecha(asistencia.getFecha());
                            tardanza.setHora(asistencia.getHora());
                            tardanza.setId(asistencia.getId());
                            tardanza.setMinuto(asistencia.getMinuto());
                            tardanza.setTipo(asistencia.getTipo());

                            this.getTardanzas().add(tardanza);
                        }   
                    }
                }  
            }  
        }
            
        return this.getTardanzas();
     } 
}
