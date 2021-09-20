import java.lang.Integer.parseInt
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val calculator: Calculator = Calculator()

    try {
        val value1 = args[0].toInt()
        val value2 = args[2].toInt()
        println("$value1 ${args[1]} $value2 is ${calculator.calculate(value1,args[1],value2)}")
    }catch (a: ArithmeticException){
        exitProcess(1)
    }catch (u: UnsupportedOperationException){
        exitProcess(2)
    }



}



