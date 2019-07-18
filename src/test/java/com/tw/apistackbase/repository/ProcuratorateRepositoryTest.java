package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LawCases;
import com.tw.apistackbase.entity.Procuratorate;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProcuratorateRepositoryTest {
    @Autowired
    private ProcuratorateRepository procuratorateRepository;
    @Autowired
    private LawCases lawCases;

    @Test
    public void should_return_true_imformation_when_search_given__procuratorate_id() {
        //givem
        Procuratorate procuratorate=new Procuratorate();
        procuratorate.setName("procuratorate1");
        procuratorateRepository.save(procuratorate);
        Long id=procuratorate.getId();
        //when
        Procuratorate procuratorate1=procuratorateRepository.findById(id).get();
        //then
        Assertions.assertEquals(id,procuratorate1.getId());
        Assertions.assertEquals(procuratorate.getName(),procuratorate1.getName());

    }

    /*@Test
    public void should_return_true_imformation_when_search_given__lawcase_id() {
        //givem
        Procuratorate procuratorate=new Procuratorate();
        procuratorate.setName("procuratorate2");
        procuratorateRepository.save(procuratorate);
        LawCases lawCases=new LawCases();

        //when
        Procuratorate procuratorate1=procuratorateRepository.findById(id).get();
        //then
        Assertions.assertEquals(id,procuratorate1.getId());
        Assertions.assertEquals(procuratorate.getName(),procuratorate1.getName());

    }*/
}