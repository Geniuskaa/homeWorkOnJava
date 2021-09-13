import java.util.InvalidPropertiesFormatException;

public class Main {
    public static void main(String[] args) {

        Parser parser = new Parser();

        try {
            parser.countOfArgumentsChecker(args);
            var val1 = parser.parseIntOrError(args[0]);
            var operator = parser.parseOperatorOrError(args[1]);
            var val2 = parser.parseIntOrError(args[2]);
            int sum = new Calculator().calculate(val1, operator, val2);
            System.out.println("Result is " + sum);

        }catch (InvalidPropertiesFormatException e) {
            switch (e.getMessage()){
                case("Argument is not number"):
                    System.exit(1);
                    break;
                case("Operator is not supported"):
                    System.exit(2);
                    break;
                case("Count of arguments is inncorrect"):
                    System.exit(3);
                    break;
                default:
                    System.exit(4);
            }
        }






    }
}
