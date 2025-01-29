import java.util.Scanner;

public class PromedioNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos números vas a ingresar? ");
        int cantidad = scanner.nextInt();

        double suma = 0;
        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Ingresa el número " + i + ": ");
            suma += scanner.nextDouble();
        }

        double promedio = suma / cantidad;
        System.out.println("El promedio es: " + promedio);
        scanner.close();
    }
}
