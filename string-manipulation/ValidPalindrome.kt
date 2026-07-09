/**
 * Valid Palindrome — Two Pointer + Compare
 *
 * Cek apakah sebuah string adalah palindrome, dengan aturan: hanya huruf &
 * angka (alphanumeric) yang diperhitungkan, spasi/simbol diabaikan, dan
 * case-insensitive.
 *
 * Contoh: "A man, a plan, a canal: Panama" -> true
 * Contoh: "race a car" -> false
 * Contoh: " " -> true (string kosong setelah filter dianggap palindrome)
 *
 * Insight penting:
 * - Beda dari Reverse Letters Only: di sini operasinya COMPARE, bukan SWAP.
 *   Swap cuma perlu kalau tujuannya rearrange data; di sini tujuannya cuma
 *   jawab Boolean, jadi cukup bandingin tiap pasangan (left, right)
 * - Kalau ketemu pasangan yang beda -> return false langsung (early exit)
 * - Kalau loop selesai NORMAL (gak pernah return false) -> itu sendiri udah
 *   bukti semua pasangan cocok -> return true, gak perlu bukti tambahan
 *   (gak perlu bikin/reverse string apa pun di akhir)
 */
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val chars = s.toCharArray()
        var left = 0
        var right = chars.size - 1

        while (left < right) {
            if (!chars[left].isLetterOrDigit()) {
                left++
            } else if (!chars[right].isLetterOrDigit()) {
                right--
            } else if (chars[left].lowercase() == chars[right].lowercase()) {
                left++
                right--
            } else {
                return false
            }
        }
        return true
    }
}

fun main() {
    val solver = ValidPalindrome()
    val testCases = listOf(
        "A man, a plan, a canal: Panama",
        "race a car",
        " ",
        "ab",
        "0P"
    )
    for (t in testCases) {
        println("\"$t\" -> ${solver.isPalindrome(t)}")
    }
}
