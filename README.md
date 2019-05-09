# D-Star-Path-Planning
Penelusuran peta menggunakan algoritma D star.

## Deskripsi Tugas
Buatlah sebuah program implementasi algoritma D star<sup>1</sup> yang dapat digunakan untuk menelusuri sebuah peta.
Program harus dapat:
1. Membaca peta<sup>2</sup> dari sebuah file eksternal (seperti pada tugas kecil 3 Strategi Algoritma), beserta node start dan node goal.
2. Menampilkan peta beserta node start dan node goal.
3. Memperlihatkan perubahan jalur, cost jalur beserta status setiap node pada peta selama eksplorasi.
4. Menentukan apakah node goal dapat dicapai dari node start.

Catatan:<br>
<sup>1</sup> Implementasi algoritma bebas. Anda dapat memilih untuk menggunakan beberapa variasi algoritma D star seperti yang disebutkan di <a href="https://en.wikipedia.org/wiki/D*">sini</a>. Gunakanlah library external sesedikit mungkin, originalitas struktur data dan algoritma akan dihargai lebih.<br>
<sup>2</sup> Peta boleh di-generate secara random. Gunakanlah peta yang dapat menampilkan kasus-kasus sebagai berikut:
1. Node goal dapat dicapai dari node start tanpa perubahan jalur.
2. Node goal dapat dicapai dari node start dengan perubahan jalur.
3. Node goal tidak dapat dicapai dari node start setelah dilakukan eksplorasi peta.

## Deliverables
1. Source code program dalam bahasa C/C++/Java.
2. File eksternal untuk kasus uji.
2. Makefile.
3. Readme yang berisi :
   * Cara menjalankan program,
   * penjelasan algoritma yang digunakan beserta perhitungan cost jalur, 
   * library external yang digunakan beserta alasan penggunaan, 
   * screenshot yang menampilkan minimal 3 kasus yang telah didefinisikan di atas beserta penjelasan untuk setiap screenshot,
   * waktu pengerjaan beserta kesulitan yang dialami, dan
   * referensi

## Referensi:<br>
<a href="https://www.cs.cmu.edu/~motionplanning/lecture/AppH-astar-dstar_howie.pdf">Motion Planning Lecture</a><br>
<a href="http://idm-lab.org/bib/abstracts/papers/aaai02b.pdf">D* Lite Paper</a>
