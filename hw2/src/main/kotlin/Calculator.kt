import java.lang.ArithmeticException

open class Calculator {
    fun calculate(val1: Int, operator: String, val2: Int) = when(operator){
                "+" -> val1 + val2
                "-" -> val1 - val2
                "*" -> val1 * val2
                "/" -> {
                    if (val2 != 0)
                        val1 / val2
                    else throw ArithmeticException("You can`t divide by zero!")
                }
                else -> throw UnsupportedOperationException("Operator is not supported!")
            }
    }
