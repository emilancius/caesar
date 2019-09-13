package org.emgen.crypto.caesar.extensions

import org.emgen.crypto.caesar.exceptions.ParseException

fun String.toIntOrException(exception: Exception = ParseException("string '$this' cannot be parsed to integer")): Int {
    return try {
        this.toInt()
    } catch (e: Exception) {
        throw exception
    }
}