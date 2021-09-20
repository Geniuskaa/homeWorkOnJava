import java.util.InvalidPropertiesFormatException;

public class Main {
    public static void main(String[] args) throws InvalidPropertiesFormatException {

        Parser.countOfArgumentsChecker(args);

        var val1 = Parser.parseIntOrError(args[0]);
        var operator = Parser.parseOperatorOrError(args[1]);
        var val2 = Parser.parseIntOrError(args[2]);
        int sum = new Calculator().calculate(val1, operator, val2);

        System.out.println("Result is " + sum);

    }
}
