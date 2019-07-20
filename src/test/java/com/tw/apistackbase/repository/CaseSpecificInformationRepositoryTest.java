package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CaseSpecificInformation;
import com.tw.apistackbase.entity.LawCases;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//Story2
public class CaseSpecificInformationRepositoryTest {
    @Autowired
    private CaseSpecificInformationRepository caseSpecificInformationRepository;
    @Autowired
    private  CasesRepository casesRepository;
    @BeforeEach
    public void deleteAll(){
        caseSpecificInformationRepository.deleteAll();
    }
//AC1
    @Test
    public void should_return_detial_imformation_when_find_given_not_null_important_document() {
        //given
        CaseSpecificInformation caseSpecificInformation=new CaseSpecificInformation();
        caseSpecificInformation.setObjectiveAspectDescription("XXXXXXXXXXXXXXXXXXXXXXXXXX");
        caseSpecificInformation.setSubjectiveAspectDescription("XXXXXXX");
        //when
        caseSpecificInformationRepository.save(caseSpecificInformation);
        List<CaseSpecificInformation> caseSpecificInformationsList=caseSpecificInformationRepository.findAll();
        //then
        Assertions.assertEquals(caseSpecificInformation.getId(),caseSpecificInformationsList.get(0).getId());
        Assertions.assertEquals(caseSpecificInformation.getObjectiveAspectDescription(),caseSpecificInformationsList.get(0).getObjectiveAspectDescription());
        Assertions.assertEquals(caseSpecificInformation.getSubjectiveAspectDescription(),caseSpecificInformationsList.get(0).getSubjectiveAspectDescription());
    }
//Ac2
    @Test
    public void should_return_detial_imformation_when_search_given_id() {
        //given
        CaseSpecificInformation caseSpecificInformation=new CaseSpecificInformation();
        caseSpecificInformation.setObjectiveAspectDescription("XXXXXXXXXXXXXXXXXXXXXXXXXX");
        caseSpecificInformation.setSubjectiveAspectDescription("XXXXXXX");
        Long id=caseSpecificInformation.getId();
        //when
        caseSpecificInformationRepository.save(caseSpecificInformation);
        List<CaseSpecificInformation> caseSpecificInformationsList=caseSpecificInformationRepository.findAll();
        caseSpecificInformationsList.stream().filter(item->item.getId()==id);
        //then
        Assertions.assertEquals(caseSpecificInformation.getId(),caseSpecificInformationsList.get(0).getId());
        Assertions.assertEquals(caseSpecificInformation.getObjectiveAspectDescription(),caseSpecificInformationsList.get(0).getObjectiveAspectDescription());
        Assertions.assertEquals(caseSpecificInformation.getSubjectiveAspectDescription(),caseSpecificInformationsList.get(0).getSubjectiveAspectDescription());
    }

//Ac3
    @Test
    public void should_return_true_imformation_when_search_given_case_id() {
        //given
        CaseSpecificInformation caseSpecificInformation=new CaseSpecificInformation();
        caseSpecificInformation.setObjectiveAspectDescription("XXXXXXXXXXXXXXXXXXXXXXXXXX");
        caseSpecificInformation.setSubjectiveAspectDescription("XXXXXXX");
        caseSpecificInformationRepository.save(caseSpecificInformation);
        LawCases lawCases=new LawCases();
        lawCases.setCasename("case1");
        lawCases.setCaseHappenTime(new Date().getTime());
        lawCases.setCaseSpecificInformation(caseSpecificInformation);
        casesRepository.save(lawCases);
        Long id=lawCases.getId();
//Ac4
        //when
        List<LawCases> lawCasesList=casesRepository.findAll();
        lawCasesList.stream().filter(item->item.getId()==id);
        //then
        LawCases lawCases1=lawCasesList.get(0);
        Assertions.assertEquals(id,lawCases1.getId());
        Assertions.assertEquals(lawCases.getCasename(),lawCases1.getCasename());
        Assertions.assertEquals(lawCases.getCaseHappenTime(),lawCases1.getCaseHappenTime());
        Assertions.assertEquals(caseSpecificInformation.getId(),lawCases1.getCaseSpecificInformation().getId());
        Assertions.assertEquals(caseSpecificInformation.getObjectiveAspectDescription(),lawCases1.getCaseSpecificInformation().getObjectiveAspectDescription());
        Assertions.assertEquals(caseSpecificInformation.getSubjectiveAspectDescription(),lawCases1.getCaseSpecificInformation().getSubjectiveAspectDescription());
    }

    @Test
    public void should_return_true_detail_imformation_when_search_given_case_id() {
        //given
        CaseSpecificInformation caseSpecificInformation=new CaseSpecificInformation();
        caseSpecificInformation.setObjectiveAspectDescription("XXXXXXXXXXXXXXXXXXXXXXXXXX");
        caseSpecificInformation.setSubjectiveAspectDescription("XXXXXXX");
        caseSpecificInformationRepository.save(caseSpecificInformation);
        LawCases lawCases=new LawCases();
        lawCases.setCasename("case1");
        lawCases.setCaseHappenTime(new Date().getTime());
        lawCases.setCaseSpecificInformation(caseSpecificInformation);
        casesRepository.save(lawCases);
        Long id=lawCases.getId();

        //when
        LawCases lawCases1=casesRepository.findById(id).get();
        //then
        assertEquals(caseSpecificInformation,lawCases1.getCaseSpecificInformation());

    }




}