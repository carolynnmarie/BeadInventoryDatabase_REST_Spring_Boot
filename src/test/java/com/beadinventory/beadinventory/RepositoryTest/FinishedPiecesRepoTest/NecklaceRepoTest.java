package com.beadinventory.beadinventory.RepositoryTest.FinishedPiecesRepoTest;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.*;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.REST.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.REST.Repository.FinishedPiecesRepos.NecklaceRepo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.StringWireCategory.BEADING_WIRE;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class NecklaceRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NecklaceRepo mockNecklaceRepo;

    private Bead bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20, "translucent purple with some white", 0.8, "bead landing");
    private Bead bead2 = new Bead(SWAROVSKI_CRYSTAL, BICONE, "black", 4, "good", 10, "",1, "Bead Gallery");
    private Bead bead4 = new Bead(AMETHYST, ROUND, "purple", 6, "good", 15, "translucent purple with some white", 0.9, "Bead Gallery");
    private Bead seeds = new Bead(SEED, SEED_E_LARGE, "black", 0, "good", 100, "good black large seed beads", .01, "Bead Gallery");
    private Finding lobsterClasp2 = new Finding(LOBSTER_CLASP, BRIGHT_SILVER_PLATED, 4, .1, 10, "Bead Gallery", "medium");
    private Finding splitRing = new Finding(SPLIT_RING, BRASS, 1, .01, 25, "Bead Gallery", "smallest");
    private HashMap<Bead, Integer> beads =new HashMap<>();
    private HashMap<Finding,Integer>findings =new HashMap<>();
    private StringWire beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm","good",.5,"Beadalon",
            "7 strand");
    private Necklace necklace;

    @Before
    public void setUp() {
        beads.put(bead1,4);
        beads.put(bead2,2);
        beads.put(bead4,3);
        beads.put(seeds,100);
        findings.put(lobsterClasp2,1);
        findings.put(splitRing,1);

        this.necklace = new Necklace(beads,findings, beadingWire, 20,3,1,"",true,true,40,LOBSTER_CLASP);
    }

    @Test
    public void testFindNecklacesByHasNaturalStonesTrue(){
        entityManager.persist(bead1);
        entityManager.persist(bead2);
        entityManager.persist(bead4);
        entityManager.persist(seeds);
        entityManager.persist(lobsterClasp2);
        entityManager.persist(splitRing);
        entityManager.persist(necklace);
        entityManager.flush();

        List<Necklace> list = mockNecklaceRepo.findNecklacesByHasNaturalStonesTrue();
        assertThat(list).contains(necklace);
    }

    @Test
    public void testFindNecklacesByHasSwarovskiTrue(){
        entityManager.persist(bead1);
        entityManager.persist(bead2);
        entityManager.persist(bead4);
        entityManager.persist(seeds);
        entityManager.persist(lobsterClasp2);
        entityManager.persist(splitRing);
        entityManager.persist(necklace);
        entityManager.flush();

        List<Necklace> list = mockNecklaceRepo.findNecklacesByHasSwarovskiTrue();
        assertThat(list).contains(necklace);
    }

}
