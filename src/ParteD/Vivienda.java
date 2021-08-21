package ParteD;

import java.util.ArrayList;

public class Vivienda {
    private long id;
    private String calle;
    private int numeroCalle;
    private double superficieTerreno;
    private Barrio barrio;
    private ArrayList<Habitacion> habitaciones;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public double getSuperficieTerreno() {
        return superficieTerreno;
    }

    public void setSuperficieTerreno(double superficieTerreno) {
        this.superficieTerreno = superficieTerreno;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
    
    public double getMetrosCuadradosCubiertos() throws Exception{
        double metrosCubiertos = 0.0;
        for (Habitacion habitacion : getHabitaciones()) {
            metrosCubiertos += habitacion.getMetrosCuadrados();
        }
        if (metrosCubiertos > getSuperficieTerreno()) {
            throw new Exception("“La superficie cubierta no puede ser mayor a la superficie del terreno");
        }
        return metrosCubiertos;
    }
}
