package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LawCases;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CasesRepositoryTest {
    @Autowired
    private CasesRepository casesRepository;
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

}