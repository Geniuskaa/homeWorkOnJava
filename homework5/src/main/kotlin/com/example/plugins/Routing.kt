package com.example.plugins

import com.example.Races
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.response.*
import io.ktor.serialization.*
import kotlinx.coroutines.delay
import kotlinx.html.*
import kotlinx.serialization.Serializable


import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.jvmErasure


//@OptIn(ExperimentalStdlibApi::class)
inline fun <reified T:Any> HTML.form(obj: T) {
    body {
        div{
            T::class
                .memberProperties
                //.filter { it.visibility == KVisibility.PUBLIC}
                .map {
                    div{

                        val v = if (it.parameters.count() == 1) it.call(obj) else ""
                        + "${it.name}  "

                        val enumClass = it.returnType.jvmErasure.java
                        if (enumClass.isEnum) {
                            select {
                                enumClass.enumConstants.forEach {
                                    option {
                                        selected = it.toString() == v.toString()
                                        text(it.toString())
                                    }
                                }
                            }
                        } else {
                            textInput {
                                value = v.toString()
                            }
                        }
                    }

                }

        }
    }
}


@Serializable //disabled reified Generics
class UserProfile(
    val firstName: String,
    val secondName: String,
    val age: Int
)

@Serializable
class GameCharacter(
    val nameOfPlayer: String,
    val sex: Char, // w - woman, m - man, i - it
    val races: Races
)

fun Application.configureRouting() {
    // Starting point for a Ktor app:
    install(ContentNegotiation){
        json()
    }

    routing {
        get("/") {
            delay(1000)
            val firstName = call.request.queryParameters["firstname"]
            val secondName = call.request.queryParameters["secondname"]
            val age = call.request.queryParameters["age"]

            call.respond(UserProfile(firstName ?: "Default", secondName ?: "Default",  18))
        }

        get("/reflection") {
            call.respondHtml(status = HttpStatusCode.OK, HTML::userProfileForm)
        }

        get("/reflection2") {
            call.respondHtml(status = HttpStatusCode.OK, HTML::gameCharacterFrom)
        }

        get("/reflection3") {
            call.respondText("Hello")
        }
    }

}


fun HTML.userProfileForm() = form(UserProfile("Emil", "Zinnatullin", 21))
fun HTML.gameCharacterFrom() = form(GameCharacter("arnold96",'m', Races.ORC))