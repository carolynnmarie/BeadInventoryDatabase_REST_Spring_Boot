package com.beadinventory.beadinventory.ServiceTest.FinishedPiecesServiceTest;

import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.REST.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.REST.Repository.FinishedPiecesRepos.NecklaceRepo;
import com.beadinventory.beadinventory.REST.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.REST.Service.FinishedPiecesServices.NecklaceService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;

import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.StringWireCategory.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.*;

@RunWith(SpringRunner.class)
public class NecklaceServiceTest {

    @InjectMocks
    private NecklaceService mockService;

    @Mock
    private NecklaceRepo mockRepo;
    @Mock
    private BeadRepo beadRepo;

    private HashMap<Bead, Integer> beads = new HashMap<>();
    private HashMap<Bead, Integer> beads2 = new HashMap<>();
    private Bead bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20, "translucent purple with some white", 0.8, "Bead Gallery");
    private Bead bead2 = new Bead(JASPER, ROUND, "black", 4, "good", 10, "", 0.6, "Bead Gallery");
    private Bead bead4 = new Bead(AMETHYST, ROUND, "purple", 6, "good", 15, "translucent purple with some white", 0.9, "Bead Gallery");;
    private Bead seeds = new Bead(SEED,SEED_E_LARGE,"black",0,"good",100,"good black large seed beads",.01,"Bead Gallery");
    private Bead sWBead = new Bead(SWAROVSKI_CRYSTAL, BICONE, "blue", 4, "good", 10, "",1, "Bead Gallery");
    private HashMap<Finding, Integer> findings = new HashMap<>();
    private Finding lobsterClasp2 = new Finding(LOBSTER_CLASP,DULL_SILVER_PLATED,4,.1,10,"bead landing","bright silver medium lobster clasp");
    private Finding splitRing = new Finding(SPLIT_RING, BRASS, 1, .01, 25, "Bead Gallery", "smallest");
    private StringWire beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm","good",.5,"Beadalon",
            "7 strand");
    private Necklace necklace= new Necklace(beads,findings,beadingWire,20,3,1,"",true,false,40,LOBSTER_CLASP);
    private Necklace necklace2 = new Necklace(beads2,findings,beadingWire,21.0,4,1.25,"",true,true,45,LOBSTER_CLASP);


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        beads.put(bead1, 4);
        beads.put(bead2, 2);
        beads.put(bead4, 3);
        beads.put(seeds, 100);
        findings.put(lobsterClasp2, 1);
        findings.put(splitRing,1);
        beads2.put(seeds, 100);
        beads2.put(sWBead, 5);
        beads2.put(bead4, 8);
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

//    @Test
//    public void updateBeadsTest(){
//        necklace.setAllId(1);
//        LinkedHashMap<Bead, Integer> beadList = new LinkedHashMap<>();
//        beadList.put(bead1,5);
//        bead1.setBeadId(1);
//        beadList.put(bead2,4);
//        bead2.setBeadId(2);
//        beadList.put(seeds, 150);
//        seeds.setBeadId(3);
//
//        given(mockRepo.findById(necklace.getAllId())).willReturn(necklace);
//        given(mockRepo.save(any(Necklace.class))).willReturn(necklace);
//
//        given(beadRepo.findById(bead1.getBeadId())).willReturn(bead1);
//        given(beadRepo.save(any(Bead.class))).willReturn(bead1);
//
//        ResponseEntity<Necklace> actualResponse = mockService.updateBeadRepoExistItem(necklace.getAllId(),beadList);
//        Map<Bead,Integer> actual = actualResponse.getBody().getBeads();
//
//        verify(mockRepo).findById(anyLong());
//        verify(mockRepo).save(any(Necklace.class));
//        Assert.assertEquals(beadList,actual);
//    }
}
