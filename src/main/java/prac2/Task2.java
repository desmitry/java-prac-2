package prac2;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        System.out.println("Задание 2: ln(X+1) ~ X - X^2/2 + X^3/3 - ... + (-1)^(N-1) X^N/N");

        try (Scanner scanner = new Scanner(System.in)) {
            double x;
            int n;
            try {
                System.out.print("Введите X (|X| < 1): ");
                x = Double.parseDouble(scanner.next().replace(',', '.'));
                System.out.print("Введите N (N > 0): ");
                n = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: X должен быть числом, N целым числом.");
                return;
            }

            if (Math.abs(x) >= 1) {
                System.out.println("Ошибка: должно быть |X| < 1.");
                return;
            }
            if (n <= 0) {
                System.out.println("Ошибка: N должно быть больше 0.");
                return;
            }

            System.out.printf("Сумма ряда = %.10f%n", series(x, n));
            System.out.printf("ln(X+1)    = %.10f%n", Math.log(x + 1));
        }
    }

    static double series(double x, int n) {
        double sum = 0;
        double power = 1;
        for (int k = 1; k <= n; k++) {
            power *= x;   // X^k
            sum += (k % 2 == 1 ? 1 : -1) * power / k;
        }
        return sum;
    }
}
