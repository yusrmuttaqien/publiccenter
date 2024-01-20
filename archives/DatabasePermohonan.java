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
import java.util.List;

public class DatabasePermohonan {
    private List<PermohonanLayananPublik> permohonanList;
    private int lastAssignedId;

    public DatabasePermohonan() {
        this.permohonanList = new ArrayList<>();
    }

    public void tambahPermohonan(PermohonanLayananPublik permohonan) {
        
        this.permohonanList.add(permohonan);
    }

    public List<PermohonanLayananPublik> getPermohonanList() {
        return permohonanList;
    }
}

