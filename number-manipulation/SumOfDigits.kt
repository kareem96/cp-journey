/**
 * Sum of Digits
 *
 * Hitung jumlah semua digit dari sebuah angka.
 *
 * Insight: variasi dari pola "reverse integer" — bedanya cuma di apa yang
 * dilakukan ke lastDigit. Reverse butuh placeValue (posisi) karena mau
 * SUSUN ULANG jadi angka baru. Sum of digits gak peduli posisi/urutan,
 * cukup DIJUMLAHIN aja (total += lastDigit).
 */
class SumOfDigits {
    fun sumOfDigits(x: Int): Int {
        var number = x
        var total = 0
        while (number != 0) {
            val lastDigit = number % 10
            total += lastDigit
            number /= 10
        }
        return total
    }
}

fun main() {
    val solver = SumOfDigits()
    val testCases = listOf(123, 9999, 5, 0, 100, 45678)
    for (t in testCases) {
        println("sumOfDigits($t) = ${solver.sumOfDigits(t)}")
    }
}
