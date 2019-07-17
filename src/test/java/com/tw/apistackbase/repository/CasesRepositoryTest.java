package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LawCases;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CasesRepositoryTest {
    private CasesRepository casesRepository;
//AC1
    @Test
    public void shoule_throw_exception_when_save_given_null_casehappentime(){
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
}