import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.InvalidPropertiesFormatException;


public class ParserTest {
    private String[] correctArguments;
    private String[] wrongArguments;


    @Before
    public void prepareThreeArgumentsAndParser(){
        new Parser();
        correctArguments = new String[]{"1", "+", "3"};
        wrongArguments = new String[]{"k", ")", "3", "6"};
    }


    @Test
    public void parseIntSuccessfully() throws InvalidPropertiesFormatException {
        var val1 = Parser.parseIntOrError(correctArguments[0]);
        var val2 = Parser.parseIntOrError(correctArguments[2]);
        Assert.assertEquals(Integer.parseInt(correctArguments[0]),val1);
        Assert.assertEquals(Integer.parseInt(correctArguments[2]),val2);
    }

    @Test
    public void parseIntWithError(){
        Assert.assertThrows(InvalidPropertiesFormatException.class, new ThrowingRunnable() {
                    @Override
                    public void run() throws Throwable {
                        Parser.parseIntOrError(wrongArguments[0]);
                    }
                });
    }

    @Test
    public void parseOperator_plus() throws InvalidPropertiesFormatException {
        var operator = Parser.parseOperatorOrError("+");
        Assert.assertEquals("+",operator);
    }

    @Test
    public void parseOperator_minus() throws InvalidPropertiesFormatException {
        var operator = Parser.parseOperatorOrError("-");
        Assert.assertEquals("-",operator);
    }

    @Test
    public void parseOperator_multiply() throws InvalidPropertiesFormatException {
        var operator = Parser.parseOperatorOrError("*");
        Assert.assertEquals("*",operator);
    }

    @Test
    public void parseOperator_divide() throws InvalidPropertiesFormatException {
        var operator = Parser.parseOperatorOrError("/");
        Assert.assertEquals("/",operator);
    }

    @Test
    public void parseOperatorWithError(){
        Assert.assertThrows(InvalidPropertiesFormatException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                Parser.parseOperatorOrError(wrongArguments[1]);
            }
        });
    }

    @Test
    public void countOfArgsWithError(){
        Assert.assertEquals(false, Parser.countOfArgumentsChecker(wrongArguments));
    }

    @Test
    public void countOfArgsCorrect(){
        Assert.assertEquals(true, Parser.countOfArgumentsChecker(correctArguments));
    }

}
