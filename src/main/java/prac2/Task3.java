package prac2;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        System.out.println("Задание 3: A1 = 1, A2 = 2, AK = (A(K-2) + 2*A(K-1)) / 3");

        try (Scanner scanner = new Scanner(System.in)) {
            double eps;
            try {
                System.out.print("Введите ε (ε > 0): ");
                eps = Double.parseDouble(scanner.next().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ε должно быть числом.");
                return;
            }

            if (eps <= 0) {
                System.out.println("Ошибка: ε должно быть больше 0.");
                return;
            }

            double prev2 = 1;   // A(K-2)
            double prev = 2;    // A(K-1)
            int k = 2;
            double current;
            // заранее неизвестно, сколько шагов нужно, поэтому do-while
            do {
                k++;
                current = (prev2 + 2 * prev) / 3;
                prev2 = prev;
                prev = current;
            } while (Math.abs(current - prev2) >= eps);

            System.out.println("K = " + k);
            System.out.printf("A(K-1) = %.10f%n", prev2);
            System.out.printf("A(K)   = %.10f%n", current);
        }
    }
}
