import java.util.Scanner;

public class ConversorTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la temperatura en grados Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println(celsius + "°C es igual a " + fahrenheit + "°F");

        scanner.close();
    }
}
