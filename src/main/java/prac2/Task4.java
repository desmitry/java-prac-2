package prac2;

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        System.out.println("Задание 4: расстояние между двумя точками в пространстве");

        try (Scanner scanner = new Scanner(System.in)) {
            String[] names = { "x1", "y1", "z1", "x2", "y2", "z2" };
            double[] c = new double[6];
            try {
                for (int i = 0; i < c.length; i++) {
                    System.out.print("Введите " + names[i] + ": ");
                    c[i] = Double.parseDouble(scanner.next().replace(',', '.'));
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: координаты должны быть числами.");
                return;
            }

            double d = distance(c[0], c[1], c[2], c[3], c[4], c[5]);
            System.out.printf("Расстояние = %.4f%n", d);
        }
    }

    static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dz = z2 - z1;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
