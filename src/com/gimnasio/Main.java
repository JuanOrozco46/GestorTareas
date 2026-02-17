package src.com.gimnasio;

import src.com.gimnasio.logica.GestorAgenda;
import src.com.gimnasio.modelo.Cita;
import src.com.gimnasio.util.EntradaSalida;

public class Main {
    public static void main(String[] args) {
        GestorAgenda gestor = new GestorAgenda();
        boolean continuar = true;

        System.out.println("Bienvenido al sistema de gestión 'El Horno Gym'");

        while (continuar) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Agendar nueva cita");
            System.out.println("2. Listar citas");
            System.out.println("3. Eliminar cita");
            System.out.println("4. Salir");
            
            // Usamos la clase de Nasly para leer la opción
            int opcion = EntradaSalida.leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    String nombre = EntradaSalida.leerTexto("Nombre del cliente: ");
                    String fecha = EntradaSalida.leerTexto("Fecha (dd/mm/aaaa): ");
                    String hora = EntradaSalida.leerTexto("Hora (hh:mm): ");
                    int nuevoId = gestor.cantidadCitas() + 1;

                    Cita nuevaCita = new Cita(nuevoId, nombre, fecha, hora);
                    gestor.agendarCita(nuevaCita);
                    break;

                case 2:
                    gestor.listarCitas();
                    break;

                case 3:
                    gestor.listarCitas();
                    int idBorrar = EntradaSalida.leerEntero("Ingrese el ID de la cita a eliminar: ");
                    gestor.eliminaCita(idBorrar);
                    break;

                case 4:
                    System.out.println("Guardando y saliendo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}