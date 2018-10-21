package com.beadinventory.beadinventory.DomainTest.FinishedPiecesDomainTest;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import org.junit.*;
import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.BEADING_WIRE;

public class NecklaceTest {
    private Bead bead1;
    private Bead bead2;
    private Bead bead4;
    private Bead seeds;
    private Finding lobsterClasp2;
    private Finding splitRing;
    private LinkedHashMap<Bead, Integer> beads;
    private LinkedHashMap<Finding, Integer> findings;
    private StringWire beadingWire;
    private Necklace necklace;


    @Before
    public void setUp() {
        TreeSet<String> brands = new TreeSet<>(Arrays.asList("Bead Gallery"));
        this.bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20, "translucent purple with some white", 0.8, brands);
        this.bead2 = new Bead(JASPER, ROUND, "black", 4, "good", 10, "", 0.6, brands);
        this.bead4 = new Bead(AMETHYST, ROUND, "purple", 6, "good", 15, "translucent purple with some white", 0.9, brands);
        this.seeds = new Bead(SEED,SEED_E_LARGE,"black",0,"good",100,"good black large seed beads",.01,brands);
        this.lobsterClasp2 = new Finding(LOBSTER_CLASP, BRIGHT_SILVER_PLATED, "medium", 4, .1, 10, brands);
        this.splitRing = new Finding(SPLIT_RING, BRASS, "smallest", 1, .01, 25, brands);
        this.beads = new LinkedHashMap<>();
        beads.put(bead1, 4);
        beads.put(bead2, 2);
        beads.put(bead4, 3);
        beads.put(seeds, 100);
        this.findings = new LinkedHashMap<>();
        findings.put(lobsterClasp2, 1);
        findings.put(splitRing,1);
        this.beadingWire = new StringWire(BEADING_WIRE, BRIGHT_SILVER_PLATED, "silver", ".5 mm", 7, "good", .1, "Beadalon");
        this.necklace = new Necklace(beads,findings,beadingWire,20,3,1,"",true,false,40,LOBSTER_CLASP);
    }

//getStringWireTest, getLengthInchTest, getSwarovskiTest, and getNaturalStonesTest are present in BraceletTest class

    @Test
    public void getHoursSpentTest(){
        int expected = 3;
        int actual = necklace.getHoursSpent();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getDifficultyLevelTest(){
        double expected = 1;
        double actual = necklace.getDifficultyLevel();

        Assert.assertEquals(expected,actual, 0.001);
    }

    @Test
    public void getClaspTest(){
        FindingCategory expected = LOBSTER_CLASP;
        FindingCategory actual = necklace.getClasp();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void describeNecklaceTest(){
        String expected = "The necklace is 20.0 inches long, on beading wire, with a lobster clasp, with natural stone beads";
        String actual = necklace.describeNecklace();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setAutoPriceTest(){
        double expected = 40.0;
        necklace.setAutoPrice();
        double actual = necklace.getPrice();

        Assert.assertEquals(expected,actual, 0.001);
    }


}
/*
    public void setAutoPrice() {
        double beadPrice = 0.0;
        double findingPrice = 0.0;
        double stringPrice = stringWire.getPricePerFoot()*lengthInch;
        for(Map.Entry<Bead,Integer> bead: beads.entrySet()){
            beadPrice += (bead.getKey().getPricePoint()*bead.getValue());
        }
        for(Map.Entry<Finding,Integer> finding: findings.entrySet()){
            findingPrice += (finding.getKey().getPricePoint()*finding.getValue());
        }
        this.price = beadPrice + stringPrice + findingPrice + (hoursSpent*8)*difficultyLevel;
        if(getHasSwarovski()) price += 5;
        if(getHasNaturalStones()) price += 5;
        price = Math.ceil(price)
    }
 */