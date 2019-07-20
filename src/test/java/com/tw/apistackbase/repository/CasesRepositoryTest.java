package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LawCases;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//Story1
public class CasesRepositoryTest {
    @Autowired
    private CasesRepository casesRepository;
    @BeforeEach
    public void deleteall(){
        casesRepository.deleteAll();
    }
//AC1
    @Test
    public void should_throw_exception_when_save_given_null_casehappentime(){
        //given
        LawCases lawCase1=new LawCases();
        lawCase1.setCasename("case1");

        //when
        //then
        Assertions.assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                casesRepository.saveAndFlush(lawCase1);
            }
        });
    }
    @Test
    public void should_throw_exception_when_save_given_null_casename(){
        //given
        LawCases lawCase1=new LawCases();
        lawCase1.setCaseHappenTime(new Date().getTime());
        //when
        //then
        Assertions.assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                casesRepository.saveAndFlush(lawCase1);
            }
        });
    }
    @Test
    public void should_return_casename_when_save_given_notnull_casename_and_notnull_casehappentime(){

        //given
        LawCases lawCase1=new LawCases();
        lawCase1.setCasename("case1");
        lawCase1.setCaseHappenTime(new Date().getTime());

        //when
        casesRepository.save(lawCase1);
        List<LawCases> lawCases=casesRepository.findAll();

        //then
        Assertions.assertEquals(1, lawCases.size());
        Assertions.assertEquals("case1",lawCases.get(0).getCasename());
    }
    //AC2
    @Test
    public void should_return_allcontent_when_find_given_id(){

        //given
        LawCases lawCase1=new LawCases();
        lawCase1.setCasename("case1");
        lawCase1.setCaseHappenTime(new Date().getTime());
        casesRepository.save(lawCase1);
        Long id=casesRepository.findAll().get(0).getId();

        //when
        LawCases lawCase=casesRepository.findById(id).get();

        //then
        Assertions.assertEquals(id,lawCase.getId());
        Assertions.assertEquals("case1",lawCase.getCasename());
        Assertions.assertEquals(casesRepository.findAll().get(0).getCaseHappenTime(),lawCase.getCaseHappenTime());

    }
    //AC3
    @Test
    public void should_return_allcontent_orderby_casehappentime_when_find_given_id(){

        //given
        LawCases lawCase1=new LawCases();
        lawCase1.setCasename("case"+ UUID.randomUUID().toString());
        lawCase1.setCaseHappenTime(new Date().getTime());
        casesRepository.save(lawCase1);
        System.out.println(lawCase1.getId());
        LawCases lawCase2=new LawCases();
        lawCase2.setCasename("case"+ UUID.randomUUID().toString());
        lawCase2.setCaseHappenTime(new Date().getTime());
        casesRepository.save(lawCase2);
        System.out.println(lawCase2.getId());
        //Long id=casesRepository.findAll().get(0).getId();

        //when
        //LawCases lawCase=casesRepository.findById(id).get();
        List<LawCases> caseList=casesRepository.findAll(Sort.by("caseHappenTime").descending());

        //then
        Assertions.assertEquals(lawCase2.getId(),caseList.get(0).getId());
        Assertions.assertEquals(lawCase2.getCasename(),caseList.get(0).getCasename());
        Assertions.assertEquals(lawCase2.getCaseHappenTime(),caseList.get(0).getCaseHappenTime());

    }
    //AC4
    @Test
    public void should_return_allcases_when_find_given_name(){

        //given
        LawCases lawCase1=new LawCases();
        lawCase1.setCasename("case2");
        lawCase1.setCaseHappenTime(new Date().getTime());
        casesRepository.save(lawCase1);
        LawCases lawCase2=new LawCases();
        lawCase2.setCasename("case2");
        lawCase2.setCaseHappenTime(new Date().getTime());
        casesRepository.save(lawCase2);
        LawCases lawCase3=new LawCases();
        lawCase3.setCasename("case3");
        lawCase3.setCaseHappenTime(new Date().getTime());
        casesRepository.save(lawCase3);

        //when
        List<LawCases> caseList=casesRepository.findAll();
        caseList.stream().filter(item->item.getCasename()=="case2");

        //then
        Assertions.assertEquals(lawCase1.getId(),caseList.get(0).getId());
        Assertions.assertEquals(lawCase1.getCasename(),caseList.get(0).getCasename());
        Assertions.assertEquals(lawCase1.getCaseHappenTime(),caseList.get(0).getCaseHappenTime());
        Assertions.assertEquals(lawCase2.getId(),caseList.get(1).getId());
        Assertions.assertEquals(lawCase2.getCasename(),caseList.get(1).getCasename());
        Assertions.assertEquals(lawCase2.getCaseHappenTime(),caseList.get(1).getCaseHappenTime());

    }
//AC5
    @Test
    public void should_return_true_size_when_delete_given_id(){

        //given
        LawCases lawCase1=new LawCases();
        lawCase1.setCasename("case2");
        lawCase1.setCaseHappenTime(new Date().getTime());
        casesRepository.save(lawCase1);
        LawCases lawCase2=new LawCases();
        lawCase2.setCasename("case2");
        lawCase2.setCaseHappenTime(new Date().getTime());
        casesRepository.save(lawCase2);
        LawCases lawCase3=new LawCases();
        lawCase3.setCasename("case3");
        lawCase3.setCaseHappenTime(new Date().getTime());
        casesRepository.save(lawCase3);

        //when
        casesRepository.deleteById(lawCase1.getId());

        //then
        Assertions.assertEquals(2,casesRepository.findAll().size());
    }






}