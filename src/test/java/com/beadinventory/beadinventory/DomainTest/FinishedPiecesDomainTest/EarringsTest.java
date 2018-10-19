package com.beadinventory.beadinventory.DomainTest.FinishedPiecesDomainTest;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.ROUND;

public class EarringsTest {

    private Bead bead;
    private Finding eyePin;
    private Finding headPin;
    private Finding earWire;
    private LinkedHashMap<Bead,Integer> beads;
    private LinkedHashMap<Finding, Integer> findings;
    private Earrings earrings;

    @Before
    public void setUp(){
        TreeSet<String> brands = new TreeSet<>(Arrays.asList("Bead Gallery"));
        this.bead = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"translucent purple with some white", 0.2,brands);
        this.beads = new LinkedHashMap<>();
        beads.put(bead,3);
        this.eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,brands);
        this.headPin= new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,brands);
        this.earWire = new Finding(EAR_WIRE,FULL_STERLING_SILVER,"",2.0,.1,2,brands);
        this.findings = new LinkedHashMap<>();
        findings.put(eyePin,2);
        findings.put(headPin,1);
        findings.put(earWire,2);
        this.earrings = new Earrings(beads,findings,15,"dangles",true);
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
