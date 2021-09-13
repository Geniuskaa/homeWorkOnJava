public class Calculator {
    public int calculate(int val1, String operator, int val2) throws ArithmeticException {
        switch (operator) {
            case "+" -> {return val1 + val2;}
            case "-" -> {return val1 - val2;}
            case "/" -> {
                if (val1 == 0) {
                    throw new ArithmeticException();
                }
                int sum = val1/val2;
                return sum;


            }
            case "*" -> {return val1 * val2;}
            default -> throw new ArithmeticException("It seems that operator isn`t correct!");
        }
    }
}
