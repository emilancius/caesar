package org.emgen.crypto.caesar

enum class Action(val value:Int = 1) {
    ENCRYPT,
    DECRYPT(-1)
}