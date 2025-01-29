// Importaciones
import java.util.ArrayList;
import java.util.Scanner;

// Definición de la clase GestorEmpleados
public class GestorEmpleados {

    // Lista de empleados
    private ArrayList<Empleado> empleados;

    // Constructor
    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    // Método para agregar un empleado
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // Método para mostrar todos los empleados
    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();
            System.out.println("-----");
        }
    }

    // Método principal para interactuar con el gestor de empleados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

        // Ingresar número de empleados
        System.out.print("Ingrese el número de empleados: ");
        int numeroEmpleados = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        for (int i = 0; i < numeroEmpleados; i++) {
            System.out.println("Empleado " + (i + 1));

            // Ingresar datos del empleado
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            System.out.print("Salario: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            // Crear un nuevo objeto Empleado y agregarlo al gestor
            Empleado empleado = new Empleado(nombre, edad, salario);
            gestor.agregarEmpleado(empleado);
        }

        // Mostrar todos los empleados
        System.out.println("\nInformación de todos los empleados:");
        gestor.mostrarEmpleados();

        scanner.close();
    }
}
