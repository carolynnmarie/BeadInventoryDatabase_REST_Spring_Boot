package com.beadinventory.beadinventory.DomainTest.FinishedPiecesDomainTest;

import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.NapkinRingSet;
import com.beadinventory.beadinventory.REST.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.*;
import org.junit.*;
import java.util.*;

import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.StringWireCategory.BEADING_WIRE;

public class NapkinRingSetTest {

    private Bead bead;
    private Bead bead1;
    private Finding crimp;
    private HashMap<Bead, Integer> beads;
    private HashMap<Finding, Integer> findings;
    private NapkinRingSet napkinRingSet;
    private StringWire beadingWire;

    @Before
    public void setUp(){
        this.bead = new Bead(SEED,SEED_E_LARGE,"black",0,"good",100,"good black large seed beads",.001,"Bead Gallery");
        this.bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"translucent purple with some white", 0.2,"Bead Gallery");
        this.crimp = new Finding(FindingCategory.CRIMP_BEAD,BRIGHT_SILVER_PLATED,.02,.01,10,"Bead Gallery","");
        this.beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm","good",.5,"Beadalon", "7 strand");
        this.beads = new HashMap<>();
        beads.put(bead,25);
        beads.put(bead1,4);
        this.findings = new HashMap<>();
        findings.put(crimp,1);
        this.napkinRingSet = new NapkinRingSet(beads,findings,20,"",beadingWire,"purple and black",4, false, "");
    }

    @Test
    public void getStringWireTest(){
        StringWire expected = beadingWire;
        StringWire actual = napkinRingSet.getStringWire();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getColorSchemeTest(){
        String expected = "purple and black";
        String actual = napkinRingSet.getColorScheme();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getQuantityTest(){
        int expected = 4;
        int actual = napkinRingSet.getQuantity();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setAutoPriceTest(){
        double expected = 20;
        napkinRingSet.setAutoPrice();
        double actual = napkinRingSet.getPrice();

        Assert.assertEquals(expected,actual, 0.01);
    }

}
