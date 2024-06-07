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
public class jurnalmengajar {
    private String databaseName = "2210010492";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public jurnalmengajar(){
        try {
            String location = "jdbc:mysql://localhost/"+databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }
    }
    
    public void simpanJM(int id_jurnal, int id_dosen, String id_mata_kuliah, String tgl_mengajar, String jam_mengajar, String ruangan){
        try {
            String sql = "insert into jurnal_mengajar (id_jurnal, id_dosen, id_mata_kuliah, tgl_mengajar, jam_mengajar, ruangan) value (?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_jurnal);
            perintah.setInt(2, id_dosen);
            perintah.setString(3, id_mata_kuliah);
            perintah.setString(4, tgl_mengajar);
            perintah.setString(5, jam_mengajar);
            perintah.setString(6, ruangan);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahJM(int id_jurnal, int id_dosen, String id_mata_kuliah, String tgl_mengajar, String jam_mengajar, String ruangan){
        try {
            String sql = "update jurnal_mengajar set id_dosen = ?, mata_kuliah = ?, tgl_mengajar = ?, jam_mengajar = ?, ruangan = ? where id_jurnal = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_dosen);
            perintah.setString(2, id_mata_kuliah);
            perintah.setString(3, tgl_mengajar);
            perintah.setString(4, jam_mengajar);
            perintah.setString(5, ruangan);
            perintah.setInt(6, id_jurnal);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusJM(int id_jurnal){
        try {
            String sql = "delete from jurnal_mengajar where id_jurnal = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_jurnal);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariJM(int id_jurnal){
        try {
            String sql = "select * from jurnal_mengajar where id_jurnal = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setInt(1, id_jurnal);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID JURNAL : "+data.getInt("id_jurnal"));
                System.out.println("ID DOSEN : "+data.getInt("id_dosen"));
                System.out.println("ID MATKUL : "+data.getString("id_mata_kuliah"));
                System.out.println("TANGGAL MENGAJAR : "+data.getString("tgl_mengajar"));
                System.out.println("JAM MENGAJAR : "+data.getString("jam_mengajar"));
                System.out.println("RUANGAN : "+data.getString("ruangan"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataJM(int id_jurnal){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from jurnal_mengajar order by id_jurnal asc");
            while(baris.next()){
                System.out.println(baris.getInt("id_jurnal")+" | "+
                        baris.getInt("id_dosen")+" | "+
                        baris.getString("id_mata_kuliah")+" | "+
                        baris.getString("tgl_mengajar")+" | "+
                        baris.getString("jam_mengajar")+" | "+
                        baris.getString("ruangan")+" | ");        
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
