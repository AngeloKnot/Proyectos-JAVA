import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;  // Número entre 1 y 100
        Scanner scanner = new Scanner(System.in);

        int intento;
        do {
            System.out.print("Adivina el número (1-100): ");
            intento = scanner.nextInt();
            if (intento < numeroAleatorio) {
                System.out.println("El número es más grande.");
            } else if (intento > numeroAleatorio) {
                System.out.println("El número es más pequeño.");
            }
        } while (intento != numeroAleatorio);

        System.out.println("¡Felicidades, adivinaste el número!");
        scanner.close();
    }
}
