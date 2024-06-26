/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasi;

/**
 *
 * @author ASUS
 */
public class mahasiswa {
    private String id_mahasiswa;
    private String nama;
    private String nim;
    private String nomor_telpon;
    private String password;
    
    public mahasiswa(String id_mahasiswa, String nama, String nim, String nomor_telpon,String password){
       this.id_mahasiswa = id_mahasiswa;
       this.nama = nama;
       this.nim = nim;
       this.nomor_telpon = nomor_telpon;
       this.password = password;
}
    public String getId_mahasiswa (){
        return id_mahasiswa;
    }
     public String getNama (){
         return nama;
     }
    public String getNim (){
        return nim;
    }
    public String getNomor_telpon (){
        return nomor_telpon;
    }
    public String getPassword (){
        return password;
    }
}
