package org.emgen.crypto.caesar

import org.emgen.crypto.caesar.extensions._mod
import org.emgen.crypto.caesar.extensions.toIntOrException

fun main(arguments: Array<String>) {
    if (arguments.isEmpty()) {
        println("no arguments provided")
        return
    }

    val action = arguments[0]

    if (!Action.values().map { it.name.toLowerCase() }.contains(action)) {
        println("action '$action' is not supported")
        return
    }

    val parameters = Parameters(arguments)

    try {
        val settings = Settings(
            Action.valueOf(action.toUpperCase()),
            parameters.value(Parameter.MESSAGE) ?: throw Exception("message not provided"),
            parameters.value(Parameter.KEY)?.toIntOrException() ?: Settings.DEFAULT_KEY,
            parameters.value(Parameter.ALPHABET) ?: Settings.DEFAULT_ALPHABET)
        println(process(settings))
    } catch (e: Exception) {
        println(e.message)
    }
}

fun process(settings: Settings): String {
    val lettersMapping = settings.lettersAsMap()
    return settings.input.toCharArray().joinToString("") { processLetter(lettersMapping, it, settings).toString() }
}

private fun processLetter(lettersMapping: Map<Char, Int>, letter: Char, settings: Settings): Char {
    val processed = lettersMapping[letter.toUpperCase()]?.let {
        lettersMapping.entries.find { e -> e.value == calculateIndex(it, settings) }?.key
    } ?: letter
    return if (letter.isUpperCase()) processed else processed.toLowerCase()
}

private fun calculateIndex(index: Int, settings: Settings): Int {
    val key = if (Action.ENCRYPT == settings.action) settings.key else -settings.key
    val count = settings.letters.length
    return if (key < 0) (index - (key * -1))._mod(count) else (index + key)._mod(count)
}