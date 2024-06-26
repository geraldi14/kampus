/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasi;


/**
 *
 * @author ASUS
 */
public class matakuliah {
    private String id_matakuliah;
    private String nama;
    private String sks;
    
    
   public matakuliah(String id_matakuliah, String nama, String sks){
       this.id_matakuliah = id_matakuliah;
       this.nama = nama;
       this.sks = sks;
    }
    public String getId_matakuliah (){
        return id_matakuliah;
    }
    public String getNama (){
        return nama;
    }
    public String getSks (){
        return sks;
    }
    
}
