package net.idrok.sadik.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Enum getJins() {
        return jins;
    }

    public void setJins(Enum jins) {
        this.jins = jins;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getManzil() {
        return manzil;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }

    public Number getContact() {
        return contact;
    }

    public void setContact(Number contact) {
        this.contact = contact;
    }

    public Number getTulov() {
        return tulov;
    }

    public void setTulov(Number tulov) {
        this.tulov = tulov;
    }

    @Column(unique = true, length = 100, nullable = false)
    private String ism;
    @Column(unique = true, length = 100, nullable = false)
    private String familiya;
    @Column(unique = true, length = 100, nullable = false)
    private String sharif;
    @Column(unique = true, length = 100, nullable = false)
    private Enum jins;
    @Column(unique = true, length = 100, nullable = false)
    private LocalDate birthday;
    private String manzil;
    private Number contact;
    private Number tulov;

}
