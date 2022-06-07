package com.Utis;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "otsenki")
public class Otsenki {
    private Integer id;
    private Integer otsenka;
    private String predmet;
    private Studentyi studentyi;

    public Otsenki() {
    }

    public Otsenki(Integer otsenka, String predmet, Studentyi studentyi) {
        this.otsenka = otsenka;
        this.predmet = predmet;
        this.studentyi = studentyi;
    }

    @Id
    @Column(name = "Id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "otsenka", nullable = false)
    public Integer getOtsenka() {
        return otsenka;
    }

    public void setOtsenka(Integer otsenka) {
        this.otsenka = otsenka;
    }

    @Column(name = "predmet", nullable = false, length = 120)
    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nomerZachetki", nullable = false)
    public Studentyi getStudentyi() {
        return this.studentyi;
    }

    public void setStudentyi(Studentyi studentyi) {
        this.studentyi = studentyi;
    }
}
