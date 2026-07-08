/**
 * Special Character Counter & Remove Digits
 *
 * Dua soal terkait, sama-sama nunjukin insight WHITELIST vs BLACKLIST.
 *
 * Insight penting (dari proses trial-error nyata):
 * - Whitelist ("boleh masuk kalau A ATAU B ATAU C...") gampang kelupaan
 *   1 kategori kalau syaratnya makin banyak.
 * - Blacklist ("masuk kalau BUKAN X") lebih aman & ringkas kalau yang
 *   dilarang cuma sedikit dan jelas.
 * - Percobaan pertama Remove Digits pakai isLetter() doang -> spasi & simbol
 *   ikut kebuang (whitelist, kurang lengkap). Fix final pakai !isDigit()
 *   (blacklist) -> 1 kondisi doang, semua kasus ke-handle.
 */
class SpecialCharacterOps {

    // Hitung simbol saja (huruf, angka, spasi TIDAK dihitung)
    fun countSpecial(text: String): Int {
        var total = 0
        for (char in text) {
            if (!char.isLetter() && !char.isDigit() && !char.isWhitespace()) {
                total++
            }
        }
        return total
    }

    // Hapus semua angka, sisanya (huruf, spasi, simbol) tetap ada
    // Pakai pendekatan BLACKLIST (!isDigit()), bukan whitelist
    fun removeDigits(text: String): String {
        var result = ""
        for (char in text) {
            if (!char.isDigit()) {
                result += char
            }
        }
        return result
    }
}

fun main() {
    val solver = SpecialCharacterOps()

    println("-- countSpecial --")
    val specialTests = listOf("Hello World! 123@#", "abc def", "", "!!!", "   ")
    for (t in specialTests) {
        println("\"$t\" -> ${solver.countSpecial(t)}")
    }

    println("-- removeDigits --")
    val removeTests = listOf("K4r33m", "Hello 123 World", "2026", "a1b2c3!@#")
    for (t in removeTests) {
        println("\"$t\" -> \"${solver.removeDigits(t)}\"")
    }
}
