package ParteA;

public class Control {
    private int id;
    private String denominacion;
    private boolean esObligatorio;
    private EstadoControl estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public boolean getEsObligatorio() {
        return esObligatorio;
    }

    public void setEsObligatorio(boolean esObligatorio) {
        this.esObligatorio = esObligatorio;
    }

    public EstadoControl getEstado() {
        return estado;
    }

    public void setEstado(EstadoControl estado) {
        this.estado = estado;
    }
    
    
}
