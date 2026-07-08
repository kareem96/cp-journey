# CP Journey

Repo latihan Competitive Programming — Kotlin. Dibangun buat persiapan test kerja
di Meratus, lanjut jadi habit belajar CP jangka panjang.

## Struktur

```
CLAUDE.md               <- konteks & aturan main buat AI assistant (baca ini duluan
                            kalau buka repo ini pakai Claude Code / AI lain)
progress-log.md          <- catatan progress & insight tiap sesi belajar
string-manipulation/      <- reverse string, palindrome, two-pointer
number-manipulation/      <- reverse integer, sum of digits
character-classification/ <- klasifikasi karakter, special character handling
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
