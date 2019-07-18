package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Procurator;
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
public class ProcuratorRepositoryTest {
    @Autowired
    private ProcuratorRepository procuratorRepository;

    @Test
    public void should_return_true_imformation_when_search_given__procurator_id() {
        //given
        Procurator procurator=new Procurator();
        procurator.setName("procurator");
        procuratorRepository.save(procurator);
        Long id=procurator.getId();
        //when
        Procurator procurator1=procuratorRepository.findById(id).get();
        //then
        Assertions.assertEquals(id,procurator1.getId());
        Assertions.assertEquals(procurator.getName(),procurator1.getName());

    }
}