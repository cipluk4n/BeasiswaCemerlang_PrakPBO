package model;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connector {
    static final String DB_URL = "jdbc:mysql://localhost/scholarship_db";
    static final String USER = "root";
    static final String PASS = "";
    Connection conn;
    
    public Connector(){
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal: "+e.getMessage());
        }
    }
    public void insertData(Beasiswa bs) throws SQLException{
        String query = "INSERT INTO pendaftar(id, nama, jalur, nilai_ipk, "
                + "nilai_portofolio, nilai_wawancara, nilai_akhir, status)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, bs.getID());
        pst.setString(2, bs.getNama());
        pst.setString(3, bs.getJalur());
        pst.setDouble(4, bs.getNilaiIPK());
        pst.setDouble(5, bs.getNilaiPortofolio());
        pst.setDouble(6, bs.getNilaiWawancara());
        pst.setDouble(7, bs.HitungNilaiAkhir());
        pst.setString(8, bs.tentukanStatus());
        pst.executeUpdate();
    }
    public ResultSet getAllData(){
        try{
            Statement st = conn.createStatement();
            return st.executeQuery(("SELECT * FROM pendaftar"));
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public void updateData(Beasiswa bs, String namaLama) throws SQLException{
        String query = "UPDATE pendaftar SET id=?, nama=?, jalur=?, nilai_ipk=?,"
                + "nilai_portofolio=?, nilai_wawancara=?, nilai_akhir=?, status=? "
                + "WHERE id=?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, bs.getID());
        pst.setString(2, bs.getNama());
        pst.setString(3, bs.getJalur());
        pst.setDouble(4, bs.getNilaiIPK());
        pst.setDouble(5, bs.getNilaiPortofolio());
        pst.setDouble(6, bs.getNilaiWawancara());
        pst.setDouble(7, bs.HitungNilaiAkhir());
        pst.setString(8, bs.tentukanStatus());
        pst.setString(9, namaLama());
        pst.executeUpdate();
    }
    public void deleteData(int id) throws SQLException{
        String query = "DELETE FROM pendaftar WHERE id=?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        pst.executeUpdate();
    }
}
