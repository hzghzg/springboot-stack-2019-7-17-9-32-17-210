package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class CaseSpecificInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String objectiveAspectDescription;

    @Column(nullable = false)
    private String subjectiveAspectDescription;

    public CaseSpecificInformation() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setObjectiveAspectDescription(String objectiveAspectDescription) {
        this.objectiveAspectDescription = objectiveAspectDescription;
    }

    public void setSubjectiveAspectDescription(String subjectiveAspectDescription) {
        this.subjectiveAspectDescription = subjectiveAspectDescription;
    }

    public Long getId() {
        return id;
    }

    public String getObjectiveAspectDescription() {
        return objectiveAspectDescription;
    }

    public String getSubjectiveAspectDescription() {
        return subjectiveAspectDescription;
    }
}
