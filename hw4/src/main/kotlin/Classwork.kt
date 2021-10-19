import arrow.core.Either
import arrow.core.Option
import arrow.core.computations.either
import arrow.core.computations.option
import arrow.core.none
import kotlinx.coroutines.runBlocking

suspend fun main(args: Array<String>) {
    val left: Either<String, Int> =
//        Either.Right(1)
        Either.Left("Nothing at all")
    val right: Either<String, Int> = Either.Right(0)

    val some2 = Option(2)
    val some3 = Option(3)


    val none = none<Int>()

    runBlocking {
        val opt = option {
            val temp = none.bind()
            some2.bind() + some3.bind()
        }
        val rFold = opt.fold(
            {"None"}, {s->s.toString()})
        rFold
        println(rFold)
    }
    runBlocking {
        val er = either<String, Int> {
            val lb = left.bind()
            val rb = right.bind()
            lb + rb
        }
        val rFold = er.fold({it}, {it.toString()})
        rFold
        println(rFold)
    }
}