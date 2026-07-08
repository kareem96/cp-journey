/**
 * Reverse Integer — dengan Overflow Handling
 *
 * Balik urutan digit sebuah angka. Kalau hasilnya kelewat batas 32-bit
 * signed integer [-2^31, 2^31 - 1], return 0.
 *
 * Insight penting:
 * - Urutan wajib per iterasi: (1) number % 10 ambil digit, (2) proses digit
 *   itu, (3) BARU number /= 10 buang digit. Kalau dibalik, digit yang mau
 *   diambil keburu hilang.
 * - Overflow check harus SEBELUM perkalian *10 terjadi, bukan sesudahnya,
 *   karena kerusakan data sudah terjadi duluan kalau dicek belakangan.
 * - Angka 7 dan -8 di kondisi overflow itu diambil dari digit terakhir
 *   Int.MAX_VALUE (2147483647) dan Int.MIN_VALUE (-2147483648).
 */
class ReverseInteger {

    // Versi manual — murni Int, sesuai constraint asli soal LeetCode #7
    // ("assume environment does not allow 64-bit integers")
    fun reverseManual(x: Int): Int {
        var reversed = 0
        var number = x
        while (number != 0) {
            val lastDigit = number % 10

            if (reversed > Int.MAX_VALUE / 10 ||
                (reversed == Int.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0
            }
            if (reversed < Int.MIN_VALUE / 10 ||
                (reversed == Int.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0
            }

            reversed = (reversed * 10) + lastDigit
            number /= 10
        }
        return reversed
    }

    // Versi pakai Long — lebih gampang dipahami konsepnya (proses bebas dulu
    // pakai wadah besar, cek muat-tidaknya di akhir), tapi teknisnya melanggar
    // constraint asli soal (gak boleh pakai 64-bit integer)
    fun reverseUsingLong(x: Int): Int {
        var reversed: Long = 0
        var number = x
        while (number != 0) {
            val lastDigit = number % 10
            reversed = (reversed * 10) + lastDigit
            number /= 10
        }
        if (reversed > Int.MAX_VALUE || reversed < Int.MIN_VALUE) {
            return 0
        }
        return reversed.toInt()
    }
}

fun main() {
    val solver = ReverseInteger()
    val testCases = listOf(123, -123, 120, 0, 1534236469, -2147483648)
    for (t in testCases) {
        println("x=$t -> manual=${solver.reverseManual(t)}, long=${solver.reverseUsingLong(t)}")
    }
}
