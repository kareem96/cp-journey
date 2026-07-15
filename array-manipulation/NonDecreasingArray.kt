/**
 * Non-decreasing Array — LeetCode #665
 *
 * Diberikan array integer nums. Tentukan apakah array ini bisa jadi
 * non-decreasing dengan mengubah paling banyak 1 elemen (ubah nilainya
 * jadi apa aja, bukan hapus).
 *
 * Insight penting:
 * - Ini BUKAN Two Pointer dari 2 ujung — single pass, jalan 1x dari depan
 *   ke belakang, bandingin nums[i] ke nums[i+1] doang.
 * - "Hitung jumlah pelanggaran" doang gak cukup buat mutusin fixable atau
 *   enggak — itu tergantung NILAI di sekitar titik pelanggaran, bukan cuma
 *   JUMLAH pelanggarannya. Contoh: [3,4,2,3] cuma punya 1 pelanggaran tapi
 *   tetep false, karena gak ada cara benerin tanpa bikin pelanggaran baru.
 * - Pas ketemu pelanggaran nums[i] > nums[i+1], ada 2 opsi:
 *   - canLowerLeft: aman turunin nums[i] kalau i==0 (gak ada elemen
 *     sebelumnya) ATAU nums[i-1] <= nums[i+1] (elemen sebelum masih valid
 *     dibanding nilai baru)
 *   - canRaiseRight: aman naikin nums[i+1] kalau itu elemen terakhir ATAU
 *     nums[i] <= nums[i+2] (elemen sesudah masih valid dibanding nilai baru)
 *   Kalau dua-duanya gak aman, gak bisa dibenerin dengan 1x edit -> false.
 */
fun checkPossibility(nums: IntArray): Boolean {
    var fouls = 0

    for (i in 0 until nums.size - 1) {
        if (nums[i] > nums[i + 1]) {
            fouls++
            if (fouls > 1) return false

            val canLowerLeft = i == 0 || nums[i - 1] <= nums[i + 1]
            val canRaiseRight = i + 2 == nums.size || nums[i] <= nums[i + 2]

            if (!canLowerLeft && !canRaiseRight) return false

            if (canLowerLeft) {
                nums[i] = nums[i + 1]
            } else {
                nums[i + 1] = nums[i]
            }
        }
    }

    return true
}

fun runTest(nums: IntArray, expected: Boolean) {
    val original = nums.copyOf()
    val result = checkPossibility(nums)
    val status = if (result == expected) "PASS" else "FAIL"
    println(status + " input=" + original.toList().toString() + " expected=" + expected + " got=" + result)
}

fun main() {
    runTest(intArrayOf(4, 2, 3), true)
    runTest(intArrayOf(4, 2, 1), false)
    runTest(intArrayOf(3, 4, 2, 3), false)
    runTest(intArrayOf(5), true)
    runTest(intArrayOf(1, 3, 2, 5), true)
    runTest(intArrayOf(3, 3, 3), true)
}
