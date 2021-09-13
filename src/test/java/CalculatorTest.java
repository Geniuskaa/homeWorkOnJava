import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

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
        Assert.assertEquals(x+y, calculator.calculate(x,"+", y));
    }

    @Test
    public void difference_X_Minus_Y_equal(){
        Assert.assertEquals(x-y, calculator.calculate(x,"-", y));
    }

    @Test
    public void amount_X_Multiply_Y_equal(){
        Assert.assertEquals(x*y, calculator.calculate(x,"*", y));
    }

    @Test
    public void amount_X_Divide_Y_equal(){
        Assert.assertEquals(x/y, calculator.calculate(x,"/", y));
    }

    @Test
    public void divisionBy_0_Forbidden() throws ArithmeticException {
        Assert.assertThrows(ArithmeticException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                calculator.calculate(0,"/",5);
            }
        });
    }

    @Test
    public void calculateWithWrongOperator(){
        Assert.assertThrows(ArithmeticException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                calculator.calculate(2,"%",5);
            }
        });
    }


}
