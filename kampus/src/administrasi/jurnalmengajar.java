/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasi;

/**
 *
 * @author ASUS
 */
public class jurnalmengajar {
    private String id_jurnal;
    private String id_dosen;
    private String id_matakuliah;
    private String tanggal_mengajar;
    private String jam_mengajar;
    private String ruangan;
    
    
    public jurnalmengajar(String id_jurnal, String id_dosen, String id_matakuliah, String tanggal_mengajar, String jam_mengajar, String ruangan){
       this.id_jurnal = id_jurnal;
       this.id_dosen = id_dosen;
       this.id_matakuliah = id_matakuliah;
       this.tanggal_mengajar = tanggal_mengajar;
       this.jam_mengajar = jam_mengajar;
       this.ruangan = ruangan;
}
    public String getId_jurnal (){
        return id_jurnal;
    }
    
    public String getId_dosen (){
        return id_dosen;
    }
    
    public String getId_matakuliah (){
        return id_matakuliah;
    }
    
    public String getTanggal_mengajar (){
        return tanggal_mengajar;
    }
    
    public String getJam_mengajar (){
        return jam_mengajar;
    }
    
    public String getRuangan () {
        return ruangan;
    }
  }
    

        
    

    