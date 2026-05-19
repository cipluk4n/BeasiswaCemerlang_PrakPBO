package model;

public class Pendaftar {
    private String nama;
    private double nilaiIPK;
    private double nilaiPortofolio;
    private double nilaiWawancara;
    private double nilaiAkhir;
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getNilaiIPK() {
        return nilaiIPK;
    }

    public void setNilaiIPK(double nilaiIPK) {
        this.nilaiIPK = nilaiIPK;
    }

    public double getNilaiPortofolio() {
        return nilaiPortofolio;
    }

    public void setNilaiPortofolio(double nilaiPortofolio) {
        this.nilaiPortofolio = nilaiPortofolio;
    }

    public double getNilaiWawancara() {
        return nilaiWawancara;
    }

    public void setNilaiWawancara(double nilaiWawancara) {
        this.nilaiWawancara = nilaiWawancara;
    }

    public double getNilaiAkhir() {
        return nilaiAkhir;
    }

    public void setNilaiAkhir(double nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }
    
    public Pendaftar(String nama, double nilaiIPK, double nilaiPorfotolio,
            double nilaiWawancara, double nilaiAkhir){
        this.nama = nama;
        this.nilaiIPK = nilaiIPK;
        this.nilaiPortofolio = nilaiPorfotolio;
        this.nilaiWawancara = nilaiWawancara;
        this.nilaiAkhir = nilaiAkhir;
    }
}
