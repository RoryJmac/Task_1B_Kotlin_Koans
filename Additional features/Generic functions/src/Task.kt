import java.util.*

fun <T, C : MutableCollection<T>> partitionTo(
    source: Collection<T>,
    first: C,
    second: C,
    predicate: (T) -> Boolean
): Pair<C, C> {
    for (element in source) {
        if (predicate(element)) {
            first.add(element)
        } else {
            second.add(element)
        }
    }
    return Pair(first, second)
}

fun partitionWordsAndLines() {
    val (words, lines) = partitionTo(listOf("a", "a b", "c", "d e"), ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = partitionTo(
        setOf('a', '%', 'r', '}'),
        HashSet(),
        HashSet()
    ) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
