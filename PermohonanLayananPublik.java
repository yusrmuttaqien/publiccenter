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
public class PermohonanLayananPublik {
    private int idPermohonan;
    private String status;
    private String dokumenDukung;
    private String namaUserLogin;
    private String namaLayananTerpilih;
    private String namaTempatLayananTerpilih;
    


    // Konstruktor untuk membuat objek PermohonanLayananPublik
    public PermohonanLayananPublik() {
        // Set default status ke "Sedang diproses" saat permohonan diajukan
        this.status = "Sedang diproses";
    }
    
//        public static PermohonanLayananPublik[] getPermohonanByUser(int idUser) {
//        // Implementation to get permohonan by user ID
//        // Return an array of PermohonanLayananPublik objects
//        
//        return new PermohonanLayananPublik[0]; // Replace with your logic
//    }

    // Getter untuk mendapatkan idPermohonan
    public int getIdPermohonan() {
        return idPermohonan;
    }

    // Setter untuk mengatur idPermohonan
    public void setIdPermohonan(int idPermohonan) {
        this.idPermohonan = idPermohonan;
//        permohonan.setIdPermohonan(++lastAssignedId);
    }

    // Getter untuk mendapatkan status
    public String getStatus() {
        return status;
    }
    
    public void setStatus() {
        this.status = "Sedang Diproses";
    }
    
     public void setStatusSelesai() {
        this.status = "Selesai";
    }

    // Getter untuk mendapatkan dokumen dukung
    public String getDokumenDukung() {
        return dokumenDukung;
    }

    
    public String getnamaTempatLayananTerpilih() {
        return namaTempatLayananTerpilih;
    }

    public String getnamaLayananTerpilih() {
        return namaLayananTerpilih;
    }

    public String getNamaUserLogin() {
        return namaUserLogin;
    }
    
    // Setter untuk mengatur dokumen dukung
    public void setDokumenDukung(String dokumenDukung) {
        this.dokumenDukung = dokumenDukung;
    }
    
     public void setnamaUserLogin(String namaUserLogin) {
        this.namaUserLogin = namaUserLogin;
    }
     
      public void setnamaLayananTerpilih(String namaLayananTerpilih) {
        this.namaLayananTerpilih = namaLayananTerpilih;
    }
      
       public void setnamaTempatLayananTerpilih(String namaTempatLayananTerpilih) {
        this.namaTempatLayananTerpilih = namaTempatLayananTerpilih;
    }
      
      
}
