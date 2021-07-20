package com.beadinventory.beadinventory.DomainTest.FinishedPiecesDomainTest;

import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Bookmark;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.*;
import org.junit.*;
import java.util.*;

import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape.*;

public class BookmarkTest {

    private Bead bead1;
    private Bead bead2;
    private Finding headPin;
    private HashMap<Bead, Integer> beads;
    private HashMap<Finding, Integer> findings;

    private Bookmark bookmark;

    @Before
    public void setUp(){
        this.bead1 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white", 0.2,"Bead Gallery");
        this.bead2 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple with some white", 0.2,"Bead Gallery");
        this.headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,5.08,5.08,20,"Bead Gallery","thin");
        beads = new HashMap<>();
        beads.put(bead1,1);
        beads.put(bead2,1);
        this.findings = new HashMap<>();
        findings.put(headPin,2);

        this.bookmark = new Bookmark(beads,findings,12.0,"Amethyst on black cord", COTTON,StringWireCategory.CORD,"black",10, false, "");
    }

    @Test
    public void getBeadsTest(){
        Map<Bead, Integer> expected = new HashMap<>(beads);
        Map<Bead, Integer> actual = bookmark.getBeads();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getFindingsTest(){
        Map<Finding, Integer> expected = new HashMap<>(findings);
        Map<Finding, Integer> actual = bookmark.getFindings();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPriceTest(){
        Double expected = 12.0;
        Double actual = bookmark.getPrice();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setAutoPriceTest(){
        double expected = 10.0;
        bookmark.setAutoPrice();
        double actual = bookmark.getPrice();

        Assert.assertEquals(expected,actual, 0.005);
    }

    @Test
    public void getDescriptionTest(){
        String expected = "Amethyst on black cord";
        String actual = bookmark.getDescription();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getStringMaterialTest(){
        Material expected = COTTON;
        Material actual = bookmark.getStringMaterial();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getStringColorTest(){
        String expected = "black";
        String actual = bookmark.getStringColor();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLengthInchTest(){
        int expected = 10;
        int actual = bookmark.getLengthInch();
        
        Assert.assertEquals(expected,actual);
    }
}
