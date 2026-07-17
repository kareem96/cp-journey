# CP Journey

Repo latihan Competitive Programming — Kotlin. Dibangun untuk membentuk habit
belajar CP jangka panjang, dari fondasi dasar (string/number manipulation,
character handling) menuju pattern yang lebih kompleks.

## Struktur

```
CLAUDE.md               <- konteks & aturan main buat AI assistant (baca ini duluan
                            kalau buka repo ini pakai Claude Code / AI lain)
progress-log.md          <- catatan progress & insight tiap sesi belajar
string-manipulation/      <- reverse string, palindrome, two-pointer
number-manipulation/      <- reverse integer, sum of digits
character-classification/ <- klasifikasi karakter, special character handling
array-manipulation/       <- single-pass array check, modifikasi in-place
pattern-printing/         <- nested loop, pola indentasi/spacing (piramid dst)
hashing-map/              <- (rencana) Map/HashMap, frequency counting
sliding-window/           <- (rencana) sliding window, lanjutan Two Pointer
stack-queue/              <- (rencana) Stack (Valid Parentheses dst)
binary-search/            <- (rencana) Binary Search
```

## Cara pakai

Tiap file `.kt` bisa langsung di-compile & run:

```bash
kotlinc NamaFile.kt -include-runtime -d output.jar
java -jar output.jar
```

Atau paste ke [Kotlin Playground](https://play.kotlinlang.org) buat coba cepat.

## Progress

Lihat `progress-log.md` untuk rangkuman lengkap tiap sesi, insight, dan
kegagalan yang jadi pelajaran. Checklist pattern yang sedang/sudah dikuasai
ada di `CLAUDE.md`.
