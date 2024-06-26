/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 * 
 * @author User
 */
public class koneksi {
    private String databaseName = "2210010492";
    private String username = "root";
    private String password = "";
    public static Connection koneksiDB;
    
    public koneksi(){
        try {
            String location = "jdbc:mysql://localhost/"+databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void simpanDosen(String id_dosen, String nama, String npp, String no_telp, String jml_nguji, String jml_bimbing, String jml_nyanggah){
        try {
            String sql = "insert into dosen (id_dosen, nama, npp, no_telp, jml_nguji, jml_bimbing, jml_nyanggah) value (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_dosen);
            perintah.setString(2, nama);
            perintah.setString(3, npp);
            perintah.setString(4, no_telp);
            perintah.setString(5, jml_nguji);
            perintah.setString(6, jml_bimbing);
            perintah.setString(7, jml_nyanggah);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }            
    }
    
    public void ubahDosen (String id_dosen, String nama, String npp, String no_telp, String jml_nguji, String jml_bimbing, String jml_nyanggah){
        try {
            String sql = "update dosen set nama = ?, npp = ?, no_telp = ?, jml_nguji = ?, jml_bimbing = ?, jml_nyanggah = ? where id_dosen = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, npp);
            perintah.setString(2, no_telp);
            perintah.setString(2, jml_nguji);
            perintah.setString(2, jml_bimbing);
            perintah.setString(2, jml_nyanggah);
            perintah.setString(7, id_dosen);
           
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusDosen(String id_dosen){
        try {
            String sql = "delete from dosen where id_dosen = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_dosen);
            
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
    
    public void simpanJurnalmengajar(String id_jurnal, String id_dosen, String id_mata_kuliah, String tgl_mengajar, String jam_mengajar, String ruangan){
        try {
            String sql = "insert into jurnal_mengajar (id_jurnal, id_dosen, id_mata_kuliah, tgl_mengajar, jam_mengajar, ruangan) value (?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_jurnal);
            perintah.setString(2, id_dosen);
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
    
    public void ubahJurnalmengajar(String id_jurnal, String id_dosen, String id_mata_kuliah, String tgl_mengajar, String jam_mengajar, String ruangan){
        try {
            String sql = "update jurnal_mengajar set id_dosen = ?, mata_kuliah = ?, tgl_mengajar = ?, jam_mengajar = ?, ruangan = ? where id_jurnal = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_dosen);
            perintah.setString(2, id_mata_kuliah);
            perintah.setString(3, tgl_mengajar);
            perintah.setString(4, jam_mengajar);
            perintah.setString(5, ruangan);
            perintah.setString(6, id_jurnal);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusJurnalmengajar(String id_jurnal){
        try {
            String sql = "delete from jurnal_mengajar where id_jurnal = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_jurnal);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariJurnalmengajar(String id_jurnal){
        try {
            String sql = "select * from jurnal_mengajar where id_jurnal = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_jurnal);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID JURNAL : "+data.getString("id_jurnal"));
                System.out.println("ID DOSEN : "+data.getString("id_dosen"));
                System.out.println("ID MATKUL : "+data.getString("id_mata_kuliah"));
                System.out.println("TANGGAL MENGAJAR : "+data.getString("tgl_mengajar"));
                System.out.println("JAM MENGAJAR : "+data.getString("jam_mengajar"));
                System.out.println("RUANGAN : "+data.getString("ruangan"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataJurnalmengajar(String id_jurnal){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from jurnal_mengajar order by id_jurnal asc");
            while(baris.next()){
                System.out.println(baris.getString("id_jurnal")+" | "+
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
    
    public void simpanMahasiswa(String id_mahasiswa, String nama, String nim, String no_telp, String password){
        try {
            String sql = "insert into mahasiswa (id_mahasiswa, nama, nim, no_telp, password) value (?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_mahasiswa);
            perintah.setString(2, nama);
            perintah.setString(3, nim);
            perintah.setString(4, no_telp);
            perintah.setString(5, password);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahMahasiswa(String id_mahasiswa, String nama, String nim, String no_telp, String password){
        try {
            String sql = "update mahasiswa set nama = ?, nim = ?, no_telp = ?, password = ? where id_mahasiswa = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, nim);
            perintah.setString(3, no_telp);
            perintah.setString(4, password);
            perintah.setString(5, id_mahasiswa);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusMahasiswa(String id_mahasiswa){
        try {
            String sql = "delete from mahasiswa where id_mahasiswa = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_mahasiswa);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariMahasiswa(String id_mahasiswa){
        try {
            String sql = "select * from mahasiwa where id_mahasiswa = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_mahasiswa);
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
    
    public void dataMahasiswa(String id_mahasiswa){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from mahasiswa order by id_mahasiswa asc");
            while(baris.next()){
                System.out.println(baris.getInt("id_mahasiswa")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getString("nim")+" | "+
                        baris.getString("no_telp")+" | "+
                        baris.getString("password"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanMatakuliah(String id_mata_kuliah, String nama, String sks){
        try {
            String sql = "insert into mata_kuliah(id_mata_kuliah, nama, sks) value(?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_mata_kuliah);
            perintah.setString(2, nama);
            perintah.setString(3, sks);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahMatakuliah(String id_mata_kuliah, String nama, String sks){
        try {
            String sql = "update mata_kuliah set nama = ?, sks = ? where id_mata_kuliah = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, sks);
            perintah.setString(3, id_mata_kuliah);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusMatakuliah(String id_mata_kuliah){
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
    
    public void cariMatakuliah(String id_mata_kuliah){
        try {
            String sql = "select * from mata_kuliah where id_mata_kuliah = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id_mata_kuliah);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID MATAKULIAH : "+data.getString("id_mata_kuliah"));
                System.out.println("NAMA : "+data.getString("nama"));
                System.out.println("SKS : "+data.getString("sks"));
            }          
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataMatakuliah(String id_mata_kuliah){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from mata_kuliah order by id_mata_kuliah asc");
            while(baris.next()){
                System.out.println(baris.getString("id_mata_kuliah")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getString("sks"));                                     
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void simpandosen(String id_dosen, String nama, String npp, String no_telpon, String jumlah_nguji, String jumlah_bimbing, String jumlah_nyanggah) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
