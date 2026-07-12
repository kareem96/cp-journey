/**
 * Valid Palindrome II — LeetCode #680
 *
 * Diberikan string s (huruf kecil a-z). Return true kalau s bisa jadi
 * palindrome dengan menghapus paling banyak 1 karakter.
 *
 * Insight penting:
 * - "Menghapus karakter" gak beneran motong string — cukup GESER index
 *   (left/right) buat nge-skip 1 posisi yang dianggap gak dihitung.
 * - Pas ketemu mismatch pertama, ada 2 kemungkinan yang harus dicoba: skip
 *   karakter di posisi left, atau skip karakter di posisi right — gak bisa
 *   ditentuin dari awal yang mana yang bener, jadi dua-duanya dicoba.
 * - Dua pendekatan di bawah beda di trade-off: pake helper function (range
 *   sebagai parameter, gak ada duplikasi kode) vs inline (gak ada function
 *   tambahan, tapi logic compare-nya keulang 2x).
 */

// Versi 1: pake helper function (isPalindromeInRange) — gak ada duplikasi
fun validPalindromeWithHelper(s: String): Boolean {
    val char = s.toCharArray()
    var left = 0
    var right = char.size - 1

    while (left < right) {
        if (char[left] != char[right]) {
            return isPalindromeInRange(char, left + 1, right) ||
                isPalindromeInRange(char, left, right - 1)
        }
        left++
        right--
    }
    return true
}

fun isPalindromeInRange(s: CharArray, left: Int, right: Int): Boolean {
    var l = left
    var r = right
    while (l < r) {
        if (s[l] != s[r]) return false
        l++
        r--
    }
    return true
}

// Versi 2: tanpa function tambahan — logic compare-nya keulang 2x (duplikat)
fun validPalindromeInline(s: String): Boolean {
    val char = s.toCharArray()
    var left = 0
    var right = char.size - 1

    while (left < right) {
        if (char[left] != char[right]) {
            var l1 = left + 1
            var r1 = right
            var skipLeftOk = true
            while (l1 < r1) {
                if (char[l1] != char[r1]) {
                    skipLeftOk = false
                    break
                }
                l1++
                r1--
            }

            var l2 = left
            var r2 = right - 1
            var skipRightOk = true
            while (l2 < r2) {
                if (char[l2] != char[r2]) {
                    skipRightOk = false
                    break
                }
                l2++
                r2--
            }

            return skipLeftOk || skipRightOk
        }
        left++
        right--
    }
    return true
}

fun main() {
    val testCases = listOf("aba", "abca", "abc", "a")
    for (t in testCases) {
        println(
            "\"$t\" -> withHelper=${validPalindromeWithHelper(t)}, " +
                "inline=${validPalindromeInline(t)}"
        )
    }
}
