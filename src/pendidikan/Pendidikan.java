/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pendidikan;
import administrasi.*;

/**
 *
 * @author ASUS
 */
public class Pendidikan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        dosen koneksiDB = new dosen();
//        koneksiDB.simpanDosen(0, "", 0, 0, 0, 0, 0);
//        koneksiDB.dataDosen(0);

//        mahasiswa db = new mahasiswa();
//        db.simpanMahasiswa(0, "", 0, 0, "");
//        db.dataMahasiswa(0);

//        matakuliah p = new matakuliah();
//        p.simpanMK("", "", 0);
//        p.dataMK("");

        jurnalmengajar DB = new jurnalmengajar();
        DB.simpanJM(1, 1, "JRKM2", "24-11-2024", "08:00 - 10:00", "Lab Multimedia");
        DB.dataJM(0);
    }
    
}
