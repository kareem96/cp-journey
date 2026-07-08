/**
 * Palindrome Number — Pendekatan String
 *
 * Cek apakah sebuah angka sama kalau dibaca dari depan atau belakang.
 *
 * Insight: pendekatan String otomatis handle kasus negatif dengan benar,
 * TANPA perlu if tambahan. Kenapa? Karena tanda minus "-" ikut jadi bagian
 * dari string, dan saat direverse, posisinya berpindah ke belakang
 * (misal "-121" -> reverse -> "121-"), yang otomatis beda dari string aslinya.
 */
class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        val nums = x.toString()
        var reverse = ""
        for (i in nums.indices) {
            reverse = nums[i] + reverse
        }
        return reverse == nums
    }
}

fun main() {
    val solver = PalindromeNumber()
    val testCases = listOf(121, -121, 10, 0, 1, 12321, 123)
    for (t in testCases) {
        println("isPalindrome($t) = ${solver.isPalindrome(t)}")
    }
}
