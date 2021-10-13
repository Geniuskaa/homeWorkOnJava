import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InvalidPropertiesFormatException;

public class MainTest {

    private String[] arguments;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        new Main();
        this.arguments = new String[]{"4", "*", "3"};
        System.setOut(new PrintStream(output));
    }

    @Test
    public void mainTest() throws InvalidPropertiesFormatException {
        Main.main(arguments);
        Assert.assertEquals("Result is 12", output.toString().trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}