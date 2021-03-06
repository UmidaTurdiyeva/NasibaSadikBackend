package net.idrok.sadik.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mahsulot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 100, nullable = false)
    private String nom;
    private MahsulotUlchov mahsulotUlchov;
    private MahsulotTur mahsulotTur;
    private String info;

    

    public Mahsulot() {
    }
    
    public Mahsulot(Long id, String nom, MahsulotUlchov mahsulotUlchov, MahsulotTur mahsulotTur, String info) {
        this.id = id;
        this.nom = nom;
        this.mahsulotUlchov = mahsulotUlchov;
        this.mahsulotTur = mahsulotTur;
        this.info = info;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public MahsulotUlchov getMahsulotUlchov() {
        return mahsulotUlchov;
    }
    public void setMahsulotUlchov(MahsulotUlchov mahsulotUlchov) {
        this.mahsulotUlchov = mahsulotUlchov;
    }
    public MahsulotTur getMahsulotTur() {
        return mahsulotTur;
    }
    public void setMahsulotTur(MahsulotTur mahsulotTur) {
        this.mahsulotTur = mahsulotTur;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }


    
    
}
