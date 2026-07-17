/**
 * Number Pyramid — latihan mandiri (bukan dari LeetCode/HackerRank, eksplorasi
 * nested loop sendiri buat ngerti pola indentasi/spacing).
 *
 * Insight penting:
 * - Ada 2 hal yang jalan BERLAWANAN arah tiap baris (`i` nambah):
 *   - Padding/spasi kosong (`0..(10-i)`) → jumlahnya BERKURANG tiap baris
 *     (11, 10, 9, ..., 2), karena `10-i` makin kecil pas `i` makin gede
 *   - Angka (`0..i`) → jumlahnya BERTAMBAH tiap baris (1, 2, 3, ..., 10),
 *     karena range `0..i` makin panjang pas `i` makin gede
 * - Padding berfungsi sebagai "dorongan ke kanan" (indentasi) — makin
 *   sedikit padding-nya, makin ke KIRI posisi angka mulai dicetak. Bareng
 *   sama itu, jumlah angka makin banyak, jadi makin ke KANAN juga posisi
 *   angka berakhir. Kombinasi "mulai lebih ke kiri + berakhir lebih ke
 *   kanan" itu yang bikin tiap baris melebar diagonal — itulah bentuk
 *   piramidnya.
 * - Teknik debug: pakai karakter yang KELIATAN (`*`) buat gantiin spasi
 *   kosong sementara, biar jumlah padding per baris bisa diverifikasi
 *   visual dulu sebelum diganti jadi spasi (`" "`) yang gak keliatan tapi
 *   tetep makan tempat.
 */
fun main() {
    // Versi debug — pakai `*` biar keliatan jumlah padding-nya
    println("--- Versi pakai * (debug) ---")
    for (i in 0 until 10) {
        for (j in 0..(10 - i)) {
            print("*")
        }
        for (k in 0..i) {
            print("$k ")
        }
        println()
    }

    println()

    // Versi final — `*` diganti spasi kosong, jadi piramid angka
    println("--- Versi final (spasi kosong) ---")
    for (i in 0 until 10) {
        for (j in 0..(10 - i)) {
            print(" ")
        }
        for (k in 0..i) {
            print("$k ")
        }
        println()
    }
}
