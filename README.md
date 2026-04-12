# Pengolahan Nilai Mahasiswa

Project sederhana untuk mengolah nilai mahasiswa, termasuk validasi, perhitungan nilai akhir, penentuan grade, dan status kelulusan.

## Struktur Folder

```
.
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       ├── app
│   │       │   └── Main.java
│   │       └── module
│   │           ├── HitungNilaiAkhir.java
│   │           ├── InputData.java
│   │           ├── TentukanGrade.java
│   │           ├── TentukanKelulusan.java
│   │           └── ValidasiData.java
│   └── test
│       └── java
│           └── module
│               ├── HitungNilaiAkhirTest.java
│               ├── TentukanGradeTest.java
│               ├── TentukanKelulusanTest.java
│               └── ValidasiDataTest.java
└── target
```

## Modul

- **InputData**: Modul untuk menginput nilai tugas, uts, dan uas.
- **ValidasiData**: Modul untuk memvalidasi nilai yang diinput.
- **HitungNilaiAkhir**: Modul untuk menghitung nilai akhir berdasarkan bobot yang ditentukan.
- **TentukanGrade**: Modul untuk menentukan grade (A, B, C, D, E) berdasarkan nilai akhir.
- **TentukanKelulusan**: Modul untuk menentukan status kelulusan berdasarkan nilai akhir.

## Unit Test

Setiap modul memiliki unit testnya masing-masing untuk memastikan fungsionalitas berjalan dengan baik.

## Build Project Mengecualikan Test
`mvn -q -DskipTests package`

## Jalankan Program
`java -cp target/pengolahan-nilai-mahasiswa-1.0-SNAPSHOT.jar app.Main`

## Unit Test
`mvn test`

## Specific Unit Test
`mvn test -Dtest="module.modulename"`
