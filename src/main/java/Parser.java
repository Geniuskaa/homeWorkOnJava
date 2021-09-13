import java.util.InvalidPropertiesFormatException;

public class Parser {


    public int parseIntOrError(String arg) throws InvalidPropertiesFormatException {
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

    public String parseOperatorOrError(String arg) throws InvalidPropertiesFormatException {
        if (!("+".equals(arg) || "-".equals(arg) || "/".equals(arg) || "*".equals(arg))) {
            throw new InvalidPropertiesFormatException("Operator is not supported");
        }
        return arg;
    }

    public void countOfArgumentsChecker(String[] args) throws InvalidPropertiesFormatException {
        if (!(args.length == 3)) {
            System.out.println("Arg format is: val1 +|-|*|/ val2");
            throw new InvalidPropertiesFormatException("Count of arguments is inncorrect");
        }
    }


}
