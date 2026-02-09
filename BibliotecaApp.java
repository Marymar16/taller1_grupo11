import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    // prestamo = [idPrestamo, nombreUsuario, tituloLibro, diasPrestamo, multaPorDia]
    static ArrayList<ArrayList<Object>> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarPrestamo();
                case 2 -> mostrarPrestamos();
                case 3 -> buscarPrestamoPorId();
                case 4 -> actualizarPrestamo();
                case 5 -> eliminarPrestamo();
                case 6 -> calcularTotalMultas();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
            System.out.println();
        } while (opcion != 7);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("=== Biblioteca: Gestión de Préstamos ===");
        System.out.println("1. Registrar nuevo préstamo");
        System.out.println("2. Mostrar todos los préstamos");
        System.out.println("3. Buscar préstamo por ID");
        System.out.println("4. Actualizar un préstamo");
        System.out.println("5. Eliminar un préstamo");
        System.out.println("6. Calcular total de multas");
        System.out.println("7. Salir");
    }

    // ====== CRUD ======

   static void buscarPrestamoPorId() { 
        int idBuscar = leerEntero("Ingrese el ID a buscar: ");

    for (ArrayList<Object> p : prestamos) {
        if ((int) p.get(0) == idBuscar) {
            System.out.println("Préstamo encontrado:");
            System.out.println(p);
            return;
        }
    }

    System.out.println("Préstamo no encontrado.");
    }


    static void actualizarPrestamo() { 
          int idBuscar = leerEntero("Ingrese el ID a actualizar: ");

    for (ArrayList<Object> p : prestamos) {
        if ((int) p.get(0) == idBuscar) {

            String nuevoNombre = leerTexto("Nuevo nombre del usuario: ");
            String nuevoTitulo = leerTexto("Nuevo título del libro: ");
            int nuevosDias = leerEntero("Nuevos días de préstamo: ");
            double nuevaMulta = Double.parseDouble(leerTexto("Nueva multa por día: "));

            p.set(1, nuevoNombre);
            p.set(2, nuevoTitulo);
            p.set(3, nuevosDias);
            p.set(4, nuevaMulta);

            System.out.println("Préstamo actualizado correctamente.");
            return;
        }
    }

    System.out.println("Préstamo no encontrado.");
    }


    // ====== Cálculo (por implementar) ======
    static void calcularTotalMultas() { /* TODO */ }

    // ====== Utilidades mínimas ======
    static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Ingrese un entero válido.");
            }
        }
    }

    static String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}

