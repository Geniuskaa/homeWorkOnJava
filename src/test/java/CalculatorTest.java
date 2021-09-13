import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Integer x;
    private Integer y;
    private Calculator calculator;

    @Before
    public void prepareArguments(){
        this.calculator = new Calculator();
        this.x = 3;
        this.y = 7;
    }


    @Test
    public void sum_X_Plus_Y_equal(){
        Assert.assertEquals(10, calculator.calculate(x,"+", y));
    }

    @Test
    public void difference_X_Minus_Y_equal(){
        Assert.assertEquals(-4, calculator.calculate(x,"-", y));
    }

    @Test
    public void amount_X_Multiply_Y_equal(){
        Assert.assertEquals(21, calculator.calculate(x,"*", y));
    }

    @Test
    public void amount_X_Divide_Y_equal(){
        Assert.assertEquals(0, calculator.calculate(x,"/", y));
    }


}
