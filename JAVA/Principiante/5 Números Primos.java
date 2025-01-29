import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa un número: ");
        int num = scanner.nextInt();

        System.out.println("Números primos hasta " + num + ":");
        for (int i = 2; i <= num; i++) {
            if (esPrimo(i)) {
                System.out.println(i);
            }
        }

        scanner.close();
    }

    public static boolean esPrimo(int numero) {
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
