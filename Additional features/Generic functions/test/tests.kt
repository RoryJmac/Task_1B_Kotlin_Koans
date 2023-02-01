import koans.util.errorMessage
import org.junit.Assert
import org.junit.Test
import java.util.*

class TestGenericFunctions {
    @Test(timeout = 1000)
    fun testPartitionWordsAndLines() {
        partitionWordsAndLines()

        val (words, lines) = partitionTo(
            listOf("a", "a b", "c", "d e"),
            ArrayList(),
            ArrayList()
        ) { s -> !s.contains(" ") }
        Assert.assertEquals(errorMessage("partitionTo"), listOf("a", "c"), words)
        Assert.assertEquals(errorMessage("partitionTo"), listOf("a b", "d e"), lines)
    }

    @Test(timeout = 1000)
    fun testPartitionLettersAndOtherSymbols() {
        partitionLettersAndOtherSymbols()

        val (letters, other) = partitionTo(
            setOf('a', '%', 'r', '}'),
            HashSet(),
            HashSet()
        ) { c -> c in 'a'..'z' || c in 'A'..'Z' }
        Assert.assertEquals(errorMessage("partitionTo"), setOf('a', 'r'), letters)
        Assert.assertEquals(errorMessage("partitionTo"), setOf('%', '}'), other)
    }
}