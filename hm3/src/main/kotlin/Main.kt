import arrow.core.*

fun main() {
    var x: Int = calculate(Pair(sum.partially1(2),5),Pair(minus.partially1(5),6))
    println(x)

    x  = calculate(Pair(multiply.partially1(8),5)) //,Pair(divide.partially1(60),6)
    println(x)

    x  = calculate(Pair(multiply.partially1(8),5) ,Pair(divide.partially1(60),6), Pair(minus.partially1(60),6) )
    println(x)

    x = calculate(Pair({it + 6},9), Pair({it / 3}, 9))
    println(x)
}

val sum = {x:Int, y:Int -> x + y}
val minus = {x:Int, y:Int -> x - y}
val multiply = {x:Int, y:Int -> x * y}
val divide = {x:Int, y:Int -> x / y }

fun calculate(vararg params: Pair<(Int) -> Int, Int> ): Int {
    val fnc = params
        .map {
            val v = it.first.partially1(it.second)
            val f = {x:Int -> x + v()}
            f
        }
        .reduce { c, n -> c andThen n }

    return fnc(0)
}


