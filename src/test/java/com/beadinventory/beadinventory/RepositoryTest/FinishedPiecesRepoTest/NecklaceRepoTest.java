package com.beadinventory.beadinventory.RepositoryTest.FinishedPiecesRepoTest;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.NecklaceRepo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.BEADING_WIRE;
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

    private Necklace necklace;

    @Before
    public void setUp() {
        List<String> brands = new ArrayList<>(Arrays.asList("Bead Gallery"));
        Bead bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20, "translucent purple with some white", 0.8, brands);
        Bead bead2 = new Bead(SWAROVSKI_CRYSTAL, BICONE, "black", 4, "good", 10, "",1, brands);
        Bead bead4 = new Bead(AMETHYST, ROUND, "purple", 6, "good", 15, "translucent purple with some white", 0.9, brands);
        Bead seeds = new Bead(SEED, SEED_E_LARGE, "black", 0, "good", 100, "good black large seed beads", .01, brands);
        Finding lobsterClasp2 = new Finding(LOBSTER_CLASP, BRIGHT_SILVER_PLATED, "medium", 4, .1, 10, brands);
        Finding splitRing = new Finding(SPLIT_RING, BRASS, "smallest", 1, .01, 25, brands);
        HashMap<Bead, Integer> beads =new HashMap<>();
        beads.put(bead1,4);
        beads.put(bead2,2);
        beads.put(bead4,3);
        beads.put(seeds,100);
        HashMap<Finding,Integer>findings =new HashMap<>();
        findings.put(lobsterClasp2,1);
        findings.put(splitRing,1);
        StringWire beadingWire =new StringWire(BEADING_WIRE, BRIGHT_SILVER_PLATED, "silver",".5 mm",7,"good",.1,"Beadalon");
        this.necklace = new Necklace(beads,findings, beadingWire, 20,3,1,"",true,true,40,LOBSTER_CLASP);
    }

    @Test
    public void testFindNecklacesByHasNaturalStonesTrue(){
        entityManager.persist(necklace);
        entityManager.flush();

        List<Necklace> list = mockNecklaceRepo.findNecklacesByHasNaturalStonesTrue();
        assertThat(list).contains(necklace);
    }

    @Test
    public void testFindNecklacesByHasSwarovskiTrue(){
        entityManager.persist(necklace);
        entityManager.flush();

        List<Necklace> list = mockNecklaceRepo.findNecklacesByHasSwarovskiTrue();
        assertThat(list).contains(necklace);
    }

}
