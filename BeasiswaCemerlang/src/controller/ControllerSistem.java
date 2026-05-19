package controller;

import model.*;
import view.MainView;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class ControllerSistem {
    private MainView view;
    private Connector db;
    private String namaLama = "";
    
    public ControllerSistem(MainView view){
        this.view = view;
        this.db = new Connector();
        
        tampilData();
        
        this.view.btnAdd.addActionListener(e -> tambahData());
        this.view.btnUpdate.addActionListener(e -> updateData());
        this.view.btnDelete.addActionListener(e -> deleteData());
        this.view.btnClear.addActionListener(e -> clearData());
        this.view.tabelData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                pilihDataTabel();
            }
        });
    }
}

private void tampilData(){
    try{
        DefaultTableModel model = (DefaultTableModel) view tabelData.getModel();
        model.setRowCount(0);
        
        ResultSet rs = double.getAllData();
        while(rs.next()){
            Object[] row = {
                rs.getInt("id");
                rs.getString("nama");
                rs.getString("jalur");
                rs.getDouble("nilai_ipk");
                rs.getDouble("nilai_portofolio");
                rs.getDouble("nilai_wawancara");
                rs.getDouble("nilai_akhir");
                rs.getString("status");
            };
            model.addRow(row);
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(view, "Gagal memuat data: "+e.getMessage());
    }
}

private void tambahData(){
    try{
        String nama = view.tfNama.getText();
        String jalur = view.cmbJalur.getSelectedItem().toString();
        double nilai_ipk = Double.parseDouble(view.tfIPK.getText());
        double nilai_portofolio = Double.parseDouble(view.tfPortofolio.getText());
        double nilai_wawancara = Double.parseDouble(view.tfWawancara.getText());

        if (nilai_ipk<0 || nilai_ipk>100 || nilai_portofolio<0 || nilai_portofolio>100 || nilai_wawancara<0 || nilai_wawancara>100){
            throw new Exception("Nilai harus antara 0-100");
        }
        Beasiswa bs = new Beasiswa(nama, nilai_ipk, nilai_portofolio, nilai_wawancara, jalur);
        db.insertData(bs);
        
        JOptionPane.showMessageDialog(view, "Berhasil ditambahkan! Status: "+bs.tentukanStatus());
        clearData();
        tampilData();
    }catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(view, "Input harus berupa angka!");
    }catch(Exception e){
        JOptionPane.showMessageDialog(view, ex.getMessage());
}

private void updateData(){

}

private void deleteData(){

}

private void clearData(){

}

private void pilihDataTabel(){

}