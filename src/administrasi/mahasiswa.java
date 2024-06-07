/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasi;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author ASUS
 */
public class mahasiswa {
    private String databaseName = "2210010492";
    private String username = "root";
    private String password = "";
    private Connection koneksiDB;
    
    public mahasiswa(){
        try {
            String location = "jdbc:mysql://localhost/"+databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      
    }
    
    public void simpanMahasiswa(int id_mahasiswa, String nama, int nim, int no_telp, String password){
        try {
            String sql = "insert into mahasiswa (id_mahasiswa, nama, nim, no_telp, password) value (?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_mahasiswa);
            perintah.setString(2, nama);
            perintah.setInt(3, nim);
            perintah.setInt(4, no_telp);
            perintah.setString(5, password);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahMahasiswa(int id_mahasiswa, String nama, int nim, int no_telp, String password){
        try {
            String sql = "update from mahasiswa set nama = ?, nim = ?, no_telp = ?, password = ? where id_mahasiswa = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setInt(2, nim);
            perintah.setInt(3, no_telp);
            perintah.setString(4, password);
            perintah.setInt(5, id_mahasiswa);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusMahasiswa(int id_mahasiswa){
        try {
            String sql = "delete from mahasiswa where id_mahasiswa = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_mahasiswa);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariMahasiswa(int id_mahasiswa){
        try {
            String sql = "select * from mahasiwa where id_mahasiswa = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_mahasiswa);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID MAHASISWA :"+data.getInt("id_mahasiswa"));
                System.out.println("NAMA : "+data.getString("nama"));
                System.out.println("NIM : "+data.getInt("nim"));
                System.out.println("NO TELPON : "+data.getInt("no_telp"));
                System.out.println("PASSWORD : "+data.getString("password"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataMahasiswa(int id_mahasiswa){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from mahasiswa order by id_mahasiswa asc");
            while(baris.next()){
                System.out.println(baris.getInt("id_mahasiswa")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getInt("nim")+" | "+
                        baris.getInt("no_telp")+" | "+
                        baris.getString("password"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
