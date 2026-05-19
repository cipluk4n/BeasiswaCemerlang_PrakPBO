package model;

public class Beasiswa extends Pendaftar implements Penilaian{
    private String jalur;

    public Beasiswa(int id, String nama, double nilaiIPK, double nilaiPortofolio, 
            double nilaiWawancara, String jalur) {
        super(id, nama, nilaiIPK, nilaiPortofolio, nilaiWawancara);
        this.jalur = jalur;
    }

    @Override
    public double hitungNilaiAkhir() {
//1. Jalur akademik : nilai IPK (50%), portofolio (20%), wawancara (30%).
//2. Jalur non-akademik : nilai IPK (20%), portofolio (50%), wawancara (30%).
        
        if(jalur == akademik){
            return (getNilaiIPK()*0.50 + getNilaiPortofolio()*0.20 + getNilaiWawancara()*0.30);
        }
        else if (jalur == nonAkademik){
            return (getNilaiIPK()*0.20 + getNilaiPortofolio()*0.50 + getNilaiWawancara()*0.30);
        }    
    }
    public String tentukanStatus(){
        if(hitungNilaiAkhir()>=82.50){
            return "LULUS";
        }else{
            return "TIDAK LULUS";
        }
    }
    public String getJalur(){
        return jalur;
    }
}
