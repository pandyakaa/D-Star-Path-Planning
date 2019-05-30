# D-Star-Path-Planning
Penelusuran peta menggunakan algoritma D star.

## How to Use
1. Clone repository ini
2. Lakukan pengubahan peta(map) pada file **map.txt**, sesuaikan dengan kebutuhan
3. Jika peta ada pada file selain map.txt, pada file Main.java, ubah

```java
DStar ds = new DStar("map.txt");
```
dengan
```java
DStar ds = new DStar("<nama-file-map>.txt");
```

4. Jalankan program dengan 
```java
javac *.java
java Main
```

5. Jika ingin menambahkan sebuah **_obstacle_** pada peta, dilakukan secara manual pada file **DStar.java**, pada bagian yang memiliki komentar _PERUBAHAN OBSTACLE_

## Algoritma D-Star
Algoritma D-Star menggunakan Algoritma A-Star, yang dapat beradaptasi jika pada saat melakukan _backtracking_ jalur, ternyata ada perubahan sehingga jalur awal tidak bisa ditempuh lagi.
Implementasi pada program ini adalah sebagai berikut :
1. Cari terlebih dahulu apakah goal node bisa dicapai atau tidak menggunakan algoritma A-Star dengan cost :
```
cost(node) = cost(prev_node) + 1 , jika berpindah ke kanan, kiri, atas, atau bawah
cost(node) = cost(prev_node) + sqrt(2), jika berpindah secara serong atas kanan, atas kiri, bawah kanan, atau bawah kiri
```
2. Jika tidak bisa dicapai, maka keluarkan output 
```
PATH NOT FOUND
```
3. Jika bisa dicapai, akan _move_ dari start hingga ke goal node
4. Jika tiba-tiba ada perubahan pada jalur, maka secara **rekursif** akan memanggil kembali algoritma A-Star dengan melakukan perubahan titik awal serta cost masing-masing node yang berubah akibat perubahan jalur

## Library eksternal
Tidak ada

## Uji Kasus

### Uji Kasus 1 (Tanpa perubahan jalur)
![1](https://user-images.githubusercontent.com/38171936/58598349-352f8700-82a6-11e9-9197-e58b28aaea5a.JPG)
![2](https://user-images.githubusercontent.com/38171936/58598350-3660b400-82a6-11e9-8217-50902d77fbb0.JPG)

Pada kasus ini, tidak ditemukan adanya perubahan jalur ketika sudah dilakukan searching, sehingga hanya akan dilakukan algoritma A-Star, dan kemudian backtrack dari start ke goal

### Uji Kasus 2 (Dengan perubahan jalur)
![3](https://user-images.githubusercontent.com/38171936/58598423-80e23080-82a6-11e9-9e35-5f75eeee1927.JPG)
![4](https://user-images.githubusercontent.com/38171936/58598424-817ac700-82a6-11e9-80db-bb583a2a9ed6.JPG)

Pada kasus ini, ditemukan adanya perubahan jalur ketika sudah dilakukan searching, dikarenakan pada titik (2,4) tiba-tiba ditemukan sebuah _obstacle_, oleh karena itu ketika ada di titik (2,3) dilakukan pencarian ulang dengan titik awal ada di (2,3) dan titik akhir tetap dengan memanggil secara rekursif fungsi yang menerapkan algoritma A-Star

### Uji Kasus 3 (Goal tidak bisa dicapai)
![5](https://user-images.githubusercontent.com/38171936/58599296-d9ff9380-82a9-11e9-9a19-75714c244113.JPG)
![6](https://user-images.githubusercontent.com/38171936/58601324-7a59b600-82b2-11e9-85e8-8d025ac96fa1.JPG)

Pada kasus ini, ketika dilakukan eksplorasi peta, tidak ditemukan jalur yang bisa dilewati untuk menuju goal node, sehingga akan muncul "PATH NOT FOUND" 

## Waktu pengerjaan dan Kesulitan
Pengerjaan dilakukan selama kurang lebih **lima** hari, dengan kesulitan terbesar tidak adanya algoritma DStar yang sudah jadi, sehingga harus memahami teori terlebih dahulu dan mengimplementasikannya menjadi sebuah program

## Referensi:<br>
<a href="https://www.cs.cmu.edu/~motionplanning/lecture/AppH-astar-dstar_howie.pdf">Motion Planning Lecture</a><br>
<a href="http://idm-lab.org/bib/abstracts/papers/aaai02b.pdf">D* Lite Paper</a>
