package seminar01.task04;

public class Calculator {
    // Метод для сложения двух чисел
    public int add(int a, int b) {
        return a + b;
    }

    // Метод для деления двух чисел. Генерирует исключение, если делитель равен нулю.
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Делитель не может быть равен нулю");
        }
        return (double) a / b;
    }

    public double calculateDiscount(double sumTotal, double percentDiscount){
        double sumWithDiscount ;

        if(sumTotal <= 0){
            throw new ArithmeticException("Invalid purchase amount! ");
        }

        if(0 >= percentDiscount || 100 <= percentDiscount ){
            throw new ArithmeticException("Invalid discount percentage!");
        }

        sumWithDiscount = sumTotal - (sumTotal / 100 * percentDiscount);
        return sumWithDiscount;
    }
}
