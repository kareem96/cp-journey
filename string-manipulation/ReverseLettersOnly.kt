/**
 * Reverse Letters Only — Two Pointer + Skip
 *
 * Balik urutan HURUF saja dalam sebuah string, simbol/angka tetap di posisi asal.
 * Ini soal yang keluar di live coding test kerja.
 *
 * Contoh: "ab-cd" -> "dc-ba" (huruf a,b,c,d dibalik, "-" tetap di posisi ke-3)
 * Contoh: "ad()j!" -> "jd()a!" (cuma 'a' dan 'j' yang huruf & bisa ditukar,
 *                                sisanya di-skip karena bukan huruf)
 *
 * Insight penting:
 * - Tukar isi itu LANGSUNG (loncat), bukan geser bertahap
 * - Urutan wajib: tukar isi DULU, baru geser pointer (left++, right--)
 * - Kalau salah satu sisi bukan huruf -> skip (geser pointer itu doang,
 *   TANPA tukar)
 */
class ReverseLettersOnly {
    fun reverseLetters(text: String): String {
        val chars = text.toCharArray()
        var left = 0
        var right = chars.size - 1

        while (left < right) {
            if (!chars[left].isLetter()) {
                left++
            } else if (!chars[right].isLetter()) {
                right--
            } else {
                val temp = chars[left]
                chars[left] = chars[right]
                chars[right] = temp
                left++
                right--
            }
        }
        return String(chars)
    }
}

fun main() {
    val solver = ReverseLettersOnly()
    val testCases = listOf("ab-cd", "a1b2c", "Test123", "ad()j!", "abc", "a")
    for (t in testCases) {
        println("\"$t\" -> \"${solver.reverseLetters(t)}\"")
    }
}
