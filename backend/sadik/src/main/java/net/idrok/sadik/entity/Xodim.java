package net.idrok.sadik.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Xodim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 100, nullable = false)
    private String ism;
    @Column(unique = true, length = 100, nullable = false)
    private String familiya;
    @Column(unique = true, length = 100, nullable = false)
    private String sharif;
    private String info;  


    public Xodim() {
    }

    public Xodim(Long id, String ism, String familiya, String sharif, String info) {
        this.id = id;
        this.ism = ism;
        this.familiya = familiya;
        this.sharif = sharif;
        this.info = info;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIsm() {
        return ism;
    }
    public void setIsm(String ism) {
        this.ism = ism;
    }
    public String getFamiliya() {
        return familiya;
    }
    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }
    public String getSharif() {
        return sharif;
    }
    public void setSharif(String sharif) {
        this.sharif = sharif;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    
    
}
