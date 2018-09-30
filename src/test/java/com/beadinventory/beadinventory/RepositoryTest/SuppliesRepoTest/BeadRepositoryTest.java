package com.beadinventory.beadinventory.RepositoryTest.SuppliesRepoTest;


import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.ROUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;




@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class BeadRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BeadRepo beadRepo;

    private Bead bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"translucent purple with some white",
            0.2,"Bead Gallery");
    private Bead bead2 = new Bead(JASPER,ROUND, "black", 4, "good", 10, "",0.1,"Bead Gallery");
    private Bead bead3  = new Bead(STONE, ROUND,"tan",6,"ok",7,"with design cut into bead",0.05,
            "Bead Gallery");
    private Bead bead4 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white",
            0.2,"Bead Gallery");
    private Bead bead5 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple with some white",
            0.2,"Bead Gallery");

    @Test
    public void findBeadsByMaterial() {
        entityManager.persist(bead1);
        entityManager.persist(bead2);
        entityManager.persist(bead3);
        entityManager.persist(bead4);
        entityManager.persist(bead5);
        entityManager.flush();

        Iterable<Bead> list = beadRepo.findByMaterial(AMETHYST);
 //       Iterable<Bead> expected = Arrays.asList(bead1,bead4,bead5);

        assertThat(list).containsExactly(bead1,bead4,bead5);
    }

    @Test
    public void findBeadsByMaterialAndColor() {
    }

    @Test
    public void findBeadsByMaterialAndSize() {
    }

    @Test
    public void findBeadsByShape() {
    }

    @Test
    public void findByQuantityIsLessThan() {

    }
}