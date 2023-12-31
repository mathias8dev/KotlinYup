package io.github.mathias8dev.yup


data class Errors(
    private val errors: MutableMap<String, List<String>> = mutableMapOf()
) {
    fun get(key: String): List<String>? = errors[key]

    fun getAll(): List<String> = errors.values.flatten()

    internal fun set(key: String, value: List<String>) {
        if (errors.containsKey(key)) errors[key] = value
    }

    internal fun set(keyPair: Pair<String, List<String>>) {
        set(keyPair.first, keyPair.second)
    }
}
