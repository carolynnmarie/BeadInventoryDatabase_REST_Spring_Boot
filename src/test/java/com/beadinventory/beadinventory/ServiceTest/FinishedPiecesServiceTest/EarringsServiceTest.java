package com.beadinventory.beadinventory.ServiceTest.FinishedPiecesServiceTest;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.EarringsRepo;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.EarringsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.TreeSet;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.EYE_PIN;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.HEAD_PIN;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.AMETHYST;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.BRIGHT_SILVER_PLATED;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.ROUND;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class EarringsServiceTest {

    @InjectMocks
    private EarringsService mockEarringsService;

    @Mock
    private EarringsRepo mockEarringsRepo;

    private Earrings earrings;

    @Before
    private void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        LinkedHashMap<Bead,Integer> beads = new LinkedHashMap<>();
        TreeSet<String> beadBrands = new TreeSet<>(Arrays.asList("Bead Gallery"));
        Bead bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"purple", 0.2,beadBrands);
        beads.put(bead1,3);

        LinkedHashMap<Finding,Integer> findings = new LinkedHashMap<>();
        TreeSet<String> findingBrands = new TreeSet<>(Arrays.asList("Beadalon","bead landing"));
        Finding eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,findingBrands);
        Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,beadBrands);
        findings.put(eyePin,2);
        findings.put(headPin,1);

        this.earrings = new Earrings(beads,15,"dangles",findings,true);
        earrings.setId(1L);
    }

    @Test
    public void getItemByIdTest1(){
        given(mockEarringsRepo.findById(1L)).willReturn(earrings);

    }
}
