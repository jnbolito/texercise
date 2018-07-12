package io.bolito.texercise.domain.quiz

enum class Correctness {
    INCORRECT,
    PARTIAL,
    CORRECT
}

sealed class MarkInfo(val available: Boolean) : Comparable<MarkInfo>

object NoMarkInfo : MarkInfo(false) {
    override fun compareTo(other: MarkInfo): Int = if (other.available) -1 else 0
}

data class AvailableMarkInfo(val marks: Int, val correctness: Correctness) : MarkInfo(true) {
    override fun compareTo(other: MarkInfo): Int = when (other) {
        is NoMarkInfo -> 1
        is AvailableMarkInfo -> Integer.compare(marks, other.marks)
    }
}

interface Marker {
    fun mark(answer: SimpleAnswer): MarkInfo = throw IllegalStateException()
    fun mark(answer: MultipleChoiceAnswer): MarkInfo = throw IllegalStateException()
    fun mark(answer: TrueFalseAnswer): MarkInfo = throw IllegalStateException()
}