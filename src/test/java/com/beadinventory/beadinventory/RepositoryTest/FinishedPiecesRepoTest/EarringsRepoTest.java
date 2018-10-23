package com.beadinventory.beadinventory.RepositoryTest.FinishedPiecesRepoTest;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.EarringsRepo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.ROUND;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class EarringsRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EarringsRepo mockEarringsRepo;

    HashMap<Bead,Integer> beads = new HashMap<>();
    HashMap<Finding,Integer> findings = new HashMap<>();
    List<String> beadBrands = new ArrayList<>(Arrays.asList("Bead Gallery"));
    Bead bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"purple", 0.2,"Bead Gallery");
    List<String> findingBrands= new ArrayList<>(Arrays.asList("Beadalon","bead landing"));
    Finding eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,"Bead Gallery");
    Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,"Bead Gallery");

    private Earrings earring= new Earrings(beads,findings,15,"dangles",true);;

    @Before
    public void setUp(){
        beads.put(bead1,3);
        findings.put(eyePin,2);
        findings.put(headPin,1);
    }

    @Test
    public void findAllTest(){
        entityManager.persist(bead1);
        entityManager.persist(eyePin);
        entityManager.persist(headPin);
        entityManager.persist(earring);
        entityManager.flush();

        List<Earrings> earrings = mockEarringsRepo.findAll();
        assertThat(earrings).contains(earring);
    }

    @Test
    public void findByIdTest(){
        entityManager.persist(bead1);
        entityManager.persist(eyePin);
        entityManager.persist(headPin);
        Long earringId = entityManager.persistAndGetId(earring, Long.class);
        long id = earringId;
        entityManager.flush();

        Earrings earrings = mockEarringsRepo.findById(id);
        assertThat(earrings).isEqualTo(earring);
    }

    @Test
    public void findBySterlingSilverYorNTest(){
        entityManager.persist(bead1);
        entityManager.persist(eyePin);
        entityManager.persist(headPin);
        entityManager.persist(earring);
        entityManager.flush();

        List<Earrings> earrings = mockEarringsRepo.findEarringsBySterlingSilverYorNIsTrue();
        assertThat(earrings).contains(earring);
    }
}
