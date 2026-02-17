package src.com.gimnasio.util;

public class EntradaSalida {
     private static Scanner sc = new Scanner(System.in);

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }


    public static int leerEntero(String mensaje) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(sc.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
            }
        }
        return numero;
    }
}
