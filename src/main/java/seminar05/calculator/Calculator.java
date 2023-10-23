package seminar05.calculator;

public class Calculator {
    private Logger logger;

    public Calculator(Logger logger){
        this.logger = logger;
    }

    public int add(int a, int b){
        int result = a + b;
        logger.addLog("Сложение: " + a + " + " + b + " = " + result);
        return result;
    }

    public int subtract(int a, int b){
        int result = a - b;
        logger.addLog("Вычитание: " + a + " - " + b + " = " + result);
        return result;
    }
}
