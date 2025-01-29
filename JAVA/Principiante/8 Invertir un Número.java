import java.util.Scanner;

public class InvertirNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa un número: ");
        int num = scanner.nextInt();
        int invertido = 0;

        while (num != 0) {
            int digito = num % 10;
            invertido = invertido * 10 + digito;
            num /= 10;
        }

        System.out.println("El número invertido es: " + invertido);
        scanner.close();
    }
}
