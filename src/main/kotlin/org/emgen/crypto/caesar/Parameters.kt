package org.emgen.crypto.caesar

class Parameters(val parameters: Array<String> = emptyArray()) {

    fun value(parameter: Parameter): String? {
        var index = 0

        for (param in parameters) {
            val isLast = index == parameters.size - 1

            if (param == parameter.key && !isLast) {
                val next = parameters[index + 1]

                if (!checkIsParameterKey(next)) {
                    return parameters[index + 1]
                }
            }

            index++
        }

        return null
    }

    private fun checkIsParameterKey(input: String) = Parameter.values().map { it.key }.contains(input)
}