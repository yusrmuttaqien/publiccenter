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
public class User {

    private ArrayList<Integer> idUser = new ArrayList<Integer>();
    private ArrayList<String> nama = new ArrayList<String>();
    private ArrayList<String> email = new ArrayList<String>();
    private ArrayList<String> password = new ArrayList<String>();
    private ArrayList<PermohonanLayananPublik> bookedData = new ArrayList<>();
    // Konstruktor
    public User() {
        this.idUser.add(0);
        this.nama.add("Doni Anggara");
        this.email.add("doni@gmail.com");
        this.password.add("123456");

        this.idUser.add(1);
        this.nama.add("Riki Sukmawijaya");
        this.email.add("riki@gmail.com");
        this.password.add("123457");

        this.idUser.add(2);
        this.nama.add("Nana Anggraini");
        this.email.add("nana@gmail.com");
        this.password.add("123458");
        
        this.bookedData = new ArrayList<>();
    }

    // Method get
    
    public int getJmlUser(){//method
 return this.nama.size();
 }//mendapatkan jumlah masyarakat sesuai nama masyarakat  
 
      
    public int getId(int idUser) {
        return this.idUser.get(idUser);
    }
 
    public String getNama(int idUser) {
        return this.nama.get(idUser);
    }

    public String getEmail(int idUser) {
        return this.email.get(idUser);
    }

    public String getPassword(int idUser) {
        return this.password.get(idUser);
    }
    
   
   public ArrayList<PermohonanLayananPublik> getBookedData() {
    return this.bookedData;
}

public void addBookedData(PermohonanLayananPublik permohonan) {
        // Membuat objek baru untuk menyimpan data yang benar-benar baru
        PermohonanLayananPublik newPermohonan = new PermohonanLayananPublik();
        newPermohonan.setnamaUserLogin(permohonan.getNamaUserLogin());
        newPermohonan.setnamaLayananTerpilih(permohonan.getnamaLayananTerpilih());
        newPermohonan.setnamaTempatLayananTerpilih(permohonan.getnamaTempatLayananTerpilih());
        newPermohonan.setIdPermohonan(permohonan.getIdPermohonan());
        newPermohonan.setDokumenDukung(permohonan.getDokumenDukung());
        newPermohonan.setStatus();

        // Menambahkan objek baru ke bookedData
        this.bookedData.add(newPermohonan);
    }


    // Method set
    public void setId(int idUser) {
        this.idUser.add(idUser);
    }
    
    public void setNama(String nama) {
        this.nama.add(nama);
    }

    public void setEmail(String email) {
        this.email.add(email);
    }

    public void setPassword(String password) {
        this.password.add(password);
    }
}

    

