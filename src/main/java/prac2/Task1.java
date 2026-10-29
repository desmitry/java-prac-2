package prac2;

public class Task1 {

    public static void main(String[] args) {
        System.out.println("Таблица тангенсов от 0° до 90° с шагом 5°");
        for (int deg = 0; deg <= 90; deg += 5) {
            if (deg == 90) {
                System.out.println("tg(90°) не определён");
            } else {
                System.out.printf("tg(%d°) = %.4f%n", deg, Math.tan(Math.toRadians(deg)));
            }
        }
    }
}
