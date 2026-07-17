# Hashing / Frequency Counting

Stage berikutnya setelah Two Pointer, sesuai urutan Blind 75 / NeetCode 150
(Arrays & Hashing). Fondasi buat frequency counting — teknik yang sering
dipakai buat ngubah pendekatan `O(n^2)` jadi `O(n)` pakai `Map`/`HashMap`.

**Pengenalan konsep dulu (STEP 1):** `Map`/`HashMap`, kapan pakai
`MutableMap`. Kalau ada gap di `List`/`MutableList` juga dibereskan di sini
secukupnya — bukan drilling penuh dari nol.

## Rencana soal

Strategi: mulai Easy, begitu udah bisa ngerjain Medium dalam ~15 menit,
GESER fokus ke Medium (rasio Easy:Medium:Hard yang direkomendasiin riset
~3:6:1 — Medium yang paling penting buat interview beneran, Hard boleh
diskip mayoritas).

**Easy:**
- [ ] Contains Duplicate (#217)
- [ ] Valid Anagram (#242)
- [ ] Ransom Note (#383)
- [ ] Two Sum versi HashMap (#1) — bandingin ke pendekatan awal yang mungkin `O(n^2)`

**Medium (setelah Easy lancar):**
- [ ] Group Anagrams (#49)
- [ ] Top K Frequent Elements (#347)
- [ ] Product of Array Except Self (#238)
