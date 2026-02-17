package src.com.gimnasio.logica;

import java.io.*;
import java.util.ArrayList;
import src.com.gimnasio.modelo.Cita;

public class GestorAgenda {
    private ArrayList<Cita> citas;
    // Ruta donde se guardará el archivo de texto
    private final String RUTA_ARCHIVO = "data/agenda_db.txt"; 

    public GestorAgenda() {
        this.citas = new ArrayList<>();
        cargarDesdeArchivo();
    }

    public void agendarCita(Cita cita) {
        citas.add(cita);
        System.out.println("Cita agregada con éxito.");
        guardarEnArchivo();
    }

    public void eliminaCita(int id) {
        // CORRECCIÓN: Usamos removeIf para borrar de forma segura sin romper el bucle
        boolean eliminado = citas.removeIf(cita -> cita.getId() == id);
        
        if (eliminado) {
            System.out.println("Cita eliminada correctamente.");
            guardarEnArchivo();
        } else {
            System.out.println("Id no encontrado, intente nuevamente.");
        }
    }
    public void listarCitas() {
        System.out.println("\n--- Citas Registradas ---");
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
        } else {
            for (Cita cita : citas) {
                System.out.println("ID: " + cita.getId() + " | Cliente: " + cita.getNombre() + 
                                   " | Fecha: " + cita.getFecha() + " | Hora: " + cita.getHora());
            }
        }
    }
    private void guardarEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (Cita cita : citas) {

                writer.write(cita.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
    private void cargarDesdeArchivo() {
        File archivo = new File(RUTA_ARCHIVO);
        if (!archivo.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String fecha = partes[2];
                    String hora = partes[3];
                    citas.add(new Cita(id, nombre, fecha, hora));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }

    public int cantidadCitas() {
        return citas.size();
    }
}