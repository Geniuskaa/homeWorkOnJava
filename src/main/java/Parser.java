import java.util.InvalidPropertiesFormatException;

public class Parser {

    public static int parseIntOrError(String arg) throws InvalidPropertiesFormatException {
        boolean isValInt;
        try {
            Integer.parseInt(arg);
            isValInt = true;
        } catch (NumberFormatException e) {
            isValInt = false;
        }

        if (!isValInt) {
            System.out.println();
            throw new InvalidPropertiesFormatException("Argument is not number");
        }
        var val = Integer.parseInt(arg);
        return val;
    }

    public static String parseOperatorOrError(String arg) throws InvalidPropertiesFormatException {
        if (!("+".equals(arg) || "-".equals(arg) || "/".equals(arg) || "*".equals(arg))) {
            throw new InvalidPropertiesFormatException("Operator is not supported");
        }
        return arg;
    }

    public static boolean countOfArgumentsChecker(String[] args) {
        if (!(args.length == 3)) {
            System.out.println("Arg format is: val1 +|-|*|/ val2");
            return false;
        }
        return true;
    }


}
