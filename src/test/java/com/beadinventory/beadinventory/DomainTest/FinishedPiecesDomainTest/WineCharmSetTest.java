package com.beadinventory.beadinventory.DomainTest.FinishedPiecesDomainTest;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.FinishedPieces.WineCharmSet;

import org.junit.*;
import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;

public class WineCharmSetTest {

    private Bead bead;
    private Bead bead1;
    private HashMap<Bead, Integer> beads;
    private HashMap<Finding, Integer> findings;
    private Finding headPin;
    private WineCharmSet wineCharms;

    @Before
    public void setUp(){
        List<String> brands = new ArrayList<>(Arrays.asList("Bead Gallery"));
        this.bead = new Bead(SEED,SEED_E_LARGE,"clear",0,"good",100,"good clear large seed beads",.001,"Bead Gallery");
        this.bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"translucent purple with some white", 0.2,"Bead Gallery");
        this.headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,"Bead Gallery");
        this.beads = new HashMap<>();
        beads.put(bead,24);
        beads.put(bead1,6);
        this.findings = new HashMap<>();
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
