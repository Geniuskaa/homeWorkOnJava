package org.example

import arrow.core.Either
import arrow.core.getOrElse



open class Calculator {

    private fun parseInt(x: String): Either<String, Int> {
        return try {
            Either.Right(x.toInt())
        } catch (e: NumberFormatException) {
            Either.Left("Incorrect number")
        }
    }

    fun calculate(a: String?, operator: String, b: String?): Either<String, Int> {
        if (a == null || b == null) {
            return Either.Left("Some number is null")

        }

        val val1Either = parseInt(a)
        val val2Either = parseInt(b)

        val val1 = val1Either.getOrElse { return Either.Left("Incorrect number") }
        val val2 = val2Either.getOrElse { return Either.Left("Incorrect number") }
        return when (operator) {
            "+" -> Either.Right(val1 + val2)
            "-" -> Either.Right(val1 - val2)
            "*" -> Either.Right(val1 * val2)
            "/" -> Either.Right(val1 / val2)
            else -> Either.Left("Incorrect operator")
        }
    }
}

