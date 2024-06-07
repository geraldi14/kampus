/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class dosen {
    private String databaseName = "2210010492";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public dosen(){
        try {
            String location = "jdbc:mysql://localhost/"+databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanDosen(int id_dosen, String nama, int npp, int no_telp, int jml_nguji, int jml_bimbing, int jml_nyanggah){
        try {
            String sql = "insert into dosen (id_dosen, nama, npp, no_telp, jml_nguji, jml_bimbing, jml_nyanggah) value (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_dosen);
            perintah.setString(2, nama);
            perintah.setInt(3, npp);
            perintah.setInt(4, no_telp);
            perintah.setInt(5, jml_nguji);
            perintah.setInt(6, jml_bimbing);
            perintah.setInt(7, jml_nyanggah);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }            
    }
    
    public void ubahDosen (int id_dosen, String nama, int npp, int no_telp, int jml_nguji, int jml_bimbing, int jml_nyanggah){
        try {
            String sql = "update from dosen set nama = ?, npp = ?, no_telp = ?, jml_nguji = ?, jml_bimbing = ?, jml_nyanggah = ? where id_dosen = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setInt(2, npp);
            perintah.setInt(2, no_telp);
            perintah.setInt(2, jml_nguji);
            perintah.setInt(2, jml_bimbing);
            perintah.setInt(2, jml_nyanggah);
            perintah.setInt(7, id_dosen);
           
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusDosen(int id_dosen){
        try {
            String sql = "delete from dosen where id_dosen = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_dosen);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariDosen(int id_dosen){
        try {
            String sql = "select * from dosen where id_dosen = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_dosen);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID DOSEN : "+data.getInt("id_dosen"));
                System.out.println("NAMA : "+data.getString("nama"));
                System.out.println("NPP : "+data.getInt("npp"));
                System.out.println("NO TELPON : "+data.getInt("no_telp"));
                System.out.println("JUMLAH PENGUJIAN : "+data.getInt("jml_nguji"));
                System.out.println("JUMLAH BIMBINGAN : "+data.getInt("jml_bimbing"));
                System.out.println("JUMLAH SANGGAHAN : "+data.getInt("jml_nyanggah"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataDosen(int id_dosen){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from dosen order by id_dosen asc");
            while(baris.next()){
                System.out.println(baris.getInt("id_dosen")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getInt("npp")+" | "+
                        baris.getInt("no_telp")+" | "+
                        baris.getInt("jml_nguji")+" | "+
                        baris.getInt("jml_bimbing")+" | "+
                        baris.getInt("jml_nyanggah")+" | ");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
