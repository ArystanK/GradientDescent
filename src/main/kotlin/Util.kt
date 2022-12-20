import kotlin.math.pow
import kotlin.math.sqrt

operator fun Double.times(array: DoubleArray): DoubleArray = DoubleArray(array.size) { array[it] * this }

operator fun DoubleArray.minus(array: DoubleArray): DoubleArray = DoubleArray(array.size) { this[it] - array[it] }

fun distance(array1: DoubleArray, array2: DoubleArray): Double {
    var squareSum = 0.0
    for (i in array1.indices) squareSum += (array1[i] - array2[i]).pow(2)
    return sqrt(squareSum)
}
