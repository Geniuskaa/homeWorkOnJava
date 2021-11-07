
import arrow.core.Either
import io.kotest.matchers.shouldBe
import org.junit.Test



class CalcTest {


    @Test
    fun plus_succes_test(){
        val answer = calculate(arrayOf("4.5", "+", "8"))
        answer.shouldBe(Either.Right(12.5))
    }

    @Test
    fun minus_succes_test(){
        val answer = calculate(arrayOf("9.2", "-", "8.2"))
        answer.shouldBe(Either.Right(1.0))
    }

    @Test
    fun div_succes_test(){
        val answer = calculate(arrayOf("9.3", "/", "3"))
        answer.shouldBe(Either.Right(3.1000000635782876))
    }

    @Test
    fun times_succes_test(){
        val answer = calculate(arrayOf("0", "*", "8"))
        answer.shouldBe(Either.Right(0))
    }

    @Test
    fun plus_fail_test(){
        val answer = calculate(arrayOf("af", "+", "8"))
        answer.shouldBe(Either.Left(CalculatorException.WrongArgument))
    }

    @Test
    fun div_fail_test(){
        val answer = calculate(arrayOf("437", "/", "0"))
        answer.shouldBe(Either.Left(CalculatorException.WrongArgument))
    }



}


