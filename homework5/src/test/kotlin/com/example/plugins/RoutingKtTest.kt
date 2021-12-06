package com.example.plugins

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*



internal class RoutingKtTest {

    @Test
    fun testRootReflection3() {
        withTestApplication(Application::configureRouting) {
            handleRequest(HttpMethod.Get, "/reflection3").apply {
                kotlin.test.assertEquals(HttpStatusCode.OK, response.status())
                kotlin.test.assertEquals("Hello", response.content)
            }
        }
    }


    @Test
    fun testRoot() {
        withTestApplication(Application::configureRouting) {
            val uri = "/?firstname=Emil&secondname=Zinnatullin&age=21"
            val expected = "{\"firstName\":\"Emil\",\"secondName\":\"Zinnatullin\",\"age\":18}"
            handleRequest(HttpMethod.Get, uri).apply {
                kotlin.test.assertEquals(HttpStatusCode.OK, response.status())
                kotlin.test.assertEquals(expected, response.content)
            }
        }
    }


    @Test
    fun testRootReflection() {
        withTestApplication(Application::configureRouting) {
            val uri = "/reflection"
            val expected = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "  <body>\n" +
                    "    <div>\n" +
                    "      <div>age  <input type=\"text\" value=\"21\"></div>\n" +
                    "      <div>firstName  <input type=\"text\" value=\"Emil\"></div>\n" +
                    "      <div>secondName  <input type=\"text\" value=\"Zinnatullin\"></div>\n" +
                    "    </div>\n" +
                    "  </body>\n" +
                    "</html>\n"
            handleRequest(HttpMethod.Get, uri).apply {
                kotlin.test.assertEquals(HttpStatusCode.OK, response.status())
                kotlin.test.assertEquals(expected, response.content)
            }
        }
    }


    @Test
    fun testRootReflection2() {
        withTestApplication(Application::configureRouting) {
            val uri = "/reflection2"
            val expected = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "  <body>\n" +
                    "    <div>\n" +
                    "      <div>nameOfPlayer  <input type=\"text\" value=\"arnold96\"></div>\n" +
                    "      <div>races  <select><option>HUMAN</option><option selected=\"selected\">ORC</option><option>GNOME</option></select></div>\n" +
                    "      <div>sex  <input type=\"text\" value=\"m\"></div>\n" +
                    "    </div>\n" +
                    "  </body>\n" +
                    "</html>\n"
            handleRequest(HttpMethod.Get, uri).apply {
                kotlin.test.assertEquals(HttpStatusCode.OK, response.status())
                kotlin.test.assertEquals(expected, response.content)
            }
        }
    }
}