package com.beadinventory.beadinventory.DomainTest.FinishedPiecesDomainTest;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.*;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.REST.Domain.Supplies.StringWire;
import org.junit.*;
import java.util.*;


import static com.beadinventory.beadinventory.REST.Domain.FinishedPieces.BraceletType.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.StringWireCategory.BEADING_WIRE;

public class BraceletTest {

    private Bead bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"translucent purple with some white", 0.2,"Bead Gallery");
    private Bead bead2 = new Bead(JASPER,ROUND, "black", 4, "good", 10, "",0.1,"Bead Gallery");
    private Bead bead4 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white", 0.2,"Bead Gallery");
    private Finding lobsterClasp2 = new Finding(LOBSTER_CLASP,DULL_SILVER_PLATED,4,.1,10,"Bead Gallery","medium");
    private HashMap<Bead, Integer> beads = new HashMap<>();
    private HashMap<Finding, Integer> findings = new HashMap<>();
    private StringWire beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm","good",.5,"Beadalon",
            "7 strand");
    private Bracelet bracelet = new Bracelet(beads,findings,15,"",MEDICAL,beadingWire,true,false,4, false, "");

    @Before
    public void setUp(){
        beads.put(bead1,4);
        beads.put(bead2,2);
        beads.put(bead4,3);
        findings.put(lobsterClasp2,2);
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
