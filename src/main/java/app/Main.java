package app;

import module.PengolahanNilai;

/**
 * Kelas Main menaungi antarmuka pengguna (CLI) untuk program pengolahan nilai mahasiswa.
 */
public class Main {
    public static void main(String[] args) {
        PengolahanNilai pengolahanNilai = new PengolahanNilai();
        pengolahanNilai.jalankan();
    }
}
