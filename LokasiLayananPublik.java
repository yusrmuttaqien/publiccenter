/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publiccenter;

/**
 *
 * @author Nisa Amelia Putri
 */

import java.util.ArrayList;

public class LokasiLayananPublik {

    private ArrayList<Integer> idLokasi = new ArrayList<Integer>();
    private ArrayList<String> namaTempatLayanan = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> jamBuka = new ArrayList<String>();
    private ArrayList<String> kontak = new ArrayList<String>();
    private ArrayList<Integer> idLayananPublik = new ArrayList<Integer>();
    int idLokasiTerpilih;
    // Konstruktor
    public LokasiLayananPublik() {
        this.idLokasi.add(0);
        this.namaTempatLayanan.add("Puskesmas Malang");
        this.alamat.add("Jl. Mawar No. 1, Malang");
        this.jamBuka.add("08.00 - 20.00");
        this.kontak.add("(0341) 123456");
        this.idLayananPublik.add(0);

        this.idLokasi.add(1);
        this.namaTempatLayanan.add("RSUD Dr. Saiful Anwar");
        this.alamat.add("Jl. Jaksa Agung Suprapto No.2, Malang");
        this.jamBuka.add("Buka 24 jam");
        this.kontak.add("(0341) 362101");
        this.idLayananPublik.add(0);
        
        this.idLokasi.add(2);
        this.namaTempatLayanan.add("Puskesmas Surabaya");
        this.alamat.add("Jl. Raya Arjowinangun No. 2, Surabaya");
        this.jamBuka.add("08.00 - 17.00");
        this.kontak.add("(0341) 751398");
        this.idLayananPublik.add(0);  
        
        this.idLokasi.add(3);
        this.namaTempatLayanan.add("Puskesmas Negeri Surabaya");
        this.alamat.add("Jl. Raya No. 2, Surabaya");
        this.jamBuka.add("08.00 - 20.00");
        this.kontak.add("(0341) 751398");
        this.idLayananPublik.add(0);  
        
        this.idLokasi.add(4);
        this.namaTempatLayanan.add("Kantor Kependudukan dan Catatan Sipil Malang");
        this.alamat.add("Jl. Melati No. 2, Malang");
        this.jamBuka.add("08.00 - 15.00");
        this.kontak.add("(0341) 789012");
        this.idLayananPublik.add(1);
        
        this.idLokasi.add(5);
        this.namaTempatLayanan.add("Kantor Kependudukan dan Catatan Sipil Surabaya");
        this.alamat.add("Jl. Melati No. 2, Surabaya");
        this.jamBuka.add("08.00 - 15.00");
        this.kontak.add("(0341) 789012");
        this.idLayananPublik.add(1);
    }

    // Method get

    public int getJmlLokasi(){//method
    return this.namaTempatLayanan.size();
    }//mendapatkan jumlah masyarakat sesuai nama masyarakat  

      
    public int getIdLokasi(int idLokasi) {
        return this.idLokasi.get(idLokasi);
    }

    public String getNamaTempat(int idLokasi) {
        return this.namaTempatLayanan.get(idLokasi);
    }

    public String getAlamat(int idLokasi) {
        return this.alamat.get(idLokasi);
    }

    public String getJamBuka(int idLokasi) {
        return this.jamBuka.get(idLokasi);
    }

    public String getKontak(int idLokasi) {
        return this.kontak.get(idLokasi);
    }

    public int getIdLayananPublik(int idLayananPublik) {
        return this.idLayananPublik.get(idLayananPublik);
    }

      public int getIdLokasiTerpilih() {
        // Return the ID of the selected lokasi (implement accordingly)
        return this.idLokasiTerpilih;
    }
    // Method set

    public void setIdLokasi(int idLokasi) {
        this.idLokasi.add(idLokasi);
    }

    public void setNamaTempat(String namaTempatLayanan) {
        this.namaTempatLayanan.add(namaTempatLayanan);
    }

    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }

    public void setJamBuka(String jamBuka) {
        this.jamBuka.add(jamBuka);
    }

    public void setKontak(String kontak) {
        this.kontak.add(kontak);
    }

    public void setIdLayananPublik(int idLayananPublik) {
        this.idLayananPublik.add(idLayananPublik);
    }
}

