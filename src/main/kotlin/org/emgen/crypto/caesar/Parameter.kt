package org.emgen.crypto.caesar

enum class Parameter(val key: String) {
    MESSAGE("-i"),
    KEY("-k"),
    ALPHABET("-l")
}
