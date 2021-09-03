import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class usuario {

    static HashMap<String, String> usuarios = new HashMap<>();

    String nombre;
    String clave;

    public usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
        usuarios.put(nombre, clave);
    }

    public static void nuevoUsuario() {
        System.out.println("Bienvenido. Por favor, elige un seudónimo:");
        String nombre = entrada.next();

        if (usuarios.containsKey(nombre)) {
            System.out.println("El nombre de usuario ya está registrado. Intente con otro diferente");
        }

        else {
            System.out.println("Elije la clave que vas a usar");
            String clave = entrada.next();

            usuario nuevo = new usuario(nombre, clave);
            System.out.println("¡Se ha realizado el registro con éxito!");
            System.out.println("Usted es el usuario con seudónimo " + nuevo.nombre + " y contraseña " + nuevo.clave);
            System.out.println("\n");
        }
    }

    public static void logueo() {
        System.out.println("¿Cuál es su usuario?");
        String nombre = entrada.next();
        System.out.println("¿Cuál es su constraseña?");
        String clave = entrada.next();

        if (!usuarios.containsKey(nombre)) {
            System.out.println("No existe un usuario con el seudónimo ingresado. Inténtelo de nuevo.");
            System.out.println("\n");
        }
        else {
            if (clave.equals(usuarios.get(nombre))) {
                System.out.println("Usted se ha logueado correctamente.");
            }
            else {
                System.out.println("Su clave es incorrecta");
            }
        }
        System.out.println("\n");
    }

    public static void baseDatos() {
        for (Map.Entry<String, String> stringStringEntry : usuarios.entrySet()) {
            System.out.println("Usuario: " + ((Map.Entry) stringStringEntry).getKey() + " --- " + "Contraseña: " + ((Map.Entry) stringStringEntry).getValue());
        }
        System.out.println("\n");
    }

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion; // Entero para el número de opción a usar en el menú
        do {
            System.out.println("¡Bienvenido a la página X!");
            System.out.println("Ingrese el número de la opción que desee:");
            System.out.println("1. Registrarme.");
            System.out.println("2. Ingresar.");
            System.out.println("3. Salir.");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 0 -> baseDatos();
                case 1 -> nuevoUsuario();
                case 2 -> logueo();
                case 3 -> System.out.println("¡Hasta luego!");
            }
        }
        while (opcion != 3);

    }
}
