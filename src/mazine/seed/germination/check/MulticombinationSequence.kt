package mazine.seed.germination.check

import java.util.NoSuchElementException

/**
 * Sequence of all possible k-multicombinations from set [0..n]
 */
public class MulticombinationSequence(val n: Int, val k: Int) : Sequence<IntArray> {
    init {
        assert(n > 0, "Parameter n should be positive integer")
        assert(k > 0, "Parameter k should be positive integer")
    }

    override fun iterator() = MulticombinationIterator()

    inner class MulticombinationIterator : Iterator<IntArray> {
        private val current = IntArray(k).fill(0)
        private var overflow = false

        override fun hasNext(): Boolean {
            return !overflow
        }

        override fun next(): IntArray {
            if (overflow) throw NoSuchElementException()
            val result = current.copyOf()
            incrementMulticombination(current.lastIndex, n)
            return result
        }

        private fun incrementMulticombination(index: Int, n: Int): Int = when {
            current[index] < n -> ++current[index]
            index > 0 -> {
                val prevIndex = incrementMulticombination(index - 1, n)
                current[index] = prevIndex
                current[index]
            }
            else -> {
                overflow = true
                n
            }
        }
    }


}