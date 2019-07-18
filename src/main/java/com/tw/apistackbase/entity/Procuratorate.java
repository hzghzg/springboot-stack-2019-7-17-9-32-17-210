package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Procurator> procuratorsList=new ArrayList<>();

    public Procuratorate() {
    }

    public void setProcuratorsList(List<Procurator> procuratorsList) {
        this.procuratorsList = procuratorsList;
    }

    public List<Procurator> getProcuratorsList() {
        return procuratorsList;
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
