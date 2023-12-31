package io.github.mathias8dev.yup


object Yup {

    val reactiveValidation = Options.REACTIVE
    internal const val DEFAULT_MIN_LENGTH = 1
    internal const val DEFAULT_MAX_LENGTH = 8


    fun statefulValidator(
        vararg options: Options,
        builder: StatefulValidatorBuilder.() -> Unit
    ): Validator.StatefulValidator {
        val statefulValidatorBuilder = StatefulValidatorBuilder(options)
        builder(statefulValidatorBuilder)

        return statefulValidatorBuilder.build()
    }

    fun statelessValidator(builder: ValidationConstraints.Builder.() -> List<Pair<String, ValidationConstraints>>): Validator.StatelessValidator {
        val constraintsBuilder = ValidationConstraints.Builder()
        val validationConstraints = builder(constraintsBuilder)
        return Validator.StatelessValidator(
            validationConstraints = validationConstraints.toMap(),
        )
    }


    fun ValidationConstraints(builder: ValidationConstraints.Builder.() -> Unit): ValidationConstraints {
        val constraintsBuilder = ValidationConstraints.Builder()
        builder(constraintsBuilder)
        return constraintsBuilder.build()
    }


    enum class Options {
        REACTIVE
    }



}

fun constraintsListOf(vararg args: Pair<String, ValidationConstraints>): Map<String, ValidationConstraints> {
    return mapOf(*args)
}

fun stateList(vararg args: Pair<String, String>): Map<String, String> {
    return mapOf(*args)
}


