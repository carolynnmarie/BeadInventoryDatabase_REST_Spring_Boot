package com.beadinventory.beadinventory.DomainTest.FinishedPiecesDomainTest;

import com.beadinventory.beadinventory.Domain.FinishedPieces.WineCharmSet;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.StringWire;

import org.junit.*;
import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.BEADING_WIRE;

public class WineCharmSetTest {

    private Bead bead;
    private Bead bead1;
    private LinkedHashMap<Bead, Integer> beads;
    private LinkedHashMap<Finding, Integer> findings;
    private Finding headPin;
    private WineCharmSet wineCharms;

    @Before
    public void setUp(){
        TreeSet<String> brands = new TreeSet<>(Arrays.asList("Bead Gallery"));
        this.bead = new Bead(SEED,SEED_E_LARGE,"clear",0,"good",100,"good clear large seed beads",.001,brands);
        this.bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"translucent purple with some white", 0.2,brands);
        this.headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,brands);
        this.beads = new LinkedHashMap<>();
        beads.put(bead,24);
        beads.put(bead1,6);
        this.findings = new LinkedHashMap<>();
        findings.put(headPin,6);
        this.wineCharms = new WineCharmSet(beads,findings,24,"",6);
    }

    @Test
    public void getQuantityTest(){
        int expected = 6;
        int actual = wineCharms.getQuantity();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setAutoPriceTest(){
        double expected = 23;
        wineCharms.setAutoPrice();
        double actual = wineCharms.getPrice();

        Assert.assertEquals(expected, actual,.01);
    }
}
