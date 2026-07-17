# Progress Log

Catatan progress dan insight penting dari tiap sesi latihan. Diisi tiap kali
selesai sesi belajar — bukan cuma "hari ini ngerjain apa", tapi juga
**kenapa gagal** (kalau gagal) dan **insight** yang didapat.

---

## Sesi 1 — Kickoff: Reverse String & Reverse Integer

**Konteks:** Persiapan test kerja basic (1 minggu), format compiler online.
Kisi-kisi: reverse string, handling character/number/special character.

**Yang dipelajari:**
- Reverse string manual (two-pointer) vs otomatis (`.reversed()`)
- Reverse integer + integer overflow handling
- Perbedaan `while` vs `for`: `for` cocok kalau jumlah iterasi diketahui di awal,
  `while` cocok kalau kondisi berhenti bergantung ke state yang berubah

**Insight penting:**
- Urutan `number % 10` (ambil digit) HARUS sebelum `number /= 10` (buang digit) —
  kalau dibalik, digit yang mau diambil keburu hilang
- Integer overflow itu bukan "acak" — hasilnya adalah `nilai mod 2^32`, lalu
  disesuaikan ke rentang signed 32-bit. Deterministik, bisa dihitung manual.
- Overflow check harus dilakukan SEBELUM operasi perkalian yang berpotensi
  overflow, bukan sesudahnya (karena kerusakan data sudah terjadi duluan)
- `Int.MAX_VALUE` = 2147483647, `Int.MIN_VALUE` = -2147483648 — angka `7` dan
  `-8` di overflow check itu diambil dari digit terakhir dua angka itu, bukan
  angka sembarangan
- Pendekatan `Long` (proses pakai tipe besar, cek & convert di akhir) lebih mudah
  dipahami konsepnya dibanding pendekatan `Int` manual (cek tiap iterasi,
  butuh tau kasus "pas mepet batas")

**Kegagalan & pelajaran:**
- Awalnya bingung `Run` vs `Submit` di LeetCode punya cakupan testcase beda
  (`Run` cuma sample kecil, `Submit` ke semua hidden testcase) — makanya kode
  yang belum ada overflow check sempat terlihat "Accepted" padahal belum lengkap

---

## Sesi 2 — Palindrome, Sum of Digits, Character Classification

**Yang dipelajari (dikerjakan mandiri, benar di percobaan pertama untuk beberapa soal):**
- Palindrome Number — pendekatan String (convert ke reverse, compare)
  otomatis handle kasus negatif tanpa perlu if tambahan (karena tanda minus
  ikut "pindah posisi" saat reverse string)
- Sum of Digits — variasi dari pola reverse, bedanya cuma `total += lastDigit`
  (tanpa perlu placeValue karena urutan gak penting)
- Character Classifier (huruf/angka/simbol) — pakai `isLetter()`, `isDigit()`,
  kategori simbol pakai pendekatan eksklusi (`else`)
- Special Character Counter (exclude spasi) — insight penting soal
  whitelist vs blacklist (lihat di bawah)

**Insight penting:**
- Perbedaan `.length` (Int, jumlah karakter) vs `.indices` (Range, siap pakai
  di for) — `.indices` itu shortcut dari `0 until .length`
- Konsep ASCII: huruf besar 65-90, huruf kecil 97-122, angka 48-57 — ini
  angka historis/konvensi dari standar ASCII 1963, bukan sesuatu yang
  "dihitung", harus tau/hafal posisinya
- **Whitelist vs blacklist**: kalau syarat "boleh masuk" makin banyak
  (huruf ATAU spasi ATAU simbol ATAU...), pendekatan whitelist gampang
  kelupaan 1 kategori. Blacklist ("kalau BUKAN angka") lebih aman kalau
  yang dilarang cuma sedikit dan jelas

**Kegagalan & pelajaran:**
- Percobaan pertama Remove Digits pakai `isLetter()` doang -> spasi ikut
  kebuang (padahal cuma angka yang harus dibuang). Fix pertama nambah
  `|| isWhitespace()` -> masih ada lubang (simbol ikut kebuang). Fix final
  ganti ke `!isDigit()` (blacklist) -> semua kasus ke-handle dengan 1 kondisi

---

## Sesi 3 — Two Pointer: Reverse Letters Only

**Yang dipelajari:**
- Teknik Two Pointer: `left` dan `right` bergerak dari dua ujung, saling
  mendekat, dengan 3 cabang kondisi (skip kiri / skip kanan / tukar)
- `String` itu immutable di Kotlin — butuh `toCharArray()` buat bisa
  ditukar isinya per index, lalu `String(chars)` buat convert balik

**Insight penting:**
- Tukar isi (`chars[left] <-> chars[right]`) itu LANGSUNG/loncat, bukan
  geser bertahap satu-satu — beda konsep sama geser penunjuk (`left++`,
  `right--`) yang memang bertahap
- Urutan WAJIB: tukar isi dulu (3 baris pakai `temp`) baru geser penunjuk
  (2 baris) — kalau dibalik, tukar terjadi di posisi yang salah
- Urutan `temp = chars[left]` vs `temp = chars[right]` itu BEBAS (gak
  matter mulai dari mana), begitu juga urutan `left++` vs `right--` — karena
  operasi-operasi itu independen satu sama lain
- SEMUA cabang kondisi (skip kiri, skip kanan, tukar) wajib menggerakkan
  penunjuk — kalau ada 1 cabang yang lupa, infinite loop (kejadian nyata
  saat awal nulis kode ini)

**Kegagalan & pelajaran:**
- Awal salah kira teknik ini "Two Sum" — diluruskan: Two Pointer itu
  TEKNIK/pola umum, Two Sum itu NAMA SOAL spesifik (beda hal)
- Sempat infinite loop karena cabang `else` (tukar) lupa nambahin
  `left++`/`right--` setelah proses tukar

---

## Sesi 4 — Reverse Letters Only (Terapan Mandiri)

**Yang dipelajari:**
- Nerapin pattern Two Pointer + character check secara mandiri tanpa tuntunan,
  selesai ~20 menit untuk 2 test case

**Insight penting:**
- Sempat ragu pakai `.reversed()` (bawaan) vs manual — akhirnya pilih pendekatan
  manual dengan two-pointer + `isLetter()` check, karena soal punya syarat
  khusus (simbol harus diam di posisi asal) yang gak bisa dipenuhi kalau pakai
  reverse biasa (baik versi bawaan bahasa maupun manual tanpa pengecekan)

---

## Sesi 5 — Two Pointer Variasi 2: Valid Palindrome (Compare, bukan Swap)

**Yang dipelajari:**
- Variasi Two Pointer dengan signature beda: return `Boolean` (bukan `String`),
  dan operasi di dalam loop-nya `compare` (bukan `swap`)
- Percobaan pertama gak pakai Two Pointer sama sekali — bikin 2 string
  (`textOri` pakai `+=`, `reverse` pakai prepend `= char + reverse`), baru
  dikonversi ke Two Pointer setelah dibahas

**Insight penting:**
- Swap itu cuma perlu kalau tujuannya REARRANGE/susun ulang data (kayak Reverse
  Letters Only). Kalau tujuannya cuma jawab Boolean (ada gak perlu ubah
  susunan), swap gak ngapa-ngapain — yang dibutuhin cuma compare tiap pasangan
  `(left, right)`, kalau beda langsung `return false` (early exit)
- Kalau loop Two Pointer selesai NORMAL (gak pernah ke-trigger `return false`),
  itu SENDIRI udah jadi bukti semua pasangan cocok -> tinggal `return true`,
  gak perlu bukti tambahan (bikin/reverse string lagi di akhir itu langkah sia-sia)
- Penjelasan/contoh di soal (misal "kalau difilter jadi X, X itu palindrome")
  itu buat bantu paham KENAPA jawabannya true/false — bukan instruksi bahwa
  kode WAJIB literally bikin string X itu. Ada banyak teknik buat sampe ke
  jawaban yang sama
- `textOri += char` (append, urutan asli ke-preserve) vs `reverse = char +
  reverse` (prepend, urutan kebalik) — beda krusial ini yang bikin percobaan
  pertama ketauan bug-nya

**Kegagalan & pelajaran:**
- Percobaan pertama: `textOri` awalnya JUGA pakai prepend (sama kayak
  `reverse`) -> keduanya jadi identik -> hasil SELALU `true` apapun input-nya
  (bug: gak pernah beneran ngecek apa-apa). Ketauan lewat trace manual pakai
  input `"ab"`
- Konversi ke Two Pointer sempat salah copy logic SWAP dari Reverse Letters
  Only, padahal soal ini butuhnya COMPARE. Diluruskan: swap = rearrange,
  compare = cek kondisi, dua tujuan yang beda
- Verifikasi pakai `kotlinc` beneran (bukan cuma trace) untuk 4 test case
  (`"ab"`, `"A man, a plan, a canal: Panama"`, `"race a car"`, `" "`) — semua lolos

---

## Sesi 6 — Two Pointer Variasi 3: Count Different Pairs After Reverse (Int)

**Konteks:** Variasi ke-3 dari dimensi "return type berbeda" yang disebut di
`CLAUDE.md` — progresi String (reverse) -> Boolean (palindrome check) -> Int
(hitung berapa index yang beda setelah reverse).

**Yang dipelajari:**
- Two Pointer dengan operasi COUNT (bukan swap, bukan compare-early-exit) —
  loop jalan terus sampai selesai sambil numpuk hitungan, gak early exit pas
  ketemu beda

**Insight penting:**
- Satu kali pertemuan pointer (`left`, `right`) itu mewakili **2 POSISI INDEX
  sekaligus** — posisi `left` DAN posisi `right` — karena `reverse[left] ==
  original[right]` dan `reverse[right] == original[left]`. Makanya
  `count += 2` per mismatch itu BUKAN hack buat maksain angka, tapi
  representasi akurat dari "berapa banyak index yang beda dari reverse-nya"
- Operator `!=` (dan `==`) itu **simetris**: `A != B` selalu punya nilai sama
  dengan `B != A`. Ngecek kondisi yang sama dari 2 arah (`char[left] !=
  char[right]` DAN `char[right] != char[left]`) gak pernah ngasih informasi
  baru — kalau ketemu pola kayak gini, itu tanda ada kondisi tautological
  (selalu true) yang bisa disederhanain
- Kode yang identik di kedua cabang `if`/`else` (di sini: `left++; right--`)
  bisa ditarik keluar, dijalanin sekali di akhir loop tanpa perlu duplikat

**Kegagalan & pelajaran:**
- Percobaan pertama nge-carry filter `!isLetter()` dari soal sebelumnya
  (Reverse Letters Only / Valid Palindrome) padahal soal baru ini gak pernah
  minta filter itu — assumption lama kebawa tanpa dicek ulang apa masih
  relevan ke soal baru
- Percobaan pertama pakai `else return 0` pas ketemu pasangan yang SAMA —
  ini bug fatal karena motong loop di tengah jalan (harusnya cuma skip/gerak
  pointer, bukan return), ketauan lewat trace manual input `"abxa"`
  (mismatch ada di pasangan tengah, tapi pasangan luar sempat "sama" duluan)
- Sempat bingung cukup lama kenapa `count += 2` itu benar, bukan cheat —
  butuh beberapa kali penjelasan pakai trace index-mapping (`reverse[i] ==
  original[n-1-i]`) sebelum beneran klik

---

## Sesi 7 — Two Pointer Variasi 4: Valid Palindrome II (Branching)

**Konteks:** LeetCode #680. Variasi baru dari dimensi teknik (bukan return
type) — pas ketemu mismatch, gak langsung nyerah (early exit false), tapi
harus nyoba 2 kemungkinan dulu (skip kiri / skip kanan) sebelum mutusin.

**Yang dipelajari:**
- Teknik "branching on mismatch": ketemu 2 karakter beda -> coba anggap
  salah satu (kiri ATAU kanan) gak dihitung -> cek sisanya masih palindrome
  atau enggak -> kalau salah satu aja iya, jawabannya true
- Konsep "range": function yang nerima `left`/`right` sebagai PARAMETER
  (bukan hardcode `0`/`size-1`) biar bisa ngecek SEBAGIAN string, bukan
  cuma seluruhnya
- 2 pendekatan dicoba & dibandingin: pake helper function
  `isPalindromeInRange` (gak ada duplikasi kode) vs inline tanpa function
  tambahan (logic compare keulang 2x, tapi valid & lebih gampang dipahami
  di awal)
- Soal LeetCode/HackerRank cuma nuntut 1 function resmi jadi hasil akhir,
  TAPI bebas bikin helper function/variable tambahan sendiri buat bantu

**Kegagalan & pelajaran:**
- Percobaan pertama cuma niru `ValidPalindrome` lama (compare, langsung
  `return false` pas mismatch) — gagal di test case `"abca"` (harusnya
  `true`), karena belum ada logic "coba skip 1 karakter" sama sekali
- Konsep "range" (window `[left, right]` yang lagi aktif dibandingin,
  BUKAN seluruh string) sempat butuh dijelasin berkali-kali pake trace
  visual index sebelum klik
- Proses sesi ini banyak gesekan komunikasi — istilah "dibuang" yang
  dipake buat jelasin konsep bikin dikira manggil function `.drop()`
  beneran, function tambahan (`isPalindromeInRange`) muncul di tengah
  tanpa disebut dari awal soal dikasih. Semua ini udah di-capture jadi
  rule permanen baru di `CLAUDE.md` (format soal, catatan implementasi,
  istilah ambigu, boleh bikin function tambahan) biar sesi berikutnya
  lebih jelas dari awal

---

## Sesi 8 — LeetCode #665 Non-decreasing Array (Single Pass, bukan Two Pointer)

**Konteks:** Lanjutan soal yang digantung dari sesi sebelumnya. Teknik baru:
single pass 1 arah, keputusan fix di titik pelanggaran butuh liat elemen
sebelum DAN sesudah — beda total dari semua variasi Two Pointer yang udah
dilatih di Sesi 3-7.

**Yang dipelajari:**
- Single pass array check: loop 1x dari depan, bandingin `nums[i]` ke
  `nums[i+1]` doang (bukan ke semua elemen di belakang kayak percobaan
  awal yang pakai nested loop)
- Keputusan "bisa dibenerin atau enggak" pas ketemu pelanggaran butuh 2
  opsi: `canLowerLeft` (turunin elemen kiri, cek `nums[i-1]`) atau
  `canRaiseRight` (naikin elemen kanan, cek `nums[i+2]`) — kalau dua-duanya
  gak aman, `return false` langsung

**Insight penting:**
- **"Punya pelanggaran" (definisi non-decreasing, dicek APA ADANYA) beda
  sama "gak bisa dibenerin" (jawaban `checkPossibility`)** — dua hal yang
  gampang ketuker. Definisi non-decreasing itu statis, gak melibatkan izin
  edit sama sekali; `checkPossibility` baru nanya "kalau boleh edit 1x,
  bisa dibenerin gak"
- **Jumlah pelanggaran doang gak cukup buat mutusin fixable/enggak** — itu
  tergantung NILAI di sekitar titik pelanggaran. Contoh: `[3,4,2,3]` cuma
  punya 1 pelanggaran (`4>2`) tapi tetep `false`, karena baik turunin `4`
  maupun naikin `2` sama-sama bikin pelanggaran baru di sisi lain
  (`nums[0]=3 > 2` kalau turunin, `4 > nums[3]=3` kalau naikin)
- `i+2` di `canRaiseRight` bukan angka ajaib — itu `(i+1)+1`, index tepat
  setelah elemen kanan pelanggaran (`nums[i+1]`). Sama pola-nya kayak
  `i-1` di `canLowerLeft` (index tepat sebelum `nums[i]`)

**Kegagalan & pelajaran:**
- Percobaan pertama pakai nested loop (`j` dari `i+1` sampai akhir,
  bandingin `nums[i]` ke SEMUA `nums[j]`) — beda dari definisi
  non-decreasing yang disepakati (cuma bandingin ke elemen TEPAT
  setelahnya). Selain gak sesuai definisi, pendekatan ini juga salah itung
  jumlah "fouls" (1 elemen buruk bisa nyumbang banyak pelanggaran palsu ke
  banyak `j` sekaligus)
- Percobaan kedua ngitung `fouls` doang dari pasangan adjacent, `return
  false` kalau `fouls == 2` — gagal di `[3,4,2,3]` (cuma 1 fouls tapi
  harusnya `false`), karena gak ngecek APAKAH pelanggaran itu beneran bisa
  dibenerin, cuma ngitung ada berapa
- Sempat ke-trigger `ArrayIndexOutOfBoundsException` karena loop bound
  `for(i in 0 until nums.size)` masih ngakses `nums[i+1]` sampai index
  terakhir — dibenerin jadi `0 until nums.size - 1`
- `kotlinc` bawaan Android Studio di device ini butuh classpath eksplisit
  ke `kotlin-stdlib.jar` (auto-detect kepental, error `unresolved
  reference 'println'` dkk padahal bukan bug kode) — solusinya tambahin
  `-cp <path>/kotlinc/lib/kotlin-stdlib.jar` pas compile

---

## Sesi 9 — Bedah `for` Loop (Review Sesi 8) + Number Pyramid (Mandiri)

**Konteks:** Bukan soal baru — review mendalam ke solusi `checkPossibility`
(Sesi 8) buat ngerti detail mekanisme `for` loop-nya, dilanjut eksplorasi
mandiri bikin pola piramid angka pakai nested loop.

**Yang dipelajari:**
- Bedah kenapa `for (i in 0 until nums.size - 1)` pakai `-1`, sampai ke
  akar konsepnya (bukan cuma hafalan)
- `nums.withIndex()` dan `for (i in nums)` sebagai bentuk loop OTOMATIS
  (lawan dari manual `for (i in 0 until nums.size)`)
- Nested loop buat cetak pola (piramid angka) — eksplorasi mandiri, bukan
  dari LeetCode/HackerRank

**Insight penting:**
- **`i` di dalam `for` itu CUMA angka biasa — "index" bukan konsep bawaan
  Kotlin, itu cuma PERAN yang KITA kasih kalau angka itu dipake buat
  akses `nums[i]`.** Loop `0..nums.size` gak tau dan gak peduli soal
  array — dia cuma generator angka. Angka itu BARU "jadi index" (dan bisa
  ketauan valid/enggak) pas dipake di `nums[...]`
- **`until N` (exclusive) vs `..N` (inclusive) itu SELALU beda 1 di titik
  berhenti.** `until N` berhenti di `N-1`, `..N` berhenti TEPAT di `N`.
  Konsekuensinya: `until nums.size - 1` == `..nums.size - 2`, BUKAN
  `..nums.size - 1` (itu kelebihan 1)
- `nums[i]` polos (gak ada `+1`/`+2`) itu AMAN pakai `until nums.size`
  tanpa perlu `-1` sama sekali — `-1` cuma dibutuhin kalau di dalam loop
  ada akses index dengan OFFSET (`nums[i+1]`, dst). Prinsip umum: akses
  `nums[i+N]` di dalam loop -> batas atas loop harus `nums.size - N`
- `for (i in nums)` -> `i` = NILAI elemen langsung (bukan posisi). Beda
  sama `for (i in 0 until nums.size)` yang `i`-nya POSISI. Ngebungkus
  `nums[i]` di skenario `for (i in nums)` itu keliru — nilai dipaksa jadi
  index, gampang out of bounds (kejadian nyata: `nums[8]` dari nilai
  elemen ke-2 yang kebetulan `8`)
- `nums.withIndex()` = versi OTOMATIS dari "loop pakai index + ambil
  value manual" — bisa didestructure `(index, value)` atau dibiarin 1
  objek (`IndexedValue`). Tapi gak ngasih akses ke TETANGGA (`i-1`,
  `i+1`), jadi gak cukup buat soal yang butuh ngintip elemen sekitar
  (kayak Non-decreasing Array)
- **Piramid angka**: padding (spasi kosong) BERKURANG tiap baris
  sementara konten (angka) BERTAMBAH tiap baris — dua arah yang
  berlawanan ini yang bikin bentuk diagonal/piramid. Teknik debug: pakai
  karakter KELIATAN (`*`) buat gantiin spasi kosong sementara, verifikasi
  jumlah padding-nya visual dulu sebelum diganti spasi beneran

**Kegagalan & pelajaran:**
- Beberapa kali sengaja mancing `ArrayIndexOutOfBoundsException` buat
  ngetes batas (`0..nums.size` tanpa penyesuaian, `nums[value]` dari
  `for (i in nums)`, `nums[value]` dari `withIndex()`) — ini eksperimen
  yang disengaja buat bangun intuisi, bukan bug beneran, tapi kegagalan
  ini paling efektif ngebentuk pemahaman dibanding dijelasin doang
- Sempat ambigu antara "loop range valid" (`i` boleh berapa aja sesuai
  definisi range) sama "index array valid" (`nums[i]` cuma boleh
  `0..size-1`) — dikira itu 1 aturan yang sama, padahal 2 aturan
  independen yang KEBETULAN sering nyambung

---

<!-- Template buat entry baru:

## Sesi N — [Judul singkat]

**Yang dipelajari:**
-

**Insight penting:**
-

**Kegagalan & pelajaran:**
-

-->
