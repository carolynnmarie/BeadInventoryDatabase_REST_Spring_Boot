package com.beadinventory.beadinventory.DomainTest.FinishedPiecesDomainTest;

import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Finding;
import org.junit.*;

import java.util.*;

import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape.ROUND;

public class EarringsTest {

    private Bead bead;
    private Finding eyePin;
    private Finding headPin;
    private Finding earWire;
    private HashMap<Bead,Integer> beads;
    private HashMap<Finding, Integer> findings;
    private Earrings earrings;

    @Before
    public void setUp(){
        this.bead = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"translucent purple with some white", 0.2,"Bead Gallery");
        this.beads = new HashMap<>();
        beads.put(bead,3);
        this.eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,5.08,5.08,20,"Bead Gallery","thin");
        this.headPin= new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,5.08,5.08,20,"Bead Gallery","thin");
        this.earWire = new Finding(EAR_WIRE,FULL_STERLING_SILVER,2.0,.1,2,"Bead Gallery","");
        this.findings = new HashMap<>();
        findings.put(eyePin,2);
        findings.put(headPin,1);
        findings.put(earWire,2);
        this.earrings = new Earrings(beads,findings,15,"dangles",true, false, "");
    }

    @Test
    public void getSterlingSilverTest(){
        Assert.assertTrue(earrings.getSterlingSilverYorN());
    }

    @Test
    public void setAutoPrice(){
        double expected = 18;
        earrings.setAutoPrice();
        double actual = earrings.getPrice();

        Assert.assertEquals(expected,actual,0.05);
    }
}
