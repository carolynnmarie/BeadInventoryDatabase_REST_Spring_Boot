package com.beadinventory.beadinventory.ControllerTest.FinishedPiecesControllerTest;

import com.beadinventory.beadinventory.Controller.FinishedPiecesControllers.NecklaceController;
import com.beadinventory.beadinventory.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.NecklaceService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@WebMvcTest(NecklaceController.class)
public class NecklaceContIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NecklaceController mockController;

    @MockBean
    private NecklaceService mockService;

    private Bead bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20, "translucent purple with some white", 0.8, "Bead Gallery");
    private Bead bead2 = new Bead(JASPER, ROUND, "black", 4, "good", 10, "", 0.6, "Bead Gallery");
    private Bead bead4 = new Bead(AMETHYST, ROUND, "purple", 6, "good", 15, "translucent purple with some white", 0.9, "Bead Gallery");
    private Bead seeds = new Bead(SEED,SEED_E_LARGE,"black",0,"good",100,"good black large seed beads",.01,"Bead Gallery");
    private Bead sWBead = new Bead(SWAROVSKI_CRYSTAL, BICONE, "blue", 4, "good", 10, "",1, "Bead Gallery");;
    private Finding lobsterClasp = new Finding(LOBSTER_CLASP, BRIGHT_SILVER_PLATED, "medium", 4, .1, 10, "Bead Gallery");;
    private Finding splitRing = new Finding(SPLIT_RING, BRASS, "smallest", 1, .01, 25, "Bead Gallery");
    private HashMap<Bead, Integer> beads= new HashMap<>();
    private HashMap<Finding, Integer> findings= new HashMap<>();
    private StringWire beadingWire= new StringWire(BEADING_WIRE, BRIGHT_SILVER_PLATED, "silver", ".5 mm", 7, "good", .1, "Beadalon");
    private HashMap<Bead, Integer> beads2= new HashMap<>();
    private Necklace necklace= new Necklace(beads,findings,beadingWire,20,3,1,"",true,false,40,LOBSTER_CLASP);
    private Necklace necklace2= new Necklace(beads2,findings,beadingWire,21.0,4,1.25,"",true,true,45,LOBSTER_CLASP);


    @Before
    public void setUp() {
        beads.put(bead1, 4);
        beads.put(bead2, 2);
        beads.put(bead4, 3);
        beads.put(seeds, 100);
        findings.put(lobsterClasp, 1);
        findings.put(splitRing,1);
        beads2.put(seeds, 100);
        beads2.put(sWBead, 5);
        beads2.put(bead4, 8);
    }

    @Test
    public void findAllItemsIntegTest() throws Exception{
        List<Necklace> list = new ArrayList<>(Arrays.asList(necklace,necklace2));
        given(mockController.findAllItems()).willReturn(list);


        mockMvc.perform(get("/necklaces")
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllWithNaturalStonesIntegTest() throws Exception{
        List<Necklace> list = new ArrayList<>(Arrays.asList(necklace,necklace2));
        given(mockController.findAllWithNaturalStones()).willReturn(list);

        mockMvc.perform(get("/necklaces/findAllWithNaturalStones")
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllWithSwarovskiIntegTest() throws Exception{
        List<Necklace> list = new ArrayList<>(Arrays.asList(necklace,necklace2));
        given(mockController.findAllWithSwarovski()).willReturn(list);

        mockMvc.perform(get("/necklaces/findAllWithSwarovski")
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }



}
/*

List<Necklace> findAllWithClasp(FindingCategory clasp)
Necklace updateNecklaceBeads(long id, LinkedHashMap<Bead,Integer> beads)
 */