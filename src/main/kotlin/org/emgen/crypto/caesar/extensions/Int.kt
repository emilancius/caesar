package org.emgen.crypto.caesar.extensions

fun Int._mod(other: Int): Int {
    val rem = this.rem(other)
    return if (rem < 0) rem + other else rem
}