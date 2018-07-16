package io.bolito.texercise.domain.quiz

import java.util.*

data class QuizInstance(val uuid: UUID = UUID.randomUUID(), val quizElements: List<QuizElement>)