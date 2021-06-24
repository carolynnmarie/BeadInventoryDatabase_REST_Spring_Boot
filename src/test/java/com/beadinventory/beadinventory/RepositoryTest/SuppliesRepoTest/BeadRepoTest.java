package com.beadinventory.beadinventory.RepositoryTest.SuppliesRepoTest;


import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Repository.SuppliesRepos.BeadRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class BeadRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BeadRepo beadRepo;

    List<String> brands = new ArrayList<>(Arrays.asList("Bead Gallery"));
    private Bead bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20, "translucent purple with some white", 0.2,"bead landing");
    private Bead bead2 = new Bead(JASPER,ROUND, "black", 4, "good", 10, "", 0.1,"bead landing");
    private Bead bead3  = new Bead(STONE, RONDELLE,"tan",6,"ok",7, "with design cut into bead",0.05, "bead landing");
    private Bead bead4 = new Bead(AMETHYST, ROUND,"purple",6,"good",15, "translucent purple with some white", 0.2,"bead landing");
    private Bead bead5 = new Bead(AMETHYST, ROUND,"light purple",4,"poor",10, "translucent purple with some white", 0.2,"bead landing");


    @Test
    public void findBeadsByMaterialTest() {
        entityManager.persist(bead1);
        entityManager.persist(bead2);
        entityManager.persist(bead3);
        entityManager.persist(bead4);
        entityManager.persist(bead5);
        entityManager.flush();

        List<Bead> list = beadRepo.findByMaterial(AMETHYST);

        assertThat(list).containsExactly(bead1,bead4,bead5);
    }


    @Test
    public void findBeadsByMaterialAndSizeTest() {
        entityManager.persist(bead1);
        entityManager.persist(bead2);
        entityManager.persist(bead3);
        entityManager.persist(bead4);
        entityManager.persist(bead5);
        entityManager.flush();

        List<Bead> list = beadRepo.findByMaterialAndSizeMM(JASPER,4);
        assertThat(list).containsExactly(bead2);
    }

    @Test
    public void findByQuantityIsLessThanTest() {
        entityManager.persist(bead1);
        entityManager.persist(bead2);
        entityManager.persist(bead3);
        entityManager.persist(bead4);
        entityManager.persist(bead5);
        entityManager.flush();

        List<Bead> list = beadRepo.findByQuantityIsLessThan(12);
        assertThat(list).containsExactly(bead2,bead3,bead5);
    }

    @Test
    public void findAllOrderByMaterialTest(){
        entityManager.persist(bead1);
        entityManager.persist(bead2);
        entityManager.persist(bead3);
        entityManager.persist(bead4);
        entityManager.persist(bead5);
        entityManager.flush();

        List<Bead> list = beadRepo.findAllOrderByMaterial();
        assertThat(list).containsExactly(bead1,bead4,bead5,bead2,bead3);
    }

    @Test
    public void getBeadByIdTest(){
        long id = entityManager.persistAndGetId(bead1,Long.class);
        entityManager.flush();

        Bead bead = beadRepo.findById(id);
        assertThat(bead).isEqualTo(bead1);
    }

    @Test
    public void saveTest(){
        entityManager.persist(bead1);
        entityManager.flush();

        Bead bead = beadRepo.save(bead1);
        assertThat(bead).isEqualTo(bead1);
    }

    @Test
    public void getBeIdTest2(){
        Long id = entityManager.persistAndGetId(bead2,Long.class);
        entityManager.flush();

        Optional<Bead> oBead = beadRepo.findById(id);
        assertThat(oBead).contains(bead2);
    }
}