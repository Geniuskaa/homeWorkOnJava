import arrow.core.Either
import arrow.core.computations.either
import kotlinx.coroutines.runBlocking

suspend fun main(args: Array<String>) {
    runBlocking {
        val value = either<CalculatorException, Int> {
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

fun argumentIsInt(arg: String): Boolean {
    return try {
        Integer.parseInt(arg)
        true
    } catch (e: NumberFormatException) {
        false
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

fun calculate(args: Array<String>): Either<CalculatorException.WrongArgument, Int> =
    if (!argumentIsInt(args[0]) || !argumentIsInt(args[2])) Either.Left(CalculatorException.WrongArgument)
    else when (args[1]) {
        "+" -> Either.Right(Integer.parseInt(args[0]) + Integer.parseInt(args[2]))
        "-" -> Either.Right(Integer.parseInt(args[0]) - Integer.parseInt(args[2]))
        "/" -> Either.Right(Integer.parseInt(args[0]) / Integer.parseInt(args[2]))
        "*" -> Either.Right(Integer.parseInt(args[0]) * Integer.parseInt(args[2]))
        else -> Either.Left(CalculatorException.WrongArgument)
    }

