package src.com.gimnasio;
import java.util.Scanner;
import com.gimnasio.servicio.GestorAgenda;
import com.gimnasio.vista.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        
        // 1. Instanciamos el SERVICIO (El cerebro)
        // Aquí es donde se guardarán los datos en memoria mientras corre el programa.
        GestorAgenda gestor = new GestorAgenda();

        // 2. Instanciamos la VISTA (La cara)
        // Le pasamos el 'gestor' al menú. Esto es clave:
        // El menú necesita tener acceso al gestor para poder agregar/eliminar eventos.
        MenuPrincipal menu = new MenuPrincipal(gestor);

        // 3. Arrancamos el ciclo del programa
        System.out.println("==========================================");
        System.out.println("   SISTEMA DE GESTIÓN DE HORARIO - GYM    ");
        System.out.println("==========================================");
        
        // Este método iniciará el bucle while(true) del menú
        menu.iniciar(); 
    }
}