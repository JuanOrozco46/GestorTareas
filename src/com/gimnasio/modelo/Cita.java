package src.com.gimnasio.modelo;

public class Cita {
    package src.com.gimnasio.modelo;

public class Cita {
    
    private String nombre;
    private String fecha;
    private String hora;

    public Cita(String nombre, String fecha, String hora){
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    public String toString() {
        return "Cita{" + "nombre='" + nombre + '\'' + 
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}

}
