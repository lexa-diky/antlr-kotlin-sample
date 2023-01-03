package io.github.lexadiky.sample

import io.github.lexadiky.sample.json.JsonLexer
import io.github.lexadiky.sample.json.JsonParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream


class JsonReader {

    fun read(path: String): Map<String, Any> {
        val contextClassLoader = Thread.currentThread().contextClassLoader
        val charStream = contextClassLoader.getResourceAsStream(path).use {  input ->
            CharStreams.fromStream(input)
        }
        val lexer = JsonLexer(charStream)
        val tokens = CommonTokenStream(lexer)
        val parser = JsonParser(tokens)
        println(parser)

        return emptyMap()
    }
}


fun main(args: Array<String>) {
    val reader = JsonReader()

    println(reader.read("sample.json"))
}