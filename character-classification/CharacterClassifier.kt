/**
 * Character Classifier
 *
 * Hitung berapa huruf, angka, dan simbol dalam sebuah string.
 *
 * Insight: kategori "simbol" gak punya function bawaan khusus (beda sama
 * isLetter()/isDigit()) karena "simbol" bukan kategori universal yang jelas.
 * Pendekatan yang benar: EKSKLUSI — kalau bukan huruf DAN bukan angka,
 * otomatis masuk simbol (pakai else, bukan cek langsung).
 */
class CharacterClassifier {
    fun classify(text: String): Triple<Int, Int, Int> {
        var huruf = 0
        var angka = 0
        var simbol = 0

        for (ch in text) {
            when {
                ch.isLetter() -> huruf++
                ch.isDigit() -> angka++
                else -> simbol++
            }
        }
        return Triple(huruf, angka, simbol)
    }
}

fun main() {
    val solver = CharacterClassifier()
    val testCases = listOf("Hello123!", "abc DEF 456", "", "12345", "!!!@@@")
    for (t in testCases) {
        val (huruf, angka, simbol) = solver.classify(t)
        println("\"$t\" -> huruf=$huruf, angka=$angka, simbol=$simbol")
    }
}
