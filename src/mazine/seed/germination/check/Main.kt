package mazine.seed.germination.check

import java.lang.Math.abs
import java.lang.Math.sqrt


val PETRI_DISH_NUMBER = 3
val SEEDS_PER_PETRI_DISH_NUMBER = 30

val targetValues = listOf(
        Pair(12.22, 4.16),
        Pair(40.0, 4.71),
        Pair(30.0, 2.72),
        Pair(50.0, 5.44),
        Pair(70.0, 5.44),
        Pair(55.56, 10.3),
        Pair(17.78, 6.85)
)

fun main(args: Array<String>) {
    targetValues.forEach {
        val (targetMean, targetSD) = it
        // Iterate over all possible combinations of seed germinations
        for (germinatedSeeds in MulticombinationSequence(SEEDS_PER_PETRI_DISH_NUMBER, PETRI_DISH_NUMBER)) {
            // Turn numbers of germinated seeds into percents of germinated seeds
            val percentsOfGerminatedSeeds = germinatedSeeds.map { it * 100.0 / SEEDS_PER_PETRI_DISH_NUMBER }

            val mean = percentsOfGerminatedSeeds.mean()
            val correctSD = percentsOfGerminatedSeeds.correctStandardDeviation()
            val incorrectSD = percentsOfGerminatedSeeds.incorrectStandardDeviation()

            if (mean approxEqual targetMean && incorrectSD approxEqual targetSD) {
                println("${germinatedSeeds.map { it.toString() }.join(", ")}: Mean=${mean.format(2)} incorrect ±${incorrectSD.format(2)}, correct ±${correctSD.format(2)}")
            }
            if (mean approxEqual targetMean && correctSD approxEqual targetSD) {
                println("${germinatedSeeds.map { it.toString() }.join(", ")}: Mean=${mean.format(2)} incorrect ±${incorrectSD.format(2)}, correct ±${correctSD.format(2)}")
            }
        }
    }
}

fun List<Double>.mean() = sum() / count()

private fun List<Double>.sumOfSquares(): Double {
    val mean = mean()
    return map { x -> square(x - mean) }.sum()
}

fun List<Double>.correctStandardDeviation() = sqrt(sumOfSquares() / (count() - 1))

fun List<Double>.incorrectStandardDeviation() = sqrt(sumOfSquares() / (count()))

fun square(x: Double) = x * x

fun Double.approxEqual(that: Double) = abs(this - that) < 0.01

fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)