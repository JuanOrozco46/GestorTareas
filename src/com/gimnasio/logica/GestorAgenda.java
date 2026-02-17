package src.com.gimnasio.logica;

import java.util.ArrayList;

import src.com.gimnasio.modelo.Cita;

public class GestorAgenda {
    ArrayList<Cita> citas;

    public GestorAgenda() {
        new ArrayList<>();

    }

    public void agendarCita(Cita cita) {
        citas.add(cita);
    }

    public void eliminaCita(int id) {
        for (Cita cita : citas) {
            if (cita.getId() == id) {
                citas.remove(cita);
            } else {
                System.out.println("Id no encontrado, intente nuevamente");
            }

        }
    }

    public void listarCitas() {
        System.out.println("\n Citas registrados:");
        // Esta condición verifica que el array no este vacio
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas");
        } else {
            for (Cita cita : citas) {
                System.out.println("Id: " + cita.getId() + " Nombre: " + cita.getNombre() );

            }

        }
    }
}
