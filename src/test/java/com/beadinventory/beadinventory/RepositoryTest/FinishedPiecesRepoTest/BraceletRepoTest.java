package com.beadinventory.beadinventory.RepositoryTest.FinishedPiecesRepoTest;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Bracelet;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.BraceletRepo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.FinishedPieces.BraceletType.MEDICAL;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.LOBSTER_CLASP;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.ROUND;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.BEADING_WIRE;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class BraceletRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BraceletRepo mockBraceletRepo;

    private Bracelet bracelet;

    @Before
    public void setUp(){
        TreeSet<String> brands = new TreeSet<>(Arrays.asList("Bead Gallery"));
        Bead bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"translucent purple with some white",
                0.2,brands);
        Bead bead2 = new Bead(JASPER,ROUND, "black", 4, "good", 10, "",0.1,brands);
        Bead bead4 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white",
                0.2,brands);
        Finding lobsterClasp2 = new Finding(LOBSTER_CLASP,DULL_SILVER_PLATED,"medium",4,.1,10,brands);
        LinkedHashMap<Bead,Integer> beads = new LinkedHashMap<>();
        beads.put(bead1,4);
        beads.put(bead2,2);
        beads.put(bead4,3);
        LinkedHashMap<Finding,Integer> findings = new LinkedHashMap<>();
        findings.put(lobsterClasp2,2);
        StringWire beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm",7,"good",.5,"Beadalon");

        this.bracelet = new Bracelet(beads,findings,15,"",MEDICAL,beadingWire,false,true,4);
    }

    @Test
    public void testFindBraceletsByBraceletType(){
        entityManager.persist(bracelet);
        entityManager.flush();

        List<Bracelet> list = mockBraceletRepo.findBraceletsByBraceletType(MEDICAL);
        assertThat(list).contains(bracelet);
    }

    @Test
    public void testGetById(){
        long id = entityManager.persistAndGetId(bracelet,Long.class);
        entityManager.flush();

        Bracelet bracelet2 = mockBraceletRepo.findById(id);
        assertThat(bracelet2).isEqualToComparingFieldByField(bracelet);
    }
}
//    List<Bracelet> findBraceletsByBraceletType(BraceletType braceletType);