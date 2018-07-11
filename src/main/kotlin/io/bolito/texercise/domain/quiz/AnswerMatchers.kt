package io.bolito.texercise.domain.quiz

enum class AnswerMatcher {
    LITERAL {
        override fun matches(expectedAnswer: String, actualAnswer: String): Int =
            if (expectedAnswer == actualAnswer) 100 else 0
    },
    MANUAL {
        override fun matches(expectedAnswer: String, actualAnswer: String): Int {
            throw IllegalStateException("Requires manual intervention")
        }
    };

    abstract fun matches(expectedAnswer: String, actualAnswer: String): Int
}
