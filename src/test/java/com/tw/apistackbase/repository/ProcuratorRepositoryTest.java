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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProcuratorRepositoryTest {
    @Autowired
    private ProcuratorRepository procuratorRepository;
    @Autowired
    private ProcuratorateRepository procuratorateRepository;

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

    @Test
    public void should_return_true_imformation_when_search_given__procuratorate_id() {
        //given
        List<Procurator> procuratorsList=new ArrayList<>();
        Procurator procurator=new Procurator();
        procurator.setName("procurator");
        procuratorsList.add(procurator);
        procuratorRepository.save(procurator);
        Procurator procurator1=new Procurator();
        procurator1.setName("procurator1");
        procuratorRepository.save(procurator1);
        procuratorsList.add(procurator1);
        Procuratorate procuratorate=new Procuratorate();
        procuratorate.setName("procuratorate");
        procuratorate.setProcuratorsList(procuratorsList);
        procuratorateRepository.save(procuratorate);
        Long id=procuratorate.getId();

        //when
        Procuratorate procuratorate1=procuratorateRepository.findById(id).get();
        //then
        Assertions.assertEquals(id,procuratorate1.getId());
        Assertions.assertEquals(procuratorate.getName(),procuratorate1.getName());
        Assertions.assertEquals(procurator.getId(),procuratorate1.getProcuratorsList().get(0).getId());
        Assertions.assertEquals(procurator.getName(),procuratorate1.getProcuratorsList().get(0).getName());
        Assertions.assertEquals(procurator1.getId(),procuratorate1.getProcuratorsList().get(1).getId());
        Assertions.assertEquals(procurator1.getName(),procuratorate1.getProcuratorsList().get(1).getName());

    }
}
