package seminar03;

public class Calculator {

    /**
     * Метод evenOddNumber проверяет, является ли переданное число четным или нечетным
     * @param n - проверяемое число
     * @return true если число четное
     */
    public boolean evenOddNumber(int n) {
        return n % 2 == 0;
    }


    /**
     * Метод проверяет, попадает ли переданное число в интервал (25;100)
     * круглые скобки означают - границы НЕ включаются
     * @param n - проверяемое число
     * @return true если число попадает в интервал
     */
    public boolean numberInInterval(int n) {
        return ((25 < n) && (n < 100));
    }

}
