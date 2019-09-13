package org.emgen.crypto.caesar

class Settings(
    val action: Action,
    val input: String,
    val key: Int = DEFAULT_KEY,
    val letters: String = DEFAULT_ALPHABET
) {
    companion object {
        const val DEFAULT_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        const val DEFAULT_KEY = 5
    }

    fun lettersAsMap() = letters.map { it to letters.indexOf(it) }.toMap()
}