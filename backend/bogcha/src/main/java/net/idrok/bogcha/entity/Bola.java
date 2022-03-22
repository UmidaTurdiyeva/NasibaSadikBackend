package net.idrok.bogcha.entity;

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

    @Column(unique = true, length = 1000, nullable = false)
    private String ism;
    @Column(unique = true, length = 1000, nullable = false)
    private String familiya;
    @Column(unique = true, length = 1000, nullable = false)
    private String sharif;
    private Enum jinsi;
    
}
