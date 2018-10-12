package com.beadinventory.beadinventory.RepositoryTest.SuppliesRepoTest;

import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.StringWireRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import java.util.List;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class StringWireRepoTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private StringWireRepo mockSMRepo;

    private StringWire beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm",7,"good",.5,"Beadalon");
    private StringWire brassChain = new StringWire(CHAIN,BRASS,"brass","thin",1,"okay",.5,"bead landing");
    private StringWire leatherCord = new StringWire(CORD,LEATHER,"black","medium",1,"okay",.5,"bead landing");

    @Test
    public void findStringingMaterialsBySMCategoryTest(){
        entityManager.persist(beadingWire);
        entityManager.persist(brassChain);
        entityManager.persist(leatherCord);
        entityManager.flush();

        List<StringWire> list = mockSMRepo.findStringingMaterialsByStringWireCategory(CORD);
        assertThat(list).containsExactly(leatherCord);
    }

    @Test
    public void findStringingMaterialsByMaterialTest() {
        entityManager.persist(beadingWire);
        entityManager.persist(brassChain);
        entityManager.persist(leatherCord);
        entityManager.flush();

        List<StringWire> list = mockSMRepo.findStringingMaterialsByMaterial(BRASS);
        assertThat(list).containsExactly(brassChain);
    }

    }
/*
    List<StringWire> findStringingMaterialsByStringWireCategory(StringWireCategory category);
    List<StringWire> findStringingMaterialsByMaterial(Material material);
 */