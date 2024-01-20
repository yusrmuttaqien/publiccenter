/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publiccenter;

import java.util.ArrayList;
/**
 *
 * @author Nisa Amelia Putri
 */
import java.util.List;

public class TampilData {

  public void tampil(LayananPublik layananPublik) {
    int x = layananPublik.getJmlLayanan();
    System.out.println();
    System.out.println(
      "===================================   TABEL LAYANAN PUBLIK  ====================================="
    );

    System.out.printf(
      "%-15s%-25s%-15s%-25s%-25s%n",
      "ID Layanan",
      "Nama Layanan",
      "Kategori",
      "Persyaratan",
      "Prosedur"
    );
    System.out.println(
      "----------------------------------------------------------------------------------------"
    );

    // Data Tabel
    for (int i = 0; i < layananPublik.getJmlLayanan(); i++) {
      System.out.printf(
        "%-15d%-25s%-15s%-25s%-25s%n",
        layananPublik.getIdLayanan(i),
        layananPublik.getNamaLayanan(i),
        layananPublik.getKategori(i),
        layananPublik.getPersyaratan(i),
        layananPublik.getProsedur(i)
      );
    }
  }

  public void tampil(LokasiLayananPublik lokasi, int idLayananPublik) {
    System.out.println();
    System.out.println(
      "===================================   TABEL LOKASI LAYANAN PUBLIK  ====================================="
    );

    System.out.printf(
      "%-15s%-48s%-30s%-20s%-20s%n",
      "ID Lokasi",
      "Nama Tempat Layanan",
      "Alamat",
      "Jam Buka",
      "Kontak"
    );
    System.out.println(
      "----------------------------------------------------------------------------------------"
    );

    // Data Tabel
    boolean ditemukan = false;
    for (int i = 0; i < lokasi.getJmlLokasi(); i++) {
      if (lokasi.getIdLayananPublik(i) == idLayananPublik) {
        System.out.printf(
          "%-15s%-48s%-30s%-20s%-20s%n",
          lokasi.getIdLokasi(i),
          lokasi.getNamaTempat(i),
          lokasi.getAlamat(i),
          lokasi.getJamBuka(i),
          lokasi.getKontak(i)
        );
        ditemukan = true;
      }
    }

    if (!ditemukan) {
      System.out.println(
        "Data Lokasi Layanan Publik tidak ditemukan untuk ID Layanan Publik: " +
        idLayananPublik
      );
    }
  }

  public void tampilDataPermohonan(PermohonanLayananPublik permohonan) {
    // Cek apakah ada data permohonan
    if (permohonan == null) {
      System.out.println("Tidak ada data permohonan.");
      return;
    }

    // Menampilkan informasi permohonan
    System.out.println(
      "=================================== Informasi Permohonan ============================================================================="
    );
    System.out.printf(
      "%-25s%-25s%-48s%-20s%-25s%n",
      "Nama User Login",
      "Nama Layanan Terpilih",
      "Nama Tempat Layanan",
      "Status",
      "Dukungan Dokumen"
    );
    System.out.println(
      "-------------------------------------------------------------------------------------------------------------------------------------"
    );
    System.out.printf(
      "%-25s%-25s%-48s%-20s%-25s%n",
      permohonan.getNamaUserLogin(),
      permohonan.getnamaLayananTerpilih(),
      permohonan.getnamaTempatLayananTerpilih(),
      permohonan.getStatus(),
      permohonan.getDokumenDukung()
    );
    System.out.println(
      "========================================================================================"
    );
  }

  // Tambahkan metode tampilKumpulanDataPermohonan pada kelas PublicCenter
  public void tampilKumpulanDataPermohonan(User user) {
    System.out.println(
      "=================================== Data Permohonan Layanan Publik ==================================="
    );
    System.out.printf(
      "%-15s%-25s%-25s%-48s%-20s%-25s%n",
      "ID",
      "Nama User Login",
      "Nama Layanan Terpilih",
      "Nama Tempat Layanan",
      "Status",
      "Dukungan Dokumen"
    );
    System.out.println(
      "-------------------------------------------------------------------------------------------------------------------------------------"
    );

    List<PermohonanLayananPublik> bookedData = user.getBookedData();

    for (PermohonanLayananPublik permohonan : bookedData) {
      System.out.printf(
        "%-15s%-25s%-25s%-48s%-20s%-25s%n",
        permohonan.getIdPermohonan(),
        permohonan.getNamaUserLogin(),
        permohonan.getnamaLayananTerpilih(),
        permohonan.getnamaTempatLayananTerpilih(),
        permohonan.getStatus(),
        permohonan.getDokumenDukung()
      );
    }

    System.out.println(
      "========================================================================================"
    );
  }
}
