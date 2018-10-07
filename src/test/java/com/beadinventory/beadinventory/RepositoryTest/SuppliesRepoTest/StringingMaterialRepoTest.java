package com.beadinventory.beadinventory.RepositoryTest.SuppliesRepoTest;

import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.StringingMaterialRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import java.util.List;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class StringingMaterialRepoTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private StringingMaterialRepo mockSMRepo;

    private StringingMaterial beadingWire = new StringingMaterial(BEADING_WIRE,BRIGHT_SILVER_PLATED,".5 mm",7,"good",.5,"Beadalon");
    private StringingMaterial brassChain = new StringingMaterial(CHAIN,BRASS,"thin",1,"okay",.5,"bead landing");
    private StringingMaterial leatherCord = new StringingMaterial(CORD,LEATHER,"medium",1,"okay",.5,"bead landing");

    @Test
    public void findStringingMaterialsBySMCategoryTest(){
        entityManager.persist(beadingWire);
        entityManager.persist(brassChain);
        entityManager.persist(leatherCord);
        entityManager.flush();

        List<StringingMaterial> list = mockSMRepo.findStringingMaterialsBySMCategory(CORD);
        assertThat(list).containsExactly(leatherCord);
    }

    @Test
    public void findStringingMaterialsByMaterialTest() {
        entityManager.persist(beadingWire);
        entityManager.persist(brassChain);
        entityManager.persist(leatherCord);
        entityManager.flush();

        List<StringingMaterial> list = mockSMRepo.findStringingMaterialsByMaterial(BRASS);
        assertThat(list).containsExactly(brassChain);
    }

    }
/*
    List<StringingMaterial> findStringingMaterialsBySMCategory(StringingMaterialCategory category);
    List<StringingMaterial> findStringingMaterialsByMaterial(Material material);
 */