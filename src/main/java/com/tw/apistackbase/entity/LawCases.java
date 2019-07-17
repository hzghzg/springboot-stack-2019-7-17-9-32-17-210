package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class LawCases {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String casename;
    @Column(nullable = false)
    private long caseHappenTime;

    public LawCases() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public void setCaseHappenTime(long caseHappenTime) {
        this.caseHappenTime = caseHappenTime;
    }

    public long getId() {
        return id;
    }

    public String getCasename() {
        return casename;
    }

    public long getCaseHappenTime() {
        return caseHappenTime;
    }

}
