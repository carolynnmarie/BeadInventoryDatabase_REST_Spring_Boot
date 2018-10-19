package com.beadinventory.beadinventory.RepositoryTest.FinishedPiecesRepoTest;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
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

    private Earrings earring;

    @Before
    public void setUp(){
        LinkedHashMap<Bead,Integer> beads = new LinkedHashMap<>();
        TreeSet<String> beadBrands = new TreeSet<>(Arrays.asList("Bead Gallery"));
        Bead bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"purple", 0.2,beadBrands);
        beads.put(bead1,3);
        LinkedHashMap<Finding,Integer> findings = new LinkedHashMap<>();
        TreeSet<String> findingBrands= new TreeSet<>(Arrays.asList("Beadalon","bead landing"));
        Finding eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,findingBrands);
        Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,beadBrands);
        findings.put(eyePin,2);
        findings.put(headPin,1);

        this.earring = new Earrings(beads,findings,15,"dangles",true);

    }

    @Test
    public void findAllTest(){
        entityManager.persist(earring);
        entityManager.flush();

        List<Earrings> earrings = mockEarringsRepo.findAll();
        assertThat(earrings).contains(earring);
    }

    @Test
    public void findByIdTest(){
        Long earringId = entityManager.persistAndGetId(earring, Long.class);
        long id = earringId;
        entityManager.flush();

        Earrings earrings = mockEarringsRepo.findById(id);
        assertThat(earrings).isEqualTo(earring);
    }

    @Test
    public void findBySterlingSilverYorNTest(){
        entityManager.persist(earring);
        entityManager.flush();

        List<Earrings> earrings = mockEarringsRepo.findEarringsBySterlingSilverYorNIsTrue();
        assertThat(earrings).contains(earring);
    }
}
