package com.beadinventory.beadinventory.RepositoryTest.SuppliesRepoTest;

import com.beadinventory.beadinventory.REST.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.REST.Repository.SuppliesRepos.FindingRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.*;

import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class FindingRepoTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private FindingRepo mockFindingRepo;


    private Finding eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,5.08,5.08,20,"bead landing","thin");
    private Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,5.08,5.08,20,"bead landing","thin");

    @Test
    public void findFindingsByCategoryTest(){
        entityManager.persist(eyePin);
        entityManager.persist(headPin);
        entityManager.flush();

        List<Finding> list = mockFindingRepo.findFindingsByCategory(EYE_PIN);
        assertThat(list).containsExactly(eyePin);
    }

    @Test
    public void findFindingsByMaterialTest(){
        entityManager.persist(eyePin);
        entityManager.persist(headPin);
        entityManager.flush();

        List<Finding> list = mockFindingRepo.findFindingsByMaterial(BRIGHT_SILVER_PLATED);
        assertThat(list).containsExactly(eyePin, headPin);
    }
    @Test
    public void findFindingsByCategoryAndMaterial(){
        entityManager.persist(eyePin);
        entityManager.persist(headPin);
        entityManager.flush();

        List<Finding> list = mockFindingRepo.findFindingsByCategoryAndMaterial(HEAD_PIN,BRIGHT_SILVER_PLATED);
        assertThat(list).containsExactly(headPin);
    }


}