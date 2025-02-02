package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class LawCases {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String casename;
    @Column(nullable = false)
    private Long caseHappenTime;
    @OneToOne(cascade = CascadeType.ALL)
    private CaseSpecificInformation caseSpecificInformation;
    @OneToOne(cascade = CascadeType.ALL)
    private Procuratorate procuratorate;

    public LawCases() {
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setCaseSpecificInformation(CaseSpecificInformation caseSpecificInformation) {
        this.caseSpecificInformation = caseSpecificInformation;
    }

    public CaseSpecificInformation getCaseSpecificInformation() {
        return caseSpecificInformation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public void setCaseHappenTime(Long caseHappenTime) {
        this.caseHappenTime = caseHappenTime;
    }

    public Long getId() {
        return id;
    }

    public String getCasename() {
        return casename;
    }

    public Long getCaseHappenTime() {
        return caseHappenTime;
    }

}
