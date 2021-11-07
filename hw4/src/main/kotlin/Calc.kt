import arrow.core.Either
import arrow.core.computations.either
import kotlinx.coroutines.runBlocking

suspend fun main(args: Array<String>) {
    runBlocking {
        val value = either<CalculatorException, kotlin.Number> {
            numOfArgsChecker(args).bind()
            operatorChecker(args).bind()
            zeroDivisionChecker(args).bind()
            calculate(args).bind()
        }

        println(value.fold({ it.toString() }, { it }))
    }
}

sealed class CalculatorException {
    object WrongNumOfArgs : CalculatorException()
    object WrongOperator : CalculatorException()
    object WrongArgument : CalculatorException()
    object ZeroDivision : CalculatorException()

    override fun toString(): String = when(this){
        WrongNumOfArgs -> "Invalid number of arguments"
        WrongOperator -> "Wrong operator"
        WrongArgument -> "First or third argument is not an integer"
        ZeroDivision -> "You can't divide by 0"
    }
}


fun argumentIsNum(arg: String): kotlin.Number? {

    try {
        val a = arg.toInt();
        return a
    }catch (e: NumberFormatException){ }

    try {
        val b = arg.toFloat()
        return b
    }catch (e: NumberFormatException){ }

    try {
        val c = arg.toDouble();
        return c
    }catch (e: NumberFormatException){ }

    return null
}


private fun first_arg_converter(arg: kotlin.Number?): Number {
    return when (arg) {
        is Int -> return Number(arg)
        is Float -> return Number(arg)
        is Double -> return Number(arg)
        else -> return throw NumberFormatException("Something gone wrong")
    }
}

private fun second_arg_converter(arg: kotlin.Number?): kotlin.Number {
    return when (arg) {
        is Int -> return arg
        is Float -> return arg
        is Double -> return arg
        else -> return throw NumberFormatException("Something gone wrong")
    }
}


fun numOfArgsChecker(args: Array<String>): Either<CalculatorException.WrongNumOfArgs, Array<String>> =
    if (args.size != 3) Either.Left(CalculatorException.WrongNumOfArgs)
    else Either.Right(args)

fun operatorChecker(args: Array<String>): Either<CalculatorException.WrongOperator, Array<String>> =
    if (args[1] == "+" || args[1] == "-" || args[1] == "/" || args[1] == "*") Either.Right(args)
    else Either.Left(CalculatorException.WrongOperator)

fun zeroDivisionChecker(args: Array<String>): Either<CalculatorException.ZeroDivision, Array<String>> =
    if (args[1] == "/" && args[2] == "0") Either.Left(CalculatorException.ZeroDivision)
    else Either.Right(args)

fun calculate(args: Array<String>): Either<CalculatorException.WrongArgument, kotlin.Number> {
    return try {

        when (args[1]) {
            "+" -> Either.Right(first_arg_converter(argumentIsNum(args[0])) + second_arg_converter(argumentIsNum(args[2])))
            "-" -> Either.Right(first_arg_converter(argumentIsNum(args[0])) - second_arg_converter(argumentIsNum(args[2])))
            "/" ->if(args[2].equals("0")) throw NumberFormatException() else Either.Right(first_arg_converter(argumentIsNum(args[0])) / second_arg_converter(argumentIsNum(args[2])))
            "*" -> Either.Right(first_arg_converter(argumentIsNum(args[0])) * second_arg_converter(argumentIsNum(args[2])))
            else -> Either.Left(CalculatorException.WrongArgument)
        }
    } catch (e: NumberFormatException) {
        return Either.Left(CalculatorException.WrongArgument)
    }
}

data class Number(val f_arg: kotlin.Number){

    operator fun plus(s_arg: kotlin.Number): kotlin.Number{
        when(f_arg){
            is Int -> when(s_arg){
                is Int -> return f_arg.toInt() + s_arg.toInt()
                else -> return f_arg.toInt() + s_arg.toDouble()
            }
            else -> when(s_arg){
                is Int -> return f_arg.toDouble() + s_arg.toInt()
                else -> return f_arg.toDouble() + s_arg.toDouble()
            }
        }
    }

    operator fun minus(s_arg: kotlin.Number): kotlin.Number{
        when(f_arg){
            is Int -> when(s_arg){
                is Int -> return f_arg.toInt() - s_arg.toInt()
                else -> return f_arg.toInt() - s_arg.toDouble()
            }
            else -> when(s_arg){
                is Int -> return f_arg.toDouble() - s_arg.toInt()
                else -> return f_arg.toDouble() - s_arg.toDouble()
            }
        }
    }

    operator fun div(s_arg: kotlin.Number): kotlin.Number{
        when(f_arg){
            is Int -> when(s_arg){
                is Int -> return f_arg.toInt() / s_arg.toInt()
                else -> return f_arg.toInt() / s_arg.toDouble()
            }
            else -> when(s_arg){
                is Int -> return f_arg.toDouble() / s_arg.toInt()
                else -> return f_arg.toDouble() / s_arg.toDouble()
            }
        }
    }

    operator fun times(s_arg: kotlin.Number): kotlin.Number{
        when(f_arg){
            is Int -> when(s_arg){
                is Int -> return f_arg.toInt() * s_arg.toInt()
                else -> return f_arg.toInt() * s_arg.toDouble()
            }
            else -> when(s_arg){
                is Int -> return f_arg.toDouble() * s_arg.toInt()
                else -> return f_arg.toDouble() * s_arg.toDouble()
            }
        }
    }
}







