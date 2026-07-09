/**
 * Reverse String — Manual (Two Pointer)
 *
 * Balik urutan karakter dalam sebuah string, tanpa fungsi bawaan .reversed()
 *
 * Konsep: dua pointer dari ujung berlawanan (left, right), tukar isinya,
 * geser saling mendekat sampai ketemu di tengah.
 */
class ReverseString {
    fun reverseManual(s: String): String {
        val chars = s.toCharArray()
        var left = 0
        var right = chars.size - 1
        while (left < right) {
            val temp = chars[left]
            chars[left] = chars[right]
            chars[right] = temp
            left++
            right--
        }
        return String(chars)
    }
}

fun main() {
    val solver = ReverseString()
    val testCases = listOf("Algorithm", "Kotlin", "a", "", "ab")
    for (t in testCases) {
        println("\"$t\" -> \"${solver.reverseManual(t)}\"")
    }
}
