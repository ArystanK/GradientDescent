import kotlin.math.pow
import kotlin.random.Random

fun main() {
    // z = x^2 + y^2 + 2x + 1
    val function: (DoubleArray) -> Double = { it[0].pow(2) + it[1].pow(2) + 2 * it[0] + 1 }
    // gradient = (2x + 2, 2y)
    val gradient: (DoubleArray) -> DoubleArray = { doubleArrayOf(2 * it[0] + 2, 2 * it[1]) }
    println(
        gradientDescent(
            dimension = 2,
            learningRate = 0.3,
            epsilon = 0.0001,
            gradient = gradient
        ).contentToString()
    )
}

fun gradientDescent(
    dimension: Int,
    learningRate: Double,
    epsilon: Double,
    domain: IntRange = -100..100,
    startX: DoubleArray = DoubleArray(dimension) {
        Random.nextDouble(
            domain.first.toDouble(),
            domain.last.toDouble()
        )
    },
    gradient: (DoubleArray) -> DoubleArray,
): DoubleArray {
    var x = startX
    while (true) {
        val change = gradientDescentOptimizer(learningRate, gradient(x))
        if (distance(x, x - change) < epsilon) break
        x -= change
    }
    return x
}

fun gradientDescentOptimizer(learningRate: Double, gradient: DoubleArray) = learningRate * gradient

fun gradientDescentWithMomentumOptimizer(
    learningRate: Double,
    gradient: DoubleArray,
    momentum: Double,
    prevChange: DoubleArray,
): DoubleArray = learningRate * gradient + momentum * prevChange



