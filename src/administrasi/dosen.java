/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasi;

/**
 *
 * @author ASUS
 */
public class dosen {
   private String id_dosen;
   private String nama;
   private String npp;
   private String no_telp;
   private String jumlah_nguji;
   private String jumlah_bimbing;
   private String jumlah_nyanggah;
   
   public dosen( String id_dosen, String nama, String npp, String no_telp, String jml_nguji, String jml_bimbing, String jml_nyanggah){
       this.id_dosen = id_dosen;
       this.nama = nama;
       this.npp = npp;
       this.no_telp = no_telp;
       this.jumlah_nguji = jumlah_nguji;
       this.jumlah_bimbing = jumlah_bimbing;
       this.jumlah_nyanggah = jumlah_nyanggah;
   }
   
   public String getId_dosen (){
       return id_dosen;
   }
   
   public String getNama (){
       return nama;
   }
   
   public String getNpp (){
       return npp;
   }
   
   public String getNo_telp (){
       return no_telp;
   }
   
   public String getJumlah_nguji (){
       return jumlah_nguji;
   }
   
   public String getJumlah_bimbing (){
       return jumlah_bimbing;
   }
   
  public String getJumlah_nyanggah (){
      return jumlah_nyanggah;
  }
}
