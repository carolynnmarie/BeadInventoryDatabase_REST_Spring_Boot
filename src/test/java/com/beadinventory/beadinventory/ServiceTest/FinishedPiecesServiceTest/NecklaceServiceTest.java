package com.beadinventory.beadinventory.ServiceTest.FinishedPiecesServiceTest;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.NecklaceRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.NecklaceService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.*;

@RunWith(SpringRunner.class)
public class NecklaceServiceTest {

    @InjectMocks
    NecklaceService mockService;

    @Mock
    NecklaceRepo mockRepo;
    @Mock
    BeadRepo beadRepo;

    private Bead bead1;
    private Bead bead2;
    private Bead bead4;
    private Bead seeds;
    private Bead sWBead;
    private Finding lobsterClasp2;
    private Finding splitRing;
    private HashMap<Bead, Integer> beads;
    private HashMap<Finding, Integer> findings;
    private StringWire beadingWire;
    private HashMap<Bead, Integer> beads2;
    private Necklace necklace;
    private Necklace necklace2;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        List<String> brands = new ArrayList<>(Arrays.asList("Bead Gallery"));
        this.bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20, "translucent purple with some white", 0.8, brands);
        this.bead2 = new Bead(JASPER, ROUND, "black", 4, "good", 10, "", 0.6, brands);
        this.bead4 = new Bead(AMETHYST, ROUND, "purple", 6, "good", 15, "translucent purple with some white", 0.9, brands);
        this.seeds = new Bead(SEED,SEED_E_LARGE,"black",0,"good",100,"good black large seed beads",.01,brands);
        this.sWBead = new Bead(SWAROVSKI_CRYSTAL, BICONE, "blue", 4, "good", 10, "",1, brands);
        this.lobsterClasp2 = new Finding(LOBSTER_CLASP, BRIGHT_SILVER_PLATED, "medium", 4, .1, 10, brands);
        this.splitRing = new Finding(SPLIT_RING, BRASS, "smallest", 1, .01, 25, brands);
        this.beads = new HashMap<>();
        beads.put(bead1, 4);
        beads.put(bead2, 2);
        beads.put(bead4, 3);
        beads.put(seeds, 100);
        this.findings = new HashMap<>();
        findings.put(lobsterClasp2, 1);
        findings.put(splitRing,1);
        this.beadingWire = new StringWire(BEADING_WIRE, BRIGHT_SILVER_PLATED, "silver", ".5 mm", 7, "good", .1, "Beadalon");
        this.necklace = new Necklace(beads,findings,beadingWire,20,3,1,"",true,false,40,LOBSTER_CLASP);
        this.beads2 = new HashMap<>();
        beads2.put(seeds, 100);
        beads2.put(sWBead, 5);
        beads2.put(bead4, 8);
        this.necklace2 = new Necklace(beads2,findings,beadingWire,21.0,4,1.25,"",true,true,45,LOBSTER_CLASP);
    }

    @Test
    public void getAllWithNaturalStonesTest(){
        List<Necklace> list = new ArrayList<>(Arrays.asList(necklace,necklace2));
        given(mockRepo.findNecklacesByHasNaturalStonesTrue()).willReturn(list);

        ResponseEntity<List<Necklace>> expected = new ResponseEntity<>(list, OK);
        ResponseEntity<List<Necklace>> actual = mockService.getAllWithNaturalStones();

        verify(mockRepo).findNecklacesByHasNaturalStonesTrue();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllWithSwarovskiTest(){
        List<Necklace> list = new ArrayList<>(Arrays.asList(necklace2));
        given(mockRepo.findNecklacesByHasSwarovskiTrue()).willReturn(list);

        ResponseEntity<List<Necklace>> expected = new ResponseEntity<>(list, OK);
        ResponseEntity<List<Necklace>> actual = mockService.getAllWithSwarovski();

        verify(mockRepo).findNecklacesByHasSwarovskiTrue();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateBeadsTest(){
        LinkedHashMap<Bead, Integer> beadList = new LinkedHashMap<>();
        beadList.put(bead1,5);
        bead1.setId(1);
        beadList.put(bead2,4);
        bead2.setId(2);
        beadList.put(seeds, 150);
        seeds.setId(3);

        given(mockRepo.findById(necklace.getId())).willReturn(necklace);
        given(mockRepo.save(any(Necklace.class))).willReturn(necklace);

        given(beadRepo.findById(bead1.getId())).willReturn(bead1);
        given(beadRepo.save(any(Bead.class))).willReturn(bead1);

        ResponseEntity<Necklace> actualResponse = mockService.updateBeads(necklace.getId(),beadList);
        Map<Bead,Integer> actual = actualResponse.getBody().getBeads();

        verify(mockRepo).findById(anyLong());
        verify(mockRepo).save(any(Necklace.class));
        Assert.assertEquals(beadList,actual);
    }
}

/*
ResponseEntity<List<Necklace>> getAllWithNaturalStones()
ResponseEntity<List<Necklace>> getAllWithSwarovski()
ResponseEntity<Necklace> updateBeads(long id, LinkedHashMap<Bead,Integer> beads)
 */