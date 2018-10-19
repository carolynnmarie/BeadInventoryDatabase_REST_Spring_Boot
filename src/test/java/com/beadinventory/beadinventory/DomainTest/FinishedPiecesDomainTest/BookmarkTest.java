package com.beadinventory.beadinventory.DomainTest.FinishedPiecesDomainTest;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Bookmark;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;

public class BookmarkTest {

    private Bead bead1;
    private Bead bead2;
    private Finding headPin;
    private LinkedHashMap<Bead, Integer> beads;
    private LinkedHashMap<Finding, Integer> findings;

    private Bookmark bookmark;

    @Before
    public void setUp(){
        TreeSet<String> beadBrands = new TreeSet<>(Arrays.asList("Bead Gallery"));
        bead1 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white",
                0.2,beadBrands);
        bead2 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple with some white",
                0.2,beadBrands);
        TreeSet<String> findingBrands = new TreeSet<>(Arrays.asList("bead landing"));
        headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,findingBrands);

        beads = new LinkedHashMap<>();
        beads.put(bead1,1);
        beads.put(bead2,1);
        findings = new LinkedHashMap<>();
        findings.put(headPin,2);

        bookmark = new Bookmark(beads,findings,12.0,"Amethyst on black cord", COTTON,"black",10);
    }

    @Test
    public void getBeadsTest(){
        LinkedHashMap<Bead, Integer> expected = new LinkedHashMap<>(beads);
        LinkedHashMap<Bead, Integer> actual = bookmark.getBeads();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getFindingsTest(){
        LinkedHashMap<Finding, Integer> expected = new LinkedHashMap<>(findings);
        LinkedHashMap<Finding, Integer> actual = bookmark.getFindings();

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
