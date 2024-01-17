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

public class LayananPublik {

    private ArrayList<Integer> idLayananPublik = new ArrayList<Integer>();
    private ArrayList<String> namaLayanan = new ArrayList<String>();
    private ArrayList<String> kategori = new ArrayList<String>();
    private ArrayList<String> persyaratan = new ArrayList<String>();
    private ArrayList<String> prosedur = new ArrayList<String>();
    int idLayananPublikTerpilih;
  
                
    // Konstruktor
    public LayananPublik() {
        this.idLayananPublik.add(0);
        this.namaLayanan.add("Layanan Kesehatan");
        this.kategori.add("Kesehatan");
        this.persyaratan.add("Memiliki KTP");
        this.prosedur.add("Mendaftar di Puskesmas");

        this.idLayananPublik.add(1);
        this.namaLayanan.add("Layanan Pendidikan");
        this.kategori.add("Pendidikan");
        this.persyaratan.add("Memiliki Kartu Keluarga");
        this.prosedur.add("Mendaftar di Sekolah");

        this.idLayananPublik.add(2);
        this.namaLayanan.add("Layanan Transportasi");
        this.kategori.add("Transportasi");
        this.persyaratan.add("Memiliki KTP");
        this.prosedur.add("Membeli Tiket");
    }

    // Method get

     public int getJmlLayanan(){//method
 return this.namaLayanan.size();
 }//mendapatkan jumlah masyarakat sesuai nama masyarakat  
 
     
    public int getIdLayanan(int idLayananPublik) {
        return this.idLayananPublik.get(idLayananPublik);
    }

    public String getNamaLayanan(int idLayananPublik) {
        return this.namaLayanan.get(idLayananPublik);
    }

    public String getKategori(int idLayananPublik) {
        return this.kategori.get(idLayananPublik);
    }

    public String getPersyaratan(int idLayananPublik) {
        return this.persyaratan.get(idLayananPublik);
    }

    public String getProsedur(int idLayananPublik) {
        return this.prosedur.get(idLayananPublik);
    }

     public int getIdLayananPublikTerpilih() {
        // Return the ID of the selected layanan (implement accordingly)
        return this.idLayananPublikTerpilih;
    }
    // Method set

    public void setIdLayanan(int idLayananPublik) {
        this.idLayananPublik.add(idLayananPublik);
    }

    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan.add(namaLayanan);
    }

    public void setKategori(String kategori) {
        this.kategori.add(kategori);
    }

    public void setPersyaratan(String persyaratan) {
        this.persyaratan.add(persyaratan);
    }

    public void setProsedur(String prosedur) {
        this.prosedur.add(prosedur);
    }
}

    
    

