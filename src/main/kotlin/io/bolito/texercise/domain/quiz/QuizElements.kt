package io.bolito.texercise.domain.quiz

sealed class QuizElement(val isQuestion: Boolean) {
    abstract val id: Int
}

data class Text(override val id: Int, val text: String) : QuizElement(false)

sealed class Question(
    override val id: Int,
    val question: String,
    val marks: Int = 1,
    val acceptedAnswer: Answer
) : QuizElement(true)

/////////////////  ANSWERS //////////////////////////

sealed class Answer {
    abstract fun mark(marker: Marker): MarkInfo
}

object OpenEndedAnswer : Answer() {
    override fun mark(marker: Marker): MarkInfo = NoMarkInfo
}

data class SimpleAnswer(val answer: String) : Answer() {
    override fun mark(marker: Marker): MarkInfo = marker.mark(this)
}

data class TrueFalseAnswer(val boolean: Boolean) : Answer() {
    override fun mark(marker: Marker): MarkInfo = marker.mark(this)
}

data class MultipleSimpleAnswer(val answers: List<SimpleAnswer>) : Answer() {
    init {
        require(answers.isNotEmpty())
    }

    override fun mark(marker: Marker): MarkInfo = answers.map { it.mark(marker) }.max() as MarkInfo
}

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

    override fun mark(marker: Marker): MarkInfo = marker.mark(this)
}

data class AnswerChoice(val answer: String, val correct: Boolean)
