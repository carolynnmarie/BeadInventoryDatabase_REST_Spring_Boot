package com.beadinventory.beadinventory.DomainTest.FinishedPiecesDomainTest;

import com.beadinventory.beadinventory.Domain.FinishedPieces.*;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import org.junit.*;
import java.util.*;


import static com.beadinventory.beadinventory.Domain.FinishedPieces.BraceletType.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.BEADING_WIRE;

public class BraceletTest {

    private Bead bead1;
    private Bead bead2;
    private Bead bead4;
    private Finding lobsterClasp2;
    private HashMap<Bead, Integer> beads;
    private HashMap<Finding, Integer> findings;
    private StringWire beadingWire;
    private Bracelet bracelet;

    @Before
    public void setUp(){
        List<String> brands = new ArrayList<>(Arrays.asList("Bead Gallery"));
        this.bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"translucent purple with some white", 0.2,"Bead Gallery");
        this.bead2 = new Bead(JASPER,ROUND, "black", 4, "good", 10, "",0.1,"Bead Gallery");
        this.bead4 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white", 0.2,"Bead Gallery");
        this.lobsterClasp2 = new Finding(LOBSTER_CLASP,DULL_SILVER_PLATED,"medium",4,.1,10,"Bead Gallery");
        this.beads = new HashMap<>();
        beads.put(bead1,4);
        beads.put(bead2,2);
        beads.put(bead4,3);
        this.findings = new HashMap<>();
        findings.put(lobsterClasp2,2);
        this.beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm",7,"good",.5,"Beadalon");

        this.bracelet = new Bracelet(beads,findings,15,"",MEDICAL,beadingWire,true,false,4);
    }

    @Test
    public void getStringWireTest(){
        StringWire expected = beadingWire;
        StringWire actual = bracelet.getStringWire();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getBraceletTypeTest(){
        BraceletType expected = MEDICAL;
        BraceletType actual = bracelet.getBraceletType();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getHasSwarovskiTest(){
        Assert.assertFalse(bracelet.getHasSwarovski());
    }

    @Test
    public void getHasNaturalStonesTest(){
        Assert.assertTrue(bracelet.getHasNaturalStones());
    }

    @Test
    public void getLengthInchTest(){
        int expected = 4;
        int actual = bracelet.getLengthInch();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setAutoPriceTest(){
        double expected = 17.0;
        bracelet.setAutoPrice();
        double actual =  bracelet.getPrice();

        Assert.assertEquals(expected,actual, 0.01);
    }

}
