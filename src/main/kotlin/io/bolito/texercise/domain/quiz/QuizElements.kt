package io.bolito.texercise.domain.quiz

sealed class QuizElement {
    abstract val id: Int
}

data class Text(override val id: Int, val text: String) : QuizElement()

sealed class Question(override val id: Int, val question: String, val marks: Int = 1) : QuizElement()

sealed class Answer

data class OpenEndedAnswer(val answer: String) : Answer()

data class AnswerChoice(val answer: String, val correct: Boolean)
data class MultipleChoiceAnswer(
    val answers: List<AnswerChoice>,
    val uniqueAnswer: Boolean
) : Answer() {
    init {
        if (uniqueAnswer) {
            val correctAnswers = answers.asSequence().filter { it.correct }.count()
            if (correctAnswers != 1) throw IllegalArgumentException("This multiple choice question may only have one answer")
        }
    }
}

