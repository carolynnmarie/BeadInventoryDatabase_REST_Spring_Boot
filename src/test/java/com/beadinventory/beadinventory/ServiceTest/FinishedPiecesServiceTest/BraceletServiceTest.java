package com.beadinventory.beadinventory.ServiceTest.FinishedPiecesServiceTest;

import com.beadinventory.beadinventory.Domain.FinishedPieces.*;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.BraceletRepo;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.BraceletService;
import org.junit.*;
import java.util.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static com.beadinventory.beadinventory.Domain.FinishedPieces.BraceletType.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.ROUND;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.ELASTIC;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

@RunWith(SpringRunner.class)
public class BraceletServiceTest {

    @InjectMocks
    BraceletService mockBraceletService;

    @Mock
    BraceletRepo mockBraceletRepo;

    private Bead bead1;
    private Bead bead2;
    private Bead bead4;
    private Finding lobsterClasp2;
    private Finding splitRing;
    private LinkedHashMap<Bead, Integer> beads;
    private LinkedHashMap<Finding, Integer> findings;
    private StringWire beadingWire;
    private StringWire elastic;
    private Bracelet bracelet;
    private Bracelet bracelet2;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        TreeSet<String> brands = new TreeSet<>(Arrays.asList("Bead Gallery"));
        this.bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"translucent purple with some white",
                0.2,brands);
        this.bead2 = new Bead(JASPER,ROUND, "black", 4, "good", 10, "",0.1,brands);
        this.bead4 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white",
                0.2,brands);
        this.lobsterClasp2 = new Finding(LOBSTER_CLASP,DULL_SILVER_PLATED,"medium",4,.1,10,brands);
        this.splitRing = new Finding(SPLIT_RING,BRASS,"smallest",1,.01,25,brands);
        this.beads = new LinkedHashMap<>();
        beads.put(bead1,4);
        beads.put(bead2,2);
        beads.put(bead4,3);
        this.findings = new LinkedHashMap<>();
        findings.put(lobsterClasp2,2);
        this.beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm",7,"good",.5,"Beadalon");
        this.elastic = new StringWire(ELASTIC,POLYESTER,"white","thin",1,"ok",.25,"bead landing");
        LinkedHashMap<Finding,Integer> findings2 = new LinkedHashMap<>();
        findings2.put(lobsterClasp2,1);
        findings2.put(splitRing,1);

        this.bracelet = new Bracelet(beads,findings,15,"",MEDICAL,elastic,true,false,4);
        this.bracelet2 = new Bracelet(beads,findings2,18,"",NORMAL,beadingWire,true,false,6);
    }

    @Test
    public void findByBraceletTypeTest(){
        List<Bracelet> list = new ArrayList<>(Arrays.asList(bracelet2));
        given(mockBraceletRepo.findBraceletsByBraceletType(NORMAL)).willReturn(list);

        ResponseEntity<List<Bracelet>> expected = new ResponseEntity<>(list,OK);
        ResponseEntity<List<Bracelet>> actual = mockBraceletService.findByBraceletType(NORMAL);

        verify(mockBraceletRepo).findBraceletsByBraceletType(any(BraceletType.class));
        Assert.assertEquals(expected,actual);
    }
}
