package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = false)
    private String name;

    public Procuratorate() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
