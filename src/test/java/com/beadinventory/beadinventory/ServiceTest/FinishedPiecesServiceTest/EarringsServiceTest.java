package com.beadinventory.beadinventory.ServiceTest.FinishedPiecesServiceTest;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.EarringsRepo;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.EarringsService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.ROUND;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.*;

@RunWith(SpringRunner.class)
public class EarringsServiceTest {

    @InjectMocks
    private EarringsService mockEarringsService;

    @Mock
    private EarringsRepo mockEarringsRepo;

    private Earrings earrings;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        HashMap<Bead,Integer> beads = new HashMap<>();
        List<String> beadBrands = new ArrayList<>(Arrays.asList("Bead Gallery"));
        Bead bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"purple", 0.2,beadBrands);
        beads.put(bead1,3);

        HashMap<Finding,Integer> findings = new HashMap<>();
        List<String> findingBrands = new ArrayList<>(Arrays.asList("Beadalon","bead landing"));
        Finding eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,findingBrands);
        Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,findingBrands);
        Finding earWire = new Finding(EAR_WIRE,FULL_STERLING_SILVER,"",2.0,.1,2,findingBrands);
        findings.put(eyePin,4);
        findings.put(headPin,2);
        findings.put(earWire,2);
        this.earrings = new Earrings(beads,findings,15,"amethyst dangles",true);
        earrings.setId(1L);
    }

    @Test
    public void updatePriceOfOneTest(){
        given(mockEarringsRepo.findById(1L)).willReturn(earrings);
        given(mockEarringsRepo.save(earrings)).willReturn(earrings);

        double expected = 18;
        ResponseEntity<Earrings> actualResponse = mockEarringsService.updatePriceOfOne(1L,18);
        double actual = actualResponse.getBody().getPrice();

        verify(mockEarringsRepo).findById(anyLong());
        verify(mockEarringsRepo).save(any(Earrings.class));
        Assert.assertEquals(expected,actual, 0.05);
    }

    @Test
    public void getAllSterlingSilverTest(){
        List<Earrings> list = new ArrayList<>(Arrays.asList(earrings));
        given(mockEarringsRepo.findEarringsBySterlingSilverYorNIsTrue()).willReturn(list);

        ResponseEntity<List<Earrings>> expected = new ResponseEntity<>(list,OK);
        ResponseEntity<List<Earrings>> actual = mockEarringsService.getAllSterlingSilver();

        verify(mockEarringsRepo).findEarringsBySterlingSilverYorNIsTrue();
        Assert.assertEquals(expected,actual);
    }
}
