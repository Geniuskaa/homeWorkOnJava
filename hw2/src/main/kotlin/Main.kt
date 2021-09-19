import java.lang.Integer.parseInt
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val calculator: Calculator = Calculator()
    val parser: Parser = Parser()

    val value1: Int
    val value2: Int
    
    try {
        value1 = parser.intParser(args[0])
        value2 = parser.intParser(args[2])
        println("$value1 ${args[1]} $value2 is ${calculator.calculate(value1,args[1],value2)}")
    }catch (a: ArithmeticException){
        exitProcess(1)
    }catch (u: UnsupportedOperationException){
        exitProcess(2)
    }



}



