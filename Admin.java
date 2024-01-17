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
public class Admin {

    private String username;
    private String namaAdmin;
    private String password;

    public Admin() {
        this.username = "admin";
        this.namaAdmin = "Mariana";
        this.password = "admin";
    }

     public String getNameAdmin() {
        return namaAdmin;
    }
     
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
