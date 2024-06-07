/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class matakuliah {
    private String databaseName = "2210010492";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public matakuliah(){
        try {
            String location = "jdbc:mysql://localhost/"+databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanMK(String id_mata_kuliah, String nama, int sks){
        try {
            String sql = "insert into mata_kuliah(id_mata_kuliah, nama, sks) value(?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_mata_kuliah);
            perintah.setString(2, nama);
            perintah.setInt(3, sks);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahMK(String id_mata_kuliah, String nama, int sks){
        try {
            String sql = "update mata_kuliah set nama = ?, sks = ? where id_mata_kuliah = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setInt(2, sks);
            perintah.setString(3, id_mata_kuliah);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusMK(String id_mata_kuliah){
        try {
            String sql = "delete from mata_kuliah where id_mata_kuliah = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_mata_kuliah);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariMK(String id_mata_kuliah){
        try {
            String sql = "select * from mata_kuliah where id_mata_kuliah = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_mata_kuliah);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID MATAKULIAH : "+data.getString("id_mata_kuliah"));
                System.out.println("NAMA : "+data.getString("nama"));
                System.out.println("SKS : "+data.getInt("sks"));
            }          
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataMK(String id_mata_kuliah){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from mata_kuliah order by id_mata_kuliah asc");
            while(baris.next()){
                System.out.println(baris.getString("id_mata_kuliah")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getInt("sks"));                                     
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
