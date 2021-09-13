import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.InvalidPropertiesFormatException;


public class ParserTests {
    private String[] correctArguments;
    private String[] wrongArguments;
    private Parser parser;


    @Before
    public void prepareThreeArgumentsAndParser(){
        correctArguments = new String[]{"1", "+", "3"};
        wrongArguments = new String[]{"k", ")", "3", "6"};
        parser = new Parser();
    }


    @Test
    public void parseIntSuccessfully() throws InvalidPropertiesFormatException {
        var val1 = parser.parseIntOrError(correctArguments[0]);
        var val2 = parser.parseIntOrError(correctArguments[2]);
        Assert.assertEquals(Integer.parseInt(correctArguments[0]),val1);
        Assert.assertEquals(Integer.parseInt(correctArguments[2]),val2);
    }

    @Test
    public void parseIntWithError(){
        Assert.assertThrows(InvalidPropertiesFormatException.class, new ThrowingRunnable() {
                    @Override
                    public void run() throws Throwable {
                        parser.parseIntOrError(wrongArguments[0]);
                    }
                });
    }

    @Test
    public void parseOperatorSuccessfully() throws InvalidPropertiesFormatException {
        var operator = parser.parseOperatorOrError(correctArguments[1]);
        Assert.assertEquals(correctArguments[1],operator);
    }

    @Test
    public void parseOperatorWithError(){
        Assert.assertThrows(InvalidPropertiesFormatException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                parser.parseOperatorOrError(wrongArguments[1]);
            }
        });
    }

    @Test
    public void countOfArgsWithError(){
        Assert.assertThrows(InvalidPropertiesFormatException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                parser.countOfArgumentsChecker(wrongArguments);
            }
        });
    }

}
