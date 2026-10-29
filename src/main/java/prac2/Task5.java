package prac2;

import java.util.Scanner;

// программа из практической работы 1 (площадь треугольника), доработанная: меню, повтор ввода, статические методы
public class Task5 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMenu();
                String command = scanner.next();
                switch (command) {
                    case "1" -> calculate(scanner);
                    case "2" -> printAbout();
                    case "3" -> printDeveloper();
                    case "0" -> running = false;
                    default -> System.out.println("Нет такого пункта, введите 1, 2, 3 или 0.");
                }
            }
            System.out.println("Выход из программы.");
        }
    }

    static void printMenu() {
        System.out.println();
        System.out.println("1 - выполнить расчёт");
        System.out.println("2 - информация о программе");
        System.out.println("3 - информация о разработчике");
        System.out.println("0 - выход");
        System.out.print("Выберите пункт: ");
    }

    static void printAbout() {
        System.out.println("Программа вычисляет площадь треугольника по трем сторонам.");
        System.out.println("Формула Герона: S = sqrt(p(p-a)(p-b)(p-c)), p = (a+b+c)/2");
    }

    static void printDeveloper() {
        System.out.println("Разработчик: desmitry");
    }

    static void calculate(Scanner scanner) {
        while (true) {
            Double a = readSide(scanner, "a");
            if (a == null) return;
            Double b = readSide(scanner, "b");
            if (b == null) return;
            Double c = readSide(scanner, "c");
            if (c == null) return;

            if (isTriangle(a, b, c)) {
                System.out.printf("Площадь треугольника S = %.4f%n", area(a, b, c));
                return;
            }
            System.out.println("Ошибка: из таких сторон нельзя построить треугольник. Введите стороны заново.");
        }
    }

    // спрашивает, пока не введут положительное число; null, если ввели 0 (возврат в меню)
    static Double readSide(Scanner scanner, String name) {
        while (true) {
            System.out.print("Введите сторону " + name + " (0 - в меню): ");
            String s = scanner.next();
            double value;
            try {
                value = Double.parseDouble(s.replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: сторона должна быть числом.");
                continue;
            }
            if (value == 0) return null;
            if (value < 0) {
                System.out.println("Ошибка: сторона должна быть положительной.");
                continue;
            }
            return value;
        }
    }

    static boolean isTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    static double area(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
