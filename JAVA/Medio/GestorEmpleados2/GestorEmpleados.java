import java.util.*;
import java.io.*;

public class GestorEmpleados {

    private ArrayList<Empleado> empleados;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    // Función 1: Agregar empleado
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // Función 2: Eliminar empleado por nombre
    public void eliminarEmpleadoPorNombre(String nombre) {
        Iterator<Empleado> iter = empleados.iterator();
        while (iter.hasNext()) {
            Empleado empleado = iter.next();
            if (empleado.getNombre().equals(nombre)) {
                iter.remove();  // Elimina el empleado de la lista
                System.out.println("Empleado " + nombre + " eliminado.");
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    // Función 3: Modificar un empleado
    public void modificarEmpleado(String nombre) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals(nombre)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nuevo salario: ");
                double nuevoSalario = scanner.nextDouble();
                empleado.setSalario(nuevoSalario);
                System.out.println("Salario actualizado de " + nombre);
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    // Función 4: Ordenar empleados por salario
    public void ordenarEmpleadosPorSalario() {
        Collections.sort(empleados, new Comparator<Empleado>() {
            @Override
            public int compare(Empleado e1, Empleado e2) {
                return Double.compare(e1.getSalario(), e2.getSalario());
            }
        });
        System.out.println("Empleados ordenados por salario.");
    }

    // Función 5: Buscar empleado por nombre
    public void buscarEmpleadoPorNombre(String nombre) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals(nombre)) {
                empleado.mostrarInformacion();
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    // Función 6: Calcular salario promedio
    public void calcularSalarioPromedio() {
        if (empleados.size() == 0) {
            System.out.println("No hay empleados.");
            return;
        }
        double sumaSalarios = 0;
        for (Empleado empleado : empleados) {
            sumaSalarios += empleado.getSalario();
        }
        double salarioPromedio = sumaSalarios / empleados.size();
        System.out.println("El salario promedio de los empleados es: " + salarioPromedio);
    }

    // Función 7: Mostrar empleado con salario más alto
    public void mostrarEmpleadoConSalarioMasAlto() {
        if (empleados.size() == 0) {
            System.out.println("No hay empleados.");
            return;
        }
        Empleado empleadoConSalarioMasAlto = empleados.get(0);
        for (Empleado empleado : empleados) {
            if (empleado.getSalario() > empleadoConSalarioMasAlto.getSalario()) {
                empleadoConSalarioMasAlto = empleado;
            }
        }
        System.out.println("Empleado con el salario más alto:");
        empleadoConSalarioMasAlto.mostrarInformacion();
    }

    // Función para guardar empleados en un archivo
    public void guardarEmpleadosEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(empleados);
            System.out.println("Empleados guardados en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Función para cargar empleados desde un archivo
    public void cargarEmpleadosDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            empleados = (ArrayList<Empleado>) ois.readObject();
            System.out.println("Empleados cargados desde el archivo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Mostrar todos los empleados
    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : empleados) {
                empleado.mostrarInformacion();
                System.out.println("-----");
            }
        }
    }

    // Menú interactivo
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Eliminar Empleado");
            System.out.println("3. Modificar Empleado");
            System.out.println("4. Ordenar Empleados por Salario");
            System.out.println("5. Buscar Empleado por Nombre");
            System.out.println("6. Calcular Salario Promedio");
            System.out.println("7. Mostrar Empleado con Salario Más Alto");
            System.out.println("8. Guardar Empleados en Archivo");
            System.out.println("9. Cargar Empleados desde Archivo");
            System.out.println("10. Mostrar Todos los Empleados");
            System.out.println("11. Salir");

            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer
                    agregarEmpleado(new Empleado(nombre, edad, salario));
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del empleado a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    eliminarEmpleadoPorNombre(nombreEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del empleado a modificar: ");
                    String nombreModificar = scanner.nextLine();
                    modificarEmpleado(nombreModificar);
                    break;
                case 4:
                    ordenarEmpleadosPorSalario();
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del empleado a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    buscarEmpleadoPorNombre(nombreBuscar);
                    break;
                case 6:
                    calcularSalarioPromedio();
                    break;
                case 7:
                    mostrarEmpleadoConSalarioMasAlto();
                    break;
                case 8:
                    guardarEmpleadosEnArchivo("empleados.dat");
                    break;
                case 9:
                    cargarEmpleadosDesdeArchivo("empleados.dat");
                    break;
                case 10:
                    mostrarEmpleados();
                    break;
                case 11:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();
        gestor.menu();
    }
}
